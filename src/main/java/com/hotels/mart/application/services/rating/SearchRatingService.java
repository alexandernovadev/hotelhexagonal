package com.hotels.mart.application.services.rating;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.application.services.emails.EmailService;
import com.hotels.mart.domain.entities.Rating;
import com.hotels.mart.infrastructure.jpa.repositories.RatingRepository;

@Service
public class SearchRatingService {

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private EmailService emailService;

  public ResponseApi search(
      Long rating_id,
      Long reservation_id,
      Long user_id,
      int rating,
      String comment) {

    // List<Rating> data = ratingRepository.findByCriteria(
    //     rating_id,
    //     reservation_id,
    //     user_id,
    //     rating,
    //     comment
    // );

    var response = emailService.sendEmail(
        "andresolano34@gmail.com",
        "titoantifa69@gmail.com", 
        "Search Reservation",
        "<h1>Hola Como estas</h1> <p>Sara no hace caso</p>");

    return new ResponseApi(
        "List of reservations",
        HttpStatus.OK,
        LocalDateTime.now());
  }
}
