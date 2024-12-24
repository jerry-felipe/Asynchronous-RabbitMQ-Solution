package com.transaction.mgmt.repository;

import com.jerryfelipe.transactionmgmt.model.AsynchEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsynchEventRepository extends JpaRepository<AsynchEvent, Long> {}

public interface AsynchDlqEventRepository extends JpaRepository<AsynchDlqEvent, Long> {}

public interface AsynchConsumedEventRepository extends JpaRepository<AsynchConsumedEvent, Long> {}
