package com.dzhenetl.transferapp.model;

import lombok.Getter;

@Getter
public class TransferResponse {

    private final Long operationId;

    public TransferResponse(Long operationId) {
        this.operationId = operationId;
    }
}
