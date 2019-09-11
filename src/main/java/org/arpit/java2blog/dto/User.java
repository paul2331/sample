package org.arpit.java2blog.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User implements Serializable{
	String emailId;
	String password;
	String name;
	String role;
	String userType;
	Integer staffId;
}
