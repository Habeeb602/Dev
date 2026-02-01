package com.learnspringboot.restwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learnspringboot.restwebservices.daoservice.UserDaoService;
import com.learnspringboot.restwebservices.entity.User;
import com.learnspringboot.restwebservices.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dao/users")
public class UserDaoController {

	private UserDaoService userDaoService;
	
	public UserDaoController(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	
	@GetMapping("/")
	@ResponseBody
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id) {
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("ID: " + id + " not found...");
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel; 
	}
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		// ResponseEntity.created() -> sends 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user = userDaoService.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("ID: " + id + " not found...");
		}
		
		userDaoService.deleteById(id);
	}
	
//	@Path
	 
}
