package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.Traceability;

@Repository
public interface TraceabilityRepository extends JpaRepository<Traceability, Long> { 
  
}
