package com.watersoftware.beans;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "employee_count")
	@SequenceGenerator(name = "employee_count", initialValue = 1, allocationSize = 1)
	@Column(length=16)
	private int eid;
	
	@NotNull
	@Size(max = 32)
	@Column(length = 32)
    private String name;
    
	@Email(message = "Email should be valid")
	@Size(max = 32)
	@Column(length = 32)
	private String email;
    
	
	private String url;
	
	@Pattern(regexp = "\\d{1,20}")
    @Size(max = 20)
	@Column(length = 32,name="mobileno")
	private String mobile_no;

	@Pattern(regexp = "\\d{1,20}")
    @Size(max = 20)
	@Column(length = 32,name="alternateno")
	private String alternate_no;

	@Column(length = 65535, columnDefinition = "Text")
	private String address;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date doj;

	@Size(max = 32)
	@Column(length = 32)
	private String aadhar_no;
    
	@Size(max = 32)
	@Column(length = 32)
	private String pan_no;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created_at;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updated_at;

	@JsonManagedReference
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "dept_id")
	private Department department;
	
	
	@OneToOne(targetEntity=User.class,cascade=CascadeType.MERGE)  
	private User user;
      
	@Size(max = 32)
	@Column(length = 32)
	private String status;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, @NotNull @Size(max = 32) String name,
			@Email(message = "Email should be valid") @Size(max = 32) String email, String url,
			@Pattern(regexp = "\\d{1,20}") @Size(max = 20) String mobile_no,
			@Pattern(regexp = "\\d{1,20}") @Size(max = 20) String alternate_no, String address, Date doj,
			@Size(max = 32) String aadhar_no, @Size(max = 32) String pan_no, LocalDateTime created_at,
			LocalDateTime updated_at, @NotNull Department department, User user, @Size(max = 32) String status) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.url = url;
		this.mobile_no = mobile_no;
		this.alternate_no = alternate_no;
		this.address = address;
		this.doj = doj;
		this.aadhar_no = aadhar_no;
		this.pan_no = pan_no;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.department = department;
		this.user = user;
		this.status = status;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAlternate_no() {
		return alternate_no;
	}

	public void setAlternate_no(String alternate_no) {
		this.alternate_no = alternate_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + ", url=" + url + ", mobile_no="
				+ mobile_no + ", alternate_no=" + alternate_no + ", address=" + address + ", doj=" + doj
				+ ", aadhar_no=" + aadhar_no + ", pan_no=" + pan_no + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", department=" + department + ", user=" + user + ", status=" + status + "]";
	}

	

	

	

	
	
	

	
	
	
	
	

}
