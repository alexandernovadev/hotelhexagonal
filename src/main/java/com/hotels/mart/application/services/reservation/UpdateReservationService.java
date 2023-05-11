package com.hotels.mart.application.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class UpdateReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  public void updateReservation(Reservation reservation) {
    reservationRepository.save(reservation);
  }

}
