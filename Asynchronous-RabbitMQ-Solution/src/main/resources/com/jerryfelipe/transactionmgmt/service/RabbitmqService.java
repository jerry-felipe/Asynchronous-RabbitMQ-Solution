package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.model.AsynchMessage;
import com.jerryfelipe.transactionmgmt.model.AsynchRabbitmqEvent;
import com.jerryfelipe.transactionmgmt.repository.AsynchMessageRepository;
import com.jerryfelipe.transactionmgmt.repository.AsynchRabbitmqEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RabbitmqService {

    @Autowired
    private AsynchMessageRepository asynchMessageRepository;

    @Autowired
    private AsynchRabbitmqEventRepository asynchRabbitmqEventRepository;

    // Método para guardar un mensaje en la tabla ASYNCH_MESSAGES
    @Transactional
    public void saveMessage(String messageContent) {
        AsynchMessage message = new AsynchMessage();
        message.setMessageContent(messageContent);
        message.setStatus("PENDING");
        asynchMessageRepository.save(message);
    }

    // Método para registrar un evento de RabbitMQ
    @Transactional
    public void logRabbitmqEvent(String eventType, String eventMessage) {
        AsynchRabbitmqEvent event = new AsynchRabbitmqEvent();
        event.setEventType(eventType);
        event.setEventMessage(eventMessage);
        asynchRabbitmqEventRepository.save(event);
    }

    // Método para cambiar el estado del mensaje a 'PROCESSED'
    @Transactional
    public void updateMessageStatus(Long messageId, String status) {
        AsynchMessage message = asynchMessageRepository.findById(messageId).orElseThrow(() -> new RuntimeException("Message not found"));
        message.setStatus(status);
        asynchMessageRepository.save(message);
    }
}
