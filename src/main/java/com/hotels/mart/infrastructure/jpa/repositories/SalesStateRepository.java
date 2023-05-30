package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.SalesState;


public interface SalesStateRepository extends JpaRepository<SalesState, Long> {
  
}


