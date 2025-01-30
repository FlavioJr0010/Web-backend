package br.com.ifba.usuario.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um serviço gerenciado pelo Spring
@Service
@RequiredArgsConstructor // Gera um construtor com argumentos obrigatórios para os campos finais (final)
public class UsuarioService implements UsuarioIService {

    // Repositório responsável por interagir com o banco de dados
    private final UsuarioRepository usuarioRepository;

    // Recupera todos os usuários cadastrados
    public List<Usuario> findAll() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar todos os usuários", e);
        }
    }

    @Override
    // Busca um usuário pelo ID fornecido
    public Usuario findById(Long id) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            // Se não encontrar o usuário, lança uma exceção
            return usuario.orElseThrow(() -> new BusinessException("Usuário não encontrado para o ID: " + id));
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar usuário pelo ID: " + id, e);
        }
    }

    @Override
    // Salva um novo usuário no banco de dados
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao salvar usuário", e);
        }
    }

    @Override
    // Exclui um usuário pelo ID
    public void delete(Long id) {
        try {
            // Verifica se o usuário existe antes de tentar excluir
            if (!usuarioRepository.existsById(id)) {
                throw new BusinessException("Usuário não encontrado para exclusão com ID: " + id);
            }
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException("Erro ao excluir usuário com ID: " + id, e);
        }
    }

    @Override
    // Atualiza os dados de um usuário existente
    public Usuario update(Usuario usuario) {
        try {
            // Verifica se o usuário possui um ID válido e se já existe no banco
            if (usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
                throw new BusinessException("Usuário não encontrado para atualização com ID: " + usuario.getId());
            }
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar usuário", e);
        }
    }
}
