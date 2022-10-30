package com.dzhenetl.transferapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    private String cardFromNumber;
    private String cardToNumber;
    private String cardFromCVV;
    private String cardFromValidTill;
    private Amount amount;

    @NoArgsConstructor
    @Getter
    @Setter
    public class Amount {

        private Integer value;
        private String currency;
    }
}
