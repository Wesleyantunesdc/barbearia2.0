package br.com.devantunes.barbearia.dao;

import java.util.List;

import br.com.devantunes.barbearia.model.entity.Contato;
import br.com.devantunes.barbearia.util.HibernateUtil;
import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;

public class ContatoDAO extends GenericDAO<Integer, Contato> {

	public ContatoDAO() {
		super(HibernateUtil.getEntityManager());
	}

	public ContatoDAO(EntityManager em) {
		super(HibernateUtil.getEntityManager());
	}

	public Contato buscar(Integer id) throws Exception {
		return getById(id);
	}

	public List<Contato> buscar(Integer idPessoa, Boolean isAtivo) {
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT ID_CONTATO,TP_CONTATO, DS_CONTATO, FL_ATIVO, ID_PESSOA  ");
		sql.append("FROM CONTATO C  ");
		sql.append("WHERE C.ID_PESSOA = :idPessoa ");
		
		if(isAtivo != null) {
			sql.append("AND C.FL_ATIVO = :isAtivo ");
			sql.setParameter("isAtivo", isAtivo ? 1 : 0);
		}
		
		sql.append("ORDER BY C.FL_ATIVO, C.TP_CONTATO ");
		
		sql.setParameter("idPessoa", idPessoa);
		return getList(sql, Contato.class);
	}

	public void cadastrar(Contato contato) {
		persist(contato);
	}

	public void editar(Contato contato) {
		merge(contato);
	}
}
