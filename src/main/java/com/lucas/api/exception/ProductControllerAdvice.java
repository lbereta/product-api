package com.lucas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "com.lucas.api.controller")
public class ProductControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> productNotFound(ProductNotFoundException productNotFoundException) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Produto não encontrado!");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}