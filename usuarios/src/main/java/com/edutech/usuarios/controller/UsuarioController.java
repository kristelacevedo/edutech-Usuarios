package com.edutech.usuarios.controller;


import com.edutech.usuarios.entity.Usuario;
import com.edutech.usuarios.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.Listar();
    }
    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        return service.crear(u);
    }
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscar(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.buscar(id).orElse(null);
    }
    @PutMapping("/{id}/desactivar")
    public void desactivar(@PathVariable Long id) {
        service.desactivar(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
