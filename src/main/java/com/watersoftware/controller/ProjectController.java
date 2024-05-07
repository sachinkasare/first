package com.watersoftware.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watersoftware.beans.Project;
import com.watersoftware.common.response.ResponseHandler;
import com.watersoftware.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectservice;
	 
	Date today = new Date();

	@PostMapping
	public ResponseEntity<Object> saveProject(@RequestBody Project project)
	{
		project.setStatus(1);
		Project p=projectservice.saveProject(project);
		
		if(p!=null)
		{
			return ResponseHandler.generateResponse("Project Created Sucess", HttpStatus.ACCEPTED, p);
		}
		else
		{
			return ResponseHandler.generateResponse("Project Not Create", HttpStatus.UNSUPPORTED_MEDIA_TYPE, p);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object>GetAllProject()
	{
		List<Project> p1=projectservice.getByStatus(1);
		
		if(!p1.isEmpty())
		{
			return ResponseHandler.generateResponse("Projects Activated",HttpStatus.ACCEPTED, p1);
		}
		else
		{
			return ResponseHandler.generateResponse("Projects Not Available",HttpStatus.NO_CONTENT, p1);
		}
	}
	
	@GetMapping("/edit/{project_id}")
	public ResponseEntity<Object> editProject(@PathVariable("project_id") int project_id)
	{
		Project p=projectservice.findById(project_id);
		
		if(p!=null)
		{
			return ResponseHandler.generateResponse("Data Found ",HttpStatus.FOUND, p);
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id"+project_id+"", HttpStatus.NOT_FOUND, project_id);
		}
	}
	
	@PutMapping("/update/{projectid}")
	public ResponseEntity<Object> updateById(@PathVariable("projectid") int projectid,@RequestBody Project project)
	{
		Project p=projectservice.findById(projectid);
		if(p!=null)
		{
			p.setStart_date(project.getStart_date());
			p.setEnd_date(project.getEnd_date());
			p.setProject_name(project.getProject_name());
			p.setProject_description(project.getProject_description());
			
			Project update=projectservice.saveProject(p);
			
			return update!=null ?ResponseHandler.generateResponse("Project Details Update Sucessful", HttpStatus.OK, update)
					:ResponseHandler.generateResponse("Some Problem is There...",HttpStatus.NOT_ACCEPTABLE, p);
			
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id"+projectid+"", HttpStatus.NOT_FOUND, projectid);
		}
	}
	
	@DeleteMapping("/delete/{projectid}")
	public ResponseEntity<Object> deleteProject(@PathVariable("projectid") int projectid)
	{
		Project p=projectservice.findById(projectid);
		if(p!=null)
		{
			p.setStatus(0);
			p.setEnd_date(today);
			Project update=projectservice.saveProject(p);
			
			return update!=null ?ResponseHandler.generateResponse("Project Deleted  Sucessful", HttpStatus.OK, update)
					:ResponseHandler.generateResponse("Some Problem is There...",HttpStatus.NOT_ACCEPTABLE, p);
			
		}
		else
		{
			return ResponseHandler.generateResponse("Data Not Found for this id"+projectid+"", HttpStatus.NOT_FOUND, projectid);
		}
	}
	
	
}
