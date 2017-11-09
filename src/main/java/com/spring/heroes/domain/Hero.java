package com.spring.heroes.domain;

public class Hero {
	
	private int id;
	private String name;
	
	public Hero(){}
	
	public Hero(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
