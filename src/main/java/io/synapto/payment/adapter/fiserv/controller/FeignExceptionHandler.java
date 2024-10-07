package io.synapto.payment.adapter.fiserv.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleFeignException(FeignException ex) {
        log.error("Feign exception occurred: ", ex);
        return ResponseEntity.status(ex.status())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ex.contentUTF8());
    }
}