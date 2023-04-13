package com.conexionmysql.mysqljdb.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @author Alexander Nova
 * @version 1.0
 * @since 2022-03-22
 * This class is used to format the response of the API
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFormat {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
