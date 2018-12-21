package com.br.controleRV.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.br.controleRV.model.Estoque;

public class Estoques implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Estoques(EntityManager manager) {
		this.manager = manager;

	}

	//////////////////////////////////////////////

	public Estoque porId(Long id) {

		return manager.find(Estoque.class, id);

	}

	public Estoque guardar(Estoque estoque) {

		return this.manager.merge(estoque);

	}
	
	public void remover(Estoque estoque) {
		
		this.manager.remove(estoque);
		
	}
	
	///////////////////////////////////////////////////
	
	
	public List<Estoque> todos(){   
		
		
		TypedQuery<Estoque> query = manager.createQuery("from Estoque", Estoque.class);
		
		return query.getResultList();
		
	}
	
	public void adicionar(Estoque estoque) {
		
		this.manager.persist(estoque);
		
	}

}
