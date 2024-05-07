package com.watersoftware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watersoftware.beans.Project;
@Repository
public interface ProjectRepository  extends JpaRepository<Project,Integer>{

	public List<Project> findByStatus(int status);
	
	public Project findByProjectid(int projectid);
}
