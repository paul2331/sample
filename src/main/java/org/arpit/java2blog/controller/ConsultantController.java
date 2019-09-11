package org.arpit.java2blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import org.arpit.java2blog.dto.ConsultantDto;
import org.arpit.java2blog.dto.ConsultantDtoList;
import org.arpit.java2blog.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
public class ConsultantController {
	
	@Setter
	@Autowired
	ConsultantService consultantService;
	
	@RequestMapping(value = "/listAllConsultants", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ConsultantDto> listAllConsultants() {	
		return consultantService.listAllConsultant();
	}
	@RequestMapping(value = "/filteredConsultants", method = RequestMethod.GET, headers = "Accept=application/json")
	public ConsultantDtoList filteredCustomers(@RequestParam("iDisplayStart") int pageNo, @RequestParam("iDisplayLength") int pageSize,			
			@RequestParam("sSearch")String searchValue,@RequestParam("status") String status		  
			) {	
		return consultantService.filteredConsultant(pageNo, pageSize, searchValue, status);
	}
	@RequestMapping(value = "/getConsultants/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ConsultantDto getConsultants(@PathVariable("id")int id) {
		return consultantService.getConsultant(id);
	}
	@RequestMapping(value = "/listConsultantByStatus/{status}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  List<ConsultantDto>  listConsultantByStatus(@PathVariable("status")int status) {
		return consultantService.listConsultantByStatus(status);
	}
	@RequestMapping(value = "/saveConsultant", method = RequestMethod.POST, headers = "Accept=application/json")
	public  ConsultantDto  saveConsultant(@RequestBody ConsultantDto consultantDto) {
		System.out.println();
		return consultantService.saveConsultant(consultantDto);
	}
	@RequestMapping(value = "/isNewConsultant", method = RequestMethod.GET, headers = "Accept=application/json")
	public  boolean  isNewConsultant(@RequestParam("name")String name) {
		System.out.println("isNewConsultant------------>"+name);
		return consultantService.isNameAlreadyExists(name);
	}
	@RequestMapping(value = "/listConsultantByMobileNumber/{mobileNumber}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  List<ConsultantDto>  listConsultantByMobileNumber(@PathVariable("mobileNumber")String mobileNumber) {
		return consultantService.listConsultantByMobileNumber(mobileNumber);
	}
	
	@RequestMapping(value = "/listSimilarConsultant", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ConsultantDto> listSimilarConsultant(@RequestParam("name") String name, @RequestParam("companyname") String companyname,			
			@RequestParam("email")String email,@RequestParam("phoneNo")String phoneNo,@RequestParam("phoneNo1") String phoneNo1		  
			) {	
		return consultantService.listSimilarConsultant(name, companyname, email, phoneNo, phoneNo1);
	}
	@RequestMapping(value = "/updateByIdAndStatus/{id}/{action}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Map<String, String> updateByIdAndStatus(@PathVariable("id") String ids,@PathVariable("action")String action ) {		
		consultantService.updateByIdAndStatus(ids, action);
		Map map = new HashMap<String, String>();
		map.put("status", "Success");
		return map;
	}
	@RequestMapping(value = "/deleteConsultants/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Map<String, String> deleteConsultant(@PathVariable("id") String ids) {		
		consultantService.deleteConsultant(ids);
		Map map = new HashMap<String, String>();
		map.put("status", "Success");
		return map;
	}
}
