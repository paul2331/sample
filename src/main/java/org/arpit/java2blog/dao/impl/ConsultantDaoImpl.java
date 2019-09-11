package org.arpit.java2blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.common.CAConstants;
import org.arpit.java2blog.dao.ConsultantDao;
import org.arpit.java2blog.model.Consultant;
import org.arpit.java2blog.model.Customer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Repository
public class ConsultantDaoImpl implements ConsultantDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Consultant getConsultantByEmailId(String emailId, String password) {
		System.out.println("emailId-->"+emailId);
		Session session = this.sessionFactory.getCurrentSession();
		List<Consultant>  consultantList = session.createQuery("from Consultant where emailId=:emailId and password=:password")
				.setString("emailId", emailId).setString("password", password).list();
		System.out.println("consultantList-->"+consultantList);
		if(consultantList!=null && !consultantList.isEmpty()) {
			return consultantList.get(0);
		}
		return null;
	}
	@Override
	public Long getConsultantCount(String status, String searchStr) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder queryStr = new StringBuilder("select count(*) from Consultant where status=:status ");
		if(searchStr!=null && searchStr.trim().length()>0){	
			queryStr.append(" and ( name like :searchStr ");
			queryStr.append(" or companyname like :searchStr ");
			queryStr.append(" or address like :searchStr ");		
			queryStr.append(" or phoneNo like :searchStr ");			
			queryStr.append(" or phoneNo1 like :searchStr  ) ");			
		}	
		Query query = session.createQuery(queryStr.toString());
		query.setString("status", status);
		if(searchStr!=null && searchStr.trim().length()>0){
			query.setString("searchStr", "%"+searchStr+"%");
		}
		Long count = (Long)query.uniqueResult();
		return count;
	}
	@Override
	public List<Consultant> listFilteredConsultant(int start, int maxRecords,String status, String searchStr) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder queryStr = new StringBuilder("from Consultant where status=:status ");
		if(searchStr!=null && searchStr.trim().length()>0){	
			queryStr.append(" and ( name like :searchStr ");
			queryStr.append(" or companyname like :searchStr ");
			queryStr.append(" or address like :searchStr ");		
			queryStr.append(" or phoneNo like :searchStr ");			
			queryStr.append(" or phoneNo1 like :searchStr  ) ");			
		}	
		queryStr.append(" order by id desc ");
		Query query = session.createQuery(queryStr.toString());
		query.setString("status", status);
		if(searchStr!=null && searchStr.trim().length()>0){
			query.setString("searchStr", "%"+searchStr+"%");
		}
		query.setFirstResult(start);
		query.setMaxResults(maxRecords);
		List<Consultant>  customerList = query.list();
		return customerList;
	}
	@Override
	public List<Consultant> listAllConsultant() {
		System.out.println("inside listAllConsultant--------->");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Consultant");		
		return query.list();		
	}
	public Integer getConsultantMaxId() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select max(id) from Consultant");
		Integer count = (Integer)query.uniqueResult();
		return count;
	}
	@Override
	public Consultant saveConsultant(Consultant consultant){
		System.out.println("inside saveConsultant----------->");
		try {
			if(consultant.getId()<=0) {
				Integer id = getConsultantMaxId();
				consultant.setId(id.intValue()+1);
			}
			consultant.setStatus(new Integer(CAConstants.CUSTOMER_STATUS_ACTIVE));
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(consultant);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return consultant;
	}
	@Override
	public List<Consultant> listClientsByStatus(int status){
		System.out.println("status---"+status);
		if(status>0){			
			Session session = this.sessionFactory.getCurrentSession();       
			List<Consultant>  consultantList = session.createQuery("from Consultant where status=:status")
					.setInteger("status", status).list();
			System.out.println("consultantList-->"+consultantList);
			
			return consultantList;
		}else{
			return listAllConsultant();
		}
	}
	@Override
	public Consultant getConsultant(int id){		
		System.out.println("id-->"+id);
		Session session = this.sessionFactory.getCurrentSession();
		List<Consultant>  consultantList = session.createQuery("from Consultant where id=:id")
				.setInteger("id", id).list();
		System.out.println("consultantList-->"+consultantList);
		if(consultantList!=null && !consultantList.isEmpty()) {
			return consultantList.get(0);
		}
		return null;
	}
	@Override
	public Consultant getConsultantByName(String name) {		
		System.out.println("name-->"+name);
		Session session = this.sessionFactory.getCurrentSession();
		List<Consultant>  consultantList = session.createQuery("from Consultant where upper(name) = :name")
				.setString("name", name.toUpperCase()).list();
		System.out.println("consultantList-->"+consultantList);
		if(consultantList!=null && !consultantList.isEmpty()) {
			return consultantList.get(0);
		}
		return null;
	}
	@Override
	public List<Consultant> listConsultantByMobileNumber(String mobileNo) {		
		System.out.println("name-->"+mobileNo);
		Session session = this.sessionFactory.getCurrentSession();
		List<Consultant>  consultantList = session.createQuery("from Consultant where phoneNo = :mobileNo or phoneNo1 = :mobileNo ")
				.setString("mobileNo", mobileNo).list();
		System.out.println("consultantList-->"+consultantList);
		return consultantList;
	}
	@Override
	public List<Consultant> listSimilarConsultant(String name, String companyname, String email,
			String phoneNo, String phoneNo1) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder queryStr = new StringBuilder("from Consultant ");
		boolean condAdded = false;
		if(name!=null && name.trim().length()>0){	
			queryStr.append("where name like :name ");
			condAdded = true;
		}if(email!=null && email.trim().length()>0){	
			if(condAdded)queryStr.append(" or ");
			else queryStr.append(" where ");
			queryStr.append(" emailId like :email ");
			condAdded = true;
		}if(companyname!=null && companyname.trim().length()>0){	
			if(condAdded)queryStr.append(" or ");
			else queryStr.append(" where ");
			queryStr.append(" companyname like :companyname ");
			condAdded = true;
		}if(phoneNo!=null && phoneNo.trim().length()>0){
			if(condAdded)queryStr.append(" or ");
			else queryStr.append(" where ");
			queryStr.append("  phoneNo like :phoneNo ");
			condAdded = true;
		}if(phoneNo1!=null && phoneNo1.trim().length()>0){
			if(condAdded)queryStr.append(" or ");
			else queryStr.append(" where ");
			queryStr.append("  phoneNo1 like :phoneNo1 ");
			condAdded = true;
		}
		System.out.println("queryStr-------->"+queryStr);	
		if(condAdded==false) return new ArrayList<Consultant>();
		Query query = session.createQuery(queryStr.toString());
		if(name!=null && name.trim().length()>0){	
			query.setString("name", "%"+name+"%");
		}
		if(email!=null && email.trim().length()>0){
			query.setString("email", "%"+email+"%");
		}
		if(companyname!=null && companyname.trim().length()>0){	
			query.setString("companyname", "%"+companyname+"%");
		}
		if(phoneNo!=null && phoneNo.trim().length()>0){	
			query.setString("phoneNo", "%"+phoneNo+"%");
		}
		if(phoneNo1!=null && phoneNo1.trim().length()>0){	
			query.setString("phoneNo1", "%"+phoneNo1+"%");
		}
		List<Consultant>  customerList = query.list();
		return customerList;
	}
	public int updateConsultantByIdAndStatus(int status, List<Integer> ids) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Consultant set status=:status where id in (:ids) ");
		query.setInteger("status", status);
		query.setParameterList("ids", ids);
		return query.executeUpdate();
	}
	public int deleteConsultants(List<Integer> ids) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Consultant where id in (:ids) ");		
		query.setParameterList("ids", ids);
		return query.executeUpdate();
	}
	
}
