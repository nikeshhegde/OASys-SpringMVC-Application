package com.project.erp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(name="branch")
@Entity

public class Branch {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private Integer branchCode;
	
	private String branchName;
	
	private String branchAbbreviation;
	
	private Integer seatsAllocated;
	
	private Integer seatsAvailable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAbbreviation() {
		return branchAbbreviation;
	}

	public void setBranchAbbreviation(String branchAbbreviation) {
		this.branchAbbreviation = branchAbbreviation;
	}

	public Integer getSeatsAllocated() {
		return seatsAllocated;
	}

	public void setSeatsAllocated(Integer seatsAllocated) {
		this.seatsAllocated = seatsAllocated;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

}