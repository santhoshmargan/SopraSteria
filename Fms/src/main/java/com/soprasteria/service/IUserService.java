package com.soprasteria.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.soprasteria.model.LoginResponse;
import com.soprasteria.model.User;

@Service
public interface IUserService {

	ResponseEntity<User> addUser(User user);

	List<User> getAllUsers();

	ResponseEntity<User> updateUser(User user);

	ResponseEntity<String> deleteUserById(String userId);

	ResponseEntity<User> findUserById(String userId);

	ResponseEntity<User> validateUser(User user);
	

}
