package br.com.devantunes.barbearia.controller;

import br.com.devantunes.barbearia.dao.UsuarioDAO;
import br.com.devantunes.barbearia.model.Usuario;

public class Cadastro {

	public static void main(String[] args) {
		cadastrar();
	}

	
	private static void buscar() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscar("wesley_antunes", "1234");
		System.out.println(usuario);
	}
	
	private static void cadastrar() {
		Usuario usuario = new Usuario();
		usuario.setUsername("wesley_antunes");
		usuario.setSenha("1234");
		usuario.setIsAtivo(1);
//		Pessoa p = new Pessoa();
//		p.setId(1);
		
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.cadastrar(usuario);
		
	}
}