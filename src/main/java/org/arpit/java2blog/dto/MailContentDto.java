package org.arpit.java2blog.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class MailContentDto implements Serializable{
	String subject;
	String recipients;
	String message;
}
