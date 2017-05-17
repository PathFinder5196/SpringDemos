package com.lavesh.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lavesh.boot.demo.model.User;
import com.lavesh.boot.demo.service.UserService;

@RestController
public class HelloController {
    
	@Autowired
	private UserService userService;
	
    @GetMapping(value="/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping(value="/getUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    
    
    @PostMapping(value="/createUser")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
    	User foundUser = userService.getUserByEmail(user.getEmail());
    	if(foundUser!=null) {
    		return new ResponseEntity<String>("Email already exists", HttpStatus.FOUND);
    	}
    	else {
    		userService.create(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
    	}
    }
}