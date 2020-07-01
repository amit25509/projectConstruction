package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Users;

public interface UsersService {

	public List<Users> getAllUsers();
	public Optional<Users> getUsersById(int id);
	public Users addUser(Users user);
	public ResponseEntity<Users> updateUsers(Integer id,Users user);
	public boolean deleteUsers(int id);
}
