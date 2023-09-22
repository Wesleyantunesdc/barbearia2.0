package br.com.devantunes.barbearia.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.devantunes.barbearia.model.Pessoa;
import jakarta.persistence.EntityManager;

public class PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pessoa pessoa) {
		em.persist(pessoa);
	}

	public List<Pessoa> buscar(){
		Pessoa p = new Pessoa();
		p.setId(1);
		p.setNome("Wesley Antunes de Camargo");
		p.setCpf("12661541918");
		//p.setDtNascimento(LocalDate.now());
		p.setGenero('M');
		
		List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
		lstPessoa.add(p);
		return lstPessoa;
	}
	
}
