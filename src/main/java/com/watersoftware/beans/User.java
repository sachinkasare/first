package com.watersoftware.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "user_count")
	@SequenceGenerator(name = "user_count", initialValue = 1, allocationSize = 1)
	@Column(length=16)
	
	private int userid;
	
	@NotNull
	@Size(max = 32)
	@Column(length = 32)
	private String username;
	
	@NotNull
	@Size(max = 32)
	@Column(length = 32)
	private String password;
	
	@NotNull
	@Size(max = 32)
	@Column(length = 32)
	private String Status;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, @NotNull @Size(max = 32) String username, @NotNull @Size(max = 32) String password,
			@NotNull @Size(max = 32) String status) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		Status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", Status=" + Status
				+ "]";
	}
	
	
	

	
	
	
}
