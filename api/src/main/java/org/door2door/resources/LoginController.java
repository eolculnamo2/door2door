package org.door2door.resources;

import org.door2door.dto.LoginDto;
import org.door2door.dto.TeamDto;
import org.door2door.services.LoginService;
import org.door2door.services.TokenService;
import org.door2door.util.Roles;
import org.jboss.resteasy.spi.HttpResponse;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Path("/login")
@ApplicationScoped
public class LoginController {
  private LoginService loginService;

  @Context
  SecurityContext securityContext;

  @Inject
  TokenService tokenService;

  public LoginController (LoginService loginService){
    this.loginService = loginService;
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @PermitAll
  public Response login(final LoginDto login, HttpResponse response) {
    TeamDto team = loginService.validateLogin(login);
    if (loginService.validateLogin(login) == null){
      return Response.status(Status.NOT_FOUND).entity(login).build();
    }
    String token = tokenService.generateToken(team.getName(), team.getEmail(), Roles.ADMIN);
    NewCookie jwt = new NewCookie("JWT" , token);
    response.addNewCookie(jwt);
    return Response.status(Status.OK).entity(login).build();
  }
}
