package org.union.usuario;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import org.union.disciplina.Disciplina;
import org.union.grupo.Grupo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Cacheable
@Getter
@Setter
public class Usuario extends PanacheEntityBase implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nome;
    private String username;
    private String ra;
    private String email;
    private String senha;
    private Boolean ativo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "disciplina_id")
    private List<Disciplina> disciplinas;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grupo_id")
    private List<Grupo> grupos;
    public Usuario() {}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
