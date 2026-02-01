package com.learnspringboot.restwebservices.daoservice;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learnspringboot.restwebservices.entity.Post;
import com.learnspringboot.restwebservices.exception.UserNotFoundException;
import com.learnspringboot.restwebservices.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	
	public Post findById(Integer id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isEmpty()) {
			throw new UserNotFoundException("User with "+id+" not found!");
		}
		
		return post.get();
	}
	
	
}
