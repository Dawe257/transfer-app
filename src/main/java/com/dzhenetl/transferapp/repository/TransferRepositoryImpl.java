package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Card;
import com.dzhenetl.transferapp.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferRepositoryImpl implements TransferRepository{

    List<Card> cards = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void transfer(Card cardFrom, Card cardTo, Amount amount) {

    }

    @Override
    public void confirm() {

    }

    @Override
    public void saveCard(Card card) {
        cards.add(card);
    }
}
