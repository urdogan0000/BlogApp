package com.haydarurdogan.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final String errorType;
    private final int errorCode;
    private final String message;
    private final String details; // Extra field for additional info

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime timestamp;

    public ErrorResponse(String errorType, int errorCode, String message, String details) {
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

}
