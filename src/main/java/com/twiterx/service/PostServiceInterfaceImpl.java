package com.twiterx.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twiterx.entity.Post;
import com.twiterx.repository.PostRepository;


@Service
public class PostServiceInterfaceImpl implements PostServiceInterface
{
	@Autowired
	private PostRepository repo;

	@Override
	public Post save(Post post) 
	{
		post.setPostedAt(LocalDateTime.now());
		return repo.save(post);
		
	}

	@Override
	public Optional<Post> findById(long userId) {
		
		return repo.findById(userId);
	}

	@Override
	public List<Post> findAll() {
		
		return repo.findAll();
	}

	

}
