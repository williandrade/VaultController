package me.williandrade.vaultcontroller.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.williandrade.vaultcontroller.dto.ResponseDTO;
import me.williandrade.vaultcontroller.handler.UserRequestHandler;
import me.williandrade.vaultcontroller.session.VaultSession;
import me.williandrade.vaultcontroller.util.RestReponseUtil;

@Stateless
@Path("/vault")
public class VaultService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private VaultSession vaultSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllByVoult() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
