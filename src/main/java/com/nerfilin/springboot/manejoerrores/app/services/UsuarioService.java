package com.nerfilin.springboot.manejoerrores.app.services;

import java.util.List;
import java.util.Optional;

import com.nerfilin.springboot.manejoerrores.app.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listar();
	
	public Usuario obtenerPorId(Integer id);
	
	public Optional<Usuario> obtenerPorIdOptional(Integer id);
}
