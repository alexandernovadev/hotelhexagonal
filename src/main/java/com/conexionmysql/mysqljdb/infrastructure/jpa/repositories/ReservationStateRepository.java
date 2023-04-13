package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.domain.entities.ReservationState;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationStateRepository extends JpaRepository<ReservationState, Long> {

}
