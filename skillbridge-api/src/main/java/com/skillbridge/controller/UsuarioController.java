package com.skillbridge.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import com.skillbridge.service.UsuarioService;
import com.skillbridge.model.Usuario;
import com.skillbridge.dto.UsuarioDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody UsuarioDTO dto, UriComponentsBuilder uriBuilder) {
        Usuario u = dtoToEntity(dto);
        Usuario created = service.create(u);
        URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @Valid @RequestBody UsuarioDTO dto) {
        Usuario u = dtoToEntity(dto);
        Usuario updated = service.update(id, u);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Usuario dtoToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());
        return u;
    }
}
