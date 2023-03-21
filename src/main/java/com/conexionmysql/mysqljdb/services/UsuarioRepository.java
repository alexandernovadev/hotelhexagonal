package com.conexionmysql.mysqljdb.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}