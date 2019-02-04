package com.sample.boot;

import java.io.Serializable;

public class Greeting implements Serializable{
	private long id;
	private String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Greeting() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
