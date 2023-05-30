package org.union.grupo;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.union.usuario.Usuario;
import org.union.usuario.UsuarioRepository;

@ApplicationScoped
@Path("/grupo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GrupoService {

    @Inject
    private GrupoRepository grupoRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    @GET
    @Path("/")
    @PermitAll
    public Response getAllGrupos(){
        List<Grupo> grupos = grupoRepository.listAll();
        return Response.ok(grupos).build();
    }


    @GET
    @Path("/{id}")
    @PermitAll
    public Response getGrupoById(Long id){

        Grupo grupo = grupoRepository.findById(id);
        if(grupo == null){
            return Response.status(Status.NOT_FOUND).entity("Grupo não encontrado").build();

        }
            return Response.ok(grupo).build();
    }

    @POST
    @Transactional
    @Path("{idUsuario}")
    public Response createGrupo(Long idUsuario,Grupo grupo) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if(usuario == null){
            return Response.status(Status.NOT_FOUND).entity("Usuário não cadastrado").build();

        }
        grupo.setUsuarios(List.of(usuario));
        grupo.persistAndFlush();
        return Response.ok(grupo).status(Status.CREATED).build();
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    @PermitAll
    public Response updateGrupo(Long id, Grupo grupo) {
        Grupo grupoEncontrado = grupoRepository.findById(id);
        if(grupoEncontrado == null) {
            return Response.status(Status.NOT_FOUND).entity("Grupo não encontrado").build();

        }

        grupoEncontrado.setNome(grupo.getNome());
        grupoEncontrado.setId(grupo.getId());
        grupoEncontrado.setUsuarios(grupo.getUsuarios());
        grupoEncontrado.setAtividades(grupo.getAtividades());

        return Response.ok(grupoEncontrado).status(Status.CREATED).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteGrupo(Long id) {
        Grupo grupoEncontrado = grupoRepository.findById(id);
        if(grupoEncontrado == null) {
            return Response.status(Status.NOT_FOUND).entity("Grupo não encontrado").build();

        }
        grupoEncontrado.delete();
        return Response.ok().build();
    }
}
