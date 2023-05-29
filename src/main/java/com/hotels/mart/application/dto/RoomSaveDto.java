package com.hotels.mart.application.dto;

import com.hotels.mart.domain.entities.Room;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RoomSaveDto {
  private Long user_id;
  private Room room;
}
