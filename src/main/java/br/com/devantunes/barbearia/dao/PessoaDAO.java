package br.com.devantunes.barbearia.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.devantunes.barbearia.model.Pessoa;

public class PessoaDAO {

	public List<Pessoa> buscar(){
		Pessoa p = new Pessoa();
		p.setNome("Wesley Antunes de Camargo");
		
		List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
		lstPessoa.add(p);
		return lstPessoa;
	}
	
}
