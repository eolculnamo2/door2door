package org.door2door.services;

public interface TokenService {
    String generateUserToken(String email, String username);
    String generateToken(String subject, String name, String... roles);
}
