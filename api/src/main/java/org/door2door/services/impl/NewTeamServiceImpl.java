package org.door2door.services.impl;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.door2door.dao.TeamDao;
import org.door2door.dto.TeamDto;
import org.door2door.entities.TeamEntity;
import org.door2door.entities.ContactEntity;
import org.door2door.services.NewTeamService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class NewTeamServiceImpl implements NewTeamService {
	private final TeamDao teamDao;

	@Inject
	public NewTeamServiceImpl(final TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public void createTeam(final TeamDto team) {
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setId(UUID.randomUUID());
		teamEntity.setEmail(team.getEmail());
		teamEntity.setWebsite(team.getWebsite());
		teamEntity.setDescription(team.getDescription());
		teamEntity.setAddress(team.getAddress());
		teamEntity.setCity(team.getCity());
		teamEntity.setState(team.getState());
		teamEntity.setZip(team.getZip());
		teamEntity.setName(team.getName());
		String password = BcryptUtil.bcryptHash(team.getPassword());
		teamEntity.setPassword(password);

		List<ContactEntity> contacts = team.getContacts()
				.stream()
				.map(contact -> {
					ContactEntity contactEntity = new ContactEntity();
					contactEntity.setFirstName(contact.getFirstName());
					contactEntity.setLastName(contact.getLastName());
					contactEntity.setId(contact.getId());
					contactEntity.setPhone(contact.getPhone());
					return contactEntity;
				})
				.collect(Collectors.toList());

		teamDao.save(teamEntity);
	}
}
