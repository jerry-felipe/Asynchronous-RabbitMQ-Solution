package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.model.AsynchEvent;
import com.jerryfelipe.transactionmgmt.model.AsynchDlqEvent;
import com.jerryfelipe.transactionmgmt.model.AsynchConsumedEvent;
import com.jerryfelipe.transactionmgmt.repository.AsynchEventRepository;
import com.jerryfelipe.transactionmgmt.repository.AsynchDlqEventRepository;
import com.jerryfelipe.transactionmgmt.repository.AsynchConsumedEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private AsynchEventRepository asynchEventRepository;

    @Autowired
    private AsynchDlqEventRepository asynchDlqEventRepository;

    @Autowired
    private AsynchConsumedEventRepository asynchConsumedEventRepository;

    // Publicar un evento
    @Transactional
    public void publishEvent(String eventType, String payload) {
        AsynchEvent event = new AsynchEvent();
        event.setEventType(eventType);
        event.setPayload(payload);

        asynchEventRepository.save(event);

        // Simulación de lógica de publicación
        event.setStatus("PUBLISHED");
        asynchEventRepository.save(event);
    }

    // Manejar eventos fallidos (DLQ)
    @Transactional
    public void handleFailedEvent(Long eventId, String errorMessage) {
        AsynchEvent event = asynchEventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        // Registrar en la DLQ
        AsynchDlqEvent dlqEvent = new AsynchDlqEvent();
        dlqEvent.setEvent(event);
        dlqEvent.setEventType(event.getEventType());
        dlqEvent.setPayload(event.getPayload());
        dlqEvent.setErrorMessage(errorMessage);
        asynchDlqEventRepository.save(dlqEvent);

        // Actualizar estado del evento a 'FAILED'
        event.setStatus("FAILED");
        asynchEventRepository.save(event);
    }

    // Registrar eventos consumidos
    @Transactional
    public void consumeEvent(Long eventId) {
        AsynchEvent event = asynchEventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        // Registrar evento consumido
        AsynchConsumedEvent consumedEvent = new AsynchConsumedEvent();
        consumedEvent.setEvent(event);
        consumedEvent.setEventType(event.getEventType());
        consumedEvent.setPayload(event.getPayload());
        asynchConsumedEventRepository.save(consumedEvent);
    }
}
