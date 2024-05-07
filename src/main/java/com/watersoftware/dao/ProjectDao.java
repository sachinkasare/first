package com.watersoftware.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watersoftware.beans.Project;
import com.watersoftware.repository.ProjectRepository;
import com.watersoftware.service.ProjectService;

@Service
public class ProjectDao implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getallproject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Project findById(int project_id) {
		// TODO Auto-generated method stub
		return projectRepository.findByProjectid(project_id);
	}

	@Override
	public List<Project> getByStatus(int status) {
		// TODO Auto-generated method stub
		return projectRepository.findByStatus(status);
	}

}
