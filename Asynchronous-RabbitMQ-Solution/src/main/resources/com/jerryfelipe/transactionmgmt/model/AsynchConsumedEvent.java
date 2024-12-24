package com.jerryfelipe.transactionmgmt.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_CONSUMED_EVENTS", schema = "TRANSACTION_MGMT")
public class AsynchConsumedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSUMED_EVENT_ID")
    private Long consumedEventId;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false)
    private AsynchEvent event;

    @Column(name = "EVENT_TYPE", nullable = false, length = 50)
    private String eventType;

    @Column(name = "PAYLOAD", nullable = false, columnDefinition = "CLOB")
    private String payload;

    @Column(name = "CONSUMED_AT", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime consumedAt;

    // Getters and Setters
    public Long getConsumedEventId() {
        return consumedEventId;
    }

    public void setConsumedEventId(Long consumedEventId) {
        this.consumedEventId = consumedEventId;
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

    public LocalDateTime getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(LocalDateTime consumedAt) {
        this.consumedAt = consumedAt;
    }
}
