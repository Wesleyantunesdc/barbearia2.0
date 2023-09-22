package br.com.devantunes.barbearia.controller;

import java.util.List;

import br.com.devantunes.barbearia.model.Pessoa;
import br.com.devantunes.barbearia.dao.PessoaDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoas")
public class PessoaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar() {
		try {
			PessoaDAO dao = new PessoaDAO();
			List<Pessoa> lstPessoa = dao.buscar();
			return Response.ok().entity(lstPessoa).build();
		}catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
