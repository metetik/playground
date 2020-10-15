package com.udemyspringmvcproject.dao;

import java.util.List;

import com.udemyspringmvcproject.entity.Customer;

public interface ICustomerDAO {
	public List<Customer> getCustomers();
	
}
