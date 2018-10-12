package com.opus.employee;

public class EmployeeNew extends Employee {
	
	private float newsalary;
	private String eligible;
	
	public EmployeeNew() {
	}

	public EmployeeNew(int id, String name,float currentsalary, int rating, float newsalary, String eligible) {
		super(id, name,currentsalary, rating);
		this.newsalary = newsalary;
		this.eligible = eligible;
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public void setId(int id) {
		super.setId(id);
	}

	@Override
	public float getCurrentsalary() {
		return super.getCurrentsalary();
	}

	@Override
	public void setCurrentsalary(float currentsalary) {
		super.setCurrentsalary(currentsalary);
	}

	@Override
	public int getRating() {
		return super.getRating();
	}

	@Override
	public void setRating(int rating) {
		super.setRating(rating);
	}

	public float getNewsalary() {
		return newsalary;
	}

	public void setNewsalary(float newsalary) {
		this.newsalary = newsalary;
	}

	public String isEligible() {
		return eligible;
	}

	public void setEligible(String eligible) {
		this.eligible = eligible;
	}
	
	
}
