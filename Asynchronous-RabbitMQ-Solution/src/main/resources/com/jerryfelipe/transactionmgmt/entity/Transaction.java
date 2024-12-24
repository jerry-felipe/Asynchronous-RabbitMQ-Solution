package package com.example.transactionmgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_TRANSACTIONS", schema = "TRANSACTION_MGMT")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SOURCE_ACCOUNT_ID")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "TARGET_ACCOUNT_ID")
    private Account targetAccount;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "UNIQUE_KEY", nullable = false, unique = true, length = 255)
    private String uniqueKey;

    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters
}
entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_TRANSACTIONS", schema = "TRANSACTION_MGMT")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SOURCE_ACCOUNT_ID")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "TARGET_ACCOUNT_ID")
    private Account targetAccount;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "UNIQUE_KEY", nullable = false, unique = true, length = 255)
    private String uniqueKey;

    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters
}
