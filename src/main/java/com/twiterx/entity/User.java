package com.twiterx.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User
{
	@Id
	@GeneratedValue()
	private long userId;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private String isPremium;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(String isPremium) {
		this.isPremium = isPremium;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	

	
}
