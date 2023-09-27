package br.com.devantunes.barbearia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.devantunes.barbearia.model.entity.Agendamento;

public class AgendamentoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private LocalDateTime dataHora;
	private Integer idPessoa;

	public AgendamentoDto() {

	}

	public AgendamentoDto(Agendamento a) {
		this.id = a.getId();
		this.dataHora = a.getDataHora();
		this.idPessoa = a.getIdPessoa();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

}
