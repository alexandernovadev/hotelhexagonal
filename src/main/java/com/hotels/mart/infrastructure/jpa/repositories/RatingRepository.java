package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

  @Query(value = "SELECT * FROM ratings " +
      "WHERE (:ratingId IS NULL OR rating_id = :ratingId) " +
      "AND (:reservationId IS NULL OR reservation_id = :reservationId) " +
      "AND (:userId IS NULL OR user_id = :userId) " +
      "AND (:rating = 0 OR rating = :rating) " +
      "AND (:comment IS NULL OR comment = :comment)", nativeQuery = true)
  List<Rating> searchByCriteria(
      @Param("ratingId") Long ratingId,
      @Param("reservationId") Long reservationId,
      @Param("userId") Long userId,
      @Param("rating") Integer rating,
      @Param("comment") String comment);
}
