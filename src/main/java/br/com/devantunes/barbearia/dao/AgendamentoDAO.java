package br.com.devantunes.barbearia.dao;

import java.util.List;

import br.com.devantunes.barbearia.model.entity.Agendamento;
import br.com.devantunes.barbearia.util.HibernateUtil;
import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;

public class AgendamentoDAO extends GenericDao {
	
	public AgendamentoDAO() {
		super(HibernateUtil.getEntityManager());
	}
	
	public AgendamentoDAO(EntityManager em) {
		super(HibernateUtil.getEntityManager());
	}
	
	public SQLBuilder montarBase() {
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT A.ID_AGENDAMENTO, A.ID_PESSOA, A.DH_AGENDAMENTO ");
		sql.append(" FROM AGENDAMENTO A  ");
		return sql;
	}

	public List<Agendamento> buscar(){
		SQLBuilder sql = montarBase();
		sql.append("ORDER BY A.DH_AGENDAMENTO");
		return getList(sql, Agendamento.class);
	}
	
	
	public Agendamento buscar(Integer id) {
		SQLBuilder sql = montarBase();
		sql.append("WHERE A.ID_AGENDAMENTO = :idAgendamento");
		sql.setParameter("idAgendamento", id);
		return getSingle(sql, Agendamento.class);
	}
}
