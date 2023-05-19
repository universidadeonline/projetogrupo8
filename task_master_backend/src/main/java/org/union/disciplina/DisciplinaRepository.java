package org.union.disciplina;

import javax.inject.Singleton;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class DisciplinaRepository implements PanacheRepository<Disciplina>{
}
