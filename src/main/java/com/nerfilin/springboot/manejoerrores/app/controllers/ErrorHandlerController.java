package com.nerfilin.springboot.manejoerrores.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nerfilin.springboot.manejoerrores.app.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler({ArithmeticException.class})
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmetica.");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
	
	@ExceptionHandler({NumberFormatException.class})
	public String numberFormatException(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Error formato numero invalido");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
	
	@ExceptionHandler({UsuarioNoEncontradoException.class})
	public String usuarioNoEncontrado(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "Error: Usuario no existe.");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/usuario";
	}
}
