package com.watersoftware.service;

import java.util.List;

import com.watersoftware.beans.Employee;

public interface EmoloyeeService {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getallEmployee();
	
	public Employee getById(int eid);
}
