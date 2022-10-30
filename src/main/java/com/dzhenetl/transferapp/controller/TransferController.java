package com.dzhenetl.transferapp.controller;

import com.dzhenetl.transferapp.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transaction transaction) {
        return new ResponseEntity<>("\"operationId\": \"string\"", HttpStatus.OK);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirm(@RequestBody Transaction transaction) {
        return new ResponseEntity<>("\"operationId\": \"string\"", HttpStatus.OK);
    }
}
