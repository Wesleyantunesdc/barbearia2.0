package br.com.devantunes.barbearia.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("barbearia");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
