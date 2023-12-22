package com.ws.wiseSaying.controller.entity;

public class WiseSaying { // wisesaying클래스는 기능들의 조립하는 역할을 수행한다
	private int id;
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) {
		this.id = id;//this 를 이용해 문자들이 겹쳐도 에러나지 않는다
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}