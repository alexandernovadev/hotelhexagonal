package com.conexionmysql.mysqljdb.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationCreateDto {
    private Long userId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
