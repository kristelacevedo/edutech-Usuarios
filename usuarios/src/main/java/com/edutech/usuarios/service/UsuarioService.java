package com.edutech.usuarios.service;


import com.edutech.usuarios.model.Usuario;
import com.edutech.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {this.repo=repo;
    }
    public List<Usuario> Listar(){
        return repo.findAll();
    }
    public Usuario crear(Usuario u){
        return repo.save(u);
    }
    public Optional<Usuario> buscar(Long id){
        return repo.findById(id);
    }
    public Usuario actualizar(Long id, Usuario u){
        u.setId(id);
        return repo.save(u);
    }

    public void desactivar(Long id){
        repo.findById(id).ifPresent(usuario->{
            usuario.setActivo(false);
            repo.save(usuario);
        });
    }
    public void eliminar(Long id){
        repo.deleteById(id);

    }
}
