package com.rjt.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjt.beans.RegistraProducto;

@RestController
public class ProductoPostController {
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value="/producto/registrar")
	
	@ResponseBody
	public String registrarProducto(@RequestParam("nombre") String nombre, @RequestParam("costo") String costo, @RequestParam("inventario") String inventario,@RequestParam("descripcion") String descripcion)
	{
	//	System.out.println("Aqui va bien...");
		//return "Hola Mundo...";
		return RegistraProducto.getInstance().agregarProducto(nombre, Double.parseDouble(costo), Integer.parseInt(inventario), descripcion) + "";	
	}

}
