package com.project.erp.forms.applicant;

public class TransactionIdForm {

	private String admissionUserTransactionId;
	
	private String paymentLogType;
	
	private java.sql.Date drawnDate;
	
	private String drawnName;
	
	private String ddPayable;
	
	private String ddAmount;
	
	private String applicantBank;
	
	private String applicantBranch;
	
	private String ddNumber;
	
	private String ddMicrCode;

	
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

	
	public String getAdmissionUserTransactionId()
	{
		return admissionUserTransactionId;
	}
	
	public void setAdmissionUserTransactionId(String admissionUserTransactionId)
	{
		this.admissionUserTransactionId=admissionUserTransactionId;
	}

	public String getPaymentLogType() {
		return paymentLogType;
	}

	public void setPaymentLogType(String paymentLogType) {
		this.paymentLogType = paymentLogType;
	}
	
	
}
