package com.twiterx.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post 
{

	@Id
	@GeneratedValue()
	private long postId;
	
	@Column(nullable=false)
	private String content;
	@Column()
	private LocalDateTime postedAt;
	
	@ManyToOne()
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "botId")
	private Bot bot;
	
	@OneToMany(mappedBy= "post", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Like> likes;

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostedAt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    return postedAt.format(formatter);
	}

	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", postedAt=" + postedAt + ", user=" + user
				+ ", bot=" + bot + ", comments=" + comments + "]";
	}
	
	
}
