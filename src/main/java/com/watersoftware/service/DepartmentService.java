package com.watersoftware.service;

import java.util.List;
import java.util.Optional;

import com.watersoftware.beans.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public List<Department> alldepartment();
	
	public Department findByDeptid(int dept_id);
	
	public Optional<Department> updateDepartment(int dept_id);
}
