package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}