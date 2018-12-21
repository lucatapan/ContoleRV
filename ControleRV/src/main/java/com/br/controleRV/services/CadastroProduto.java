package com.br.controleRV.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.controleRV.model.Produto;
import com.br.controleRV.repository.Produtos;
import com.br.controleRV.util.Transactional;

public class CadastroProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	@Transactional
	public void salvar(Produto produto) {

		this.produtos.guardar(produto);
	}

	@Transactional
	public void excluir(Produto produto) throws NegocioException {

		produto = this.produtos.porId(produto.getId());
		this.produtos.remover(produto);

	}

}
