package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{
  
}

