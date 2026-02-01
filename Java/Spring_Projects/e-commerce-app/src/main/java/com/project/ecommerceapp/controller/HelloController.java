package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.UserRequest;
import com.project.ecommerceapp.entity.User;
import com.project.ecommerceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        User user = new User();
        model.addAttribute(user);
        return "signup";
    }

    @PostMapping("/user")
    public String saveUser(@ModelAttribute("user") UserRequest user){
        System.out.println(user);
        userService.saveUser(user);

        return "redirect:/login";
    }

//    @GetMapping
//    public String hello(){
//        return "Hello Everyone!";
//    }
//
//    @GetMapping("/welcome")
//    public String welcome(){
//        return "Hi There, Welcome to our site!";
//    }
}
