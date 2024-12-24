package com.jerryfelipe.transactionmgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASYNCH_USERS", schema = "TRANSACTION_MGMT")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters
}
