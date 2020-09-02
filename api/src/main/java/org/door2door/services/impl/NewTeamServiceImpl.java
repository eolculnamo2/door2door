package org.door2door.services.impl;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.door2door.dao.TeamDao;
import org.door2door.dto.NewTeamDto;
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
	public void createTeam(final NewTeamDto team) {
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setId(UUID.randomUUID());
		teamEntity.setName(team.getName());

		List<ContactEntity> contacts = team.getContacts()
				.stream()
				.map(contact -> {
					ContactEntity contactEntity = new ContactEntity();
					contactEntity.setFullName(contact.getFullName());
					contactEntity.setId(contact.getId());
					contactEntity.setPhone(contact.getPhone());
					return contactEntity;
				})
				.collect(Collectors.toList());

		teamDao.save(teamEntity);
	}
}
