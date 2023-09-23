package br.com.devantunes.barbearia.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import br.com.devantunes.barbearia.model.bo.PessoaBO;
import br.com.devantunes.barbearia.model.entity.Pessoa;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/pessoas")
public class PessoaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar() {
		try {
			PessoaBO bo = new PessoaBO();
			List<Pessoa> lstPessoa = bo.buscar();

			if (CollectionUtils.isNotEmpty(lstPessoa)) {
				return Response.ok().entity(lstPessoa).build();
			} else {
				return Response.status(Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") Integer id) {
		try {
			PessoaBO bo = new PessoaBO();
			Pessoa pessoa = bo.buscar(id);

			if (pessoa != null) {
				return Response.ok().entity(pessoa).build();
			} else {
				return Response.status(Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response buscar(@PathParam("id") Integer id) {
//		try {
//			PessoaBO bo = new PessoaBO();
//			Pessoa pessoa = bo.buscar(id);
//
//			if (pessoa != null) {
//				return Response.ok().entity(pessoa).build();
//			} else {
//				return Response.status(Status.NO_CONTENT).build();
//			}
//		} catch (Exception e) {
//			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//		}
//	}

}
