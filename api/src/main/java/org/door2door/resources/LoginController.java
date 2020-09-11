package org.door2door.resources;

import org.door2door.dto.LoginDto;
import org.door2door.services.LoginService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/login")
@RequestScoped
public class LoginController {
  private LoginService loginService;

  public LoginController (LoginService loginService){
    this.loginService = loginService;
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response login(final LoginDto login) {
    if (loginService.validateLogin(login) == null){
      return Response.status(Status.NOT_FOUND).entity(login).build();
    }
    return Response.status(Status.OK).entity(login).build();

  }
}
