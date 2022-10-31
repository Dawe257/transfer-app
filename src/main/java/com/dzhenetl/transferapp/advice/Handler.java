package com.dzhenetl.transferapp.advice;

import com.dzhenetl.transferapp.exception.TransactionNotFoundException;
import com.dzhenetl.transferapp.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorResponse> transactionNotFoundHandler(TransactionNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getId()), HttpStatus.BAD_REQUEST);
    }
}
