package com.example.Order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Order.Repository.CustomerRepository;
import com.example.Order.view.Details;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository cusomerRepository;
	
	
	public List<Details> getAllDetails(){
		return cusomerRepository.findAllWithDescriptionQuery();
		
	}

}
