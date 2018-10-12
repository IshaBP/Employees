package com.opus.employee;

public class Employee {

	private int id;
	private String name;
	private float currentsalary;
	private int rating;
	
	public Employee() {
	}
	
	public Employee(int id, String name,float currentsalary, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.currentsalary = currentsalary;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCurrentsalary() {
		return currentsalary;
	}

	public void setCurrentsalary(float currentsalary) {
		this.currentsalary = currentsalary;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
