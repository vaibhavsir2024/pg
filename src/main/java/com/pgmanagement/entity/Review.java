package com.pgmanagement.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Tenant who left the review

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private int rating;  // Rating from 1 to 5
    private String feedback;
    private LocalDateTime reviewDate;

    // Constructors, Getters, and Setters
}
