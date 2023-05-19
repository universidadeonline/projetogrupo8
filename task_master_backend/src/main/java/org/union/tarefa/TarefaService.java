package org.union.tarefa;

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

import org.union.disciplina.Disciplina;
import org.union.disciplina.DisciplinaRepository;


@ApplicationScoped
@Path("/tarefa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TarefaService {
    @Inject
    private TarefaRepository tarefaRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @GET
    @Path("/")
    @PermitAll
    public Response getAllTarefas(){
        List<Tarefa> tarefas = tarefaRepository.listAll();
        return Response.ok(tarefas).build();
    }


    @GET
    @Path("/{id}")
    @PermitAll
    public Response getTarefaById(Long id){

        Tarefa tarefa = tarefaRepository.findById(id);
        if(tarefa == null){
            throw new NotFoundException();
        }
            return Response.ok(tarefa).build();
    }

    @POST
    @Transactional
    @Path("{idDisciplina}")
    public Response createTarefa(Long idDisciplina,Tarefa tarefa) {
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina);
        if(disciplina == null){
            return Response.status(Status.NOT_FOUND).entity("Disciplina não cadastrada").build();

        }
        tarefa.setDisciplina(disciplina);
        tarefa.persistAndFlush();
        return Response.ok(tarefa).status(Status.CREATED).build();
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    @PermitAll
    public Tarefa updateDisciplina(Long id, Tarefa tarefa) {
        Tarefa tarefaEncontrada = Tarefa.findById(id);
        if(tarefaEncontrada == null) {
            throw new NotFoundException();
        }

        tarefaEncontrada.setDescricao(tarefa.getDescricao());
        tarefaEncontrada.setStatus(tarefa.getStatus());

        return tarefaEncontrada;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteDisciplina(Long id) {
        Tarefa tarefaEncontrada = Tarefa.findById(id);
        if(tarefaEncontrada == null) {
            throw new NotFoundException();
        }
        tarefaEncontrada.delete();
        return Response.ok().build();
    }
}
