package com.dzhenetl.transferapp.model;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String message;
    private final Long id;

    public ErrorResponse(String message, Long id) {
        this.message = message;
        this.id = id;
    }
}
