package org.arpit.java2blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.arpit.java2blog.dto.User;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
public class LoginController {
	@Setter
	@Autowired 
	EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public User login(@RequestBody User user, HttpSession httpSession) throws Exception{
		System.out.println("Enter into login------------------------->"+user.getEmailId());
		String sessionKey = "userDetails";
		Employee employee = employeeService.getEmployeeByEmailId(user.getEmailId());
		if(employee!=null) {
			System.out.println("Enter into employee--------employee----------------->"+employee.getName());
			user.setName(employee.getName());
			user.setId(employee.getId());
			httpSession.setAttribute(sessionKey, user);
		}else {
			System.out.println("*************sorry*********");
			throw new ArrayIndexOutOfBoundsException();
		}
	    
		return user;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET, headers = "Accept=application/json")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "success";
	}
}
