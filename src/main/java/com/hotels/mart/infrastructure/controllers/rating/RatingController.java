package com.hotels.mart.infrastructure.controllers.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.RatingSaveDto;
import com.hotels.mart.application.services.rating.SaveRatingService;
import com.hotels.mart.application.services.rating.SearchRatingService;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/ratings")
@Slf4j
public class RatingController {

  @Autowired
  SaveRatingService ratingService;

  @Autowired
  SearchRatingService searchRatingService;

  @Operation(summary = "Save Rating", description = "Creates a new rating for a reservation.")
  @ApiResponse(responseCode = "201", description = "Review saved successfully")
  @ApiResponse(responseCode = "400", description = "Invalid rating structure or input")
  @PostMapping
  public ResponseEntity<?> saveRating(@RequestBody RatingSaveDto ratingSaveDto) {
    log.info("Save Ratings");
    var response = ratingService.saveRating(ratingSaveDto);

    return new ResponseEntity<>(response, response.getStatus());
  }

  @Operation(summary = "Search Rating", description = "Search all rating in a HotelsMarts.")
  @ApiResponse(responseCode = "201", description = "Review saved successfully")
  @ApiResponse(responseCode = "400", description = "Invalid rating structure or input")
  @GetMapping("/search")
  public ResponseEntity<?> searchRating(
      @RequestParam(value = "rating_id", required = false) Long rating_id,
      @RequestParam(value = "reservation_id", required = false) Long reservation_id,
      @RequestParam(value = "user_id", required = false) Long user_id,
      @RequestParam(value = "rating", required = false) int rating,
      @RequestParam(value = "comment", required = false) String comment) {
    log.info("Search all Ratings");

    var response = searchRatingService.search(
        rating_id, reservation_id, user_id, rating, comment);

    return new ResponseEntity<>(response, response.getStatus());
  }

}
