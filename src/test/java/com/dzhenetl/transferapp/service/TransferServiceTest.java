package com.dzhenetl.transferapp.service;

import com.dzhenetl.transferapp.db.TestcontainersDbUtils;
import com.dzhenetl.transferapp.model.ConfirmRequest;
import com.dzhenetl.transferapp.model.Transaction;
import com.dzhenetl.transferapp.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class TransferServiceTest {

    @Container
    private static final MySQLContainer<?> container = TestcontainersDbUtils.createMySQLContainer();

    @DynamicPropertySource
    static void setLiquibaseChangeLog(DynamicPropertyRegistry propertyRegistry) {
        TestcontainersDbUtils.setDatasourceProperties(propertyRegistry, container);
        propertyRegistry.add("spring.liquibase.change-log", () -> "classpath:db/changelog/db.changelog-master.yaml");
    }

    @Autowired
    TransactionRepository repository;
    @Autowired
    TransactionService service;
    static Transaction request;


    @BeforeEach
    void setUp() {
        request = new Transaction();
        request.setCardFromNumber("123123");
        request.setCardFromCVV("123");
        request.setCardFromValidTill("12/23");
        request.setCardToNumber("456456");
    }

    @Test
    void transfer() {
        Long id = service.transfer(request);
        assertEquals(id, 4);
        Optional<Transaction> newRequest = repository.findById(4L);

        assertTrue(newRequest.isPresent());
        assertEquals(request, newRequest.get());
    }

    @Test
    void confirm() {
        ConfirmRequest confirmRequest = new ConfirmRequest();
        confirmRequest.setOperationId(3L);
        service.confirm(confirmRequest);
        Optional<Transaction> newRequest = repository.findById(3L);

        assertTrue(newRequest.isPresent());
        assertTrue(newRequest.get().isConfirmed());
    }
}