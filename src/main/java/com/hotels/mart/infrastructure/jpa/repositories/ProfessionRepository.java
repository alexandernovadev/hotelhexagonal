package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {

}