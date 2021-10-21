package com.crud.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.customer.entity.Customer;
import com.crud.customer.model.CustomerDto;
import com.crud.customer.modelmapping.ModelMap;
import com.crud.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	
	@Autowired
	ModelMap mapper;
	

	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	
	public CustomerDto saveCustomer(CustomerDto customerdto) {
		Customer customer= mapper.customerDtotoCustomer(customerdto);
		customerRepository.save(customer);
		 return mapper.customertoCustomerDto(customer);
	}
	
	public List<CustomerDto> saveListOfCustomers(List<CustomerDto> customer) {
		List<CustomerDto> customerDtos =new ArrayList<CustomerDto>();
		for(CustomerDto customers : customer) {
			customerDtos.add(saveCustomer(customers));
		}
		return  customerDtos;
		
	}
	
		
	public Optional<Customer> getCustomer(Integer id) {
	        return customerRepository.findById(id);
	    }
		
	
		
	public void  deleteCustomer(Integer id) {
			customerRepository.deleteById(id);
		}
	}

