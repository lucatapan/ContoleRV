package com.br.controleRV.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.br.controleRV.model.Produto;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Produtos(EntityManager manager) {
		this.manager = manager;

	}

	//////////////////////////////////////////////

	public Produto porId(Long id) {

		return manager.find(Produto.class, id);

	}

	public Produto guardar(Produto produto) {

		return this.manager.merge(produto);

	}
	
	public void remover(Produto produto) {
		
		this.manager.remove(produto);
		
	}
	
	///////////////////////////////////////////////////
	
	
	public List<Produto> todos(){   
		
		
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		
		return query.getResultList();
		
	}
	
	public void adicionar(Produto produto) {
		
		this.manager.persist(produto);
		
	}

}
