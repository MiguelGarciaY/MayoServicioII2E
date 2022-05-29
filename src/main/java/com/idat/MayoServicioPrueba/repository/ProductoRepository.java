package com.idat.MayoServicioPrueba.repository;
import java.util.List;

import com.idat.MayoServicioPrueba.model.Productos;

public interface ProductoRepository {
	void guardarProdcto(Productos productos);
	void actualizarProducto(Productos productos);
	void eliminarProducto(Integer id);	
	List<Productos>listarProductos();
	Productos obtenerProductosId(Integer id);
}
