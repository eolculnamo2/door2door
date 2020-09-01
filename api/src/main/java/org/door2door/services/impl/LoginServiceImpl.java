package org.door2door.services.impl;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.door2door.dao.impl.LoginDaoImpl;
import org.door2door.dto.LoginDto;
import org.door2door.entities.TeamEntity;
import org.door2door.services.LoginService;

import javax.inject.Inject;

public class LoginServiceImpl implements LoginService {
    private LoginDaoImpl loginDao;

    @Inject
    public LoginServiceImpl (LoginDaoImpl loginDao) {
        this.loginDao = loginDao;
    }

    public Boolean validateLogin (LoginDto loginDto) {
        TeamEntity team = loginDao.getUserByEmail(loginDto.getEmail());
        return doesPasswordMatch(loginDto.getPassword(), team.getPassword());
    }

    private Boolean doesPasswordMatch (String passAtempt, String passInDb){
        String hashedAttempt = BcryptUtil.bcryptHash(passAtempt);
        return hashedAttempt.equals(passInDb);
    }
}
