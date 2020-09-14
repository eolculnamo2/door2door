package org.door2door.dao.impl;

import org.door2door.dao.LoginDao;
import org.door2door.entities.TeamEntity;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class LoginDaoImpl implements LoginDao {
    private final EntityManager entityManager;

    @Inject
    public LoginDaoImpl (final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public TeamEntity getTeamByEmail (final String email) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TeamEntity.class, email);
    }
}
