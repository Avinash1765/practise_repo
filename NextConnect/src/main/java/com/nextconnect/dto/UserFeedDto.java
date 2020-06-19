package com.nextconnect.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserFeedDto {
	
	private UserDetails userDetails;
	private List<Post> userPosts;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<UserDetails> followingUsers;
	
	public List<UserDetails> getFollowingUsers() {
		return followingUsers;
	}
	public void setFollowingUsers(List<UserDetails> followingUsers) {
		this.followingUsers = followingUsers;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<Post> getUserPosts() {
		return userPosts;
	}
	public void setUserPosts(List<Post> userPosts) {
		this.userPosts = userPosts;
	}
	@Override
	public String toString() {
		return "UserFeedDto [userDetails=" + userDetails + ", userPosts=" + userPosts + "]";
	}
}
