package org.union.usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    // Criado usuario dessa forma pois database ainda não existe
    final String username = "admin";
    final String senha = "1234";

    @Inject
    AgroalDataSource agroalDataSource;

    public Boolean logar(Usuario usuario){

       Connection con;
    try {
        con = agroalDataSource.getConnection();
        Statement statement = con.createStatement();

        statement.execute("select * from aluno");
    } catch (SQLException e) {
        e.printStackTrace();
    }

        if(usuario.getUsername().equals(username) && usuario.getSenha() .equals(senha)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean cadastro(Usuario usuario){
        // Verificar se Usuario já existe no banco
        // Se nao existir criar usuario
        return true;
    }
}
