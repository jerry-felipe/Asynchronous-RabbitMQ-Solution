package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUserUserId(Long userId);
}