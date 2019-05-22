package com.rjt.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ConexionMongo {
	MongoClient mongo;
	DB BaseDatos;
	DBCollection coleccion;
	BasicDBObject document = new BasicDBObject();
	
	public ConexionMongo()
	{
		try
		{
			mongo = new MongoClient("localhost",27017);
			BaseDatos = mongo.getDB("apirest");
			coleccion = BaseDatos.getCollection("Productos");
			System.out.println("Conectado..............");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void CierraConexion()
	{
		try
		{
			mongo.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public int insertarProducto(String nombre, double costo, int inventario, String descripcion)
	{
		int newId = 0;
		//BasicDBObject query = new BasicDBObject();
		//BasicDBObject field = new BasicDBObject();
		try
		{
			//field.put("id", 1);
			
			//DBCursor cursor = coleccion.find(query,field);
			DBCursor cursor = coleccion.find();
			cursor.limit(1).sort(new BasicDBObject("id", -1));
			while(cursor.hasNext())
			{
				BasicDBObject obj = (BasicDBObject) cursor.next();
				System.out.println(obj.getString("id"));
				newId = Integer.parseInt(obj.getString("id")) + 1;
			}
			
			if(newId == 0)
			{
				newId = 1;
			}
			
			BasicDBObject valores = new BasicDBObject();
			
			valores.put("id",newId);
			valores.put("nombre",nombre);
			valores.put("costo",costo);
			valores.put("no_inv",inventario);
			valores.put("descripcion",descripcion);
			
			coleccion.insert(valores);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return newId;
	}
	
	public Producto obtenerProducto(int id)
	{
		Producto prod = new Producto();
		try
		{
			BasicDBObject query = new BasicDBObject();
			query.put("id", id);
			
			DBCursor cursor = coleccion.find(query);
			while(cursor.hasNext())
			{
				BasicDBObject obj = (BasicDBObject) cursor.next();
				prod.setId(Integer.parseInt(obj.getString("id")));
				prod.setNombre(obj.getString("nombre"));
				prod.setCosto(Double.parseDouble(obj.getString("costo")));
				prod.setInventario(Integer.parseInt(obj.getString("no_inv")));
				prod.setDescripcion(obj.getString("descripcion"));
			}	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return prod;
	}
	
	public String actualizarProducto(int id, double costo, String descripcion)
	{
		String respuesta = "";
		try
		{
			BasicDBObject query = new BasicDBObject();
			query.put("id", id);
			
			BasicDBObject updates = new BasicDBObject();
			updates.put("costo",costo);
			updates.put("descripcion",descripcion);
			
			BasicDBObject set = new BasicDBObject("$set", updates);
			
			coleccion.update(query, set);
			
			respuesta = "Modificado exitosamente!";
		}
		catch(Exception ex)
		{
			respuesta = ex.getMessage();
		}

		return respuesta;
	}

}
