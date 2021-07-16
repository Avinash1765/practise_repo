package com.nextconnect.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "msg_tokens")
public class MessagingToken implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer uniqueId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserDetails user;
	
	private String messagingToken;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public String getMessagingToken() {
		return messagingToken;
	}
	public void setMessagingToken(String messagingToken) {
		this.messagingToken = messagingToken;
	}
	@Override
	public String toString() {
		return "MessagingToken [user=" + user + ", messagingToken=" + messagingToken + "]";
	}
	
}
