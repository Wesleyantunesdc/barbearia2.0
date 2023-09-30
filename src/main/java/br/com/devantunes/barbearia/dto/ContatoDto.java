package br.com.devantunes.barbearia.dto;

import java.io.Serializable;

import br.com.devantunes.barbearia.model.enums.TipoContato;

public class ContatoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private TipoContato tipo;

	private String descricao;

	private Boolean isAtivo;

	private Integer idPessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ContatoDto [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", isAtivo=" + isAtivo
				+ ", idPessoa=" + idPessoa + "]";
	}
}
