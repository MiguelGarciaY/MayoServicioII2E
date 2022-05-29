package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Productos;

public interface ProductoService {
	void guardarProdcto(Productos productos);
	void actualizarProducto(Productos productos);
	void eliminarProducto(Integer id);	
	List<Productos>listarProductos();
	Productos obtenerProductosId(Integer id);
}	
