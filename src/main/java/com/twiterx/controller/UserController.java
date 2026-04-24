package com.twiterx.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twiterx.entity.User;
import com.twiterx.service.UserServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController
{
	
	@Autowired
	private UserServiceInterface service;
	
	@PostMapping("/register")
	public User saveUser(@RequestBody User user)
	{
		return service.save(user);
	}
	
	@GetMapping("/get")
	public List<User> findUsers()
	{
		return service.findAll();
	}
	
	@PutMapping("/update/{userId}")
	public String updateById(@PathVariable long userId, @RequestBody User user)
	{
		return service.updateById(userId, user);
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteById(@PathVariable long userId)
	{
		return service.deleteById(userId);
	}
	
}
