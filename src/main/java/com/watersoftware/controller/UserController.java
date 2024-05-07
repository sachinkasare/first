package com.watersoftware.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watersoftware.beans.User;
import com.watersoftware.common.response.ResponseHandler;
import com.watersoftware.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	
	UserService userservice;
	
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody User user)
	{
		user.setStatus("1");
		User saveduser=userservice.saveUser(user);
		
		if(saveduser!=null)
		{
			return ResponseHandler.generateResponse("Data Saved Sucessfully",HttpStatus.ACCEPTED , saveduser);
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Saved",HttpStatus.METHOD_NOT_ALLOWED , saveduser);
		}
	}
	
	@GetMapping("update/{user_id}")
	public ResponseEntity<Object> updateUser(@PathVariable("user_id")int user_id)
	{
		Optional<User> user=userservice.updateUser(user_id);
		
		if(user!=null)
		{
			return ResponseHandler.generateResponse("Get Data Sucessful...for this id"+user_id+"", HttpStatus.OK, user);
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found...for this id"+user_id+"", HttpStatus.NOT_FOUND, user);
		}
	}
	
	@DeleteMapping("delete/{user_id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("user_id")int user_id)
	{
		User user=userservice.findById(user_id);
		
		if(user!=null)
		{
			user.setStatus("0");
			User saveduser=userservice.saveUser(user);
			
			if(saveduser!=null)
			{
				return ResponseHandler.generateResponse("Data Delete Sucessfully",HttpStatus.OK , saveduser);
			}
			else
			{
				return ResponseHandler.generateResponse("Data Not Deleted",HttpStatus.METHOD_NOT_ALLOWED , user);
			}
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id "+user_id+"",HttpStatus.NOT_FOUND , user);
		}
	}
	
	@GetMapping
	public List<User> allUser()
	{
		List<User> userlist=userservice.getallUser();
		
		if(userlist.isEmpty())
		{
			return null;
		}
		else
		{
			return userlist;
		}
	}
}
