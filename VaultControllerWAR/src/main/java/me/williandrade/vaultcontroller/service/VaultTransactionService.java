package me.williandrade.vaultcontroller.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.williandrade.vaultcontroller.dto.ResponseDTO;
import me.williandrade.vaultcontroller.dto.VaultTransactionDTO;
import me.williandrade.vaultcontroller.handler.UserRequestHandler;
import me.williandrade.vaultcontroller.session.VaultTransactionSession;
import me.williandrade.vaultcontroller.util.RestReponseUtil;

@Stateless
@Path("/vaulttransaction")
public class VaultTransactionService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private VaultTransactionSession vaultTransactionSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/vault/{vaultId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllByVoult(@PathParam("vaultId") Integer vaultId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultTransactionSession.findAllByVoult(vaultId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/view/{viewId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllByView(@PathParam("viewId") Integer viewId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultTransactionSession.findAllByView(viewId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/view/{viewId}/period")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllFromPeriodByView(@PathParam("viewId") Integer viewId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultTransactionSession.findAllFromPeriodByView(viewId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/vault/{vaultId}/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllByUserAndVoult(@PathParam("userId") Integer userId, @PathParam("vaultId") Integer vaultId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultTransactionSession.findAllByUserAndVoult(userId, vaultId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(VaultTransactionDTO vaultTransaction) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(vaultTransactionSession.create(vaultTransaction));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@DELETE
	@Path("/{transactionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("transactionId") Integer transactionId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			vaultTransactionSession.delete(transactionId);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
