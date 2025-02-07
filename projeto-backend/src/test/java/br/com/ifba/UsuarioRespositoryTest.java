<<<<<<< HEAD
//package br.com.ifba;
//
//import br.com.ifba.usuario.Usuario;
//import jakarta.validation.ConstraintViolationException;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Optional;
//
//// Indica que este é um teste de repositório usando um banco de dados em memória
//@DataJpaTest
//@DisplayName("Test for Usuario Repository")
//@ActiveProfiles("test")
//class UsuarioRespositoryTest {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    // Testa a busca por login quando o usuário não é encontrado
//    @Test
//    @DisplayName("Find user by login when Usuario not found")
//    public void findByLogin_whenUsuarioNotFound () {
//        Optional<Usuario> usuario = usuarioRepository.
//                findByLogin("non_existent_user");
//        Assertions.assertThat(usuario).isNotPresent(); // Verifica que o usuário não está presente
//    }
//
//    // Testa a busca por login e senha quando bem-sucedido
//    @Test
//    @DisplayName("Find user by login and senha when successful")
//    public void findByLoginAndSenha_whenSucessful () {
//        Optional<Usuario> usuarioFound = usuarioRepository.
//                findByLoginAndSenha("flaviopotencia", "987654321");
//
//        Assertions.assertThat(usuarioFound.isPresent()).isTrue(); // Verifica que o usuário foi encontrado
//        Assertions.assertThat(usuarioFound.get().getLogin())
//                .isEqualTo("flaviopotencia"); // Verifica se o login está correto
//        Assertions.assertThat(usuarioFound.get().getSenha())
//                .isEqualTo("987654321"); // Verifica se a senha está correta
//    }
//
//    // Testa a busca por login e senha quando o usuário não é encontrado
//    @Test
//    @DisplayName("Find user by login and senha when Usuario not found")
//    public void findByLoginAndSenha_whenUsuarioNotFound() {
//        Optional<Usuario> usuario = usuarioRepository.
//                findByLoginAndSenha("flaviopotencia", "987654321"); // Corrigido o nome do método
//
//        Assertions.assertThat(usuario).isNotPresent(); // Verifica que o usuário não está presente
//    }
//
//
//    // Método executado antes de cada teste para configurar os dados iniciais
//    @BeforeEach
//    public void setUp () {
//        Usuario usuario = Usuario.builder()
//                .nome("Flavio")
//                .login("flaviopotencia")
//                .email("flavio@email.com")
//                .senha("987654321")
//                .build();
//        usuarioRepository.save(usuario); // Salva um usuário no banco para os testes
//    }
//
//    @Test
//    @DisplayName("Save throw ConstraintViolationException when name is empty")
//    void saveThrowsContraintViolationException_WhenNameIsEmpty () {
//        Usuario usuario = new Usuario();
//
//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.usuarioRepository.save(usuario))
//                .withMessageContaining("The Usuario name cannot be empty");
//
//    }
//}
=======
package br.com.ifba;

import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import jakarta.validation.ConstraintViolationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

// Indica que este é um teste de repositório usando um banco de dados em memória
@DataJpaTest
@DisplayName("Test for Usuario Repository")
@ActiveProfiles("test")
class UsuarioRespositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Testa a busca por login quando o usuário não é encontrado
    @Test
    @DisplayName("Find user by login when Usuario not found")
    public void findByLogin_whenUsuarioNotFound () {
        Optional<Usuario> usuario = usuarioRepository.
                findByLogin("non_existent_user");
        Assertions.assertThat(usuario).isNotPresent(); // Verifica que o usuário não está presente
    }

    // Testa a busca por login e senha quando bem-sucedido
    @Test
    @DisplayName("Find user by login and senha when successful")
    public void findByLoginAndSenha_whenSucessful () {
        Optional<Usuario> usuarioFound = usuarioRepository.
                findByLoginAndSenha("flaviopotencia", "987654321");

        Assertions.assertThat(usuarioFound.isPresent()).isTrue(); // Verifica que o usuário foi encontrado
        Assertions.assertThat(usuarioFound.get().getLogin())
                .isEqualTo("flaviopotencia"); // Verifica se o login está correto
        Assertions.assertThat(usuarioFound.get().getSenha())
                .isEqualTo("987654321"); // Verifica se a senha está correta
    }

    // Testa a busca por login e senha quando o usuário não é encontrado
    @Test
    @DisplayName("Find user by login and senha when Usuario not found")
    public void findByLoginAndSenha_whenUsuarioNotFound() {
        Optional<Usuario> usuario = usuarioRepository.
                findByLoginAndSenha("flaviopotencia", "987654321"); // Corrigido o nome do método

        Assertions.assertThat(usuario).isNotPresent(); // Verifica que o usuário não está presente
    }


    // Método executado antes de cada teste para configurar os dados iniciais
    @BeforeEach
    public void setUp () {
        Usuario usuario = Usuario.builder()
                .nome("Flavio")
                .login("flaviopotencia")
                .email("flavio@email.com")
                .senha("987654321")
                .build();
        usuarioRepository.save(usuario); // Salva um usuário no banco para os testes
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void saveThrowsContraintViolationException_WhenNameIsEmpty () {
        Usuario usuario = new Usuario();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.usuarioRepository.save(usuario))
                .withMessageContaining("The Usuario name cannot be empty");

    }
}
>>>>>>> 22ea81afd2d3b2f2da81342acbc360f70b1cc955
