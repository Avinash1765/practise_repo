package com.nextconnect.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class UserDetails {
	
	@Id
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name="image_url")
	private String userImageUrl;
	
	@Column(name="email_id")
	private String emailId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public UserDetails() {}

	public UserDetails(Integer userId, String userName, String userImageUrl, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userImageUrl = userImageUrl;
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userImageUrl=" + userImageUrl
				+ ", emailId=" + emailId + "]";
	}
	
}
