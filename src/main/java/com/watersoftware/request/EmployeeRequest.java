package com.watersoftware.request;

import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeRequest {
	
	private String name;
	
	private String email;
	
	private String url;
	
	private String mobile_no;
	
	private String alternate_no;
	
	private String address;
	
	private Date doj;
	
	private LocalDateTime created_at;
	
	private LocalDateTime updated_at;
	
	private int userid;
	
	private int departmentid;
	
	private String aadharno;
	
	private String panno;
	
	private String gender;
	
	private String status;

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequest(String name, String email, String url, String mobile_no, String alternate_no, String address,
			Date doj, LocalDateTime created_at, LocalDateTime updated_at, int userid, int departmentid, String aadharno,
			String panno, String gender, String status) {
		super();
		this.name = name;
		this.email = email;
		this.url = url;
		this.mobile_no = mobile_no;
		this.alternate_no = alternate_no;
		this.address = address;
		this.doj = doj;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.userid = userid;
		this.departmentid = departmentid;
		this.aadharno = aadharno;
		this.panno = panno;
		this.gender = gender;
		this.status = status;
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", email=" + email + ", url=" + url + ", mobile_no=" + mobile_no
				+ ", alternate_no=" + alternate_no + ", address=" + address + ", doj=" + doj + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", userid=" + userid + ", departmentid=" + departmentid
				+ ", aadharno=" + aadharno + ", panno=" + panno + ", gender=" + gender + ", status=" + status + "]";
	}

	

	
	

	
	
	
}
