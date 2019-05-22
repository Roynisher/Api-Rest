package com.rjt.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.rjt.beans.RegistraProducto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ProductoPutController {
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.GET},value="/producto/actualizar")
	
	@ResponseBody
	public String actualizarProducto(@RequestParam("id") String id, @RequestParam("costo") String costo, @RequestParam("descripcion") String descripcion)
	{
		return RegistraProducto.getInstance().actualizarProducto(Integer.parseInt(id),Double.parseDouble(costo), descripcion);
	}
}
