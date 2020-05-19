package com.vega2k.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vega2k.myspringboot.entity.User;
import com.vega2k.myspringboot.exception.ResourceNotFoundException;
import com.vega2k.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deletUser(@PathVariable Long id){
		Optional<User> optUser = userRepository.findById(id);
		if(!optUser.isPresent()) {
			return new ResponseEntity<String>(id + "NOT FOUND", HttpStatus.NOT_FOUND);
		}else {
			userRepository.deleteById(id);
			return new ResponseEntity<String>(id + "DELETE OK", HttpStatus.OK);
		}
	}
	
	
}
