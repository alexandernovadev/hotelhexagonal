package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.ReservationState;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStateRepository extends JpaRepository<ReservationState, Long> {

}
