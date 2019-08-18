package org.arpit.java2blog.dao.impl;

import java.util.List;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Customer;
import org.arpit.java2blog.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		System.out.println("emailId-->"+emailId);
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee>  employeeList = session.createQuery("from Employee where mailId=:emailId").setString("emailId", emailId).list();
		System.out.println("employeeList-->"+employeeList);
		if(employeeList!=null && !employeeList.isEmpty()) {
			return employeeList.get(0);
		}
		return null;
	}

}
