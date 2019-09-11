package org.arpit.java2blog.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class ConsultantDto implements Serializable{
	
	int id;
	
	String name; 

	String companyname; 
	
	String address;

	String emailId;
	
	String password; 
	
	String phoneNo;	

	String phoneNo1;

	Integer status;		
	
	MultipartFile uploadfile;

}
