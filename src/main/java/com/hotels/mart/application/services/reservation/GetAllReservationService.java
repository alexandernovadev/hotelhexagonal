package com.hotels.mart.application.services.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class GetAllReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  public List<Reservation> getAllReservations() {
    return reservationRepository.findAll();
  }
}
