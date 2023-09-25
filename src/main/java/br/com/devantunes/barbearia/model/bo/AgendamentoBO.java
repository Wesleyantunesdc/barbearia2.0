package br.com.devantunes.barbearia.model.bo;

import java.util.List;

import br.com.devantunes.barbearia.dao.AgendamentoDAO;
import br.com.devantunes.barbearia.model.entity.Agendamento;

public class AgendamentoBO {
	public List<Agendamento> buscar() throws Exception {
		try {
			AgendamentoDAO dao = new AgendamentoDAO();
			return dao.buscar();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar agendamentos: " + e.getMessage());
		}
	}
}
