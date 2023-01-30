package com.soprasteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soprasteria.model.User;

public interface UserRepositoryDao extends JpaRepository<User, String>{

}
