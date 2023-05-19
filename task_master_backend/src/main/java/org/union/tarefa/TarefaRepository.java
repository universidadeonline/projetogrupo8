package org.union.tarefa;

import javax.inject.Singleton;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class TarefaRepository implements PanacheRepository<Tarefa>{

}
