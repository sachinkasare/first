package com.watersoftware.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_count")
	@SequenceGenerator(name = "project_count", initialValue = 1, allocationSize = 1)
	@Column(length = 16)
	private int productid;
	
	@NotNull
	@Size(max = 256)
	@Column(length = 256)
	private String productname;
	
	@NotNull
	private int product_rate;
	
	@Size(max = 65535)
	@Column(length = 65535, columnDefinition = "Text")
	private String product_description;
	
	@Column(length = 2)
	private int status;

	
	@Transient
	private int productquantity;

    
	@JsonManagedReference
	@NotNull
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "eid")
	private Employee employee;


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int productid, @NotNull @Size(max = 256) String productname, @NotNull int product_rate,
			@Size(max = 65535) String product_description, int status, int productquantity,
			@NotNull Employee employee) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.product_rate = product_rate;
		this.product_description = product_description;
		this.status = status;
		this.productquantity = productquantity;
		this.employee = employee;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public int getProduct_rate() {
		return product_rate;
	}


	public void setProduct_rate(int product_rate) {
		this.product_rate = product_rate;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getProductquantity() {
		return productquantity;
	}


	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", product_rate=" + product_rate
				+ ", product_description=" + product_description + ", status=" + status + ", productquantity="
				+ productquantity + ", employee=" + employee + "]";
	}
	
	
	
	
	
	
	
	
	

}
