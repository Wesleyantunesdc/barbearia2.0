package br.com.devantunes.barbearia.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import br.com.devantunes.barbearia.dto.ContatoDto;
import br.com.devantunes.barbearia.model.bo.ContatoBO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/contatos")
public class ContatoController {

	@GET
	@Path("/pessoa/{idPessoa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("idPessoa") Integer idPessoa) {
		try {
			List<ContatoDto> lst = new ContatoBO().buscar(idPessoa);

			if (CollectionUtils.isNotEmpty(lst)) {
				return Response.ok().entity(lst).build();
			} else {
				return Response.status(Status.NO_CONTENT).build();
			}
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ContatoDto dto) {
		try {
			ContatoBO bo = new ContatoBO();
			dto.setId(null);
			bo.salvar(dto);
			return Response.ok().status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(ContatoDto dto) {
		try {
			ContatoBO bo = new ContatoBO();
			bo.salvar(dto);
			return Response.ok().status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();

		}

	}

}
