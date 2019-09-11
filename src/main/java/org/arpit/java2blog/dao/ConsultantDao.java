package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Consultant;

public interface ConsultantDao {
	public Consultant getConsultantByEmailId(String emailId, String password) ;
	public List<Consultant> listAllConsultant() ;
	public Consultant getConsultant(int id);
	public List<Consultant> listClientsByStatus(int status);
	public Consultant saveConsultant(Consultant consultant);
	public List<Consultant> listConsultantByMobileNumber(String mobileNo);
	public Consultant getConsultantByName(String name) ;
	public List<Consultant> listFilteredConsultant(int start, int maxRecords,String status, String searchStr);
	public Long getConsultantCount(String status, String searchStr);
	public List<Consultant> listSimilarConsultant(String name, String companyname,String email,String phoneNo, String phoneNo1) ;
	public int updateConsultantByIdAndStatus(int status, List<Integer> ids);
	public int deleteConsultants(List<Integer> ids);
}
