package org.arpit.java2blog.dao.impl;

import java.util.List;

import org.arpit.java2blog.common.CAConstants;
import org.arpit.java2blog.dao.CustomerDao;
import org.arpit.java2blog.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer>  customerList = session.createQuery("from Customer where status=:status").setString("status", CAConstants.CUSTOMER_STATUS_ACTIVE).list();
		return customerList;
	}
	public List<Customer> listCustomers(int start, int maxRecords,String status, String searchStr,int customerType) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder queryStr = new StringBuilder("from Customer where status=:status ");
		if(customerType>0){	
			queryStr.append(" and customerType=:customerType");			
		}if(searchStr!=null && searchStr.trim().length()>0){	
			queryStr.append(" and ( name like :searchStr ");
			queryStr.append(" or companyname like :searchStr ");
			queryStr.append(" or address like :searchStr ");		
			queryStr.append(" or phno like :searchStr ");			
			queryStr.append(" or phno2 like :searchStr  ) ");			
		}	
		Query query = session.createQuery(queryStr.toString());
		query.setString("status", status);
		if(customerType>0){	
			query.setInteger("customerType", customerType);
		}if(searchStr!=null && searchStr.trim().length()>0){
			query.setString("searchStr", "%"+searchStr+"%");
		}
		query.setFirstResult(start);
		query.setMaxResults(maxRecords);
		List<Customer>  customerList = query.list();
		return customerList;
	}
	public Long getCustomerCount(String status, String searchStr,int customerType) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder queryStr = new StringBuilder("select count(*) from Customer where status=:status ");
		if(customerType>0){	
			queryStr.append(" and customerType=:customerType");			
		}if(searchStr!=null && searchStr.trim().length()>0){	
			queryStr.append(" and ( name like :searchStr ");
			queryStr.append(" or companyname like :searchStr ");
			queryStr.append(" or address like :searchStr ");		
			queryStr.append(" or phno like :searchStr ");			
			queryStr.append(" or phno2 like :searchStr  ) ");			
		}	
		Query query = session.createQuery(queryStr.toString());
		query.setString("status", status);
		if(customerType>0){	
			query.setInteger("customerType", customerType);
		}if(searchStr!=null && searchStr.trim().length()>0){
			query.setString("searchStr", "%"+searchStr+"%");
		}
		Long count = (Long)query.uniqueResult();
		return count;
	}
	public List<Customer> getCustomersByFilter(String status, int customerType) {
		if(status==null) {
			status = CAConstants.CUSTOMER_STATUS_ACTIVE;
		}
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder buildString = new StringBuilder("from Customer where status=:status ");
		if(customerType>0) {
			buildString.append(" and customerType=:customerType ");
		}
		Query query = session.createQuery(buildString.toString());
		query.setString("status", status);
		if(customerType>0) {
			query.setInteger("customerType", customerType);
		}
		List<Customer>  customerList = query.list();
		return customerList;
	}
	
	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}
	public Integer getCustomerMaxId() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select max(id) from Customer");
		Integer count = (Integer)query.uniqueResult();
		return count;
	}

	public void saveCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		if(customer.getId()<=0) {
			Integer id = getCustomerMaxId();
			customer.setId(id.intValue()+1);
		}
		customer.setStatus(CAConstants.CUSTOMER_STATUS_ACTIVE);
		session.saveOrUpdate(customer);
	}
	
	public void updateCustomerByIdAndStatus(int id,String status){
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			p.setStatus(status);
			session.update(p);
		}
	}

	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
