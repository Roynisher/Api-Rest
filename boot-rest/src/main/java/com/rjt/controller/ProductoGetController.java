package com.rjt.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rjt.beans.Producto;
import com.rjt.beans.RegistraProducto;

@RestController
public class ProductoGetController {
	@RequestMapping(method = RequestMethod.GET, value="/producto/buscar")
	  @ResponseBody
	  public Producto obtenerProducto(@RequestParam("id") String id) {
		if(id != null && id.length() > 0)
		{
			return RegistraProducto.getInstance().getProductoId(Integer.parseInt(id));	
		}
		return null;
	  }

}
