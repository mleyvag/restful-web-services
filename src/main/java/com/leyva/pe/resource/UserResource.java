package com.leyva.pe.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leyva.pe.exception.UserNotFoundException;
import com.leyva.pe.model.User;
import com.leyva.pe.service.UserDaoService;

@RestController
public class UserResource {
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User findOne = userDaoService.findOne(id);
		if (findOne == null) {
			throw new UserNotFoundException("id-"+id);
		}
		return findOne;
	}
	/*@PostMapping("/users")
	public void saveUser(@RequestBody User user) {
		userDaoService.save(user);
	}*/
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
