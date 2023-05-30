package com.hotels.mart.infrastructure.controllers.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.RatingSaveDto;
import com.hotels.mart.application.services.rating.SaveRatingService;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ratings")
@Slf4j
public class RatingController {

  @Autowired
  SaveRatingService ratingService;

  @PostMapping
  public ResponseEntity<?> saveRating(@RequestBody RatingSaveDto ratingSaveDto) {
    log.info("Save Ratings");
    var response = ratingService.saveRating(ratingSaveDto);

    return new ResponseEntity<>(response, response.getStatus());
  }

}
