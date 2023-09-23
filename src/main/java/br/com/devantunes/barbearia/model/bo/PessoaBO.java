package br.com.devantunes.barbearia.model.bo;

import java.util.List;

import br.com.devantunes.barbearia.dao.PessoaDAO;
import br.com.devantunes.barbearia.model.entity.Pessoa;

public class PessoaBO {

	public List<Pessoa> buscar() throws Exception {
		try {
			PessoaDAO dao = new PessoaDAO();
			return dao.buscar();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar pessoas: " + e.getMessage());
		}
	}

	public Pessoa buscar(Integer id) throws Exception {
		try {
			PessoaDAO dao = new PessoaDAO();
			return dao.buscar(id);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar pessoa: " + e.getMessage());
		}
	}

}
