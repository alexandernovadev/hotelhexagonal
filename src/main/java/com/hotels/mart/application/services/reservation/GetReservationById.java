package com.hotels.mart.application.services.reservation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class GetReservationById {

  @Autowired
  private ReservationRepository reservationRepository;

  public Optional<Reservation> getReservationById(Long id) {

    return reservationRepository.findById(id);
  }
}
