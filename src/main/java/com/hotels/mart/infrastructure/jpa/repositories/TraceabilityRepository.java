package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.Traceability;

public interface TraceabilityRepository extends JpaRepository<Traceability, Long> { 
  
}
