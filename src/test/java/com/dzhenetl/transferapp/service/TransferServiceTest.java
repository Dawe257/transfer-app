package com.dzhenetl.transferapp.service;

import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Currency;
import com.dzhenetl.transferapp.model.TransactionRequest;
import com.dzhenetl.transferapp.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransferServiceTest {

    private static final MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0")
            .withUsername("root")
            .withPassword("root");

    @Autowired
    TransactionRepository repository;

    @BeforeAll
    static void setUp() {
        container.start();
    }

    @Test
    void transfer() {
//        Optional<TransactionRequest> byId = repository.findById(1L);
        System.out.println();
    }

    @Test
    void confirm() {

    }
}