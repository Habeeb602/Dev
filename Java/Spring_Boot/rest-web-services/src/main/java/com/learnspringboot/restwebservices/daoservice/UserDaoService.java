package com.learnspringboot.restwebservices.daoservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.learnspringboot.restwebservices.entity.User;

@Service
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	
	private static Integer autoId = 0;
	
	static {
		userList.add(new User(++autoId, "John Cena", LocalDate.now().minusYears(32)));
		userList.add(new User(++autoId, "Undertaker", LocalDate.now().minusYears(52)));
		userList.add(new User(++autoId, "Shawn Micheals", LocalDate.now().minusYears(39)));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	
	public User findOne(Integer id) {
		Predicate<User> predicate= user -> user.getId() == id;
		
		return userList.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++autoId);
		userList.add(user);
		return user;
	}
	
	public void deleteById(Integer id) {
		userList.removeIf(user -> user.getId() == id);
	}
	
}
