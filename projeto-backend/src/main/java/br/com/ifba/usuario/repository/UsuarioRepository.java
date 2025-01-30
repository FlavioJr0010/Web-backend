package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Define este repositório como um componente gerenciado pelo Spring
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método abstrato para deletar um usuário pelo ID
    // Não é necessário declará-lo, pois JpaRepository já fornece esse método
    @Override
    void deleteById(Long id);
}
