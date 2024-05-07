package com.watersoftware.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watersoftware.beans.Department;
import com.watersoftware.repository.DepartmentRepository;
import com.watersoftware.service.DepartmentService;

@Service("departmentservice")
public class DepartmentDao implements DepartmentService{

	
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> alldepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> updateDepartment(int dept_id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(dept_id);
	}

	@Override
	public Department findByDeptid(int dept_id) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDeptid(dept_id);
	}

	

	
}
