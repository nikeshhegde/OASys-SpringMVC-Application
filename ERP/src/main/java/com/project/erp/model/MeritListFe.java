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

@Table(name="meritlistfe")
@Entity
public class MeritListFe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	
	private Integer meritListNumber;
	
	
	private Integer  meritListFeCompositeRank;
	
	private String branchAssigned;
	
	@OneToOne
	private AdmissionUser1 admissionUser1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMeritListNumber() {
		return meritListNumber;
	}

	public void setMeritListNumber(Integer meritListNumber) {
		this.meritListNumber = meritListNumber;
	}

	public Integer getMeritListFeCompositeRank() {
		return meritListFeCompositeRank;
	}

	public void setMeritListFeCompositeRank(Integer meritListFeCompositeRank) {
		this.meritListFeCompositeRank = meritListFeCompositeRank;
	}

	public String getBranchAssigned() {
		return branchAssigned;
	}

	public void setBranchAssigned(String branchAssigned) {
		this.branchAssigned = branchAssigned;
	}

	public AdmissionUser1 getAdmissionUser1() {
		return admissionUser1;
	}

	public void setAdmissionUser1(AdmissionUser1 admissionUser1) {
		this.admissionUser1 = admissionUser1;
	}
	
	
}
