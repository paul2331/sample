package org.arpit.java2blog.controller;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.arpit.java2blog.common.CAConstants;
import org.arpit.java2blog.dto.User;
import org.arpit.java2blog.model.Consultant;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.service.ConsultantService;
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
	
	@Setter
	@Autowired
	ConsultantService consultantService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public User login(@RequestBody User user, HttpSession httpSession) throws Exception{
		System.out.println("Enter into login------------------------->"+user.getEmailId());
		String sessionKey = "userDetails";
		boolean validUser = false;
		Employee employee = employeeService.getEmployeeByEmailId(user.getEmailId(), user.getPassword());
		if(employee!=null) {
			System.out.println("Enter into employee--------employee----------------->"+employee.getName());
			user.setName(employee.getName());
			user.setStaffId(employee.getId());
			user.setRole(employee.getRole());
			user.setUserType(CAConstants.USER_TYPE_CA_USER);
			httpSession.setAttribute(sessionKey, user);
			validUser = true;
		}else{
			Consultant consultant = consultantService.getConsultantByEmailId(user.getEmailId(), user.getPassword());
			if(consultant!=null) {
				System.out.println("Enter into consultant--------consultant----------------->"+consultant.getName());
				user.setName(consultant.getName());
				user.setStaffId(consultant.getId());
				user.setRole(CAConstants.USER_ROLE_STAFF);
				user.setUserType(CAConstants.USER_TYPE_CONSULTANT);
				httpSession.setAttribute(sessionKey, user);
				validUser = true;
			}
		}
		if(!validUser) {
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
