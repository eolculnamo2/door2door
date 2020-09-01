package org.door2door.dao.impl;

import org.door2door.dao.TeamDao;
import org.door2door.entities.TeamEntity;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class TeamDaoImpl implements TeamDao {
	EntityManager entityManager;

	@Inject
	public TeamDaoImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(final TeamEntity team) {
		Session session = entityManager.unwrap(Session.class);
		session.save(team);
	}
}
