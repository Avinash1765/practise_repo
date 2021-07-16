package com.nextconnect.dto;

public class JokeSubDTO {
	private Integer id;
	private String joke;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJoke() {
		return joke;
	}
	public void setJoke(String joke) {
		this.joke = joke;
	}
	public JokeSubDTO(Integer id, String joke) {
		super();
		this.id = id;
		this.joke = joke;
	}
	
	public JokeSubDTO() {}
}