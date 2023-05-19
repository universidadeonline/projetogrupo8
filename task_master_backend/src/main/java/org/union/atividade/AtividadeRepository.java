package org.union.atividade;


import javax.inject.Singleton;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class AtividadeRepository implements PanacheRepository<Atividade>{
}
