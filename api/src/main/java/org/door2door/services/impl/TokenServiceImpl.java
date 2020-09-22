package org.door2door.services.impl;
import io.smallrye.jwt.build.Jwt;
import org.door2door.services.TokenService;
import org.door2door.util.Roles;
import org.door2door.util.TokenUtils;
import org.eclipse.microprofile.jwt.Claims;
import org.jboss.logmanager.Logger;
import org.jose4j.jwt.JwtClaims;

import javax.enterprise.context.RequestScoped;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@RequestScoped
public class TokenServiceImpl implements TokenService {

    public final static Logger LOGGER = Logger.getLogger(TokenServiceImpl.class.getSimpleName());

    public String generateUserToken(String email, String username) {
        return generateToken(email, username, Roles.ADMIN);
    }

    public String generateToken(String subject, String name, String... roles) {
        try {
//            JwtClaims jwtClaims = new JwtClaims();
//            jwtClaims.setIssuer("Door2Door");
//            jwtClaims.setJwtId(UUID.randomUUID().toString());
//            jwtClaims.setSubject(subject);
//            jwtClaims.setClaim(Claims.upn.name(), subject);
//            jwtClaims.setClaim(Claims.preferred_username.name(), name);
//            jwtClaims.setClaim(Claims.groups.name(), Arrays.asList(roles));
//            jwtClaims.setAudience("using-jwt");
//            jwtClaims.setExpirationTimeMinutesInTheFuture(60);

            String token = Jwt.issuer("Door2Door")
                        .upn("subject")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim("Example", "Example value")
                        .sign();


//            String token = TokenUtils.generateTokenString(jwtClaims);
            LOGGER.info("TOKEN generated: " + token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}