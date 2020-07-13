package com.project.erp.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="bankdetails")
@Entity
public class BankDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bankDetailsId;
	
	private String bankName;
	
	private String bankBranch;
	
	private String bankCity;
	
	private String accountNumber;
	
	private String accountType;
	
	private String IFSCNumber;
	
	private String accountHolder;
	
	private String role;
	
	private String status;
	
	private String semester;
	
	private String appliedUnder;
	
	//private String amountPaid;
	

	@OneToMany(fetch=FetchType.EAGER)
	private Collection<FeeDistribution> feeDistribution;
	
	public void setBankDetailsId(int bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}

	

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIFSCNumber() {
		return IFSCNumber;
	}

	public void setIFSCNumber(String iFSCNumber) {
		IFSCNumber = iFSCNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getSemester() {
		return semester;
	}



	public void setSemester(String semester) {
		this.semester = semester;
	}



	public String getAppliedUnder() {
		return appliedUnder;
	}



	public void setAppliedUnder(String appliedUnder) {
		this.appliedUnder = appliedUnder;
	}

/*

	public String getAmountPaid() {
		return amountPaid;
	}



	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

*/

	public int getBankDetailsId() {
		return bankDetailsId;
	}



	public Collection<FeeDistribution> getFeeDistribution() {
		return feeDistribution;
	}



	public void setFeeDistribution(Collection<FeeDistribution> feeDistribution) {
		this.feeDistribution = feeDistribution;
	}
	
	
	
}
