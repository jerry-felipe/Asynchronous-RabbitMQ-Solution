package com.jerryfelipe.transactionmgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_ACCOUNTS", schema = "TRANSACTION_MGMT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "BALANCE", nullable = false)
    private Double balance;

    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters
}
