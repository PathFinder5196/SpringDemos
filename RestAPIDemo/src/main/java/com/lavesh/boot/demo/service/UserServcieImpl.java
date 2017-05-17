package com.lavesh.boot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lavesh.boot.demo.model.User;
import com.lavesh.boot.demo.repository.UserRepository;

@Service
@Transactional
public class UserServcieImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void create(User user) {
		userRepository.create(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

}
