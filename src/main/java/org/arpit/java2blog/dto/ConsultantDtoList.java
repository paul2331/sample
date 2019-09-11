package org.arpit.java2blog.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class ConsultantDtoList implements Serializable{	
	 private int recordsTotal; 	 
	 List<ConsultantDto> list = new ArrayList<ConsultantDto>();
}
