package com.exam.SetDI;

import java.util.List;

public class Person {
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFriend() {
		return friend;
	}
	public void setFriend(List<String> friend) {
		this.friend = friend;
	}
	private String name;
	private List<String> friend;
  
	
	
	
	
}
