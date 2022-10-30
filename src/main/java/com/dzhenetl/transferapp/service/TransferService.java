package com.dzhenetl.transferapp.service;

import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Card;
import com.dzhenetl.transferapp.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    Logger logger = LoggerFactory.getLogger(TransferService.class);

    private final TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    public void transfer(Card cardFrom, Card cardTo, Amount amount) {
        repository.transfer(cardFrom, cardTo, amount);
    }

    public void confirm() {
        repository.confirm();
    }

    public void saveCard(Card card) {
        repository.saveCard(card);
    }
}
