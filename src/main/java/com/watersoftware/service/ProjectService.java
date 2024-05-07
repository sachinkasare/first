package com.watersoftware.service;

import java.util.List;

import com.watersoftware.beans.Project;

public interface ProjectService {

	public Project saveProject(Project project);
	
	public List<Project> getallproject();
	
	public Project findById(int project_id);
	
	public List<Project> getByStatus(int status);
	
	
}
