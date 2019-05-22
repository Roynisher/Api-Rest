package com.rjt.beans;



public class RegistraProducto {
	
	private static RegistraProducto prodReg = null;
	
	private RegistraProducto()
	{
		
	}
	
	public static RegistraProducto getInstance() 
	{
		if(prodReg == null)
		{
			prodReg = new RegistraProducto();
			return prodReg;
		}
		else
		{
			return prodReg;
		}
	}
	
	public int agregarProducto(String nombre, double costo, int inventario, String descripcion)
	{
		int idProd = 0;
		ConexionMongo cm = new ConexionMongo();
		idProd = cm.insertarProducto(nombre, costo, inventario, descripcion);
		cm.CierraConexion();
		return idProd;
	}
	
	public String actualizarProducto(int id, double costo, String descripcion)
	{
		String respuesta = "";
		ConexionMongo cm = new ConexionMongo();
		respuesta = cm.actualizarProducto(id, costo, descripcion);
		cm.CierraConexion();
		return respuesta;
	}
	

	
	public Producto getProductoId(int id)
	{
		ConexionMongo cm = new ConexionMongo();
		Producto p = cm.obtenerProducto(id);
		cm.CierraConexion();
		return	p;
	}
}
