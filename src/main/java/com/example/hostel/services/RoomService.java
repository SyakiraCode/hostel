package com.example.hostel.services;


import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
//import org.hibernate.JDBCException;
//import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
//import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hostel.models.Room;
import com.example.hostel.repositories.RoomRepository;

@Service
@Transactional
public class RoomService {
    

    //INSTANTIATE USER REPOSITORY OBJECT TO BE IMPLEMENTED IN SERVICE
     @Autowired
     private RoomRepository roomRepo;
    

     // DEFINE ALL CRUD OPERATIONS AND RETURN THE APPROPRIATE DATA (LIST, USER OBJECT, ETC..)
     
     
     
    public List<Room> listAll() {
        return (List<Room>) roomRepo.findAll();
    }
    


         /*
        public List<Room> listAll(String keyword) {
            if (keyword != null) {
               return (List<Room>) roomRepo.search(keyword);
            }
            return (List<Room>) roomRepo.findAll();
        }*/
         



     
    public Room save(Room room) throws SQLException, HibernateException{
        
        roomRepo.save(room);
		return room;

        
    }
    public Room update(Room room){
       
        roomRepo.updateRoom(room.getName(),room.getMatrik(),room.getEmail(),room.getBlock(),room.getRoomno());
		return room;
        
    }
     
    public Room get(Integer id) {
        return roomRepo.findById(id).get();
    }
     
    public void delete(Integer id) {
        roomRepo.deleteById(id);
    }

    public Boolean deleteRoom (Integer id) {
        Room r  = roomRepo.findById(id).orElse(null);
        if(r != null) {
            roomRepo.delete(r);
            return true;
        }
        return false;
     }
    
     public List<Room> search(String keyword) {
        return roomRepo.search(keyword);
    }

    public List<Room> listAll(String keyword) {
        if (keyword != null) {
            return roomRepo.search(keyword);
        }
        return roomRepo.findAll();
    }
     
}