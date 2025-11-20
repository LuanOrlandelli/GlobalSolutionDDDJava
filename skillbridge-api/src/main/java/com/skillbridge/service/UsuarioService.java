package com.skillbridge.service;

import org.springframework.stereotype.Service;
import com.skillbridge.repository.UsuarioRepository;
import com.skillbridge.model.Usuario;
import com.skillbridge.exception.UsuarioNotFoundException;
import com.skillbridge.exception.EmailAlreadyUsedException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Usuario findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario create(Usuario usuario) {
        if (repo.existsByEmail(usuario.getEmail())) {
            throw new EmailAlreadyUsedException(usuario.getEmail());
        }
        return repo.save(usuario);
    }

    public Usuario update(Long id, Usuario updated) {
        Usuario existing = findById(id);

        // Verifica se o novo email é diferente e já existe em outro usuário
        if (!existing.getEmail().equals(updated.getEmail())
                && repo.existsByEmail(updated.getEmail())) {
            throw new EmailAlreadyUsedException(updated.getEmail());
        }

        existing.setNome(updated.getNome());
        existing.setEmail(updated.getEmail()); // ✅ agora pode mudar o email
        existing.setAreaAtuacao(updated.getAreaAtuacao());
        existing.setNivelCarreira(updated.getNivelCarreira());

        return repo.save(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new UsuarioNotFoundException(id);
        repo.deleteById(id);
    }
}
