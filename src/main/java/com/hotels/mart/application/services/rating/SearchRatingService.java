package com.hotels.mart.application.services.rating;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.infrastructure.jpa.repositories.RatingRepository;

@Service
public class SearchRatingService {

  @Autowired
  private RatingRepository ratingRepository;

  public ResponseApi search(
      Long rating_id,
      Long reservation_id,
      Long user_id,
      int rating,
      String comment) {
     
     
    return new ResponseApi(
        "List of reservations",
        HttpStatus.OK,
        LocalDateTime.now());
  }
}
