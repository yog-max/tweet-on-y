package com.twiterx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twiterx.entity.Post;
import com.twiterx.entity.User;
import com.twiterx.service.PostServiceInterface;
import com.twiterx.service.UserServiceInterface;


@RestController
@CrossOrigin()
@RequestMapping("/post")
public class PostController
{
	@Autowired
	private UserServiceInterface uservice;
	
	@Autowired
	private PostServiceInterface pservice;
	
	
	@PostMapping("/create/{userId}")
	public Post postSave(@PathVariable long userId, @RequestBody Post post)
	{
		User user =  uservice.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
		post.setUser(user);
		return pservice.save(post);
	}
	
	@GetMapping("/get")
	public List<Post> findAllPost()
	{
		return pservice.findAll();
	}
	
	
}
