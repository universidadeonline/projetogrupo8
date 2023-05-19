package org.union.atividade;


import java.util.List;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
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

import org.union.disciplina.Disciplina;
import org.union.disciplina.DisciplinaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;


@ApplicationScoped
@Path("/atividade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AtividadeService {
    @Inject
    private AtividadeRepository atividadeRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @GET
    @Path("/")
    @PermitAll
    public Response getAllAtividades(){
        List<Atividade> atividades = atividadeRepository.listAll();
        return Response.ok(atividades).build();
    }


    @GET
    @Path("/{id}")
    @PermitAll
    public Response getAtividadeById(Long id){

        Atividade atividade = atividadeRepository.findById(id);
        if(atividade == null){
            return Response.status(Status.NOT_FOUND).entity("Atividade não encontrada").build();

        }
            return Response.ok(atividade).build();
    }

    @POST
    @Transactional
    @Path("{idDisciplina}")
    public Response createAtividade(Long idDisciplina,Atividade atividade) {
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina);
        if(disciplina == null){
            return Response.status(Status.NOT_FOUND).entity("Disciplina não cadastrada").build();

        }
        atividade.setDisciplina(disciplina);
        atividade.persistAndFlush();
        return Response.ok(atividade).status(Status.CREATED).build();
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    @PermitAll
    public Response updateAtividade(Long id, Atividade atividade) {
        Atividade atividadeEncontrada = atividadeRepository.findById(id);
        if(atividadeEncontrada == null) {
            return Response.status(Status.NOT_FOUND).entity("Atividade não encontrada").build();

        }

        atividadeEncontrada.setDescricao(atividade.getDescricao());
        atividadeEncontrada.setStatus(atividade.getStatus());
        atividadeEncontrada.setDataEntrega(atividade.getDataEntrega());
        atividadeEncontrada.setDisciplina(atividade.getDisciplina());
        atividadeEncontrada.setGrupo(atividade.getGrupo());
        atividadeEncontrada.setId(atividade.getId());
        atividadeEncontrada.setTipo(atividade.getTipo());
        atividadeEncontrada.setTitulo(atividade.getTitulo());
        atividadeEncontrada.setNota(atividade.getNota());

        return Response.ok(atividadeEncontrada).status(Status.CREATED).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteAtividade(Long id) {
        Atividade atividadeEncontrada = atividadeRepository.findById(id);
        if(atividadeEncontrada == null) {
            return Response.status(Status.NOT_FOUND).entity("Atividade não encontrada").build();

        }
        atividadeEncontrada.delete();
        return Response.ok().build();
    }
}
