package com.skillbridge.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import com.skillbridge.service.TrilhaService;
import com.skillbridge.model.Trilha;
import com.skillbridge.dto.TrilhaDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Trilha>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Trilha> create(@Valid @RequestBody TrilhaDTO dto, UriComponentsBuilder uriBuilder) {
        Trilha t = dtoToEntity(dto);
        Trilha created = service.create(t);
        URI uri = uriBuilder.path("/api/trilhas/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> update(@PathVariable("id") Long id, @Valid @RequestBody TrilhaDTO dto) {
        Trilha t = dtoToEntity(dto);
        Trilha updated = service.update(id, t);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Trilha dtoToEntity(TrilhaDTO dto) {
        Trilha t = new Trilha();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());
        return t;
    }
}
