package br.com.devantunes.barbearia.util;

import java.util.HashMap;
import java.util.Map;

public class SQLBuilder {

	private Map<String, Object> parametros;
	private StringBuilder sql;
	
	public SQLBuilder() {
		parametros = new HashMap<String, Object>();
		sql = new StringBuilder();
	}
	
	
	public void setParameter(String chave, Object valor) {
		parametros.put(chave, valor);
	}
	
	public void append(String sql) {
		this.sql.append(sql);
	}
	
	public String getScript() {
		return sql.toString();
	}
	
	public Map<String, Object> getParametros() {
		return parametros;
	}
	
}
