package br.com.ifba;

import br.com.ifba.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Define este repositório como um componente gerenciado pelo Spring
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método abstrato para deletar um usuário pelo ID
    // Não é necessário declará-lo, pois JpaRepository já fornece esse método
    void deleteById(Long id);


    @Query("select u from Usuario u where u.login = ?1")
    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
