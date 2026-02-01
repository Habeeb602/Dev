package com.learnspringboot.restwebservices.daoservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learnspringboot.restwebservices.entity.User;
import com.learnspringboot.restwebservices.exception.UserNotFoundException;
import com.learnspringboot.restwebservices.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User with "+id+" not found!");
		}
		return user.get();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Integer id) {
		User user = findById(id);
		
		if(user == null) {
			throw new UserNotFoundException("User with "+id+" not found!");
		}
		
		userRepository.delete(user);
	}
}
