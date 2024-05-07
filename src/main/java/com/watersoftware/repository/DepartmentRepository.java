package com.watersoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watersoftware.beans.Department;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

	public Department findByDeptid(int deptid);
}
