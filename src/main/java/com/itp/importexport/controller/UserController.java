package com.itp.importexport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.importexport.model.User;
import com.itp.importexport.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/") 

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/addusers")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	@PostMapping("/addusers")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	
	@GetMapping("/login/{userId}")
	public Optional<User> getUsers(@PathVariable int userId){
		return userRepository.findById(userId);
		
	}
	
	
	
	@PutMapping("/addusers/{userId}")
	public ResponseEntity<User> updateEquipment(
			@PathVariable String userId, @RequestBody User user){
		

		User result = userRepository.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
	@GetMapping("/findmax")
	public User getUserID() {
		
		return userRepository.findTopByOrderByUserIdDesc();
	}

}
