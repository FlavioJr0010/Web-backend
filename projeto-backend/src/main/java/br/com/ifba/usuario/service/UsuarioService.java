package br.com.ifba.usuario.service;

import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UsuarioService implements UsuarioIService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        //LOGGER.info("Buscando todos os usuários");
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        return null;
    }
}