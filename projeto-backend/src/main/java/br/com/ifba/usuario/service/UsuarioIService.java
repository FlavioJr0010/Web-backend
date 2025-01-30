package br.com.ifba.usuario.service;

import br.com.ifba.usuario.Usuario;
import java.util.List;

// Interface que define os serviços relacionados ao Usuário
public interface UsuarioIService {

    // Retorna uma lista com todos os usuários
    List<Usuario> findAll();

    // Busca um usuário pelo ID
    Usuario findById(Long id);

    // Salva um novo usuário
    Usuario save(Usuario usuario);

    // Deleta um usuário pelo ID
    void delete(Long id);

    // Atualiza um usuário existente
    Usuario update(Usuario usuario);
}