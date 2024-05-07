package com.watersoftware.service;

import java.util.List;
import java.util.Optional;

import com.watersoftware.beans.User;

public interface UserService {

	public User saveUser(User user);
	
	public Optional<User> updateUser(int userid);
	
	public User findById(int userid);
	
	public List<User> getallUser();
}
