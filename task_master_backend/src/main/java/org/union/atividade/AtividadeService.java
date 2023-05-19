package org.union.atividade;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;


@ApplicationScoped
@Path("/atividade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AtividadeService {
    @Inject
    AtividadeRepository atividadeRepository;
   
}
