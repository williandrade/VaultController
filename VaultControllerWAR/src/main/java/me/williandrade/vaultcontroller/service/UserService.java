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

import me.williandrade.vaultcontroller.annotation.OpenMethodAnnotation;
import me.williandrade.vaultcontroller.dto.ResponseDTO;
import me.williandrade.vaultcontroller.handler.UserRequestHandler;
import me.williandrade.vaultcontroller.session.UserSession;
import me.williandrade.vaultcontroller.util.RestReponseUtil;

@Stateless
@Path("/user")
public class UserService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private UserSession userSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response find() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
//			response.setPayLoad(userSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response findByName(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
//			response.setPayLoad(userSession.findById(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
