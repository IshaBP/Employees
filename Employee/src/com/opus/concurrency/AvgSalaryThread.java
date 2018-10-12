package com.opus.concurrency;

import java.util.ArrayList;

import com.opus.employee.Employee;

public class AvgSalaryThread extends Thread {

	private ArrayList<Employee> empList;

	public AvgSalaryThread(ArrayList<Employee> empList) {
		super();
		this.empList = empList;
	}
	
	@Override
	public void run() {
		// Average salary of employees
		float avgSalary = (float) empList.stream().mapToDouble(p->p.getCurrentsalary()).average().getAsDouble();
		System.out.println("\nAverage salary of employees:	"+avgSalary);
	}
}
