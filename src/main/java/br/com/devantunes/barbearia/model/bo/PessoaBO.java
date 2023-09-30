package br.com.devantunes.barbearia.model.bo;

import java.util.List;

import br.com.devantunes.barbearia.dao.PessoaDAO;
import br.com.devantunes.barbearia.dto.PessoaDto;
import br.com.devantunes.barbearia.model.entity.Pessoa;

public class PessoaBO {

	//Modificar a classe para trabalhar com dto
	
	
	public List<Pessoa> buscar() throws Exception {
		try {
			PessoaDAO dao = new PessoaDAO();
			return dao.buscar();
		} catch (Exception e) {
			
			throw new Exception("Erro ao buscar pessoas: " + e.getMessage());
		}
	}

	public Pessoa buscar(Integer id) throws Exception {
		if(id == null) {
			throw new Exception("É obrigatorio informar o id");
		}
		
		try {
			PessoaDAO dao = new PessoaDAO();
			return dao.buscar(id);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar pessoa: " + e.getMessage());
		}
	}
	
	public Pessoa cadastrar(Pessoa pessoa) throws Exception {
		try {
			PessoaDAO dao = new PessoaDAO();
			dao.persist(pessoa);
			return pessoa;
		} catch (Exception e) {
			throw new Exception("Erro ao salvar pessoa: " + e.getMessage());
		}
	}
	
	
	public Pessoa editar(PessoaDto dto) throws Exception {
		if(dto.getId() == null) { 
			throw new Exception("É obrigatorio informar o id");
		}
		
		try {
			Pessoa pessoa = buscar(dto.getId());
			pessoa.setNome(dto.getNome());
			pessoa.setCpf(dto.getCpf());
			pessoa.setRg(dto.getRg());
			pessoa.setGenero(dto.getGenero());
			pessoa.setDtNascimento(dto.getDtNascimento());
			
			PessoaDAO dao = new PessoaDAO();
			dao.merge(pessoa);
			return pessoa;
		} catch (Exception e) {
			throw new Exception("Erro ao editar pessoa: " + e.getMessage());
		}
	}
}
