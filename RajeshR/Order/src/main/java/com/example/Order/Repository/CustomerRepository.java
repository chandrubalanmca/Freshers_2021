package com.example.Order.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Order.Entity.Customer;
import com.example.Order.view.Details;

public interface CustomerRepository extends CrudRepository<Customer,BigInteger> {

	 @Query("select new com.example.Order.view.Details(c.customerId,c.customerName,o.orderId,o.name,o.quantity) from "
	 		+ "customer_table c JOIN order_table o ON c.order_id = o.order_id ")
	    public List<Details> findAllWithDescriptionQuery();
	
	
}