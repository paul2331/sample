package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.arpit.java2blog.common.CAConstants;
import org.arpit.java2blog.dao.ConsultantDao;
import org.arpit.java2blog.dto.ConsultantDto;
import org.arpit.java2blog.dto.ConsultantDtoList;
import org.arpit.java2blog.dto.CustomerDto;
import org.arpit.java2blog.dto.CustomerDtoList;
import org.arpit.java2blog.model.Consultant;
import org.arpit.java2blog.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcabi.aspects.Cacheable;

import lombok.Data;

@Data
@Service("consultantService")
public class ConsultantService {
	@Autowired
	ConsultantDao consultantDao;

	@Transactional
	public Consultant getConsultantByEmailId(String email, String password) {
		try {
			return consultantDao.getConsultantByEmailId(email, password);
		}catch (Exception e) {
			System.out.println("Exception in getConsultantByEmailId------>"+e);
		}
		return null;
	}
	@Transactional
	public ConsultantDtoList filteredConsultant(int pageNo, int pageSize,
			 String searchValue, String status) {
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
				+" searchValue--->"+searchValue);
		List<Consultant> listEnties = consultantDao.listFilteredConsultant(start, pageSize, status, searchValue);
		Long count = consultantDao.getConsultantCount(status, searchValue);
		
		ConsultantDtoList customerDtoList = new ConsultantDtoList();
		List<ConsultantDto> list = new ArrayList<ConsultantDto>();
		customerDtoList.setRecordsTotal(count.intValue());
		 if(listEnties!=null) {
			 for (Consultant consultant: listEnties) {
				 ConsultantDto consultantDto = new ConsultantDto();
				BeanUtils.copyProperties(consultant, consultantDto);
				list.add(consultantDto);
			 }
		 }
		 customerDtoList.setList(list);
		 return customerDtoList;
	}

	@Transactional
	@Cacheable(lifetime = 5, unit = TimeUnit.HOURS)
	public List<ConsultantDto> listAllConsultant(){		
		  try { 
			  List<Consultant> list = consultantDao.listAllConsultant();
			  if(list!=null) { 
				  List<ConsultantDto> listConsultantDto = new
				  ArrayList<ConsultantDto>(); 
				  for(Consultant consultant:list) { 
					  ConsultantDto dto = new ConsultantDto(); 
					  BeanUtils.copyProperties(consultant, dto);
					  listConsultantDto.add(dto); 
				  } 
				  return listConsultantDto;
			  } 
		  }catch (Exception e) {
			  System.out.println("Exception in listAllConsultant------>"+e); 
		  } 
		  return null;
		 
		/*
		 * try { System.out.println("-------------new--------"); Iterable<Consultant>
		 * iterator = consultantRepository.findAll(); if(iterator!=null) {
		 * List<ConsultantDto> listConsultantDto = new ArrayList<ConsultantDto>();
		 * 
		 * for (Consultant consultant : iterator) { ConsultantDto dto = new
		 * ConsultantDto(); BeanUtils.copyProperties(consultant, dto);
		 * listConsultantDto.add(dto); }
		 * System.out.println("size-----"+listConsultantDto); return listConsultantDto;
		 * } }catch (Exception e) { System.out.println(e); } return null;
		 */
	}
	@Transactional
	public List<ConsultantDto> listConsultantByStatus(int status){
		try {
			List<Consultant> list = consultantDao.listClientsByStatus(status);
			if(list!=null) {
				List<ConsultantDto> listConsultantDto = new ArrayList<ConsultantDto>();
				for(Consultant consultant:list) {
					ConsultantDto dto = new ConsultantDto();
					BeanUtils.copyProperties(consultant, dto);
					listConsultantDto.add(dto);
				}
				return listConsultantDto;
			}
		}catch (Exception e) {
			System.out.println("Exception in listConsultantByStatus------>"+e);
		}
		return null;
	}
	@Transactional
	public ConsultantDto getConsultant(int id){
		System.out.println("id---->"+id);
		try {
			Consultant consultant = consultantDao.getConsultant(id);
			if(consultant!=null) {				
				ConsultantDto dto = new ConsultantDto();
				BeanUtils.copyProperties(consultant, dto);	
				return dto;
			}
		}catch (Exception e) {
			System.out.println("Exception in getConsultant------>"+e);
		}
		return null;
	}
	@Transactional
	public ConsultantDto saveConsultant(ConsultantDto consultantDto){
		try {			
			if(consultantDto!=null) {				
				Consultant entity = new Consultant();
				BeanUtils.copyProperties(consultantDto, entity);	
				consultantDao.saveConsultant(entity);
				consultantDto.setId(entity.getId());
				return consultantDto;
			}
		}catch (Exception e) {
			System.out.println("Exception in saveConsultant------>"+e);
		}
		return null;
	}
	@Transactional
	public boolean isNameAlreadyExists(String name) {
		try {	
			Consultant entity = consultantDao.getConsultantByName(name);
			if(entity!=null) {
				throw new ArrayIndexOutOfBoundsException();
			}else {
				return true;
			}		
		}catch (Exception e) {
			System.out.println("Exception in isNameAlreadyExists------>"+e);
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	@Transactional
	public List<ConsultantDto> listConsultantByMobileNumber(String mobileNumber){
		try {
			List<Consultant> list = consultantDao.listConsultantByMobileNumber(mobileNumber);
			if(list!=null) {
				List<ConsultantDto> listConsultantDto = new ArrayList<ConsultantDto>();
				for(Consultant consultant:list) {
					ConsultantDto dto = new ConsultantDto();
					BeanUtils.copyProperties(consultant, dto);
					listConsultantDto.add(dto);
				}
				return listConsultantDto;
			}
		}catch (Exception e) {
			System.out.println("Exception in listConsultantByStatus------>"+e);
		}
		return null;
	}
	@Transactional
	public List<ConsultantDto> listSimilarConsultant(String name, String companyname, String email,
			String phoneNo, String phoneNo1) {
		try {
			List<Consultant> list = consultantDao.listSimilarConsultant(name, companyname, email, phoneNo, phoneNo1);
			if(list!=null) {
				List<ConsultantDto> listConsultantDto = new ArrayList<ConsultantDto>();
				for(Consultant consultant:list) {
					ConsultantDto dto = new ConsultantDto();
					BeanUtils.copyProperties(consultant, dto);
					listConsultantDto.add(dto);
				}
				return listConsultantDto;
			}
		}catch (Exception e) {
			System.out.println("Exception in listConsultantByStatus------>"+e);
		}
		return null;
	}
	@Transactional
	public String updateByIdAndStatus(String ids,String action ) {
		String idArr [] = ids.split(",");
		int status = new Integer(CAConstants.CUSTOMER_STATUS_DEACTIVE);
		if("Activate".equalsIgnoreCase(action)) {
			status = new Integer(CAConstants.CUSTOMER_STATUS_ACTIVE);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (String id : idArr) {
			if(id!=null && id.trim().length()>0) {
				list.add(new Integer(id));
			}
		}
		consultantDao.updateConsultantByIdAndStatus(status, list);
		return "success";
	}
	@Transactional
	public String deleteConsultant(String ids) {
		String idArr [] = ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (String id : idArr) {
			if(id!=null && id.trim().length()>0) {
				list.add(new Integer(id));
			}
		}
		consultantDao.deleteConsultants(list);
		return "success";
	}
}
