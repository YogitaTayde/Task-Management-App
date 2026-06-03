package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserServiceException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new UserServiceException("User not found with id : " + id, HttpStatus.NOT_FOUND));
	}

	public User updateUser(Long id, User user) {

		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new UserServiceException("User not found with id : " + id, HttpStatus.NOT_FOUND));

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());

		return userRepository.save(existingUser);
	}

	public void deleteUser(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserServiceException("User not found with id : " + id, HttpStatus.NOT_FOUND));

		userRepository.delete(user);
	}
}