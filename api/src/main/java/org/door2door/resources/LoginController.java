package org.door2door.resources;

import org.door2door.constants.AuthConstants;
import org.door2door.dto.LoginDto;
import org.door2door.dto.TeamDto;
import org.door2door.services.LoginService;
import org.door2door.services.TokenService;
import org.door2door.util.Roles;

import javax.annotation.security.PermitAll;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

@Path("/login")
public class LoginController {
  private LoginService loginService;
  private TokenService tokenService;

  @Context
  SecurityContext securityContext;


  public LoginController (final LoginService loginService, final TokenService tokenService){
    this.loginService = loginService;
    this.tokenService = tokenService;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String test() {
    return "test";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @PermitAll
  public Response login(final LoginDto login) {
//    TeamDto team = loginService.validateLogin(login);
//    if (team == null){
//      return Response.status(Status.NOT_FOUND).entity(login).build();
//    }
    TeamDto team = new TeamDto();
    team.setName("Test");
    team.setEmail("Test@test.com");
    String token = tokenService.generateToken(team.getName(), team.getEmail(), Roles.ADMIN);

    // todo add domain
    NewCookie cookie = new NewCookie(AuthConstants.AUTH_COOKIE, token, "/", null,
            "", Math.toIntExact(AuthConstants.TOKEN_TIMEOUT) / 1000, false, true);
    return Response.status(Status.OK).cookie(cookie).entity(login).build();
  }
}
