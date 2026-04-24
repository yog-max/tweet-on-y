package com.twiterx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twiterx.entity.Like;
import com.twiterx.entity.Post;
import com.twiterx.entity.User;
import com.twiterx.service.LikeServiceInterface;
import com.twiterx.service.PostServiceInterface;
import com.twiterx.service.UserServiceInterface;

@RestController
@CrossOrigin()
@RequestMapping("/like")
public class LikeController
{

	@Autowired
	private UserServiceInterface uservice;
	
	@Autowired
	private PostServiceInterface pservice;
	
	@Autowired
	private LikeServiceInterface lservice;
	
	@PostMapping("/liked/{postId}")
    public ResponseEntity<Like> likePost( @PathVariable Long postId,@RequestParam Long userId)
	{
        Post post = pservice.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        User user = uservice.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Like like = lservice.likePost(post, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(like);
    }
	
	@GetMapping("/likescount/{postId}")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long postId) {

        Post post = pservice.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        long count = lservice.getLikeCount(post);
        return ResponseEntity.ok(count);
    }
	
	
}
