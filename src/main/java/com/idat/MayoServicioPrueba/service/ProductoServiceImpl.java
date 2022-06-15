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
		repository.save(productos);
	}

	@Override
	public void actualizarProducto(Productos productos) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(productos);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Productos obtenerProductosId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
