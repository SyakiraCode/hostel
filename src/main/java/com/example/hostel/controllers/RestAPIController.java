package com.example.hostel.controllers;

import java.util.HashMap;
//import java.io.Console;
import java.util.List;
import java.util.Map;

import com.example.hostel.models.Room;
import com.example.hostel.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.web.bind.annotation.RestController;

 

import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api")
public class RestAPIController {
 
    @Autowired
    private RoomService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/rooms")
     public List<Room> getAllRooms() {

         return service.listAll();

     }
    
   

    @DeleteMapping("/rooms/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Integer id) {
    Map<String,String> response = new HashMap<String,String>();
    if(service.deleteRoom(id)) {
      response.put("status", "success");
      response.put("message", "room deleted successfully");
       return ResponseEntity.ok(response);
    } else {
      response.put("status", "error");
      response.put("message", "Delete unsuccessful");
      return ResponseEntity.status(500).body(response);
    }
  }


  
}