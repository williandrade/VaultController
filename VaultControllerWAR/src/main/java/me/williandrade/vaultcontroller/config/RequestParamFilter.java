package me.williandrade.vaultcontroller.config;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import me.williandrade.vaultcontroller.annotation.OpenMethodAnnotation;
//import me.williandrade.vaultcontroller.dto.UserDTO;
import me.williandrade.vaultcontroller.handler.UserRequestHandler;
//import me.williandrade.vaultcontroller.session.LoginSession;
//import me.williandrade.vaultcontroller.session.UserSession;
import me.williandrade.vaultcontroller.util.Constants;

@Provider
public class RequestParamFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Context
	private HttpServletRequest servletRequest;

	@Inject
	private UserRequestHandler userRequestHandler;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String userUuid = servletRequest.getHeader("User-Uuid");

		if (!Constants.DEBUG_MODE) {

			if (!resourceInfo.getResourceMethod().isAnnotationPresent(OpenMethodAnnotation.class)) {
				if (userUuid == null) {
					requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
					return;
				}

				// try {
				// // VALID USER, IF USER HAVE PERMISSION
				// // user = userSession.findByUuid(userUuid);
				//
				// if (user == null) {
				// requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
				// return;
				// } else {
				// if (!loginSession.isTheUserValid(user)) {
				// requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
				// return;
				// }
				// }
				//
				// // } catch (TimeoutException te) {
				// // requestContext.abortWith(Response.status(Status.REQUEST_TIMEOUT).build());
				// // return;
				// } catch (Exception e) {
				// requestContext.abortWith(Response.status(Status.INTERNAL_SERVER_ERROR).build());
				// return;
				// }
				// }
			}
		}

		// userRequestHandler.setApplication(applicationUuid);
		// userRequestHandler.setUser(user);
		userRequestHandler.setStartRequest(new Date());

	}

}
