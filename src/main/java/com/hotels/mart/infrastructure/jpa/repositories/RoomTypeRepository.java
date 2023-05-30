package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.RoomType;


public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}