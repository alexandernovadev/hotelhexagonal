package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.RoomState;

public interface RoomStateRepository extends JpaRepository<RoomState, Long> {

}