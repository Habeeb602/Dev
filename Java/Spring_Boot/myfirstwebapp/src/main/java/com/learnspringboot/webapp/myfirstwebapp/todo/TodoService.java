package com.learnspringboot.webapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	private static List<Todo> todos;
	private static int todoCount = 0;
	
	static {
		todos = new ArrayList<>(
				Arrays.asList( new Todo(++todoCount, "Habeeb Rahman", "Learn Full-Stack Development", LocalDate.now().plusYears(1), false),
						new Todo(++todoCount, "Habeeb Rahman", "Learn Docker/Kubernates", LocalDate.now().plusMonths(3), false),
						new Todo(++todoCount, "Habeeb Rahman", "Learn MERN Stack", LocalDate.now().plusMonths(4), false)
						)
				);
	}
	
	public List<Todo> findByName(String name){
		Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(name);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String name, String description, LocalDate date, boolean done) {
		todos.add(new Todo(++todoCount, name, description, date, done));
	}
	
	public void deleteTodo(int id) {
		for (Iterator iterator = todos.iterator(); iterator.hasNext();) {
			Todo todo = (Todo) iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo getById(int id) {
		Predicate<Todo> predicate = todo -> todo.getId() == id;
		Todo resultTodo = todos.stream().filter(predicate).findFirst().get();
		return resultTodo;
	}
	
	public void updateTodo(int id, String description, LocalDate targetDate) {
		for(int i=0;i<todos.size();i++) {
			if(todos.get(i).getId() == id) {
				todos.get(i).setDescription(description);
				todos.get(i).setTargetDate(targetDate);
				break;
			}
		}
	}
	
	
}
