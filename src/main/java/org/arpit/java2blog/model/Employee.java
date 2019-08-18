package org.arpit.java2blog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="name")
	String name; 

	@Column(name="father_name")
	String fatherName; 
	
	@Column(name="dateofbirth")
	Date dateofbirth; 
	
	@Column(name="qualification")
	String qualification; 
	
	@Column(name="address")
	String address;
	
	@Column(name="phone_no")
	String phoneNo; 
	
	@Column(name="land_line")
	String landLine;

	@Column(name="mail_id")
	String mailId;
	
	@Column(name="password")
	String password; 
	
	@Column(name="role")
	String role;	

	@Column(name="reference")
	String reference;

	@Column(name="salary")
	Integer salary;
	
	@Column(name="remark")
	String remark; 
	
	@Column(name="experience")
	Integer experience;

	@Column(name="dateofjoin")
	Date dateofjoin; 

	@Column(name="dateofresign")
	Date dateofresign; 
	
	
	
	
	

}
