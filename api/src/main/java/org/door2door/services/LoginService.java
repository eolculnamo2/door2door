package org.door2door.services;

import org.door2door.dto.LoginDto;
import org.door2door.dto.UserDto;

public interface LoginService {
    Boolean validateLogin (LoginDto loginDto);
}
