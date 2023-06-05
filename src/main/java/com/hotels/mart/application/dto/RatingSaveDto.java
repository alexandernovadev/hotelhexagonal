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
  private int reservation_id;
  private int rating;
  private int user_id;
  private String comment;

}
