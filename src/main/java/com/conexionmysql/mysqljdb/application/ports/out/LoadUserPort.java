package com.conexionmysql.mysqljdb.application.ports.out;

import java.util.Optional;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;


public interface LoadUserPort {
     /**
     * Busca un usuario por su identificador.
     *
     * @param id el identificador del usuario
     * @return un Optional<User> que contiene el usuario si se encuentra, o un Optional vacío en caso contrario
     */
    Optional<User> findById(Long id);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email el correo electrónico del usuario
     * @return un Optional<User> que contiene el usuario si se encuentra, o un Optional vacío en caso contrario
     */
    Optional<User> findByEmail(String email);
}
