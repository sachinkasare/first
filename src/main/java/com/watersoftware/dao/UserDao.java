package com.watersoftware.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watersoftware.beans.User;
import com.watersoftware.repository.UserRepository;
import com.watersoftware.service.UserService;

@Service("userservice")
public class UserDao implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<User> updateUser(int userid) {
		// TODO Auto-generated method stub
		return userRepository.findById(userid);
	}

	@Override
	public User findById(int userid) {
		// TODO Auto-generated method stub
		return userRepository.findByUserid(userid);
	}

	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	

}
