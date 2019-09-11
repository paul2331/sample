package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers() ;

	public Customer getCustomer(int id) ;

	public Customer addCustomer(Customer customer);

	public void saveCustomer(Customer customer) ;

	public void deleteCustomer(int id) ;
	
	public Long getCustomerCount(String status, String searchStr,int customerType);
	public List<Customer> listCustomers(int start, int maxRecords,String status, String searchStr,int customerType);
}
