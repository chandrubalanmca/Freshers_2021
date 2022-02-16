package com.example.Order.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer{

	    @Id
	    @Column(name = "customer_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private BigInteger customerId;
	    
	    
	    @Column(name = "order_id")
	    private BigInteger orderId;
	    

	    @Column(name = "customer_name")
	    private String customerName;

		
			
		public Customer(BigInteger customerId, BigInteger orderId, String customerName) {
			super();
			this.customerId = customerId;
			this.orderId = orderId;
			this.customerName = customerName;
		}


		public BigInteger getCustomerId() {
			return customerId;
		}

		public void setCustomerId(BigInteger customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public BigInteger getOrderId() {
			return orderId;
		}

		public void setOrderId(BigInteger orderId) {
			this.orderId = orderId;
		}
	


}


