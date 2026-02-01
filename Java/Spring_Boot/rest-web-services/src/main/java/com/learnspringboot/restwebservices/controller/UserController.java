package com.learnspringboot.restwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learnspringboot.restwebservices.daoservice.PostService;
import com.learnspringboot.restwebservices.daoservice.UserService;
import com.learnspringboot.restwebservices.entity.Post;
import com.learnspringboot.restwebservices.entity.User;
import com.learnspringboot.restwebservices.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	private UserService userService;
	private PostService postService;
	public UserController(UserService userService, PostService postService) {
		this.userService = userService;
		this.postService = postService;
	}
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable Integer id) {
		
		User user = userService.findById(id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		
		User savedUser = userService.saveUser(user);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		// ResponseEntity.created() -> sends 
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/{id}/posts")
	public List<Post> getPostsByUserId(@PathVariable Integer id){
		User user = userService.findById(id);	
		return user.getPost(); 
	}
	
	@PostMapping("/{id}/posts")
	public ResponseEntity<Object> addPostByUserId(@PathVariable Integer id, @Valid @RequestBody Post post) {
		User user = userService.findById(id);
		
		post.setUser(user);
		
		Post savedPost = postService.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		// ResponseEntity.created() -> sends 
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/{id}/posts/{postId}")
	public Post getPostById(@PathVariable Integer id, @PathVariable Integer postId) {
		User user = userService.findById(id);
		boolean isFound = false;
		int i;
		for(i=0;i<user.getPost().size();i++) {
			if(user.getPost().get(i).getId() == postId) {
				isFound = true;
				break;
			}
		}
		
		if(!isFound) {
			throw new UserNotFoundException("Post with "+postId+" not found for this user with id "+id);
		}
		
		return user.getPost().get(i);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteById(id);
	}
	
	
}
