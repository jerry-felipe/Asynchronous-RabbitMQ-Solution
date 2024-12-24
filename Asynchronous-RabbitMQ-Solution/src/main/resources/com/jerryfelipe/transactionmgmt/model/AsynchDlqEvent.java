package com.jerryfelipe.transactionmgmt.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_DLQ_EVENTS", schema = "TRANSACTION_MGMT")
public class AsynchDlqEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DLQ_EVENT_ID")
    private Long dlqEventId;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false)
    private AsynchEvent event;

    @Column(name = "EVENT_TYPE", nullable = false, length = 50)
    private String eventType;

    @Column(name = "PAYLOAD", nullable = false, columnDefinition = "CLOB")
    private String payload;

    @Column(name = "ERROR_MESSAGE", length = 4000)
    private String errorMessage;

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getDlqEventId() {
        return dlqEventId;
    }

    public void setDlqEventId(Long dlqEventId) {
        this.dlqEventId = dlqEventId;
    }

    public AsynchEvent getEvent() {
        return event;
    }

    public void setEvent(AsynchEvent event) {
        this.event = event;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
