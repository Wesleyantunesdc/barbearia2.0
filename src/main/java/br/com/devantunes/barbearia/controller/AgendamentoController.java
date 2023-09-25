package br.com.devantunes.barbearia.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import br.com.devantunes.barbearia.dto.AgendamentoDto;
import br.com.devantunes.barbearia.model.bo.AgendamentoBO;
import br.com.devantunes.barbearia.model.entity.Agendamento;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/agendamentos")
public class AgendamentoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar() {
		try {
			AgendamentoBO bo = new AgendamentoBO();
			List<Agendamento> lstAgendamento = bo.buscar();

			if (CollectionUtils.isNotEmpty(lstAgendamento)) {
				return Response.ok().entity(lstAgendamento).build();
			} else {
				return Response.status(Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(AgendamentoDto dto) {
		return null;
	}

}
