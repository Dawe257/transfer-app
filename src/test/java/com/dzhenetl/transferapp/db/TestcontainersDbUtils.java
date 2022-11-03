package com.dzhenetl.transferapp.db;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.MySQLContainer;

public class TestcontainersDbUtils {

    public static MySQLContainer<?> createMySQLContainer() {
        return new MySQLContainer<>("mysql:8.0")
                .withDatabaseName("transfer")
                .withUsername("root")
                .withPassword("root");
    }

    public static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry,
                                               MySQLContainer<?> mySQLContainer) {
        propertyRegistry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        propertyRegistry.add("spring.datasource.username", mySQLContainer::getUsername);
        propertyRegistry.add("spring.datasource.password", mySQLContainer::getPassword);

        propertyRegistry.add("spring.liquibase.url", mySQLContainer::getJdbcUrl);
        propertyRegistry.add("spring.liquibase.user", mySQLContainer::getUsername);
        propertyRegistry.add("spring.liquibase.password", mySQLContainer::getPassword);
    }
}