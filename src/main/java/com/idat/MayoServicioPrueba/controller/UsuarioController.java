package com.idat.MayoServicioPrueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.MayoServicioPrueba.dto.UsuarioDTORequest;
import com.idat.MayoServicioPrueba.dto.UsuarioDTOResponse;

import com.idat.MayoServicioPrueba.security.UserDetailService;


@RestController
public class UsuarioController {

	
	@Autowired
	private UserDetailService userService;
	/*@RequestMapping(path="/crearToken",method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request){
		UserDetails user= userService.loadUserByUsername(request.getUsuario());
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
	}*/
}
