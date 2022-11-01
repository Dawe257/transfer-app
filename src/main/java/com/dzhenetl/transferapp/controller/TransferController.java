package com.dzhenetl.transferapp.controller;

import com.dzhenetl.transferapp.model.ConfirmRequest;
import com.dzhenetl.transferapp.model.TransactionRequest;
import com.dzhenetl.transferapp.model.TransferResponse;
import com.dzhenetl.transferapp.repository.TransactionRepository;
import com.dzhenetl.transferapp.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Transactional
@RestController
public class TransferController {

    private final TransactionService service;

    public TransferController(TransactionRepository repository) {
        this.service = new TransactionService(repository);
    }

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransactionRequest request) {
        return new TransferResponse(service.transfer(request));
    }

    @PostMapping("/confirmOperation")
    public TransferResponse confirm(@RequestBody ConfirmRequest request) {
        return new TransferResponse(service.confirm(request));
    }
}
