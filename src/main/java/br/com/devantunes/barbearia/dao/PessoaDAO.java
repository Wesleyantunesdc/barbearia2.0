package br.com.devantunes.barbearia.dao;

import java.util.List;

import br.com.devantunes.barbearia.model.entity.Pessoa;
import br.com.devantunes.barbearia.model.entity.Usuario;
import br.com.devantunes.barbearia.util.HibernateUtil;
import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;

public class PessoaDAO extends GenericDao{
	
	public PessoaDAO() {
		super(HibernateUtil.getEntityManager());
	}
	
	public PessoaDAO(EntityManager em) {
		super(HibernateUtil.getEntityManager());
	}
	
	public void cadastrar(Pessoa pessoa) {
		persist(pessoa);
	}
	
	public SQLBuilder montarBase() {
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT P.ID_PESSOA, P.NM_PESSOA, P.NR_CPF, P.NR_RG, ");
		sql.append("P.TP_GENERO, P.DT_NASCIMENTO FROM PESSOA P ");
		return sql;
	}
	
	
	public Pessoa buscar(Integer id) {
		SQLBuilder sql = montarBase();
		sql.append("WHERE P.ID_PESSOA = :idPessoa ");
		sql.setParameter("idPessoa", id);
		return getSingle(sql, Pessoa.class);
	}
	

	public List<Pessoa> buscar(){
		SQLBuilder sql = montarBase();
		sql.append("ORDER BY P.NM_PESSOA ASC ");
		return getList(sql, Pessoa.class);
	}
	
}
