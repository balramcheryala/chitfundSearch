package com.chitfunds.orm;

public class Tags {

	public int id;
	public String tagName;

	private String name;
	private String email;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Tags(int id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}

	public Tags(String tagName) {
		this.tagName = tagName;
	}

}
