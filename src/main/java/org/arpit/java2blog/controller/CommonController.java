package org.arpit.java2blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.arpit.java2blog.dto.MailContentDto;
import org.arpit.java2blog.util.GMailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@Autowired
	GMailClient gmailClient;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST, headers = "Accept=application/json")
	public  Map<String, String> saveConsultant(@RequestBody MailContentDto mailContentDto) {		
		 gmailClient.send( mailContentDto.getRecipients(), mailContentDto.getSubject(), mailContentDto.getMessage());
		 Map map = new HashMap<String, String>();
		 map.put("status", "Success");
		 return map;
	}
}
