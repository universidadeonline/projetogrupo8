package org.union.usuario;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.inject.Inject;

@ApplicationScoped
@Path("/usuarioService")
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    @POST
    @Path("/login")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuario){
        // Verificar se usuario existe e/ou se o username e senha está correto
        if(usuarioRepository.logar(usuario)==true){
            return Response.ok(usuario).build();
        }else{
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @POST
    @PermitAll
    @Path("/cadastro")
    public Response cadastro(Usuario usuario){
        if(usuarioRepository.logar(usuario)==true){
            return Response.status(Status.BAD_REQUEST).build();
        }else{
            return Response.status(Status.CREATED).build();
        }
        // usuarioRepository.cadastro(usuario);
        // return Response.created(null).build();
    }
}
