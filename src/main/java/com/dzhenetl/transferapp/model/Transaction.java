package com.dzhenetl.transferapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardFromNumber;
    private String cardToNumber;
    private String cardFromCVV;
    private String cardFromValidTill;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id")
    private Amount amount;
    private boolean confirmed = false;
}
