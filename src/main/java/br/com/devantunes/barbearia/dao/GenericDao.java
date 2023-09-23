package br.com.devantunes.barbearia.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class GenericDao {
	
	private EntityManager em;
	
	public GenericDao(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getSingle(SQLBuilder sql, Class<T> classe) {
		Query query = em.createNativeQuery(sql.getScript(), classe);
		
		Map<String, Object> parametros = sql.getParametros();
		Set<String> chaves = parametros.keySet();
		
		for(String c: chaves) {
			query.setParameter(c, parametros.get(c));
		}
		
		return (T) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(SQLBuilder sql, Class<T> classe) {
		Query query = em.createNativeQuery(sql.getScript(), classe);
		
		Map<String, Object> parametros = sql.getParametros();
		Set<String> chaves = parametros.keySet();
		
		for(String c: chaves) {
			query.setParameter(c, parametros.get(c));
		}
		
		return query.getResultList();
	}
	
	public void persist(Object obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		}catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
}
