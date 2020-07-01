package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.model.Users;
import com.project1.repository.UsersRepository;
import com.project1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Optional<Users> getUsersById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id);
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		Users user1 = usersRepository.save(new Users(
//				user.getUserId(),
				user.getName(), 
				user.getPhone(), 
				user.getPassword(), 
				user.getLocation(), 
				user.getImageUrl(),
				user.getEmail())
				);
		return user1;
	}

	@Override
	public ResponseEntity<Users> updateUsers(Integer id, Users updatedUser) {

		Optional<Users> existingUser = usersRepository.findById(id);

		if (existingUser.isPresent()) {
			Users userTemp = existingUser.get();
			userTemp.setName(updatedUser.getName());
			userTemp.setPhone(updatedUser.getPhone());
			userTemp.setEmail(updatedUser.getEmail());
			userTemp.setImageUrl(updatedUser.getImageUrl());
			userTemp.setLocation(updatedUser.getLocation());
			userTemp.setPassword(updatedUser.getPassword());

			return new ResponseEntity<>(usersRepository.save(userTemp), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public boolean deleteUsers(int id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
		return false;
	}

}
