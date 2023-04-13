package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.domain.entities.UserState;

@Repository
public interface UserStateRepository extends JpaRepository<UserState, Long> {

}