package com.br.controleRV.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.controleRV.model.Usuario;
import com.br.controleRV.repository.Usuarios;
import com.br.controleRV.util.Transactional;

public class CadastroUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Transactional
	public void salvar(Usuario usuario) {

		this.usuarios.guardar(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) throws NegocioException {

		usuario = this.usuarios.porId(usuario.getId());
		this.usuarios.remover(usuario);

	}

}
