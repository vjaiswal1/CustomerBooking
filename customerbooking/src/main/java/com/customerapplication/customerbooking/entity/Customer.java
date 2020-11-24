package com.customerapplication.customerbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.customerapplication.customerbooking.utility.CustomerType;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String favRoute;
	private String customerType = CustomerType.NORMAL.toString();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFavRoute() {
		return favRoute;
	}

	public void setFavRoute(String favRoute) {
		this.favRoute = favRoute;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
