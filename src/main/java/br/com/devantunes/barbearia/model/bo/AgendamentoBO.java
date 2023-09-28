package br.com.devantunes.barbearia.model.bo;

import java.util.List;

import br.com.devantunes.barbearia.dao.AgendamentoDAO;
import br.com.devantunes.barbearia.dto.AgendamentoDto;
import br.com.devantunes.barbearia.model.entity.Agendamento;
import br.com.devantunes.barbearia.model.pojo.AgendamentoPojo;

public class AgendamentoBO {

	public List<AgendamentoPojo> buscar() throws Exception {
		try {
			AgendamentoDAO dao = new AgendamentoDAO();
			return dao.buscar();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar agendamentos: " + e.getMessage());
		}
	}

	public AgendamentoPojo buscar(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("É obrigatorio informar o id");

		}
		try {

			AgendamentoDAO dao = new AgendamentoDAO();
			return dao.buscar(id);

		} catch (Exception e) {
			throw new Exception("Erro ao buscar agendamento: " + e.getMessage());
		}
	}

	public AgendamentoDto cadastrar(AgendamentoDto dto) throws Exception {
		try {
			Agendamento agendamento = converter(dto);
			AgendamentoDAO dao = new AgendamentoDAO();
			dao.persist(agendamento);
			return new AgendamentoDto(agendamento);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar o agendamento : " + e.getMessage());
		}
	}

	public AgendamentoDto editar(AgendamentoDto dto) throws Exception {
		if (dto.getId() == null) {
			throw new Exception("É obrigatorio informar o id");
		}

		try {
			Agendamento agendamento = converter(dto);
			AgendamentoDAO dao = new AgendamentoDAO();
			dao.merge(agendamento);

			return new AgendamentoDto(agendamento);
		} catch (Exception e) {
			throw new Exception("Erro ao editar agendamento : " + e.getMessage());
		}

	}

	public Agendamento converter(AgendamentoDto dto) {

		Agendamento obj = new Agendamento();
		obj.setId(dto.getId());
		obj.setDataHora(dto.getDataHora());
		obj.setPessoa(null);

		return obj;

	}
}
