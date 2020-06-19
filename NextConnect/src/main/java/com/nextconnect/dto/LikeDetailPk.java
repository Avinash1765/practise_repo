package com.nextconnect.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LikeDetailPk implements Serializable{
	
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = UserDetails.class)
	@JoinColumn(name="liked_by")
	private UserDetails user;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Post.class)
	@JoinColumn(name="post_id")
	private Post post;

	/*
	 * public UserDetails getUser() { return user; }
	 * 
	 * public void setUser(UserDetails user) { this.user = user; }
	 * 
	 * public Post getPost() { return post; }
	 * 
	 * public void setPost(Post post) { this.post = post; }
	 */
	
	public Integer getUserId() {
		return user.getUserId();
	}

	public LikeDetailPk(UserDetails user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}
	
	public LikeDetailPk() {}
	
}
