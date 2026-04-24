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
public class Bot
{
	@Id
	@GeneratedValue()
	private long botId;
	@Column(nullable=false)
	private String botName;
	@Column(nullable=false)
	private String perDescription;
	
	@OneToMany(mappedBy= "bot", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts;

	public long getBotId() {
		return botId;
	}

	public void setBotId(long botId) {
		this.botId = botId;
	}

	public String getBotName() {
		return botName;
	}

	public void setBotName(String botName) {
		this.botName = botName;
	}

	public String getPerDescription() {
		return perDescription;
	}

	public void setPerDescription(String perDescription) {
		this.perDescription = perDescription;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Bot [botId=" + botId + ", botName=" + botName + ", perDescription=" + perDescription + ", posts="
				+ posts + "]";
	}
	
	

}
