package com.dzhenetl.transferapp.service;

import com.dzhenetl.transferapp.repository.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    public void transfer() {
        repository.transfer();
    }

    public void confirm() {
        repository.confirm();
    }
}
