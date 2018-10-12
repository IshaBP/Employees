package com.opus.employee.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opus.concurrency.AvgSalaryThread;
import com.opus.concurrency.MaxSalaryThread;
import com.opus.concurrency.TopPerformersThread;
import com.opus.employee.Employee;
import com.opus.employee.EmployeeData;
import com.opus.employee.EmployeeNew;
import com.opus.exceptions.InvalidNumberOfFieldsException;
import com.opus.interfaces.NewSalary;
import com.opus.interfaces.PromoEligible;


public class EmployeeTest {

	public static void main(String[] args) {

		ArrayList<Employee> empList = new ArrayList<Employee>();		
		ArrayList<EmployeeNew> empNewList = new ArrayList<EmployeeNew>();	

		EmployeeData ed = new EmployeeData(empList);
		try {
			// Loading data from emp_originaldata.txt
			ArrayList<Employee> e = ed.loadData();

			// Calculating newsalary and eligibility to be promoted
			for(Employee x:e) {
				NewSalary ob = (float salary, int rating) -> {if(rating<=2) {return (float) (1.5*salary);}
															else {return salary;}
															};	
				float newsalary = ob.calnewsalary(x.getCurrentsalary(), x.getRating());
				
				PromoEligible ob1 = (int rating) -> {if(rating==1) {return "Yes";}
													return "No";
													};
				String eligible = ob1.eligibleforpromo(x.getRating());
				
				// Adding all employee data to new list
				empNewList.add(new EmployeeNew(x.getId(), x.getName(), x.getCurrentsalary(), x.getRating(), newsalary, eligible));
			}
			
			try {
				PrintStream o = new PrintStream(new File("emp_new_opus.txt")); 
			    PrintStream console = System.out; 
			    
			    // To file
				System.setOut(o); 
				
				// Modified  data written in file
				List<EmployeeNew> anotherList = empNewList.stream().collect(Collectors.toList());
				System.out.println("Id\t\tName\t\t\tCurrent Salary\t\tRating\t\tNew Salary\t\tPromotion Eligibility");
				anotherList.forEach(x -> System.out.println(x.getId()+"\t\t"+x.getName()+"\t\t\t"+x.getCurrentsalary()+"\t\t"+x.getRating()+"\t\t\t"+x.getNewsalary()+"\t\t\t"+x.isEligible()));

				// To console
				System.setOut(console); 
				
			    TopPerformersThread t1 = new TopPerformersThread(empList);
			    MaxSalaryThread t2 = new MaxSalaryThread(empList);
			    AvgSalaryThread t3 = new AvgSalaryThread(empList);
			    t1.start();
			    t2.start();
				t3.start();

				o.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} catch (InvalidNumberOfFieldsException e) {
			e.printStackTrace();
		} 
        

	}

}
