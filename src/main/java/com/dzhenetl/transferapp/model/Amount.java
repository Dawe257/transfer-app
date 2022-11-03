package com.dzhenetl.transferapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer value;
    @Enumerated(EnumType.STRING)
    private Currency currency;
}
