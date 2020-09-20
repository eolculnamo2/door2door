package org.door2door.services;

public interface TokenService {
    public String generateUserToken(String email, String username);
    public String generateToken(String subject, String name, String... roles);
}
