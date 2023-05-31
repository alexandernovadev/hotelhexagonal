package com.hotels.mart.application.services.rating;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.RatingSaveDto;
import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.domain.entities.Rating;
import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.RatingRepository;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class UpdateRatingService {
  private final Long RESERVATION_CANCELED = 2L;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  public ResponseApi updaterating(
      RatingSaveDto ratingSaveDto, Long Id) {

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

    // Should rating extist exist
    Optional<Rating> rating = ratingRepository.findById(Id);
    if (rating.isEmpty()) {
      return new ResponseApi(
          "Rating with ID:" + Id + " not exist",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Should user_id exist
    Optional<User> user = userRepository.findById(Long.valueOf(ratingSaveDto.getUser_id()));
    if (user.isEmpty()) {
      return new ResponseApi(
          "User with ID:" + ratingSaveDto.getUser_id() + " not exist",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Sholuld reservation exist
    Optional<Reservation> reservation = reservationRepository.findById(Long.valueOf(ratingSaveDto.getReservation_id()));
    if (reservation.isEmpty()) {
      return new ResponseApi(
          "Reservation with ID:" + ratingSaveDto.getReservation_id() + " not exist",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // If reservation exist sholud the reserved be cancelled
    var isReservationCancelled = reservation.get().getReservation_state_id().getReservation_state_id();
    if (isReservationCancelled != RESERVATION_CANCELED) {
      return new ResponseApi(
          "The reservation it needs to be in CANCELLED state",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Should rating be between 0 and 5
    if (ratingSaveDto.getRating() < 0 || ratingSaveDto.getRating() > 5) {
      return new ResponseApi(
          "Invalid rating value,it needs to be between 0 to 5",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Should the comment has at leat 10 and max 200 caracteres
    int commentLength = ratingSaveDto.getComment().length();
    if (commentLength < 50 || commentLength > 200) {
      return new ResponseApi(
          "Invalid comment characters,it needs to be between 50 to 200 of lenght",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // If all is validated, update and save the rating
    Rating existingRating = rating.get();
    existingRating.setUser(user.get());
    existingRating.setReservation(reservation.get());
    existingRating.setRating(ratingSaveDto.getRating());
    existingRating.setComment(ratingSaveDto.getComment());

    // Save updated rating
    ratingRepository.save(existingRating);

    return new ResponseApi(
        "Review updated Succesfully",
        HttpStatus.CREATED,
        LocalDateTime.now());

  }

}
