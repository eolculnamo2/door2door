package org.door2door.dao.impl;

import org.door2door.dao.OrganizationDao;
import org.door2door.entities.OrganizationEntity;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class OrganizationDaoImpl implements OrganizationDao {
	EntityManager entityManager;

	@Inject
	public OrganizationDaoImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(final OrganizationEntity organization) {
		Session session = entityManager.unwrap(Session.class);
		session.save(organization);
	}
}
