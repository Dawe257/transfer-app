package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
