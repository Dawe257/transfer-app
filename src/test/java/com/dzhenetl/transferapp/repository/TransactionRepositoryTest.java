package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.model.Amount;
import com.dzhenetl.transferapp.model.Currency;
import com.dzhenetl.transferapp.model.TransactionRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration(initializers = TransactionRepositoryTest.Initializer.class)
public class TransactionRepositoryTest {

    private static final MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("transfer")
            .withUsername("root")
            .withPassword("root");

    @Autowired
    TransactionRepository repository;

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + container.getJdbcUrl()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @BeforeAll
    static void setUp() {
        container.start();
    }

    @Test
    void testSaveAndDelete() {
        Amount amount = new Amount();
        TransactionRequest transactionRequest = new TransactionRequest();
        amount.setCurrency(Currency.USD);
        amount.setValue(3000);
        transactionRequest.setCardFromCVV("123");
        transactionRequest.setCardFromNumber("123");
        transactionRequest.setCardToNumber("123");
        transactionRequest.setCardFromValidTill("12/33");
        transactionRequest.setConfirmed(false);
        transactionRequest.setAmount(amount);

        assertDoesNotThrow(() -> repository.save(transactionRequest));
        List<TransactionRequest> all = (List<TransactionRequest>) repository.findAll();
        assertTrue(all.contains(transactionRequest));
        assertDoesNotThrow(() -> repository.delete(transactionRequest));
        all = (List<TransactionRequest>) repository.findAll();
        assertFalse(all.contains(transactionRequest));
    }

    @Test
    void testFind() {
        List<TransactionRequest> all = (List<TransactionRequest>) repository.findAll();
        Optional<TransactionRequest> transaction1 = repository.findById(1L);
        Optional<TransactionRequest> transaction2 = repository.findById(2L);
        Optional<TransactionRequest> transaction3 = repository.findById(3L);
        Optional<TransactionRequest> transaction4 = repository.findById(4L);

        assertEquals(all.size(), 3);
        assertTrue(transaction1.isPresent());
        assertTrue(transaction2.isPresent());
        assertTrue(transaction3.isPresent());
        assertTrue(transaction4.isEmpty());
    }
}
