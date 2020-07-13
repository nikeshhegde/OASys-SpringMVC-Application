package com.project.erp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(name="admin")
@Entity
public class Admin {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String adminFname;
	
	private String adminEmail;
	
	private String adminPassword;
	
	private String adminMobileNumber;
	
	private String adminType;


	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public String getAdminFname()
	{
		return adminFname;
	}
	
	public void setAdminFname(String adminFname)
	{
		this.adminFname=adminFname;
	}
	
	public String getAdminEmail()
	{
		return adminEmail;
	}
	
	public void setAdminEmail(String adminEmail)
	{
		this.adminEmail=adminEmail;
	}
		
	public String getAdminPassword()
	{
		return adminPassword;
	}
	
	
	public void setAdminPassword(String adminPassword)
	{
		this.adminPassword=adminPassword;
	}

	
	public String getAdminMobileNumber()
	{
		return adminMobileNumber;
	}
	
	public void setAdminMobileNumber(String adminMobileNumber)
	{
		this.adminMobileNumber=adminMobileNumber;
	}
	
	public String getAdminType()
	{
		return adminType;
	}

	public void setAdminType(String adminType)
	{
		this.adminType=adminType;
	}
}