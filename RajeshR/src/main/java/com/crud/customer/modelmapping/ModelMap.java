package com.crud.customer.modelmapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.crud.customer.entity.Customer;
import com.crud.customer.model.CustomerDto;

@Component
public class ModelMap {


    ModelMapper modelMapper = new ModelMapper();

    public Customer customerDtotoCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customer;
    }

    public CustomerDto customertoCustomerDto(Customer customer) {
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }

}
