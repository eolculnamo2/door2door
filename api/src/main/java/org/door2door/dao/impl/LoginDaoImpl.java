package org.door2door.dao.impl;

import org.door2door.dao.LoginDao;
import org.door2door.entities.TeamEntity;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class LoginDaoImpl implements LoginDao {
    EntityManager entityManager;

    @Inject
    public LoginDaoImpl (final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public TeamEntity getUserByEmail (final String email) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TeamEntity.class, email);
    }
}
