package com.watersoftware.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watersoftware.beans.Department;
import com.watersoftware.beans.Employee;
import com.watersoftware.beans.User;
import com.watersoftware.common.response.ResponseHandler;
import com.watersoftware.request.EmployeeRequest;
import com.watersoftware.service.DepartmentService;
import com.watersoftware.service.EmoloyeeService;
import com.watersoftware.service.UserService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmoloyeeService employeeservice;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DepartmentService departmentservice;
	
	User user=new User();
	
	Department department=new Department();
	
	
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	LocalDateTime today = LocalDateTime.now();
	
	@SuppressWarnings("resource")
	@PostMapping
	public Map<String, Object> addEmployee(@RequestParam MultipartFile file, @RequestParam String employeeData)
			throws IOException {

		File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		// System.out.println(myFile);
		String employeeimage = file.getOriginalFilename();

		String allPath = FILE_DIRECTORY.concat(employeeimage);
		// System.out.println("Actual File Path is " + allPath);

		// Converting String into JSON
		EmployeeRequest employeeData1 = null;
		Employee employeeDetails = null;
		try {
			employeeData1 = mapper.readValue(employeeData, EmployeeRequest.class);
             System.out.println(employeeData1);
             
             
			// Employee
			Employee employee = new Employee();
			employee.setName(employeeData1.getName());
			employee.setAadhar_no(employeeData1.getAadharno());
			employee.setPan_no(employeeData1.getPanno());
			employee.setEmail(employeeData1.getEmail());
			employee.setMobile_no(employeeData1.getMobile_no());
			employee.setAlternate_no(employeeData1.getAlternate_no());
			employee.setAddress(employeeData1.getAddress());
			employee.setDoj(employeeData1.getDoj());
			employee.setUrl(allPath);
			employee.setStatus("1");
			employee.setCreated_at(today);
			User user1=userservice.findById(employeeData1.getUserid());
			System.out.println(user1);
			employee.setUser(user1);
			
			Department department=departmentservice.findByDeptid(employeeData1.getDepartmentid());
			System.out.println(department);
			
			employee.setDepartment(department);
			
			
			
			employeeDetails=employeeservice.saveEmployee(employee);


			

		} catch (JsonProcessingException e) {
			return ResponseHandler.generateResponse1(false, employeeData, "Invalid Data");
		}
		fos.write(file.getBytes());
		fos.close();

		return ResponseHandler.generateResponse1(true, employeeDetails, "Employee Data Saved Successfully");

	}
	
	@GetMapping
	public List<Employee> allemployee()
	{
		return employeeservice.getallEmployee();
	}
	
	@SuppressWarnings("resource")
	@PutMapping("/update/{eid}")
	public Map<String, Object>  updateemployee(@PathVariable("eid") int eid,@RequestParam MultipartFile file, @RequestParam String employeeData) throws IOException
	{
		Employee empdata=employeeservice.getById(eid);
		
		if(empdata!=null)
		{
			File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			// System.out.println(myFile);
			String employeeimage = file.getOriginalFilename();

			String allPath = FILE_DIRECTORY.concat(employeeimage);
			// System.out.println("Actual File Path is " + allPath);

			// Converting String into JSON
			EmployeeRequest employeeData1 = null;
			Employee employeeDetails = null;
			try {
				 employeeData1 = mapper.readValue(employeeData, EmployeeRequest.class);
	             //System.out.println(employeeData1);
	             
	             
				// Employee
				/*Employee employee = new Employee();
				employee.setName(employeeData1.getName());
				employee.setAadhar_no(employeeData1.getAadharno());
				employee.setPan_no(employeeData1.getPanno());
				employee.setEmail(employeeData1.getEmail());
				employee.setMobile_no(employeeData1.getMobile_no());
				employee.setAlternate_no(employeeData1.getAlternate_no());
				employee.setAddress(employeeData1.getAddress());
				employee.setDoj(employeeData1.getDoj());
				employee.setUrl(allPath);
				employee.setStatus("1");
				employee.setCreated_at(today);*/
				
				empdata.setName(employeeData1.getName());
				empdata.setAadhar_no(employeeData1.getAadharno());
				empdata.setAddress(employeeData1.getAddress());
				empdata.setAadhar_no(employeeData1.getAadharno());
				empdata.setPan_no(employeeData1.getPanno());
				empdata.setMobile_no(employeeData1.getMobile_no());
				empdata.setAlternate_no(employeeData1.getAlternate_no());
				empdata.setDoj(employeeData1.getDoj());
				empdata.setUpdated_at(today);
				empdata.setUrl(allPath);
				User user1=userservice.findById(employeeData1.getUserid());
				System.out.println(user1);
				empdata.setUser(user1);
				
				Department department=departmentservice.findByDeptid(employeeData1.getDepartmentid());
				System.out.println(department);
				
				empdata.setDepartment(department);
				
				
				
				employeeDetails=employeeservice.saveEmployee(empdata);


				

			}
			catch (JsonProcessingException e) 
			{
				return ResponseHandler.generateResponse1(false, employeeData, "Invalid Data");
			}
			fos.write(file.getBytes());
			fos.close();

			return ResponseHandler.generateResponse1(true, employeeDetails, "Employee Updated Saved Successfully");

		}
		else
		{
			return ResponseHandler.generateResponse1(false, employeeData, "Record Not Found");
		}
		
	}
	
	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("eid") int eid)
	{
		Employee emp=employeeservice.getById(eid);
		
		if(emp!=null)
		{
			emp.setStatus("0");
			Employee empsaved=employeeservice.saveEmployee(emp);
			return  ResponseHandler.generateResponse("Data Delete Sucessfully",HttpStatus.ACCEPTED , empsaved);
		}
		else
		{
			return  ResponseHandler.generateResponse("Data Not Found for this id"+eid+"",HttpStatus.NOT_FOUND , eid);
		}
	}
	
	
	}
	

