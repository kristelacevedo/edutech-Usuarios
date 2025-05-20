package com.edutech.usuarios.repository;

import com.edutech.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    }

