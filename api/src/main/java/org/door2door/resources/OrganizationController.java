package org.door2door.resources;

import jdk.net.SocketFlow;
import org.door2door.dto.NewOrganizationDto;
import org.door2door.dto.OrganizationDto;
import org.door2door.services.NewOrganizationService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/organization")
public class OrganizationController {
	NewOrganizationService newOrganizationService;

	@Inject
	public OrganizationController(final NewOrganizationService newOrganizationService) {
		this.newOrganizationService = newOrganizationService;
	}

	@POST
	public Response createOrganization(final NewOrganizationDto newOrganizationDto) {
		newOrganizationService.createOrg(newOrganizationDto);
		return Response.status(Response.Status.OK).build();
	}
}
