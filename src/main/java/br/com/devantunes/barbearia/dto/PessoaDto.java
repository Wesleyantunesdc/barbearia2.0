package br.com.devantunes.barbearia.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public class PessoaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotBlank(message = "O nome é um campo obrigatório")
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	@NotBlank(message = "O genero é um campo obrigatório")
	private Character genero;
	
	@Past(message = "A data de nascimento deve ser anterior ao dia de hoje")
	private LocalDate dtNascimento;
	
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
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", genero=" + genero
				+ ", dtNascimento=" + dtNascimento + "]";
	}
	
	
	
}
