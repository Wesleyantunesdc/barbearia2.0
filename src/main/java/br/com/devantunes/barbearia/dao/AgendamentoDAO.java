package br.com.devantunes.barbearia.dao;

import java.util.List;

import br.com.devantunes.barbearia.model.entity.Agendamento;
import br.com.devantunes.barbearia.util.HibernateUtil;
import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDAO<Integer, Agendamento> {
	
	public AgendamentoDAO() {
		super(HibernateUtil.getEntityManager());
	}
	
	public AgendamentoDAO(EntityManager em) {
		super(HibernateUtil.getEntityManager());
	}
	
	public List<Agendamento> buscar(){
		return findAll();
	}
}
