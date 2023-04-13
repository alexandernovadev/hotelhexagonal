package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.ReservationState;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationStateRepository extends JpaRepository<ReservationState, Long> {

}
