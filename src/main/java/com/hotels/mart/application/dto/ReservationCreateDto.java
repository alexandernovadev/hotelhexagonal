package com.hotels.mart.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationCreateDto {
    private Long user_id;
    private Long room_id;
    private Long reservation_state_id;
    private LocalDateTime check_in_date;
    private LocalDateTime check_out_date;
}
