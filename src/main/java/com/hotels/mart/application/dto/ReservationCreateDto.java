package com.hotels.mart.application.dto;

import lombok.Data;

import com.hotels.mart.domain.entities.ReservationState;
import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.domain.entities.User;

@Data
public class ReservationCreateDto {
    private User user_id;
    private Room room_id;
    private ReservationState reservation_state_id;
    private String check_in_date;
    private String check_out_date;
}
