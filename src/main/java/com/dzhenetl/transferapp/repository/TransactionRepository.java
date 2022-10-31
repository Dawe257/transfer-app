package com.dzhenetl.transferapp.repository;

import com.dzhenetl.transferapp.model.TransactionRequest;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionRequest, Long> {
}
