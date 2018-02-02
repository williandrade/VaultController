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
import me.williandrade.vaultcontroller.session.VaultViewSession;
import me.williandrade.vaultcontroller.util.RestReponseUtil;

@Stateless
@Path("/vaultview")
public class VaultViewService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private VaultViewSession vaultViewSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultViewSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{viewId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("viewId") Integer viewId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultViewSession.findById(viewId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
	
	@GET
	@Path("/{viewId}/complete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByIdComplete(@PathParam("viewId") Integer viewId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultViewSession.findByIdComplete(viewId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/vault/{vaultId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByVaultId(@PathParam("vaultId") Integer vaultId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultViewSession.findByVaultId(vaultId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
