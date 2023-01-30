package com.soprasteria.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.soprasteria.model.User;
import com.soprasteria.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IUserService service;

  @PostMapping("/addUser")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    ResponseEntity<User> response = null;
    try {
      response = service.addUser(user);
    } catch (Exception e) {
      System.out.println("Exception while adding user:" + e.getMessage());
    }
    return response;

  }

  @PostMapping("/auth")
  public ResponseEntity<User> loginUser(@RequestBody User user) {
    ResponseEntity<User> response = null;
    logger.info("Insiude /auth API Validating credentials!");
    try {
      response = service.validateUser(user);

    } catch (Exception e) {
      System.out.println("Exception while adding user:" + e.getMessage());
    }
    return response;

  }

  @PostMapping("/updateUser")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    logger.info("Inside /updateUser API updating user details");
    ResponseEntity<User> response = null;
    try {
      response = service.updateUser(user);
    } catch (Exception e) {
      System.out.println("Exception while updating user:" + e.getMessage());
    }
    return response;
  }

  @PostMapping("/deleteUser/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable String id) {
    logger.info("Inside /deleteUser API deleting user details");
    ResponseEntity<String> response = null;
    try {
      response = service.deleteUserById(id);
    } catch (Exception e) {
      System.out.println("Exception while deleting user:" + e.getMessage());
    }
    return response;
  }

  @GetMapping("/getAllUsers")
  public List<User> viewAllUsers() {
    logger.info("Inside /getAllUsers API getting all user details");
    try {
      return service.getAllUsers();
    } catch (Exception e) {
      System.out.println("Exception while retrieving users:" + e.getMessage());
    }
    return null;
  }


}
