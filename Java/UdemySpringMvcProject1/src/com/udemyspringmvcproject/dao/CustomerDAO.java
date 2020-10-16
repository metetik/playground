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
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = 
				session.createQuery("from Customer order by lastName",
						Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}
	
	@Override
	public Customer getCustomer(int Id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Customer.class,Id);
	}
	@Override
	public void deleteCustomer(int Id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(session.get(Customer.class, Id));
	}
}
