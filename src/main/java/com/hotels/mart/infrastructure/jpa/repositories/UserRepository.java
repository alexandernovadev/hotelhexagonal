package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);
  User findByEmail(String email);
  boolean existsByEmail(String email);
}