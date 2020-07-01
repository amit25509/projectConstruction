package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.model.Users;
import com.project1.service.UsersService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
	UsersService usersService;

	//1. GET ALL USERS
	@GetMapping("/getallusers")
	public ResponseEntity<List<Users>> getAllusers() {
		try {
			List<Users> users = usersService.getAllUsers();
				System.out.println(users.isEmpty());
			
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//2. GET USERS BY ID
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getusersById(@PathVariable("id") Integer id) {
		Optional<Users> users = usersService.getUsersById(id);

		if (users.isPresent()) {
			return new ResponseEntity<>(users.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//3. ADD NEW UESRS
	@PostMapping("/addusers")
	public ResponseEntity<Users> createTutorial(@RequestBody Users user) {
		try {
			Users users = usersService.addUser(user);
					
			return new ResponseEntity<>(users, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	//4. UPDATE USERS BY ID
	
	@PutMapping("/updateusers/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable("id") Integer id, @RequestBody Users updatedUser) {
		
		return usersService.updateUsers(id, updatedUser);
		
	}
	
	

	//5. DELETE USER BY ID
	
	@DeleteMapping("/deleteuser/{id}")
	private ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
		try {
			usersService.deleteUsers(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
