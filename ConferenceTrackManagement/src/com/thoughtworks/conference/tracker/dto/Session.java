package com.thoughtworks.conference.tracker.dto;

public class Session {
	
	private String sessionName;
	private int sessionDuration;
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public int getSessionDuration() {
		return sessionDuration;
	}
	public void setSessionDuration(int sessionDuration) {
		this.sessionDuration = sessionDuration;
	}
	
	public Session(String sessionName, int sessionDuration) {
		super();
		this.sessionName = sessionName;
		this.sessionDuration = sessionDuration;
	}
	@Override
	public String toString() {
		return "Session [sessionName=" + sessionName + ", sessionDuration=" + sessionDuration + "]";
	}
	
	
}
