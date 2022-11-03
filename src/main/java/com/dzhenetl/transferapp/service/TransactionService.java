package com.dzhenetl.transferapp.service;

import com.dzhenetl.transferapp.exception.TransactionNotFoundException;
import com.dzhenetl.transferapp.model.ConfirmRequest;
import com.dzhenetl.transferapp.model.Transaction;
import com.dzhenetl.transferapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Long transfer(Transaction request) {
        return repository.save(request).getId();
    }

    public Long confirm(ConfirmRequest request) {
        Long id = request.getOperationId();
        Transaction transactionRequest = repository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException("Not found transaction with id " + id, id)
        );
        transactionRequest.setConfirmed(true);
        repository.save(transactionRequest);
        return transactionRequest.getId();
    }
}
