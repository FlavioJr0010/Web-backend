package br.com.ifba.usuario.service;

import br.com.ifba.usuario.Usuario;

import java.util.List;

public interface UsuarioIService {

    public abstract List<Usuario> findAll();

    public abstract Usuario findById(Long id);

    public abstract Usuario save(Usuario usuario);

    public abstract void delete(Long id);

    public abstract Usuario update(Usuario usuario);

}
