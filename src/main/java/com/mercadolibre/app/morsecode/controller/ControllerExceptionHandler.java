package com.mercadolibre.app.morsecode.controller;

import com.mercadolibre.app.morsecode.model.MorseCodeResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<MorseCodeResponse> handleUnexpectedException(Exception ex) {
        MorseCodeResponse response = new MorseCodeResponse();
        response.setCode(500);
        response.setResponse("System unavailable, please try again later");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
