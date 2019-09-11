package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CLIENT")
public class Consultant {
	
	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="name")
	String name; 

	@Column(name="companyname")
	String companyname; 
	
	@Column(name="address")
	String address;

	@Column(name="emailId")
	String emailId;
	
	@Column(name="password")
	String password; 
	
	@Column(name="phoneNo")
	String phoneNo;	

	@Column(name="phoneNo1")
	String phoneNo1;

	@Column(name="status")
	Integer status;		
}
