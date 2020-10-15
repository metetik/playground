package com.udemyspringmvcproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemyspringmvcproject.entity.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = 
				session.createQuery("from Customer",Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}
}
