package br.com.devantunes.barbearia.dao;

import java.util.List;

import br.com.devantunes.barbearia.model.entity.Agendamento;
import br.com.devantunes.barbearia.model.pojo.AgendamentoPojo;
import br.com.devantunes.barbearia.util.HibernateUtil;
import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDAO<Integer, Agendamento> {
	
	public AgendamentoDAO() {
		super(HibernateUtil.getEntityManager());
	}
	
	public AgendamentoDAO(EntityManager em) {
		super(HibernateUtil.getEntityManager());
	}
	
	public List<AgendamentoPojo> buscar(){
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT A.id_agendamento, A.dh_agendamento, P.id_pessoa, P.nm_pessoa ");
		sql.append("FROM agendamento a ");
		sql.append("INNER JOIN pessoa p ON P.id_pessoa  = A.id_pessoa ");
		return getList(sql, AgendamentoPojo.class);
	}
	
	public AgendamentoPojo buscar(Integer id) {
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT A.id_agendamento, A.dh_agendamento, P.id_pessoa, P.nm_pessoa ");
		sql.append("FROM agendamento a ");
		sql.append("INNER JOIN pessoa p ON P.id_pessoa  = A.id_pessoa ");
		sql.append("WHERE a.id_agendamento  = :id ");
		return getSingle(sql, AgendamentoPojo.class);
	}
}
