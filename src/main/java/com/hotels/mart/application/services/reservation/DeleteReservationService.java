package com.hotels.mart.application.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class DeleteReservationService {
  
  @Autowired
  private ReservationRepository reservationRepository;

  public void deleteReservation(Long id) {
    reservationRepository.deleteById(id);
  }
}
