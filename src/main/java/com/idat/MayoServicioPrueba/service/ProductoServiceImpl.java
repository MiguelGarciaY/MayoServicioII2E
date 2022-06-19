package com.idat.MayoServicioPrueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.model.Productos;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardarProdcto(ProductoDTORequest productoDTO) {
		// TODO Auto-generated method stub
		Productos producto=new Productos();		
		producto.setDescripcion(productoDTO.getDescripcionProducto());
		producto.setNombreProducto(productoDTO.getNombre());
		producto.setPrecio(productoDTO.getPrecioProducto());
		producto.setStock(productoDTO.getStockProducto());
		repository.save(producto);
	}

	@Override
	public void actualizarProducto(ProductoDTORequest productoDTO) {
		// TODO Auto-generated method stub
		Productos producto=new Productos();	
		producto.setIdProducto(productoDTO.getId());
		producto.setDescripcion(productoDTO.getDescripcionProducto());
		producto.setNombreProducto(productoDTO.getNombre());
		producto.setPrecio(productoDTO.getPrecioProducto());
		producto.setStock(productoDTO.getStockProducto());
		
		repository.saveAndFlush(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductoDTOResponse> listar=new ArrayList<>();
		ProductoDTOResponse dto=null;
		List<Productos> p=repository.findAll();
		
		for(Productos producto:p) {
			dto=new ProductoDTOResponse();
			dto.setId(producto.getIdProducto());
			dto.setDescripcionProducto(producto.getDescripcion());
			dto.setNombre(producto.getNombreProducto());
			dto.setPrecioProducto(producto.getPrecio());
			dto.setStockProducto(producto.getStock());
			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public ProductoDTOResponse obtenerProductosId(Integer id) {
		// TODO Auto-generated method stub
		Productos producto=repository.findById(id).orElse(null);
		ProductoDTOResponse dto=null;
		dto=new ProductoDTOResponse();
		dto.setId(producto.getIdProducto());
		dto.setDescripcionProducto(producto.getDescripcion());
		dto.setNombre(producto.getNombreProducto());
		dto.setPrecioProducto(producto.getPrecio());
		dto.setStockProducto(producto.getStock());
		return dto;
	}

}
