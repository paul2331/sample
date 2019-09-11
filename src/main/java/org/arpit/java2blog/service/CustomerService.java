package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.common.CAConstants;
import org.arpit.java2blog.dao.CustomerDao;
import org.arpit.java2blog.dto.CustomerDto;
import org.arpit.java2blog.dto.CustomerDtoList;
import org.arpit.java2blog.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	public CustomerDtoList filteredCustomers(int pageNo, int pageSize,
			int colIndex, String sortDirection, String searchValue,int customerType, String status) {
		if (pageSize < 10 || pageSize > 50) {
			pageSize = 10;
		}
		if(pageNo<=0) {
			pageNo = 1;
		}
		if(status==null||status.trim().length()==0) {
			status = CAConstants.CUSTOMER_STATUS_ACTIVE;
		}
		int start = (pageNo-1) * pageSize;
		System.out.println("pageNo-->"+pageNo+" pageSize-->"+pageSize+" start--->"+start
				+" colIndex-->"+colIndex+" sortDirection-->"+sortDirection+" searchValue--->"+searchValue);
		List<Customer> listEnties = customerDao.listCustomers(start, pageSize, status, searchValue, customerType);
		Long count = customerDao.getCustomerCount(status, searchValue, customerType);
		
		CustomerDtoList customerDtoList = new CustomerDtoList();
		List<CustomerDto> list = new ArrayList<CustomerDto>();
		customerDtoList.setRecordsTotal(count.intValue());
		 if(listEnties!=null) {
			 for (Customer customer: listEnties) {
				 CustomerDto customerDto = new CustomerDto();
				BeanUtils.copyProperties(customer, customerDto);
				list.add(customerDto);
			 }
		 }
		 customerDtoList.setList(list);
		 return customerDtoList;
	}

	@Transactional
	public CustomerDtoList listCustomers(int pageNo, int pageSize,
			int colIndex, String sortDirection, String searchValue,int customerType, String status) {
		if (pageSize < 10 || pageSize > 50) {
			pageSize = 10;
		}
		if(pageNo<0) {
			pageNo = 0;
		}
		int start = pageNo * pageSize;
		System.out.println("pageNo-->"+pageNo+" pageSize-->"+pageSize+" start--->"+start
				+" colIndex-->"+colIndex+" sortDirection-->"+sortDirection+" searchValue--->"+searchValue);
		List<Customer> listEnties = customerDao.listCustomers(start, pageSize, status, searchValue, customerType);
		Long count = customerDao.getCustomerCount(status, searchValue, customerType);
		List<String[]> dtoList = new ArrayList();
		CustomerDtoList customerDtoList = new CustomerDtoList();
		 if(listEnties!=null) {
			 for (Customer customer: listEnties) {
				String[]  customerDto = new String[6];
				customerDto[0] = String.valueOf(customer.getId());
				customerDto[1] = customer.getName();
				customerDto[2] = customer.getCompanyname();
				customerDto[3] = customer.getAddress();
				customerDto[4] = customer.getPhno();
				customerDto[5] = customer.getPhno2();
						
				dtoList.add(customerDto);
			}
			 customerDtoList.setData(dtoList);
			 customerDtoList.setAaData(dtoList);
			 customerDtoList.setITotalDisplayRecords(listEnties.size()+"");
			 customerDtoList.setRecordsFiltered(listEnties.size());
		 }
				
		if(count!=null) {
			customerDtoList.setITotalRecords(count.intValue()+"");
			customerDtoList.setRecordsTotal(count.intValue());			
		}
		//customerDtoList.setDraw(1);
		return customerDtoList;
	}
	
	@Transactional
	public List<CustomerDto> getAllCustomers() {
		try {
			List<Customer> listEnties = customerDao.getAllCustomers();
			 List<CustomerDto> dtoList = new ArrayList();
			 if(listEnties!=null) {
				 for (Customer customer: listEnties) {
					CustomerDto customerDto = new CustomerDto();
					BeanUtils.copyProperties(customer, customerDto);
					dtoList.add(customerDto);
				}
				 return dtoList;
			 }
		}catch(Exception e) {
			System.out.println("exception in getAllCustomers"+e);
		}
		return null;
	}

	@Transactional
	public CustomerDto getCustomer(int id) {
		Customer customer = customerDao.getCustomer(id);
		if(customer!=null) {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(customer, customerDto);
			return customerDto;
		}
		return null;
	}

	@Transactional
	public CustomerDto addCustomer(CustomerDto customerDto) {
		if(customerDto!=null) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			customerDao.addCustomer(customer);
			customerDto.setId(customer.getId());
		}		
		return customerDto;
	}

	@Transactional
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		if(customerDto!=null) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
//			customerDao.updateCustomer(customer);
			customerDto.setId(customer.getId());
		}		
		return customerDto;		
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
