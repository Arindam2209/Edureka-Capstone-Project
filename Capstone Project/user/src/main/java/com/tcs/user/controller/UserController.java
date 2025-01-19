package com.tcs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.DTO.BankAccountDTO;
import com.tcs.user.entity.User;
import com.tcs.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/user")
	void Create(@RequestBody User user)
	{
		userservice.save(user);
		System.out.println("User Created....");
	}
	
	@GetMapping("/user")
	List<User> Read()
	{
		return userservice.findAll();
	}
	
	@GetMapping("/user/{userId}")
	List<BankAccountDTO> Search(@PathVariable int userId)
	{
		return userservice.getUserAccounts(userId);
	}
	
	@PutMapping("/user")
	void Update(@RequestBody User user)
	{
		userservice.save(user);
		System.out.println("User Updated....");
	}
	
//	@PutMapping("/user/{id}")
//	void Update(@PathVariable int id, @RequestBody User user)
//	{
//	    user.setId(id);  
//		userservice.save(user);
//		System.out.println("User Updated....");
//	}
	
	@DeleteMapping("/user/{userId}")
	void Delete(@PathVariable int userId)
	{
		userservice.deleteByUserId(userId);
		System.out.println("User Deleted.....");
	}

}
