package org.door2door.services.impl;

import org.door2door.dao.OrganizationDao;
import org.door2door.dto.NewOrganizationDto;
import org.door2door.entities.OrganizationEntity;
import org.door2door.entities.UserEntity;
import org.door2door.services.NewOrganizationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class NewOrganizationServiceImpl implements NewOrganizationService {
	OrganizationDao organizationDao;

	@Inject
	public NewOrganizationServiceImpl(final OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	@Override
	public void createOrg(final NewOrganizationDto organization) {
		OrganizationEntity organizationEntity = new OrganizationEntity();
		organizationEntity.setId(UUID.randomUUID());
		organizationEntity.setName(organization.getName());

		List<UserEntity> users = organization.getUsers()
				.stream()
				.map(user -> {
					UserEntity userEntity = new UserEntity();
					userEntity.setEmail(user.getEmail());
					userEntity.setFirstName(user.getFirstName());
					userEntity.setLastName(user.getLastName());
					userEntity.setPassword(user.getPassword());
					userEntity.setOrganization(organizationEntity);
					return userEntity;
				})
				.collect(Collectors.toList());

		organizationDao.save(organizationEntity);
	}
}
