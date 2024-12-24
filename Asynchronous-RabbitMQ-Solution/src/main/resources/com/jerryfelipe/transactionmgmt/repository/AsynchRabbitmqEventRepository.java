package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.model.AsynchRabbitmqEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsynchRabbitmqEventRepository extends JpaRepository<AsynchRabbitmqEvent, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario.
}
