package com.blogoramaapi.presentation.controller.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError runtimeException(RuntimeException exception,WebRequest webRequest) {
        return setApiError(exception, webRequest);
    }

    private static ApiError setApiError(RuntimeException exception, WebRequest webRequest) {
        return ApiError.builder()
                .httpStatusCode("400")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .path(StringUtils.replace(
                        webRequest.getDescription(false), "uri=", "")
                )
                .message(exception.getMessage())
                .date(Timestamp.from(Instant.now()))
                .build();
    }

}
