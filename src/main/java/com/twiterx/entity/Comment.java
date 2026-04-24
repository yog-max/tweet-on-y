package com.twiterx.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comment
{
	@Id
	@GeneratedValue()
	private long commentId;
	
	@Column(nullable=false)
	private String comment;
	
	@Column()
	private LocalDateTime commentAt;
	
	@ManyToOne()
	@JoinColumn(name = "postId", nullable = false)
	private Post post;
	
	@ManyToOne()
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentAt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    return commentAt.format(formatter);
	}

	public void setCommentAt(LocalDateTime commentAt) {
		this.commentAt = commentAt;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentAt=" + commentAt + ", post="
				+ post + ", user=" + user + "]";
	}
	
	
	

}
