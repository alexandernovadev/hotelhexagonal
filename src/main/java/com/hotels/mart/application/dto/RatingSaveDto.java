package com.hotels.mart.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingSaveDto {
  int reservation_id;
  int rating;
  int user_id;
  String comment;
  
}
