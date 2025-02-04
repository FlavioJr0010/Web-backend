package br.com.ifba.usuario.service;

import br.com.ifba.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// Interface que define os serviços relacionados ao Usuário
public interface UsuarioIService {

    // Retorna uma lista com todos os usuários
   public abstract Page<Usuario> findAll(Pageable pageable);

    // Busca um usuário pelo ID
    Usuario findById(Long id);

    // Salva um novo usuário
    Usuario save(Usuario usuario);

    // Deleta um usuário pelo ID
    void delete(Long id);

    // Atualiza um usuário existente
    Usuario update(Usuario usuario);
}