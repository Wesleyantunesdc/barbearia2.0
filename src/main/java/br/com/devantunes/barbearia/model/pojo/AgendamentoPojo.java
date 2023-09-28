package br.com.devantunes.barbearia.model.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AgendamentoPojo {

	@Id
	@Column(name = "ID_AGENDAMENTO")
	private Integer id;
	
	@Column(name = "DH_AGENDAMENTO")
	private LocalDateTime dataHora;
	
	@Column(name = "ID_PESSOA")
	private Integer idPessoa;
	
	@Column(name = "NM_PESSOA")
	private String nome;
	
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
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
