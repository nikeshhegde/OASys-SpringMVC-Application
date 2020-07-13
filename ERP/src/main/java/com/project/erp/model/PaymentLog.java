package com.project.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="paymentlog")
@Entity
public class PaymentLog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String paymentLogAmount;
	
	private Integer paymentLogBankId;
	
	private Integer admissionUserId;
	
	private java.util.Date paymentLogTime;
	
	private String paymentLogTransactionId;
	
	private String paymentLogSemester;
	
	private String paymentLogStatus;

	private String paymentLogType;
	
	@OneToOne
	private DDDetails dddetails;
	
	public String getPaymentLogType() {
		return paymentLogType;
	}

	public void setPaymentLogType(String paymentLogType) {
		this.paymentLogType = paymentLogType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentLogAmount() {
		return paymentLogAmount;
	}

	public void setPaymentLogAmount(String paymentLogAmount) {
		this.paymentLogAmount = paymentLogAmount;
	}

	public Integer getPaymentLogBankId() {
		return paymentLogBankId;
	}

	public void setPaymentLogBankId(Integer paymentLogBankId) {
		this.paymentLogBankId = paymentLogBankId;
	}

	public Integer getAdmissionUserId() {
		return admissionUserId;
	}

	public void setAdmissionUserId(Integer admissionUserId) {
		this.admissionUserId = admissionUserId;
	}

	public java.util.Date getPaymentLogTime() {
		return paymentLogTime;
	}

	public void setPaymentLogTime(java.util.Date paymentLogTime) {
		this.paymentLogTime = paymentLogTime;
	}

	public String getPaymentLogTransactionId() {
		return paymentLogTransactionId;
	}

	public void setPaymentLogTransactionId(String paymentLogTransactionId) {
		this.paymentLogTransactionId = paymentLogTransactionId;
	}

	public String getPaymentLogSemester() {
		return paymentLogSemester;
	}

	public void setPaymentLogSemester(String paymentLogSemester) {
		this.paymentLogSemester = paymentLogSemester;
	}

	public String getPaymentLogStatus() {
		return paymentLogStatus;
	}

	public void setPaymentLogStatus(String paymentLogStatus) {
		this.paymentLogStatus = paymentLogStatus;
	}

	public DDDetails getDddetails() {
		return dddetails;
	}

	public void setDddetails(DDDetails dddetails) {
		this.dddetails = dddetails;
	}
	
	/**
	 * @return the id
	 */
}
