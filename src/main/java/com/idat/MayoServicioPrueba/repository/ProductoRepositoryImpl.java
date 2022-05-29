package com.idat.MayoServicioPrueba.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;
import com.idat.MayoServicioPrueba.model.Productos;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	public List<Productos> listar=new ArrayList<Productos>();
	@Override
	public void guardarProdcto(Productos productos) {
		// TODO Auto-generated method stub
		listar.add(productos);
	}

	@Override
	public void actualizarProducto(Productos productos) {
		// TODO Auto-generated method stub
		Productos p=obtenerProductosId(productos.getIdProducto());
		listar.remove(p);
		listar.add(productos);
	}
 
	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Productos obtenerProductosId(Integer id) {
		// TODO Auto-generated method stub
	/*	for (Productos productos : listar) {
			if(productos.getIdProducto()==id) {
				return productos;
			}
		}
		return null;*/
		return listar.stream().filter(p -> p.getIdProducto()==id).findFirst().orElse(null);
	}

}
