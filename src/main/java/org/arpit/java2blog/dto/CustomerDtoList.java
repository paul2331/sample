package org.arpit.java2blog.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class CustomerDtoList implements Serializable{	
	String iTotalRecords;
	String iTotalDisplayRecords;
	List<String[]> aaData = new ArrayList<String[]>();
	String sColumns;
	private String sEcho;
	int iDisplayStart;
	int iDisplayLength;
	
	 private int draw=1; 
	 private int recordsFiltered; 
	 private int recordsTotal; 
	 List data;	
	 List<CustomerDto> list = new ArrayList<CustomerDto>();
	 
}
