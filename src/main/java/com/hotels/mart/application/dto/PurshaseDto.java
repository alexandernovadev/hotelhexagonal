package com.hotels.mart.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurshaseDto {
  private int number_card;
  private int user_id;
  private List<BookAmount> books; 

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class BookAmount {
    private int id;
    private int amount;
  }
}
