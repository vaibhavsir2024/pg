package com.pgmanagement.controller;

import com.pgmanagement.entity.Booking;
import com.pgmanagement.entity.BookingStatus;
import com.pgmanagement.payload.BookingRequest;
import com.pgmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a booking
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.createBooking(
                bookingRequest.getRoomId(),
                bookingRequest.getUserId(),
                bookingRequest.getBookingDate(),
                bookingRequest.getStatus()
        );
        return ResponseEntity.ok(booking);
    }

    // Get all bookings
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    // Update booking status
    @PutMapping("/update/{bookingId}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long bookingId, @RequestBody BookingStatus status) {
        Booking updatedBooking = bookingService.updateBookingStatus(bookingId, status);
        return ResponseEntity.ok(updatedBooking);
    }

    // Delete a booking
    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
