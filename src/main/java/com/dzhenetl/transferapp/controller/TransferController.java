package com.dzhenetl.transferapp.controller;

import com.dzhenetl.transferapp.model.Card;
import com.dzhenetl.transferapp.model.Transaction;
import com.dzhenetl.transferapp.repository.TransferRepository;
import com.dzhenetl.transferapp.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private final TransferService service;

    public TransferController(TransferRepository repository) {
        this.service = new TransferService(repository);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transaction transaction) {
        return new ResponseEntity<>("\"operationId\": \"string\"", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> transfer(@RequestBody Card card) {
        service.saveCard(card);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirm(@RequestBody Transaction transaction) {
        return new ResponseEntity<>("\"operationId\": \"string\"", HttpStatus.OK);
    }
}
