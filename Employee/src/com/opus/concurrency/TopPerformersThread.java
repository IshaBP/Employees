package com.opus.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opus.employee.Employee;

public class TopPerformersThread extends Thread{

	private ArrayList<Employee> empList;

	public TopPerformersThread(ArrayList<Employee> empList) {
		super();
		this.empList = empList;
	}		
	
	@Override
	public void run() {
		// Top performers (Rating==1)
        List<Employee>anotherList1 = empList.stream().filter(p -> p.getRating()<2).collect(Collectors.toList());
		System.out.println("Top Performers:");
		anotherList1.forEach(p -> System.out.println(p.getName()));
	}
}
