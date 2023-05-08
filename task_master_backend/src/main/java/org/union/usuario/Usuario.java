package org.union.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name= "usuario", schema = "public")
public class Usuario extends PanacheEntity{
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="username")
    private String username;
    @Column(name="ra")
    private String ra;
    @Column(name="email")
    private String email;
    @Column(name="senha")
    private String senha;
    @Column(name="ativo")
    private Boolean ativo;


    public Usuario() {}
    
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }  
}
