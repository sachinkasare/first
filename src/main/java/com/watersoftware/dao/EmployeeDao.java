package com.watersoftware.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watersoftware.beans.Employee;
import com.watersoftware.repository.EmployeeRepository;
import com.watersoftware.service.EmoloyeeService;

@Service
public class EmployeeDao implements EmoloyeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getallEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getById(int eid) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEid(eid);
	}


	
	

}
