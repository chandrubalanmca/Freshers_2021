package com.example.Order.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	
	    @Id
	    @Column(name = "order_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private BigInteger orderId;

	    @Column(name = "order_name")
	    private String name;

	    @Column(name = "order_quantity")
	    private String quantity;

		

		public Order(BigInteger orderId, String name, String quantity) {
			super();
			this.orderId = orderId;
			this.name = name;
			this.quantity = quantity;
		}

		public BigInteger getOrderId() {
			return orderId;
		}

		public void setOrderId(BigInteger orderId) {
			this.orderId = orderId;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

	    
	    
	   

}
