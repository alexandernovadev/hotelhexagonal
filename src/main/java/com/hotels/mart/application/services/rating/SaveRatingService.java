package com.hotels.mart.application.services.rating;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.infrastructure.jpa.repositories.RatingRepository;

@Service
public class SaveRatingService {

  @Autowired
  private RatingRepository ratingRepository;

  public ResponseApi saveRating() {

    return new ResponseApi(
        "La estructura del JSON no es válida",
        HttpStatus.CREATED,
        LocalDateTime.now());

  }

}
