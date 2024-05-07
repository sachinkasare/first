package com.watersoftware.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watersoftware.beans.Department;
import com.watersoftware.common.response.ResponseHandler;
import com.watersoftware.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController
{

	
	@Autowired
	DepartmentService departmentservice;
	
	@PostMapping
	public ResponseEntity<Object> saveDepartment(@RequestBody Department department)
	{
		department.setDept_status("1");
		Department dept=departmentservice.saveDepartment(department);
		
		if(dept!=null)
		{
			return ResponseHandler.generateResponse("Data Saved Sucessfully",HttpStatus.ACCEPTED , dept);
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Saved",HttpStatus.METHOD_NOT_ALLOWED , dept);
		}
			
	}
	
	@GetMapping
	public List<Department> allDepartment()
	{
		List<Department> depts=departmentservice.alldepartment();
		
		if(depts!=null)
		{
			return depts;
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/edit/{dept_id}")
	public ResponseEntity<Object> updateDepartment(@PathVariable("dept_id") int dept_id)
	{
		Optional<Department> dept=departmentservice.updateDepartment(dept_id);
		
		
		if(dept!=null)
		{
			return ResponseHandler.generateResponse("Data get Sucessfully",HttpStatus.FOUND , dept);
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id "+dept_id+"",HttpStatus.NOT_FOUND , dept);
		}
	}
	
	
	
	@DeleteMapping("/delete/{dept_id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable("dept_id") int dept_id)
	{
		
		Department dept=departmentservice.findByDeptid(dept_id);
		
		
		if(dept!=null)
		{
			
			dept.setDept_status("0");
			Department d1=departmentservice.saveDepartment(dept);
			if(d1!=null)
			{
				return ResponseHandler.generateResponse("Data Delete Sucessfully",HttpStatus.OK , d1);
			}
			else
			{
				return ResponseHandler.generateResponse("Data Not Deleted",HttpStatus.METHOD_NOT_ALLOWED , dept);
			}
		
	    }
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id "+dept_id+"",HttpStatus.NOT_FOUND , dept);
		}
   }



}