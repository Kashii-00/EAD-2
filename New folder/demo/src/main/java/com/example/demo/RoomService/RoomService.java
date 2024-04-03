package com.example.demo.RoomService;

import com.example.demo.Data.Room;
import com.example.demo.Data.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) throws Exception {
        try {
            return roomRepository.save(room);
        } catch (Exception e) {
            throw new Exception("Failed to create room. " + e.getMessage());
        }
    }

    public Room getRoomById(int id) throws Exception {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new Exception("Room not found with id: " + id);
        }
    }

    public void deleteRoom(int id) throws Exception {
        try {
            roomRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Failed to delete room with id: " + id + ". " + e.getMessage());
        }
    }

    public Room updateRoom(Room room) throws Exception {
        try {
            return roomRepository.save(room);
        } catch (Exception e) {
            throw new Exception("Failed to update room. " + e.getMessage());
        }
    }

    public List<Room> searchRooms(String keyword) throws Exception {
        try {
            return roomRepository.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCase(keyword, keyword);
        } catch (Exception e) {
            throw new Exception("Failed to search rooms. " + e.getMessage());
        }
    }
}
