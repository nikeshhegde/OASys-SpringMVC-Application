package com.project.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="mastertableerp")
@Entity
public class MasterTableERP {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String masterTableERPFname;
	
	private String masterTableERPSurName;
	
	private String masterTableERPFatherName;
	
	private String masterTableERPMotherName;
	
	private String masterTableERPEmail;
	
	private String masterTableERPPassword;	
	
	private String masterTableERPGender;
	
	private String masterTableERPAppliedUnder;
	
	private String masterTableERPPermanentAddress;
	
	private String masterTableERPCurrentAddress;
	
	private String masterTableERPLandlineNumber;
	
	private String masterTableERPMobileNumber;
	
	private java.sql.Date masterTableERPDateOfBirth;
	
	private String masterTableERPPlaceOfBirth;
	
	private String masterTableERPDomicile;
	
	private String masterTableERPState;
	
	private String masterTableERPNationality;
	
	private String masterTableERPReligion;
	
	private String masterTableERPCaste;
	
	private String masterTableERPPhyHandicapped;
	
	private String masterTableERPEcoBackward;
	
	private String masterTableERPMotherTongue;
	
	private String masterTableERPBloodGroup;
	
	private String masterTableERPRh;
	
	private String masterTableERPType;
		
	private String masterTableERPGuardianName;
	
	private String masterTableERPFatherOccupation;
	
	private String masterTableERPMotherOccupation;
	
	private String masterTableERPGuardianOccupation;
	
	private String masterTableERPFatherOfficeAddress;
	
	private String masterTableERPMotherOfficeAddress;
	
	private String masterTableERPGuardianOfficeAddress;
	
	private String masterTableERPFatherTelephoneNumber;
	
	private String masterTableERPMotherTelephoneNumber;
	
	private String masterTableERPGuardianTelephoneNumber;
	
	private String masterTableERPFatherMobileNumber;
	
	private String masterTableERPMotherMobileNumber;
	
	private String masterTableERPGuardianMobileNumber;
	
	private String masterTableERPFatherEmail;
	
	private String masterTableERPMotherEmail;
	
	private String masterTableERPGuardianEmail;
	
	private String masterTableERPFatherAnnualIncome;
	
	private String masterTableERPMotherAnnualIncome;
	
	private String masterTableERPGuardianAnnualIncome;
	
	private String masterTableERPStatus;
	
	private String masterTableERPRole;
	

	private String masterTableERPBranch;
	
	private Integer masterTableERPCurrentSemester;
	
	private String masterTableERPRollNumber;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMasterTableERPFname() {
		return masterTableERPFname;
	}


	public void setMasterTableERPFname(String masterTableERPFname) {
		this.masterTableERPFname = masterTableERPFname;
	}


	public String getMasterTableERPSurName() {
		return masterTableERPSurName;
	}


	public void setMasterTableERPSurName(String masterTableERPSurName) {
		this.masterTableERPSurName = masterTableERPSurName;
	}


	public String getMasterTableERPFatherName() {
		return masterTableERPFatherName;
	}


	public void setMasterTableERPFatherName(String masterTableERPFatherName) {
		this.masterTableERPFatherName = masterTableERPFatherName;
	}


	public String getMasterTableERPMotherName() {
		return masterTableERPMotherName;
	}


	public void setMasterTableERPMotherName(String masterTableERPMotherName) {
		this.masterTableERPMotherName = masterTableERPMotherName;
	}


	public String getMasterTableERPEmail() {
		return masterTableERPEmail;
	}


	public void setMasterTableERPEmail(String masterTableERPEmail) {
		this.masterTableERPEmail = masterTableERPEmail;
	}


	public String getMasterTableERPPassword() {
		return masterTableERPPassword;
	}


	public void setMasterTableERPPassword(String masterTableERPPassword) {
		this.masterTableERPPassword = masterTableERPPassword;
	}


	public String getMasterTableERPGender() {
		return masterTableERPGender;
	}


	public void setMasterTableERPGender(String masterTableERPGender) {
		this.masterTableERPGender = masterTableERPGender;
	}


	public String getMasterTableERPAppliedUnder() {
		return masterTableERPAppliedUnder;
	}


	public void setMasterTableERPAppliedUnder(String masterTableERPAppliedUnder) {
		this.masterTableERPAppliedUnder = masterTableERPAppliedUnder;
	}


	public String getMasterTableERPPermanentAddress() {
		return masterTableERPPermanentAddress;
	}


	public void setMasterTableERPPermanentAddress(
			String masterTableERPPermanentAddress) {
		this.masterTableERPPermanentAddress = masterTableERPPermanentAddress;
	}


	public String getMasterTableERPCurrentAddress() {
		return masterTableERPCurrentAddress;
	}


	public void setMasterTableERPCurrentAddress(String masterTableERPCurrentAddress) {
		this.masterTableERPCurrentAddress = masterTableERPCurrentAddress;
	}


	public String getMasterTableERPLandlineNumber() {
		return masterTableERPLandlineNumber;
	}


	public void setMasterTableERPLandlineNumber(String masterTableERPLandlineNumber) {
		this.masterTableERPLandlineNumber = masterTableERPLandlineNumber;
	}


	public String getMasterTableERPMobileNumber() {
		return masterTableERPMobileNumber;
	}


	public void setMasterTableERPMobileNumber(String masterTableERPMobileNumber) {
		this.masterTableERPMobileNumber = masterTableERPMobileNumber;
	}


	public java.sql.Date getMasterTableERPDateOfBirth() {
		return masterTableERPDateOfBirth;
	}


	public void setMasterTableERPDateOfBirth(java.sql.Date masterTableERPDateOfBirth) {
		this.masterTableERPDateOfBirth = masterTableERPDateOfBirth;
	}


	public String getMasterTableERPPlaceOfBirth() {
		return masterTableERPPlaceOfBirth;
	}


	public void setMasterTableERPPlaceOfBirth(String masterTableERPPlaceOfBirth) {
		this.masterTableERPPlaceOfBirth = masterTableERPPlaceOfBirth;
	}


	public String getMasterTableERPDomicile() {
		return masterTableERPDomicile;
	}


	public void setMasterTableERPDomicile(String masterTableERPDomicile) {
		this.masterTableERPDomicile = masterTableERPDomicile;
	}


	public String getMasterTableERPState() {
		return masterTableERPState;
	}


	public void setMasterTableERPState(String masterTableERPState) {
		this.masterTableERPState = masterTableERPState;
	}


	public String getMasterTableERPNationality() {
		return masterTableERPNationality;
	}


	public void setMasterTableERPNationality(String masterTableERPNationality) {
		this.masterTableERPNationality = masterTableERPNationality;
	}


	public String getMasterTableERPReligion() {
		return masterTableERPReligion;
	}


	public void setMasterTableERPReligion(String masterTableERPReligion) {
		this.masterTableERPReligion = masterTableERPReligion;
	}


	public String getMasterTableERPCaste() {
		return masterTableERPCaste;
	}


	public void setMasterTableERPCaste(String masterTableERPCaste) {
		this.masterTableERPCaste = masterTableERPCaste;
	}


	public String getMasterTableERPPhyHandicapped() {
		return masterTableERPPhyHandicapped;
	}


	public void setMasterTableERPPhyHandicapped(String masterTableERPPhyHandicapped) {
		this.masterTableERPPhyHandicapped = masterTableERPPhyHandicapped;
	}


	public String getMasterTableERPEcoBackward() {
		return masterTableERPEcoBackward;
	}


	public void setMasterTableERPEcoBackward(String masterTableERPEcoBackward) {
		this.masterTableERPEcoBackward = masterTableERPEcoBackward;
	}


	public String getMasterTableERPMotherTongue() {
		return masterTableERPMotherTongue;
	}


	public void setMasterTableERPMotherTongue(String masterTableERPMotherTongue) {
		this.masterTableERPMotherTongue = masterTableERPMotherTongue;
	}


	public String getMasterTableERPBloodGroup() {
		return masterTableERPBloodGroup;
	}


	public void setMasterTableERPBloodGroup(String masterTableERPBloodGroup) {
		this.masterTableERPBloodGroup = masterTableERPBloodGroup;
	}


	public String getMasterTableERPRh() {
		return masterTableERPRh;
	}


	public void setMasterTableERPRh(String masterTableERPRh) {
		this.masterTableERPRh = masterTableERPRh;
	}


	public String getMasterTableERPType() {
		return masterTableERPType;
	}


	public void setMasterTableERPType(String masterTableERPType) {
		this.masterTableERPType = masterTableERPType;
	}


	public String getMasterTableERPGuardianName() {
		return masterTableERPGuardianName;
	}


	public void setMasterTableERPGuardianName(String masterTableERPGuardianName) {
		this.masterTableERPGuardianName = masterTableERPGuardianName;
	}


	public String getMasterTableERPFatherOccupation() {
		return masterTableERPFatherOccupation;
	}


	public void setMasterTableERPFatherOccupation(
			String masterTableERPFatherOccupation) {
		this.masterTableERPFatherOccupation = masterTableERPFatherOccupation;
	}


	public String getMasterTableERPMotherOccupation() {
		return masterTableERPMotherOccupation;
	}


	public void setMasterTableERPMotherOccupation(
			String masterTableERPMotherOccupation) {
		this.masterTableERPMotherOccupation = masterTableERPMotherOccupation;
	}


	public String getMasterTableERPGuardianOccupation() {
		return masterTableERPGuardianOccupation;
	}


	public void setMasterTableERPGuardianOccupation(
			String masterTableERPGuardianOccupation) {
		this.masterTableERPGuardianOccupation = masterTableERPGuardianOccupation;
	}


	public String getMasterTableERPFatherOfficeAddress() {
		return masterTableERPFatherOfficeAddress;
	}


	public void setMasterTableERPFatherOfficeAddress(
			String masterTableERPFatherOfficeAddress) {
		this.masterTableERPFatherOfficeAddress = masterTableERPFatherOfficeAddress;
	}


	public String getMasterTableERPMotherOfficeAddress() {
		return masterTableERPMotherOfficeAddress;
	}


	public void setMasterTableERPMotherOfficeAddress(
			String masterTableERPMotherOfficeAddress) {
		this.masterTableERPMotherOfficeAddress = masterTableERPMotherOfficeAddress;
	}


	public String getMasterTableERPGuardianOfficeAddress() {
		return masterTableERPGuardianOfficeAddress;
	}


	public void setMasterTableERPGuardianOfficeAddress(
			String masterTableERPGuardianOfficeAddress) {
		this.masterTableERPGuardianOfficeAddress = masterTableERPGuardianOfficeAddress;
	}


	public String getMasterTableERPFatherTelephoneNumber() {
		return masterTableERPFatherTelephoneNumber;
	}


	public void setMasterTableERPFatherTelephoneNumber(
			String masterTableERPFatherTelephoneNumber) {
		this.masterTableERPFatherTelephoneNumber = masterTableERPFatherTelephoneNumber;
	}


	public String getMasterTableERPMotherTelephoneNumber() {
		return masterTableERPMotherTelephoneNumber;
	}


	public void setMasterTableERPMotherTelephoneNumber(
			String masterTableERPMotherTelephoneNumber) {
		this.masterTableERPMotherTelephoneNumber = masterTableERPMotherTelephoneNumber;
	}


	public String getMasterTableERPGuardianTelephoneNumber() {
		return masterTableERPGuardianTelephoneNumber;
	}


	public void setMasterTableERPGuardianTelephoneNumber(
			String masterTableERPGuardianTelephoneNumber) {
		this.masterTableERPGuardianTelephoneNumber = masterTableERPGuardianTelephoneNumber;
	}


	public String getMasterTableERPFatherMobileNumber() {
		return masterTableERPFatherMobileNumber;
	}


	public void setMasterTableERPFatherMobileNumber(
			String masterTableERPFatherMobileNumber) {
		this.masterTableERPFatherMobileNumber = masterTableERPFatherMobileNumber;
	}


	public String getMasterTableERPMotherMobileNumber() {
		return masterTableERPMotherMobileNumber;
	}


	public void setMasterTableERPMotherMobileNumber(
			String masterTableERPMotherMobileNumber) {
		this.masterTableERPMotherMobileNumber = masterTableERPMotherMobileNumber;
	}


	public String getMasterTableERPGuardianMobileNumber() {
		return masterTableERPGuardianMobileNumber;
	}


	public void setMasterTableERPGuardianMobileNumber(
			String masterTableERPGuardianMobileNumber) {
		this.masterTableERPGuardianMobileNumber = masterTableERPGuardianMobileNumber;
	}


	public String getMasterTableERPFatherEmail() {
		return masterTableERPFatherEmail;
	}


	public void setMasterTableERPFatherEmail(String masterTableERPFatherEmail) {
		this.masterTableERPFatherEmail = masterTableERPFatherEmail;
	}


	public String getMasterTableERPMotherEmail() {
		return masterTableERPMotherEmail;
	}


	public void setMasterTableERPMotherEmail(String masterTableERPMotherEmail) {
		this.masterTableERPMotherEmail = masterTableERPMotherEmail;
	}


	public String getMasterTableERPGuardianEmail() {
		return masterTableERPGuardianEmail;
	}


	public void setMasterTableERPGuardianEmail(String masterTableERPGuardianEmail) {
		this.masterTableERPGuardianEmail = masterTableERPGuardianEmail;
	}


	public String getMasterTableERPFatherAnnualIncome() {
		return masterTableERPFatherAnnualIncome;
	}


	public void setMasterTableERPFatherAnnualIncome(
			String masterTableERPFatherAnnualIncome) {
		this.masterTableERPFatherAnnualIncome = masterTableERPFatherAnnualIncome;
	}


	public String getMasterTableERPMotherAnnualIncome() {
		return masterTableERPMotherAnnualIncome;
	}


	public void setMasterTableERPMotherAnnualIncome(
			String masterTableERPMotherAnnualIncome) {
		this.masterTableERPMotherAnnualIncome = masterTableERPMotherAnnualIncome;
	}


	public String getMasterTableERPGuardianAnnualIncome() {
		return masterTableERPGuardianAnnualIncome;
	}


	public void setMasterTableERPGuardianAnnualIncome(
			String masterTableERPGuardianAnnualIncome) {
		this.masterTableERPGuardianAnnualIncome = masterTableERPGuardianAnnualIncome;
	}


	public String getMasterTableERPStatus() {
		return masterTableERPStatus;
	}


	public void setMasterTableERPStatus(String masterTableERPStatus) {
		this.masterTableERPStatus = masterTableERPStatus;
	}


	public String getMasterTableERPRole() {
		return masterTableERPRole;
	}


	public void setMasterTableERPRole(String masterTableERPRole) {
		this.masterTableERPRole = masterTableERPRole;
	}


	public Integer getMasterTableERPCurrentSemester() {
		return masterTableERPCurrentSemester;
	}


	public void setMasterTableERPCurrentSemester(
			Integer masterTableERPCurrentSemester) {
		this.masterTableERPCurrentSemester = masterTableERPCurrentSemester;
	}


	public String getMasterTableERPBranch() {
		return masterTableERPBranch;
	}


	public void setMasterTableERPBranch(String masterTableERPBranch) {
		this.masterTableERPBranch = masterTableERPBranch;
	}


	public String getMasterTableERPRollNumber() {
		return masterTableERPRollNumber;
	}


	public void setMasterTableERPRollNumber(String masterTableERPRollNumber) {
		this.masterTableERPRollNumber = masterTableERPRollNumber;
	}


}
