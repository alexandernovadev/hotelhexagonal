package com.conexionmysql.mysqljdb.application.services.reservationState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.domain.entities.ReservationState;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.ReservationStateRepository;

@Service
public class SearcReservationStateByIdService {
  

  @Autowired
  private ReservationStateRepository reservationStateRepository;


  public  ReservationState searchById(Long id) {
    return reservationStateRepository.findById(id).orElse(null);
  }

}
