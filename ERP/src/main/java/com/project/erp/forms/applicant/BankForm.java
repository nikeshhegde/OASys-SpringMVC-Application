package com.project.erp.forms.applicant;

public class BankForm {

	private Integer id;
	
	private String bankBranch;
	
	private String bankCity;
	
	private String bankAccountNumber;
	
	private String bankAccountType;
	
	private String bankIFSC;
	
	private String bankAccountHolder;
	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	 public void setId(Integer id) {
		this.id = id;
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
	
	
	public String getBankAccountNumber() {
		return bankAccountNumber;
		}

	
	public void setBankAccountNumber(String bankAccountNumber) {
					this.bankAccountNumber = bankAccountNumber;
	}
	
	
	public String getBankAccountType() {
		return bankAccountType;
		}

	
	public void setBankAccountType(String bankAccountType) {
					this.bankAccountType = bankAccountType;
	}
	
						 
	public String getBankIFSC() {
		return bankIFSC;
						}

		
	public void setBankIFSC(String bankIFSC) {
							this.bankIFSC = bankIFSC;
						}
	
	
	public String getBankAccountHolder() {
								return bankAccountHolder;
							}

	
	public void setBankAccountHolder(String bankAccountHolder) {
								this.bankAccountHolder = bankAccountHolder;
							}
}
