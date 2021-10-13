package com.crud.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="customer_table")
public class Customer {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name ="city")
	private String city;
	
	@Column(name ="address")
	private String address;
	
	public Customer() {
		
	}
	
	public Customer(Integer id, String name,String city, String address) {
		super();
		this.id = id;
		this.name = name;
		this.city= city;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	
}
