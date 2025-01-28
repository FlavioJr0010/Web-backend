package br.com.ifba.usuario.service;

import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;

import java.util.List;

public interface UsuarioIService {

    List<Usuario> findAll();

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

    Usuario update(Long id, Usuario usuario);

}
