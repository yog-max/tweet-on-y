package com.twiterx.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "likes",
uniqueConstraints = @UniqueConstraint(columnNames = {"postId", "userId"}))
public class Like 
{
	
	@Id
	@GeneratedValue()
	private long likeId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="postId", nullable=false)
	private Post post;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	@Column()
	private LocalDateTime likedAt;

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
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

	public String getLikedAt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    return likedAt.format(formatter);
	}

	public void setLikedAt(LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", post=" + post + ", user=" + user + ", likedAt=" + likedAt + "]";
	}
	
	
	
	

}
