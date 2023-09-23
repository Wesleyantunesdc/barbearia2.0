package br.com.devantunes.barbearia.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Integer id;

	@Column(name = "NM_PESSOA", length = 120, nullable = false)
	private String nome;

	@Column(name = "NR_CPF")
	private String cpf;

	@Column(name = "NR_RG")
	private String rg;

	@Column(name = "TP_GENERO")
	private Character genero;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")  
	@Column(name = "DT_NASCIMENTO")
	private LocalDateTime dtNascimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public LocalDateTime getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", genero=" + genero
				+ ", dtNascimento=" + dtNascimento + "]";
	}

}
