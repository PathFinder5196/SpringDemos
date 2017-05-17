package com.lavesh.boot.demo.service;

import java.util.List;

import com.lavesh.boot.demo.model.User;

public interface UserService {

	void create(User user);

	void update(User user);

	User getUserById(long id);

	User getUserByEmail(String email);
	
	void delete(long id);
	
	List<User> getAllUsers();
}
