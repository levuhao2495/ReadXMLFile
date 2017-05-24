package com.myapp.maven;

public class Structure {

	private String id;
	private String name;
	private String author;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public Structure() {
	}
	
	public Structure(String id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
