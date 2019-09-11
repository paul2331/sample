package org.arpit.java2blog.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
@Data
public class CustomerDto implements Serializable{
	
	int id;
	private String status;
	private int customerType;
	private String name;
	private String fathername;
	private Date dob;
	private String website;
	private String faxno;
	private String panno;
	private String tinno;
	private String cstno;
	private String stno;
	private String esino;
	private String pfno;
	private String companyname;
	private String address;
	private String resiaddress;
	private String phno;
	private String phno2="";
	private String landlineno="";
	private String landlineno2="";
	private String mailid;
	private String natureofwork;
	private String ref;
	private String accountno;
	private String accountname;
	private String accounttype;
	private String bankname;
	private String bankbranchname;
	private String ifsccode;
	private String micrcode;
	private String ecs;
	private Timestamp updttm;

}
