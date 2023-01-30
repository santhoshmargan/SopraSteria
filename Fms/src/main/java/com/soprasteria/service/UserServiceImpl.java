package com.soprasteria.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.soprasteria.dao.UserRepositoryDao;
import com.soprasteria.exceptions.RecordAlreadyExistsException;
import com.soprasteria.exceptions.RecordNotFoundException;
import com.soprasteria.model.LoginResponse;
import com.soprasteria.model.User;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepositoryDao userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public ResponseEntity<User> addUser(User user) {

		Optional<User> findResponse = userRepository.findById(user.getUsername());
		if (!findResponse.isPresent()) {
			userRepository.save(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			throw new RecordAlreadyExistsException(
					"User with name: " + user.getUsername() + " already present!!");
		}
		
	}
	
	@Override
	public ResponseEntity<User> updateUser(User user) {

		Optional<User> findResponse = userRepository.findById(user.getUsername());
		if (findResponse.isPresent()) {
			userRepository.save(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			throw new RecordNotFoundException(
					"User with name: " + user.getUsername() + " is not present!!");
		}
		
	}
	
	@Override
	public ResponseEntity<String> deleteUserById(String username) {
		userRepository.deleteById(username);
		return new ResponseEntity<String>("User with name: " + username + " deleted successfully!", HttpStatus.OK);

	}
	
	@Override
	public ResponseEntity<User> findUserById(String username) {

		Optional<User> findResponse = userRepository.findById(username);
		if (findResponse.isPresent()) {
			return new ResponseEntity<User>(findResponse.get(), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("User with name: " + username + " is not present!!");
		}

	}
	
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
    public ResponseEntity<User> validateUser(User user) {
      logger.info("Inside validateUser(): " + user.getUsername());
      Optional<User> findResponse = userRepository.findById(user.getUsername());
      User response = new User();
      if (findResponse.isPresent()) {
        User userObject = findResponse.get();
        if (userObject.getUsername().equals(user.getUsername())
            && userObject.getPassword().equals(user.getPassword())) {
          return new ResponseEntity<User>(userObject, HttpStatus.OK);
        }
      }
      return new ResponseEntity<User>(response, HttpStatus.BAD_REQUEST);
    }
     
}
