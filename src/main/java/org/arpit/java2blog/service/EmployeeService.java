package org.arpit.java2blog.service;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
@Data
@Service("employeeService")
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public Employee getEmployeeByEmailId(String email, String password) {
		return employeeDao.getEmployeeByEmailId(email, password);
	}
	
}
