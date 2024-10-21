package com.pgmanagement.controller;

import com.pgmanagement.entity.Room;
import com.pgmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //http://localhost:8081/rooms/available
    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    //http://localhost:8081/rooms/2
    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }
    //http://localhost:8081/rooms/add
    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    //http://localhost:8081/rooms/2
    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Long roomId,
            @RequestBody Room roomDetails) {
        try {
            Room updatedRoom = roomService.updateRoom(roomId, roomDetails);
            return ResponseEntity.ok(updatedRoom);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //http://localhost:8081/rooms/2
    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
        try {
            roomService.deleteRoomById(roomId);
            return ResponseEntity.ok("Room deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

