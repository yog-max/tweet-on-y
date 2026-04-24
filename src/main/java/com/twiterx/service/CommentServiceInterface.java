package com.twiterx.service;

import java.util.List;

import com.twiterx.entity.Comment;

public interface CommentServiceInterface
{

	Comment saveComment(Comment comment);

	List<Comment> findAllComments();

	

}
