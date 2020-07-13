package com.project.erp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(name="admissionuserbranchselection")
@Entity
public class AdmissionUserBranchSelection {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer admissionUserBranchSelectionCEPriority;

	private Integer admissionUserBranchSelectionEXTCPriority;
	
	private Integer admissionUserBranchSelectionITPriority;
	
	private Integer admissionUserBranchSelectionPPTPriority;
	
	private Integer admissionUserBranchSelectionBTPriority;
	
	private Integer admissionUserBranchSelectionMECHPriority;
	
	private Integer admissionUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdmissionUserBranchSelectionCEPriority() {
		return admissionUserBranchSelectionCEPriority;
	}

	public void setAdmissionUserBranchSelectionCEPriority(
			Integer admissionUserBranchSelectionCEPriority) {
		this.admissionUserBranchSelectionCEPriority = admissionUserBranchSelectionCEPriority;
	}

	public Integer getAdmissionUserBranchSelectionEXTCPriority() {
		return admissionUserBranchSelectionEXTCPriority;
	}

	public void setAdmissionUserBranchSelectionEXTCPriority(
			Integer admissionUserBranchSelectionEXTCPriority) {
		this.admissionUserBranchSelectionEXTCPriority = admissionUserBranchSelectionEXTCPriority;
	}

	public Integer getAdmissionUserBranchSelectionITPriority() {
		return admissionUserBranchSelectionITPriority;
	}

	public void setAdmissionUserBranchSelectionITPriority(
			Integer admissionUserBranchSelectionITPriority) {
		this.admissionUserBranchSelectionITPriority = admissionUserBranchSelectionITPriority;
	}

	public Integer getAdmissionUserBranchSelectionPPTPriority() {
		return admissionUserBranchSelectionPPTPriority;
	}

	public void setAdmissionUserBranchSelectionPPTPriority(
			Integer admissionUserBranchSelectionPPTPriority) {
		this.admissionUserBranchSelectionPPTPriority = admissionUserBranchSelectionPPTPriority;
	}

	public Integer getAdmissionUserBranchSelectionBTPriority() {
		return admissionUserBranchSelectionBTPriority;
	}

	public void setAdmissionUserBranchSelectionBTPriority(
			Integer admissionUserBranchSelectionBTPriority) {
		this.admissionUserBranchSelectionBTPriority = admissionUserBranchSelectionBTPriority;
	}

	public Integer getAdmissionUserBranchSelectionMECHPriority() {
		return admissionUserBranchSelectionMECHPriority;
	}

	public void setAdmissionUserBranchSelectionMECHPriority(
			Integer admissionUserBranchSelectionMECHPriority) {
		this.admissionUserBranchSelectionMECHPriority = admissionUserBranchSelectionMECHPriority;
	}

	public Integer getAdmissionUserId() {
		return admissionUserId;
	}

	public void setAdmissionUserId(Integer admissionUserId) {
		this.admissionUserId = admissionUserId;
	}
	
	
}