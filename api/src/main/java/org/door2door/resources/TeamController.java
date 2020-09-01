package org.door2door.resources;

import org.door2door.dto.NewTeamDto;
import org.door2door.services.NewTeamService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/organization")
public class 	TeamController {
	NewTeamService newTeamService;

	@Inject
	public TeamController(final NewTeamService newTeamService) {
		this.newTeamService = newTeamService;
	}

	@POST
	public Response createTeam(final NewTeamDto newTeamDto) {
		newTeamService.createTeam(newTeamDto);
		return Response.status(Response.Status.OK).build();
	}
}
