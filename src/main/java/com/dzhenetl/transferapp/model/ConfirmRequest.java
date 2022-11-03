package com.dzhenetl.transferapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConfirmRequest {

    private Long operationId;
    private String code;
}
