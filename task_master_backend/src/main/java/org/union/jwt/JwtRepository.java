package org.union.jwt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;

import io.smallrye.jwt.build.Jwt;

@Singleton
public class JwtRepository {
    
    public String generateJwt(){
        Set<String> roles = new HashSet<>(
            Arrays.asList("admin","usuario")
        );
        return Jwt.issuer("taskmasterjwt").subject("taskmasterjwt").groups(roles).expiresAt(System.currentTimeMillis()+3600).sign();
    }
}
