package com.learnspringboot.webapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.function.Predicate;

import jakarta.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	//we can autowire this here and also we can create a constructor to get this created
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping("/list-todo")
	public String listTodos(ModelMap map) {
		String name = getUserNameFromAuth();
		map.addAttribute("todos",todoService.findByName(name));
		
		return "listTodos";
	}

	
	@RequestMapping(value = "/add-todo", method =  RequestMethod.GET)
	public String addTodo(ModelMap model){
		// Here we are creating a placeholder todo which we will send in the model to JSP form
		// There it will get add by the values that we provide in the form and will get return to the POST req
		Todo todo = new Todo(100, getUserNameFromAuth(), null, LocalDate.now(), true);
		model.put("todo", todo);
		System.out.println("Hello     ----->>>" + model.toString());
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String redirectToTodoList(@Valid  Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			System.out.println(result.toString());
			return "todo";
		}
		todoService.addTodo(getUserNameFromAuth(), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="/update-todo", method= RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.getById(id);
		System.out.println(todo);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.updateTodo(todo.getId(), todo.getDescription(), todo.getTargetDate());
		return "redirect:list-todo";
	}
	
	private String getUserNameFromAuth() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
