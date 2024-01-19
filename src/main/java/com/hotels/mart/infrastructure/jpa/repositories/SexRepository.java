package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository  extends JpaRepository<Sex, Integer> {

}