package org.door2door.resources;

import org.door2door.dto.LoginDto;
import org.door2door.services.LoginService;;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/login")
public class LoginController {
  private LoginService loginService;

  public LoginController (LoginService loginService){
    this.loginService = loginService;
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response login(final LoginDto login) {
    if (!loginService.validateLogin(login)){
      return Response.status(Status.NOT_FOUND).entity(login).build();
    }
    return Response.status(Status.OK).entity(login).build();

  }
}
