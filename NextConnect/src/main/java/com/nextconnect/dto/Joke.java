package com.nextconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Joke {
	
	private String type;
	
	@JsonProperty("value")
	private JokeSubDTO jokeData;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public JokeSubDTO getJokeData() {
		return jokeData;
	}
	public void setJokeData(JokeSubDTO jokeData) {
		this.jokeData = jokeData;
	}
	@Override
	public String toString() {
		return "Joke [type=" + type + ", jokeData=" + jokeData + "]";
	}

}


