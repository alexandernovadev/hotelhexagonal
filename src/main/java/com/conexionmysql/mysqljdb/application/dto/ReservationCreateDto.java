package com.conexionmysql.mysqljdb.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationCreateDto {
    private Long user_id;
    private Long room_id;
    private Long reservation_state_id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
}
