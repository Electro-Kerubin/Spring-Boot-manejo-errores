package com.nerfilin.springboot.manejoerrores.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nerfilin.springboot.manejoerrores.app.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Aquiles", "Baeza"));
		this.lista.add(new Usuario(2, "Juan", "Kutsman"));
		this.lista.add(new Usuario(3, "Amanda", "Muñoz"));
		this.lista.add(new Usuario(4, "Pepe", "Iturria"));
		this.lista.add(new Usuario(5, "Tania", "Rosas"));
		this.lista.add(new Usuario(6, "Kimberly", "Nuñez"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;

		for (Usuario u : this.lista) {
			if (u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}

		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
