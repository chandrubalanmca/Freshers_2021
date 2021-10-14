package com.crud.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.customer.entity.Customer;
import com.crud.customer.model.CustomerDto;
import com.crud.customer.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customer-details")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();

    }

    @GetMapping("/customer-detail/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);

    }

    @PutMapping("/customer-detail/{id}")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerdto) {
        return customerService.saveCustomer(customerdto);
    }

    @PostMapping("/customer-details")
    public List<CustomerDto> saveCustomer(@RequestBody List<CustomerDto> customerDto) {
        return customerService.saveListOfCustomers(customerDto);

    }

    @DeleteMapping("/customer-detail/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }


}
