package org.union.usuario;

import java.util.Optional;

import javax.inject.Singleton;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class UsuarioRepository implements PanacheRepository<Usuario>{

    public Optional<Usuario> findByEmail(String email){
        return find("email", email).firstResultOptional();
    }

    public Optional<Usuario> findByUsername(String username){
        return find( "username", username).firstResultOptional();
    }
}
