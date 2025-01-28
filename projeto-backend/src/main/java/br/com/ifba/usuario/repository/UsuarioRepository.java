package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    public abstract void deleteById(Long id);
}
