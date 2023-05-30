package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

  // @Query("SELECT r FROM Rating r " +
  //     "WHERE (:ratingId is null or r.ratingId = :ratingId) " +
  //     "AND (:userId is null or r.userId = :userId) " +
  //     "AND (:reservationId is null or r.reservationId = :reservationId) " +
  //     "AND (:rating is null or r.rating = :rating) " +
  //     "AND (:comment is null or r.comment LIKE CONCAT('%', :comment, '%'))")
  // List<Rating> findByCriteria(
  //     @Param("ratingId") Long ratingId,
  //     @Param("userId") Long userId,
  //     @Param("reservationId") Long reservationId,
  //     @Param("rating") Integer rating,
  //     @Param("comment") String comment);

}
