package org.union.disciplina;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response.Status;


@ApplicationScoped
@Path("/disciplina")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplinaService {
    @Inject
    private DisciplinaRepository disciplinaRepository;

    @GET
    @Path("/")
    @PermitAll
    public Response getAllDisciplinas(Disciplina disciplina){
        List<Disciplina> disciplinas = disciplinaRepository.listAll();
        return Response.ok(disciplinas).build();
    }


    @GET
    @Path("/{id}")
    @PermitAll
    public Response getDisciplinaById(Long id){

        Disciplina disciplina = disciplinaRepository.findById(id);
        if(disciplina == null){
            throw new NotFoundException();
        }
            return Response.ok(disciplina).build();
    }

    @POST
    @Transactional
    public Response createDisciplina(Disciplina disciplina) {
        
        disciplina.persist();
        return Response.ok(disciplina).status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @PermitAll
    public Disciplina updateDisciplina(Long id, Disciplina disciplina) {
        Disciplina disciplinaEncontrada = Disciplina.findById(id);
        if(disciplinaEncontrada == null) {
            throw new NotFoundException();
        }

        disciplinaEncontrada.setNome(disciplina.getNome());

        return disciplinaEncontrada;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteDisciplina(Long id) {
        Disciplina disciplinaEncontrada = Disciplina.findById(id);
        if(disciplinaEncontrada == null) {
            throw new NotFoundException();
        }
        disciplinaEncontrada.delete();
        return Response.ok().build();
    }
}
