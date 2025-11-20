package com.skillbridge.service;

import org.springframework.stereotype.Service;
import com.skillbridge.repository.TrilhaRepository;
import com.skillbridge.model.Trilha;
import com.skillbridge.exception.TrilhaNotFoundException;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) {
        this.repo = repo;
    }

    public List<Trilha> findAll() {
        return repo.findAll();
    }

    public Trilha findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new TrilhaNotFoundException(id));
    }

    public Trilha create(Trilha trilha) {
        return repo.save(trilha);
    }

    public Trilha update(Long id, Trilha updated) {
        Trilha t = findById(id);
        t.setNome(updated.getNome());
        t.setDescricao(updated.getDescricao());
        t.setNivel(updated.getNivel());
        t.setCargaHoraria(updated.getCargaHoraria());
        t.setFocoPrincipal(updated.getFocoPrincipal());
        return repo.save(t);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new TrilhaNotFoundException(id);
        repo.deleteById(id);
    }
}
