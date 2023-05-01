package org.union.usuario;

import java.net.URI;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Path("/usuarioService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    @POST
    @Path("/login")
    @PermitAll
    public Response login(Usuario usuario){
        return usuarioRepository.find("username", usuario.getUsername())
            .singleResultOptional().map(user -> Response.ok(usuario).build())
            .orElse(Response.status(Status.BAD_REQUEST).build());
    }

    @POST
    @PermitAll
    @Path("/cadastro")
    @Transactional
    public Response cadastro(Usuario usuario){
        if(usuarioRepository.isPersistent(usuario)){
            return Response.status(Status.BAD_REQUEST).build();
        }else{
            usuarioRepository.persist(usuario);
            return Response.created(null).build();
        }
    }
}
