package com.conexionmysql.mysqljdb.application.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.Reservation;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class CreateReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  public void createReservation(Reservation reservation) {
    reservationRepository.save(reservation);
  }

}