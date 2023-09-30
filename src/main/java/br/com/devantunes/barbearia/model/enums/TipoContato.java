package br.com.devantunes.barbearia.model.enums;

public enum TipoContato {

	TELEFONE("Telefone", 1), 
	EMAIL("Email", 2);

	private String descricao;
	private Integer codigo;

	private TipoContato(String descricao, Integer codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
