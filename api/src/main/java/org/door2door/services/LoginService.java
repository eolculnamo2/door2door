package org.door2door.services;

import org.door2door.dto.LoginDto;
import org.door2door.dto.TeamDto;

public interface LoginService {
    TeamDto validateLogin (LoginDto loginDto);
}
