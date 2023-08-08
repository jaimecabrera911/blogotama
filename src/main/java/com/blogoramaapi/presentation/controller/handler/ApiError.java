package com.blogoramaapi.presentation.controller.handler;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
@Builder
public class ApiError {
    private String path;
    private HttpStatus httpStatus;
    private String httpStatusCode;
    private String message;
    private Timestamp date;
}
