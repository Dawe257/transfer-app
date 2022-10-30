package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Card;

public interface TransferRepository {

    void transfer(Card cardFrom, Card cardTo, Amount amount);

    void confirm();

    void saveCard(Card card);
}
