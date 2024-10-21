package com.pgmanagement.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private double amount;
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;  // e.g., PENDING, COMPLETED, FAILED

    // Constructors, Getters, and Setters
}

