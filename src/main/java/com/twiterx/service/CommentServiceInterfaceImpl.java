package com.twiterx.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twiterx.entity.Comment;
import com.twiterx.repository.CommentRepository;

@Service
public class CommentServiceInterfaceImpl implements CommentServiceInterface
{

	@Autowired
	private CommentRepository repo;
	
	@Override
	public Comment saveComment(Comment comment)
	{
		comment.setCommentAt(LocalDateTime.now());
		return repo.save(comment);
	}

	@Override
	public List<Comment> findAllComments() {
		
		return repo.findAll();
	}

	
}
