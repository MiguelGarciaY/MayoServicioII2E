package com.idat.MayoServicioPrueba.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenStore store;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("Miguel")
		.secret(new BCryptPasswordEncoder().encode("Prueba"))
		.authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
		.scopes("read","write","trust")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(5*60*60);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(store)
			.authenticationManager(manager)
			.tokenEnhancer(new TokenEnhancer() {
				
				@Override
				public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
					Map<String,Object> informacionAdicional=new HashMap<>();
					informacionAdicional.put("suscribete", "youtube");
					informacionAdicional.put("canal", "lideratec");
					
					DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
					token.setAdditionalInformation(informacionAdicional);
					return token;
				}
			});
	}	
}
