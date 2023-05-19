package org.union.disciplina;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.union.atividade.Atividade;
import org.union.tarefa.Tarefa;
import org.union.usuario.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Cacheable
public class Disciplina extends PanacheEntityBase implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "disciplina")
    private List<Tarefa> tarefas;
    @OneToMany(mappedBy = "disciplina")
    private List<Atividade> atividades;
    @ManyToMany
    private List<Usuario> usuarios;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Disciplina)) {
            return false;
        }

        Disciplina other = (Disciplina) o;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public List<Tarefa> getTarefas() {
        return tarefas;
    }



    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
