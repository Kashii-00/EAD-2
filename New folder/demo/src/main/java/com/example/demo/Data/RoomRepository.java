package com.example.demo.Data;

import com.example.demo.Data.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByNameContainingIgnoreCaseOrTypeContainingIgnoreCase(String name, String type);
}
