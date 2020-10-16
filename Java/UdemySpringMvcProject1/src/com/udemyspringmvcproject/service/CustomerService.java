package com.udemyspringmvcproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyspringmvcproject.dao.ICustomerDAO;
import com.udemyspringmvcproject.entity.Customer;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int Id) {
		return customerDAO.getCustomer(Id);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int Id) {
		customerDAO.deleteCustomer(Id);
	}
}
