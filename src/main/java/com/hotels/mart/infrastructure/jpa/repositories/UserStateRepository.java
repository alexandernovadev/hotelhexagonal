package com.hotels.mart.infrastructure.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.UserState;

public interface UserStateRepository extends JpaRepository<UserState, Long> {


}