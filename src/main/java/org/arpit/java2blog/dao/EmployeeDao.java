package org.arpit.java2blog.dao;

import org.arpit.java2blog.model.Employee;

public interface EmployeeDao {
	public Employee getEmployeeByEmailId(String emailId, String password) ;
}
