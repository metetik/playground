package com.udemyspringmvcproject.service;

import java.util.List;

import com.udemyspringmvcproject.entity.Customer;

public interface ICustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int Id);
	public void deleteCustomer(int Id);
}
