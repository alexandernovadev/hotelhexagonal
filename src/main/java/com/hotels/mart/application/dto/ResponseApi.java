package com.hotels.mart.application.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private List<?> data;

    public ResponseApi(String message, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.data = null;
    }

    public ResponseApi(String message, HttpStatus status, LocalDateTime timestamp, Object data) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.data = List.of(data);
    }
}
