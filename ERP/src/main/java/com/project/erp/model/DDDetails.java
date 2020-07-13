package com.project.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="dddetails")
@Entity
public class DDDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private java.sql.Date drawnDate;
	
	private String drawnName;
	
	private String ddPayable;
	
	private String ddAmount;
	
	private String applicantBank;
	
	private String applicantBranch;
	
	private String ddNumber;
	
	private String ddMicrCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.sql.Date getDrawnDate() {
		return drawnDate;
	}

	public void setDrawnDate(java.sql.Date drawnDate) {
		this.drawnDate = drawnDate;
	}

	public String getDrawnName() {
		return drawnName;
	}

	public void setDrawnName(String drawnName) {
		this.drawnName = drawnName;
	}

	public String getDdPayable() {
		return ddPayable;
	}

	public void setDdPayable(String ddPayable) {
		this.ddPayable = ddPayable;
	}

	public String getDdAmount() {
		return ddAmount;
	}

	public void setDdAmount(String ddAmount) {
		this.ddAmount = ddAmount;
	}

	public String getApplicantBank() {
		return applicantBank;
	}

	public void setApplicantBank(String applicantBank) {
		this.applicantBank = applicantBank;
	}

	public String getApplicantBranch() {
		return applicantBranch;
	}

	public void setApplicantBranch(String applicantBranch) {
		this.applicantBranch = applicantBranch;
	}

	public String getDdNumber() {
		return ddNumber;
	}

	public void setDdNumber(String ddNumber) {
		this.ddNumber = ddNumber;
	}

	public String getDdMicrCode() {
		return ddMicrCode;
	}

	public void setDdMicrCode(String ddMicrCode) {
		this.ddMicrCode = ddMicrCode;
	}

	
}
