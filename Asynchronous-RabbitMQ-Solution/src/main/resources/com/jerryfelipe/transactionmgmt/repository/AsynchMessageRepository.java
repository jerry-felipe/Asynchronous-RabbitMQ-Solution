package com.jerryfelipe.transactionmgmt.repository;

import com.rabbitmq.mgmt.model.AsynchMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsynchMessageRepository extends JpaRepository<AsynchMessage, Long> {
    // queries
}
