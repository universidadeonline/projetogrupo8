package org.union.usuario;

import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
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
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioEncontrado.isEmpty()){
            throw new NotAuthorizedException("Não encontrado");
        }else{
            if(usuarioEncontrado.get().getSenha().equals(usuario.getSenha())){
                return Response.ok().build();
            }else{
                throw new NotAuthorizedException("Não autorizado");
            }
        }
    }

    @POST
    @PermitAll
    @Transactional
    @Path("/cadastro")
    public Response cadastro(Usuario usuario){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioEncontrado.isEmpty()){
            usuario.persist();
            return Response.ok(usuario).status(Status.CREATED).build();
        }else{
            return Response.status(Status.BAD_REQUEST).build();
        }
    }
}
