package org.union.grupo;


import javax.inject.Singleton;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class GrupoRepository implements PanacheRepository<Grupo>{
}
