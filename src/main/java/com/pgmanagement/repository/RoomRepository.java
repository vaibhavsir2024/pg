package com.pgmanagement.repository;

import com.pgmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailable(boolean available);
}

