package br.com.devantunes.barbearia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class GenericDAO<PK, T>{
	
	private EntityManager em;
	
	public GenericDAO(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public T getById(PK pk) {
		return (T) em.find(getTypeClass(), pk);	
	}
	
	public void persist(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public void merge(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public void delete(T entity) {
		em.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}
	
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T getSingle(SQLBuilder sql, Class<T> classe){
		Query query = em.createNativeQuery(sql.getScript(), classe);

		Map<String, Object> parametros = sql.getParametros();
		Set<String> chaves = parametros.keySet();

		for (String c : chaves) {
			query.setParameter(c, parametros.get(c));
		}

		return (T) query.getSingleResult();
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> getList(SQLBuilder sql, Class<T> classe) {
		Query query = em.createNativeQuery(sql.getScript(), classe);

		Map<String, Object> parametros = sql.getParametros();
		Set<String> chaves = parametros.keySet();

		for (String c : chaves) {
			query.setParameter(c, parametros.get(c));
		}

		return query.getResultList();
	}
	
	private Class<?> getTypeClass(){
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
	}
}
