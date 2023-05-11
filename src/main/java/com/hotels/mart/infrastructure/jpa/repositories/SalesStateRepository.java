package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.SalesState;

@Repository
public interface SalesStateRepository extends JpaRepository<SalesState, Long> {
  
}


