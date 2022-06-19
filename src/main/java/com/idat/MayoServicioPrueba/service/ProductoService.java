package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.model.Productos;

public interface ProductoService {
	void guardarProdcto(ProductoDTORequest productos);
	void actualizarProducto(ProductoDTORequest productos);
	void eliminarProducto(Integer id);	
	List<ProductoDTOResponse>listarProductos();
	ProductoDTOResponse obtenerProductosId(Integer id);
}	
