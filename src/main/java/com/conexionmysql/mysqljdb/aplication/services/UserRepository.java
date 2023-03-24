package com.conexionmysql.mysqljdb.aplication.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}