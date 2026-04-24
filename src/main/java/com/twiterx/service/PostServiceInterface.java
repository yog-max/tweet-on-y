package com.twiterx.service;

import java.util.List;
import java.util.Optional;

import com.twiterx.entity.Post;
import com.twiterx.entity.User;

public interface PostServiceInterface 
{

	Post save(Post post);

	Optional<Post> findById(long userId);

	List<Post> findAll();

	

		

}
