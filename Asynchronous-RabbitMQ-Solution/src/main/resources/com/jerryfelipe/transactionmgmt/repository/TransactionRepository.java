package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByUniqueKey(String uniqueKey);
}
