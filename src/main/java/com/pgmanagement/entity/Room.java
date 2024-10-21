package com.pgmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type; // 'Single', 'Shared'
    private int rent;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner; // PG owner

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public void setAvailable(boolean available) {
    }
    // Getters and Setters

}

