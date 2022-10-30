package com.dzhenetl.transferapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Amount {

    private Integer value;
    private Currency currency;
}
