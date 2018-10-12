package com.opus.concurrency;

import java.util.ArrayList;

import com.opus.employee.Employee;

public class MaxSalaryThread extends Thread {

	private ArrayList<Employee> empList;

	public MaxSalaryThread(ArrayList<Employee> empList) {
		super();
		this.empList = empList;
	}
	
	@Override
	public void run() {
		// Employee with max salary
		Employee eMax = empList.stream().max((p1,p2) -> p1.getCurrentsalary()>p2.getCurrentsalary()?1:-1).get();
		System.out.println("\nEmployee with max salary:	"+eMax.getName());
	}
}
