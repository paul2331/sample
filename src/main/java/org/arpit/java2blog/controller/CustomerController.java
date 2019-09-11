package org.arpit.java2blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.arpit.java2blog.dto.CustomerDto;
import org.arpit.java2blog.dto.CustomerDtoList;
import org.arpit.java2blog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/listAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CustomerDto> listAllCustomers() {		
		return customerService.getAllCustomers();		
	}
	@RequestMapping(value = "/filteredCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public CustomerDtoList filteredCustomers(@RequestParam("iDisplayStart") int pageNo, @RequestParam("iDisplayLength") int pageSize,
			@RequestParam("iSortCol_0")int colIndex,@RequestParam("sSortDir_0") String sortDirection, 
			@RequestParam("sSearch")String searchValue,@RequestParam("status") String status,@RequestParam("clientId") int clientId			  
			) {	
		return customerService.filteredCustomers(pageNo, pageSize, colIndex, sortDirection, searchValue, clientId, status);
	}
	
	@RequestMapping(value = "/listCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public CustomerDtoList listCustomers(@RequestParam("iDisplayStart") int pageNo, @RequestParam("iDisplayLength") int pageSize,
			@RequestParam("iSortCol_0")int colIndex,@RequestParam("sSortDir_0") String sortDirection, 
			@RequestParam("sSearch")String searchValue,@RequestParam("status") String status,@RequestParam("clientId") int clientId			  
			) {		
		
		
		CustomerDtoList listOfCustomers = customerService.listCustomers(pageNo, pageSize, colIndex, sortDirection, searchValue, clientId, status);
		
		listOfCustomers.setIDisplayLength(pageSize);
		listOfCustomers.setIDisplayStart(pageNo);
		return listOfCustomers;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getCustomerById(@PathVariable int id) {
		customerService.getCustomer(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		return customerService.addCustomer(customer);

	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public CustomerDto updateCustomer(@RequestBody CustomerDto customer) {
		return customerService.updateCustomer(customer); 

	}	

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);


	}	
}
