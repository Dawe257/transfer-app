package com.dzhenetl.transferapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConfirmRequest {

    private Long operationId;
    private String code;
}
