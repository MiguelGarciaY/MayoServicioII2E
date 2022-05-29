package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Productos;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardarProdcto(Productos productos) {
		// TODO Auto-generated method stub
		repository.guardarProdcto(productos);
	}

	@Override
	public void actualizarProducto(Productos productos) {
		// TODO Auto-generated method stub
		repository.actualizarProducto(productos);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.eliminarProducto(id);
	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return repository.listarProductos();
	}

	@Override
	public Productos obtenerProductosId(Integer id) {
		// TODO Auto-generated method stub
		return repository.obtenerProductosId(id);
	}

}
