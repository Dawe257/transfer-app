package com.dzhenetl.transferapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Card {

    private String cardNumber;
    private String cardCVV;
    private String cardValidTill;
    private Amount amount;
}
