package org.door2door.services.impl;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.door2door.dao.impl.LoginDaoImpl;
import org.door2door.dto.ContactDto;
import org.door2door.dto.LoginDto;
import org.door2door.dto.TeamDto;
import org.door2door.entities.TeamEntity;
import org.door2door.services.LoginService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {
    private final LoginDaoImpl loginDao;

    @Inject
    public LoginServiceImpl (LoginDaoImpl loginDao) {
        this.loginDao = loginDao;
    }

    public TeamDto validateLogin (LoginDto loginDto) {
        TeamEntity team = loginDao.getTeamByEmail(loginDto.getEmail());
         if (doesPasswordMatch(loginDto.getPassword(), team.getPassword())){
             TeamDto teamDto = new TeamDto();
             teamDto.setName(team.getName());
             teamDto.setEmail(team.getEmail());
             teamDto.setWebsite(team.getWebsite());
             teamDto.setDescription(team.getDescription());
             teamDto.setAddress(team.getAddress());
             teamDto.setCity(team.getCity());
             teamDto.setState(team.getState());
             teamDto.setZip(team.getZip());

             List<ContactDto> contacts = team.getContacts()
                     .stream()
                     .map(contact -> {
                         ContactDto contactDto = new ContactDto();
                         contactDto.setId(contact.getId());
                         contactDto.setFirstName(contact.getFirstName());
                         contactDto.setLastName(contact.getLastName());
                         contactDto.setPhone(contact.getPhone());
                         return contactDto;
                     })
                     .collect(Collectors.toList());
             teamDto.setContacts(contacts);
             return teamDto;
         }
         return null;
    }

    private Boolean doesPasswordMatch (String passAtempt, String passInDb){
        String hashedAttempt = BcryptUtil.bcryptHash(passAtempt);
        return hashedAttempt.equals(passInDb);
    }
}
