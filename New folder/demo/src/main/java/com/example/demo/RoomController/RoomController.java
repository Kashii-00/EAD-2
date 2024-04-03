package com.example.demo.RoomController;

import com.example.demo.Data.Room;
import com.example.demo.RoomService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/RoomReserve")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(path = "/getrooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping(path = "/rooms")
    public ResponseEntity<?> createRoom(@RequestBody Room room) {
        try {
            Room createdRoom = roomService.createRoom(room);
            return ResponseEntity.ok(createdRoom);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(path = "/rooms/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable int id) {
        try {
            Room room = roomService.getRoomById(id);
            if (room != null) {
                return ResponseEntity.ok(room);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable int id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping(path = "/rooms/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable int id, @RequestBody Room roomDetails) {
        try {
            Room existingRoom = roomService.getRoomById(id);
            if (existingRoom != null) {
                existingRoom.setName(roomDetails.getName());
                existingRoom.setMax_count(roomDetails.getMax_count());
                existingRoom.setRent_per_day(roomDetails.getRent_per_day());
                existingRoom.setImage_urls(roomDetails.getImage_urls());
                existingRoom.setType(roomDetails.getType());
                existingRoom.setDescription(roomDetails.getDescription());
                existingRoom.setCheckinDate(roomDetails.getCheckinDate());
                existingRoom.setCheckoutDate(roomDetails.getCheckoutDate());

                Room updatedRoom = roomService.updateRoom(existingRoom);
                return ResponseEntity.ok(updatedRoom);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(path = "/rooms/search")
    public ResponseEntity<?> searchRooms(@RequestParam String keyword) {
        try {
            List<Room> rooms = roomService.searchRooms(keyword);
            return ResponseEntity.ok(rooms);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
