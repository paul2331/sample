
package org.arpit.java2blog.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Data
@Table(name="addressbook")
public class Customer{

	@Id
	@Column(name="sino")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	@Column(name="customerid")
	private String status;
	
	@Column(name="customerType")
	private int customerType;
	
	@Column(name="name")
	private String name;
	
	@Column(name="fathername")
	private String fathername;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="website")
	private String website;
	
	@Column(name="faxno")
	private String faxno;
	
	@Column(name="panno")
	private String panno;
	
	@Column(name="tinno")
	private String tinno;
	
	@Column(name="cstno")
	private String cstno;
	
	@Column(name="stno")
	private String stno;
	
	@Column(name="esino")
	private String esino;
	
	@Column(name="pfno")
	private String pfno;
	
	@Column(name="companyname")
	private String companyname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="resiaddress")
	private String resiaddress;
	
	@Column(name="phno")
	private String phno;
	
	@Column(name="phno2")
	private String phno2="";
	
	@Column(name="landlineno")
	private String landlineno="";
	
	@Column(name="landlineno2")
	private String landlineno2="";
	
	@Column(name="mailid")
	private String mailid;
	
	@Column(name="natureofwork")
	private String natureofwork;
	
	@Column(name="ref")
	private String ref;
	
	@Column(name="accountno")
	private String accountno;
	
	@Column(name="accountname")
	private String accountname;
	
	@Column(name="accounttype")
	private String accounttype;
	
	@Column(name="bankname")
	private String bankname;
	
	@Column(name="bankbranchname")
	private String bankbranchname;
	
	@Column(name="ifsccode")
	private String ifsccode;
	
	@Column(name="micrcode")
	private String micrcode;
	
	@Column(name="ecs")
	private String ecs;
	
	@Column(name="updttm")
	private Timestamp updttm;

	
}
