package com.nerfilin.springboot.manejoerrores.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nerfilin.springboot.manejoerrores.app.domain.Usuario;
import com.nerfilin.springboot.manejoerrores.app.errors.UsuarioNoEncontradoException;
import com.nerfilin.springboot.manejoerrores.app.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("unused")
	@RequestMapping("/index")
	public String index() {
		
		Integer valor = Integer.parseInt("10x");
		return "index";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/aritmetico")
	public String aritmetico() {
		Integer valor = 100/0;
		return "aritmetico";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/numberFormat")
	public String numberFormat() {
		Integer valor = Integer.parseInt("10x");
		return "numberFormat";
	}
	
	@RequestMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		Usuario usuario = usuarioService.obtenerPorId(id);
		
		if(usuario==null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
