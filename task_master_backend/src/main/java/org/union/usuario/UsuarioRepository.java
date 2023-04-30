package org.union.usuario;

import javax.inject.Singleton;

@Singleton
public class UsuarioRepository {
    // Criado usuario dessa forma pois database ainda não existe
    final String username = "admin";
    final String senha = "1234";

    public Boolean logar(Usuario usuario){
        // Comunicar com o banco
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
