package com.pgmanagement.service;

import com.pgmanagement.entity.Room;
import com.pgmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long roomId, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Update the details
        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setType(updatedRoom.getType());
        existingRoom.setRent(updatedRoom.getRent());
        existingRoom.setAvailable(updatedRoom.isAvailable());

        // Save the updated room
        return roomRepository.save(existingRoom);
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public void deleteRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        roomRepository.delete(room);
    }
}

