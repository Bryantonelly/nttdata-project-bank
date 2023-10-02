package com.nttdata.bank.customerservice.model.service;

import java.util.List;

import com.nttdata.bank.customerservice.model.entity.Customer;

public interface CustomerService{
	
	public Customer saveCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Long id);
}
