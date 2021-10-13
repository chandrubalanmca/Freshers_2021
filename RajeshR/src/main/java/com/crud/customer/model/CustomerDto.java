package com.crud.customer.model;

public class CustomerDto {
	
	private Integer id;
	private String name;
	private String city;
	private String address;
	
	
	
	public CustomerDto() {
		
	}


	public CustomerDto(Integer id, String name, String city, String address) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
