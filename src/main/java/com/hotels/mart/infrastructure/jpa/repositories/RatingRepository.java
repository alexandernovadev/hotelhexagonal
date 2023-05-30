package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {


  List<Rating> findByCriteria(
      @Param("ratingId") Long ratingId,
      @Param("userId") Long userId,
      @Param("reservationId") Long reservationId,
      @Param("rating") Integer rating,
      @Param("comment") String comment);

}
