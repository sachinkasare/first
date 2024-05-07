package com.watersoftware.beans;




import javax.persistence.*;
import javax.validation.constraints.*;





@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_count")
	@SequenceGenerator(name = "department_count", initialValue = 1, allocationSize = 1)
	@Column(length = 16)
	private int deptid;
	
	@NotNull
	@Size(max = 50)
	@Column(length = 50)
	private String dept_name;
	
	@NotNull
	@Size(max = 50)
	@Column(length = 50)
	private String dept_status;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int deptid, @NotNull @Size(max = 50) String dept_name,
			@NotNull @Size(max = 50) String dept_status) {
		super();
		this.deptid = deptid;
		this.dept_name = dept_name;
		this.dept_status = dept_status;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDept_id(int deptid) {
		this.deptid = deptid;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_status() {
		return dept_status;
	}

	public void setDept_status(String dept_status) {
		this.dept_status = dept_status;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", dept_name=" + dept_name + ", dept_status=" + dept_status + "]";
	}
	
	
	
	
	

	

	
	
	

	
	
}
