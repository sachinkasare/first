package com.watersoftware.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_count")
	@SequenceGenerator(name = "project_count", initialValue = 1, allocationSize = 1)
	@Column(length = 16)
	private int projectid;
	
	@NotNull
	@Size(max = 256)
	@Column(length = 256)
	private String project_name;
	
	@Size(max = 65535)
	@Column(length = 65535, columnDefinition = "Text")
	private String project_description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date start_date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date end_date;
	
	@Column(length = 2)
	private int status;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectid, @NotNull @Size(max = 256) String project_name,
			@Size(max = 65535) String project_description, Date start_date, Date end_date, int status) {
		super();
		this.projectid = projectid;
		this.project_name = project_name;
		this.project_description = project_description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProject_id(int projectid) {
		this.projectid = projectid;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", project_name=" + project_name + ", project_description="
				+ project_description + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
	
	
}
