package com.opus.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opus.exceptions.InvalidNumberOfFieldsException;

public class EmployeeData {

	ArrayList<Employee> empList = new ArrayList<Employee>();

	public EmployeeData(ArrayList<Employee> empList) {
		super();
		this.empList = empList;
	}
	
	public ArrayList<Employee> loadData() throws InvalidNumberOfFieldsException{
		try(BufferedReader br = new BufferedReader(new FileReader ("emp_original_opus.txt"));){
			String inputLine;
			while ( (inputLine = br.readLine()) != null) {
			    String[] empVars = inputLine.split(";");
			    if(empVars.length<4) {
			    	throw new InvalidNumberOfFieldsException("Incomplete data provided");
			    } else if(empVars.length>4) {
			    	throw new InvalidNumberOfFieldsException("Extra data provided");			    	
			    }
			    empList.add(new Employee(Integer.parseInt(empVars[0]), empVars[1], Float.parseFloat(empVars[2]),Integer.parseInt(empVars[3])));
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
