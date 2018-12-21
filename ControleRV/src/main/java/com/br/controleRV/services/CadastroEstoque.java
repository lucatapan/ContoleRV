package com.br.controleRV.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.controleRV.model.Estoque;
import com.br.controleRV.repository.Estoques;
import com.br.controleRV.util.Transactional;

public class CadastroEstoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Estoques estoques;

	@Transactional
	public void salvar(Estoque estoque) {

		this.estoques.guardar(estoque);
	}

	@Transactional
	public void excluir(Estoque estoque) throws NegocioException {

		estoque = this.estoques.porId(estoque.getId());
		this.estoques.remover(estoque);

	}

}
