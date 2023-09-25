package br.com.devantunes.barbearia.dao;

import br.com.devantunes.barbearia.model.entity.Usuario;
import br.com.devantunes.barbearia.util.HibernateUtil;
import br.com.devantunes.barbearia.util.SQLBuilder;
import jakarta.persistence.EntityManager;

public class UsuarioDAO extends GenericDao {

	public UsuarioDAO() {
		super(HibernateUtil.getEntityManager());
	}

	public UsuarioDAO(EntityManager em) {
		super(em);
	}

	public Usuario buscar(String username, String senha) {
		SQLBuilder sql = new SQLBuilder();
		sql.append("SELECT P.nr_cpf, P.nm_pessoa  ");
		sql.append("FROM PESSOA P ");
		
		
		
		
		sql.append("SELECT * FROM USUARIO U ");
		sql.append("WHERE U.NM_USERNAME = :username ");
		sql.append("AND U.VL_SENHA = :senha ");
		sql.setParameter("username", username);
		sql.setParameter("senha", senha);
		
		
		return (Usuario) getSingle(sql, Usuario.class);
	}

	public void cadastrar(Usuario usuario) {
		persist(usuario);
	}
}
