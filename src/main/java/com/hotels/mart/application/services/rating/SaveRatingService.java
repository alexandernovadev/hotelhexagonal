package com.hotels.mart.application.services.rating;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.RatingSaveDto;
import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.RatingRepository;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class SaveRatingService {

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  public ResponseApi saveRating(RatingSaveDto ratingSaveDto) {

    // Sholuld structure be validate
    if (ratingSaveDto.getReservation_id() <= 0
        || ratingSaveDto.getRating() <= 0
        || ratingSaveDto.getUser_id() <= 0
        || ratingSaveDto.getComment() == null) {
      return new ResponseApi(
          "Invalid rating structure",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Should user_id exist
    // Optional<User> user  = userRepository.findById(Long.valueOf(ratingSaveDto.getUser_id()));

    // Should rating be between 0 and 5
    if (ratingSaveDto.getRating() < 0 || ratingSaveDto.getRating() > 5) {
      return new ResponseApi(
          "Invalid rating value",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Should the comment has at leat 10 and max 200 caracteres
    int commentLength = ratingSaveDto.getComment().length();
    if (commentLength < 10 || commentLength > 200) {
      return new ResponseApi(
          "Invalid comment length",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Sholuld reservation exist

    // If reservation exist sholud the reserved be cancelled

    // If all is validate should save data

    return new ResponseApi(
        "Review save Succesfully",
        HttpStatus.CREATED,
        LocalDateTime.now());

  }

}
