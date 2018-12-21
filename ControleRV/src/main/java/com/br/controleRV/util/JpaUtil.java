package com.br.controleRV.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	public static void main(String[] args) {
		
	}
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("controlervPU");
	}
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
		
	}
}
