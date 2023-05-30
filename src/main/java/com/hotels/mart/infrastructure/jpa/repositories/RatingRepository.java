package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
