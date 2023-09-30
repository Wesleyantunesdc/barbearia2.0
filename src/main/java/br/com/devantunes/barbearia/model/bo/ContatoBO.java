package br.com.devantunes.barbearia.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.devantunes.barbearia.dao.ContatoDAO;
import br.com.devantunes.barbearia.dto.ContatoDto;
import br.com.devantunes.barbearia.model.entity.Contato;
import br.com.devantunes.barbearia.model.entity.Pessoa;

public class ContatoBO {

	public List<ContatoDto> buscar(Integer idPessoa) throws Exception {
		try {
			ContatoDAO dao = new ContatoDAO();
			List<Contato> lst = dao.buscar(idPessoa, Boolean.TRUE);
			return converter(lst);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar contatos: " + e.getMessage());
		}
	}

	public void salvar(ContatoDto dto) throws Exception {
		validarPersistencia(dto);
		Contato contato = converter(dto);
		ContatoDAO dao = new ContatoDAO();
		if (contato.getId() == null) {
			dao.persist(contato);
		} else {
			dao.merge(contato);
		}
	}

	private void validarPersistencia(ContatoDto dto) throws Exception {

		if (dto == null) {
			throw new IllegalArgumentException("O objeto está nulo");
		}

		if (dto.getIdPessoa() == null) {
			throw new IllegalArgumentException("A pessoa relacionada ao contato não foi informada");
		}

		PessoaBO pessoaBO = new PessoaBO();
		Pessoa pessoa = pessoaBO.buscar(dto.getIdPessoa());
		if (pessoa == null) {
			throw new IllegalArgumentException("A pessoa relacionada ao contato não existe");
		}

		if (dto.getTipo() == null || StringUtils.isBlank(dto.getDescricao())) {
			throw new IllegalArgumentException("A contato não foi preenchido corretamente");
		}
	}

	private List<ContatoDto> converter(List<Contato> lst) {
		List<ContatoDto> lstDto = new ArrayList<ContatoDto>();
		lst.forEach(c -> lstDto.add(converter(c)));
		return lstDto;
	}

	private ContatoDto converter(Contato obj) {
		ContatoDto dto = new ContatoDto();
		dto.setId(obj.getId());
		dto.setTipo(obj.getTipoContato());
		dto.setDescricao(obj.getDescricao());
		dto.setIsAtivo(obj.getIsAtivo().equals(1) ? true : false);
		dto.setIdPessoa(obj.getIdPessoa());
		return dto;
	}

	private Contato converter(ContatoDto dto) {
		Contato obj = new Contato();
		obj.setId(dto.getId());
		obj.setTipoContato(dto.getTipo());
		obj.setDescricao(dto.getDescricao());
		obj.setIsAtivo(dto.getIsAtivo() ? 1 : 0);
		obj.setIdPessoa(dto.getIdPessoa());
		return obj;
	}
}
