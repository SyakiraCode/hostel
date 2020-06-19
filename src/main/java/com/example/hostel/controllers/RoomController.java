/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hostel.controllers;

//import com.example.hostel.*;
import com.example.hostel.models.Room;
import com.example.hostel.repositories.RoomRepository;
import com.example.hostel.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
//import java.util.List;
//import java.util.Collection;
//import java.util.List;
//import java.util.Collection;
import java.util.Map;


import javax.validation.Valid;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
class RoomController {
	private static final String VIEWS_ROOM_FORM = "rooms/createOrUpdateRoomForm";

	@Autowired
	private RoomService roomService;
  
	private final RoomRepository rooms;

	public RoomController(RoomRepository rooms) {
		this.rooms = rooms;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


	//C - CREATE
	@GetMapping("/rooms/new")
	public String initCreationForm(Map<String, Object> model) {
		Room room = new Room();
		model.put("room", room);
		return VIEWS_ROOM_FORM;
	}

	@PostMapping("/rooms/new")
	public String processCreationForm(@Valid Room room, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return VIEWS_ROOM_FORM;
		} else {
			this.rooms.save(room);
			//return "roomDetails";
			return "redirect:/rooms/" + room.getId();
		}
	}
	//END CREATE///////////////////////

	// SEARCH

	/*
	@GetMapping("/roomSearch")
	public String initFindForm(Map<String, Object> model) {
		model.put("room", new Room());
		return "rooms/findRoom";
	}
	
	
		@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
    List<Room> result = roomService.search(keyword);
    ModelAndView mav = new ModelAndView("search");
    mav.addObject("result", result);
 
    return mav;    
}
	*/





	//// R- READ

	
	
	@RequestMapping("/rooms")
	public String index(Model model, @Param("keyword") String keyword) {
		model.addAttribute("rooms", rooms.findAll());
		
		List<Room> listRooms = roomService.listAll(keyword);
		model.addAttribute("rooms", listRooms);
        model.addAttribute("keyword", keyword);
		return "rooms/roomsList";
	}


	
     



	 
	@GetMapping("/rooms/{roomId}")
	public ModelAndView showOwner(@PathVariable("roomId") Integer roomId) {
		ModelAndView mav = new ModelAndView("rooms/roomDetails");
		Room room = roomService.get(roomId);	
		mav.addObject("room",room);
		
		return mav;
	}

	////READ///
	

	//UPDATE ///
	@GetMapping("/rooms/{roomId}/edit")
	public String showRoomForm(@PathVariable("roomId") Integer id, Model model) {
  
	  model.addAttribute("room", roomService.get(id));
	  return VIEWS_ROOM_FORM;
	}


	@PostMapping("/rooms/{roomId}/edit")
	public String processUpdateOwnerForm(@Valid Room room, BindingResult result, @PathVariable("roomId") Integer roomId) {
		if (result.hasErrors()) {
			return VIEWS_ROOM_FORM;
		} else {
			room.setId(roomId);
			this.rooms.save(room);
			return "redirect:/rooms/{roomId}";
		}
	}
	//UPDATE///



	// D - DELETE //
	@GetMapping("/delete/{roomId}")
	public String deleteUser(@PathVariable("roomId") Integer id, Model model) {
	  rooms.deleteById(id);
	  model.addAttribute("rooms", rooms.findAll());
	  return "redirect:/rooms";
	}
	// END DELETE //


}
