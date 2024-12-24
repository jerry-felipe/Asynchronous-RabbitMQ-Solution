package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.model.AuditLog;
import com.jerryfelipe.transactionmgmt.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    // Registrar una nueva acción de auditoría
    public AuditLog recordAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    // Obtener los registros de auditoría de un usuario
    public List<AuditLog> getAuditLogsForUser(Long userId) {
        return auditLogRepository.findByUserUserId(userId);
    }
}
