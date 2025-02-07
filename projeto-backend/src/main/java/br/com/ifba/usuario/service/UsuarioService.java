package br.com.ifba.usuario.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.usuario.Usuario;
import br.com.ifba.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// Indica que esta classe é um serviço gerenciado pelo Spring
@Service
@RequiredArgsConstructor // Gera um construtor com argumentos obrigatórios para os campos finais (final)
public class UsuarioService implements UsuarioIService {

    // Repositório responsável por interagir com o banco de dados
    private final UsuarioRepository usuarioRepository;

    // Recupera todos os usuários cadastrados
    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        try {
            return usuarioRepository.findAll(pageable);
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
    @Transactional
    public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
        try {
            return usuarioRepository.findByLoginAndSenha(login, senha);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar usuário por login e senha", e);
        }
    }

    @Override
    @Transactional // Garante que a operação seja atômica
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao salvar usuário", e);
        }
    }

    @Override
    @Transactional // Garante que a exclusão seja revertida se houver erro
    public void delete(Long id) {
        try {
            if (!usuarioRepository.existsById(id)) {
                throw new BusinessException("Usuário não encontrado para exclusão com ID: " + id);
            }
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException("Erro ao excluir usuário com ID: " + id, e);
        }
    }

    @Override
    @Transactional // Garante que a atualização seja segura
    public Usuario update(Usuario usuario) {
        try {
            if (usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
                throw new BusinessException("Usuário não encontrado para atualização com ID: " + usuario.getId());
            }
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar usuário", e);
        }
    }
}
