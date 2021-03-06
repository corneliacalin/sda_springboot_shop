package com.sda.corneliacalin.webshop.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest webrequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                exception.getMessage(),
                webrequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<?> resourceNotFoundHandler(ResourceNotFoundException exception, WebRequest webRequest ){

            ErrorDetails errorDetails = new ErrorDetails(
                    Instant.now(),
                    exception.getMessage(),
                    webRequest.getDescription(false)
            );
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }

}
