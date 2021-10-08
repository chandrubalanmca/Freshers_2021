package com.example.Order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Order.service.CustomerService;
import com.example.Order.view.Details;

@RestController
public class CustomerController {

	
  @Autowired
  private CustomerService customerService;

  @GetMapping("/home")
  public List<Details> getAllDetails(){
	  return customerService.getAllDetails();
  }


}
