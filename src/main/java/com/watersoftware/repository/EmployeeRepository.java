package com.watersoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watersoftware.beans.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	public Employee findByEid(int eid);
}
