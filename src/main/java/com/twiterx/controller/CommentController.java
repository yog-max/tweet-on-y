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

import com.twiterx.entity.Comment;
import com.twiterx.entity.Post;
import com.twiterx.entity.User;
import com.twiterx.service.CommentServiceInterface;
import com.twiterx.service.PostServiceInterface;
import com.twiterx.service.UserServiceInterface;

@RestController
@CrossOrigin()
@RequestMapping("/comment")
public class CommentController
{
	@Autowired
	private PostServiceInterface pservice;
	
	@Autowired
	private CommentServiceInterface cservice;
	
	@Autowired 
	private UserServiceInterface uservice;
	
	@PostMapping("/create/{userId}/{postId}")
	public Comment saveComment(@PathVariable long userId,@PathVariable long postId,  @RequestBody Comment comment)
	{
		User exist = uservice.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
		Post exist2 = pservice.findById(userId).orElseThrow(() -> new RuntimeException("post not found"));
		comment.setUser(exist);
		comment.setPost(exist2);
		return cservice.saveComment(comment);
	}
	
	@GetMapping("/get")
	public List<Comment> getAllComments()
	{
		 return cservice.findAllComments();
	}
	
	
	
	

}
