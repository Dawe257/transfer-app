package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.db.TestcontainersDbUtils;
import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Currency;
import com.dzhenetl.transferapp.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Testcontainers
public class TransactionRepositoryTest {

    @Container
    private static final MySQLContainer<?> container = TestcontainersDbUtils.createMySQLContainer();

    @DynamicPropertySource
    static void setLiquibaseChangeLog(DynamicPropertyRegistry propertyRegistry) {
        TestcontainersDbUtils.setDatasourceProperties(propertyRegistry, container);
        propertyRegistry.add("spring.liquibase.change-log", () -> "classpath:db/changelog/db.changelog-master.yaml");
    }

    @Autowired
    TransactionRepository repository;

    @Test
    void testSaveAndDelete() {
        Amount amount = new Amount();
        Transaction transactionRequest = new Transaction();
        amount.setCurrency(Currency.USD);
        amount.setValue(3000);
        transactionRequest.setCardFromCVV("123");
        transactionRequest.setCardFromNumber("123");
        transactionRequest.setCardToNumber("123");
        transactionRequest.setCardFromValidTill("12/33");
        transactionRequest.setConfirmed(false);
        transactionRequest.setAmount(amount);

        assertDoesNotThrow(() -> repository.save(transactionRequest));
        List<Transaction> all = (List<Transaction>) repository.findAll();
        assertTrue(all.contains(transactionRequest));
        assertDoesNotThrow(() -> repository.delete(transactionRequest));
        all = (List<Transaction>) repository.findAll();
        assertFalse(all.contains(transactionRequest));
    }

    @Test
    void testFind() {
        List<Transaction> all = (List<Transaction>) repository.findAll();
        Optional<Transaction> transaction1 = repository.findById(1L);
        Optional<Transaction> transaction2 = repository.findById(2L);
        Optional<Transaction> transaction3 = repository.findById(3L);
        Optional<Transaction> transaction4 = repository.findById(4L);

        assertEquals(all.size(), 3);
        assertTrue(transaction1.isPresent());
        assertTrue(transaction2.isPresent());
        assertTrue(transaction3.isPresent());
        assertTrue(transaction4.isEmpty());
    }
}
