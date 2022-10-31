package com.dzhenetl.transferapp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionNotFoundException extends RuntimeException {

    private String message;
    private Long id;

    public TransactionNotFoundException(String message, Long id) {
        super(message);
        this.message = message;
        this.id = id;
    }
}
