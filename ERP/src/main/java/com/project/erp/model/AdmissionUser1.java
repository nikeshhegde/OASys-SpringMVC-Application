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

@Table(name="admissionuser1")
@Entity

public class AdmissionUser1 {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer applicantId;
	
	private String admissionUserFname;
	
	private String admissionUserSurName;
	
	private String admissionUserFatherName;
	
	private String admissionUserMotherName;
	
	private String admissionUserEmail;
	
	private String admissionUserPassword;	
	
	private String admissionUserGender;
	
	private String admissionUserAppliedUnder;
	
	private String admissionUserPermanentAddress;
	
	private String admissionUserCurrentAddress;
	
	private String admissionUserLandlineNumber;
	
	private String admissionUserMobileNumber;
	
	private java.sql.Date admissionUserDateOfBirth;
	
	private String admissionUserPlaceOfBirth;
	
	private String admissionUserDomicile;
	
	private String admissionUserState;
	
	private String admissionUserNationality;
	
	private String admissionUserReligion;
	
	private String admissionUserCaste;
	
	private String admissionUserPhyHandicapped;
	
	private String admissionUserEcoBackward;
	
	private String admissionUserMotherTongue;
	
	private String admissionUserBloodGroup;
	
	private String admissionUserRh;
	
	private String admissionUserType;
		
	private String admissionUserGuardianName;
	
	private String admissionUserFatherOccupation;
	
	private String admissionUserMotherOccupation;
	
	private String admissionUserGuardianOccupation;
	
	private String admissionUserFatherOfficeAddress;
	
	private String admissionUserMotherOfficeAddress;
	
	private String admissionUserGuardianOfficeAddress;
	
	private String admissionUserFatherTelephoneNumber;
	
	private String admissionUserMotherTelephoneNumber;
	
	private String admissionUserGuardianTelephoneNumber;
	
	private String admissionUserFatherMobileNumber;
	
	private String admissionUserMotherMobileNumber;
	
	private String admissionUserGuardianMobileNumber;
	
	private String admissionUserFatherEmail;
	
	private String admissionUserMotherEmail;
	
	private String admissionUserGuardianEmail;
	
	private String admissionUserFatherAnnualIncome;
	
	private String admissionUserMotherAnnualIncome;
	
	private String admissionUserGuardianAnnualIncome;
	
	private String admissionUserStatus;
	
	private String admissionUserRole;
	
	
	private Integer admissionUserCurrentSemester;
	
	
	private String admissionUserBranch;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private AdmissionUserFeAcademics admissionUserFeAcademics;

	@OneToOne(cascade=CascadeType.REMOVE)
	private AcademicDetailsDse academicDetailsDse;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private AdmissionUserBranchSelection admUserBranchSelection;
	
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Users users;
	
	
	
/*	@OneToOne
	private Role role;
	
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
*/

	@OneToMany(fetch=FetchType.EAGER)
	private Collection<PaymentLog> paymentLog;

	public Integer getId() {
		return id;
	}


	public Integer getApplicantId() {
		return applicantId;
	}


	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAdmissionUserFname() {
		return admissionUserFname;
	}


	public void setAdmissionUserFname(String admissionUserFname) {
		this.admissionUserFname = admissionUserFname;
	}


	public String getAdmissionUserSurName() {
		return admissionUserSurName;
	}


	public void setAdmissionUserSurName(String admissionUserSurName) {
		this.admissionUserSurName = admissionUserSurName;
	}


	public String getAdmissionUserFatherName() {
		return admissionUserFatherName;
	}


	public void setAdmissionUserFatherName(String admissionUserFatherName) {
		this.admissionUserFatherName = admissionUserFatherName;
	}


	public String getAdmissionUserMotherName() {
		return admissionUserMotherName;
	}


	public void setAdmissionUserMotherName(String admissionUserMotherName) {
		this.admissionUserMotherName = admissionUserMotherName;
	}


	public String getAdmissionUserEmail() {
		return admissionUserEmail;
	}


	public void setAdmissionUserEmail(String admissionUserEmail) {
		this.admissionUserEmail = admissionUserEmail;
	}


	public String getAdmissionUserPassword() {
		return admissionUserPassword;
	}


	public void setAdmissionUserPassword(String admissionUserPassword) {
		this.admissionUserPassword = admissionUserPassword;
	}



	public String getAdmissionUserGender() {
		return admissionUserGender;
	}


	public void setAdmissionUserGender(String admissionUserGender) {
		this.admissionUserGender = admissionUserGender;
	}


	public String getAdmissionUserAppliedUnder() {
		return admissionUserAppliedUnder;
	}


	public void setAdmissionUserAppliedUnder(String admissionUserAppliedUnder) {
		this.admissionUserAppliedUnder = admissionUserAppliedUnder;
	}


	public String getAdmissionUserPermanentAddress() {
		return admissionUserPermanentAddress;
	}


	public void setAdmissionUserPermanentAddress(
			String admissionUserPermanentAddress) {
		this.admissionUserPermanentAddress = admissionUserPermanentAddress;
	}


	public String getAdmissionUserCurrentAddress() {
		return admissionUserCurrentAddress;
	}


	public void setAdmissionUserCurrentAddress(String admissionUserCurrentAddress) {
		this.admissionUserCurrentAddress = admissionUserCurrentAddress;
	}


	public String getAdmissionUserLandlineNumber() {
		return admissionUserLandlineNumber;
	}


	public void setAdmissionUserLandlineNumber(String admissionUserLandlineNumber) {
		this.admissionUserLandlineNumber = admissionUserLandlineNumber;
	}


	public String getAdmissionUserMobileNumber() {
		return admissionUserMobileNumber;
	}


	public void setAdmissionUserMobileNumber(String admissionUserMobileNumber) {
		this.admissionUserMobileNumber = admissionUserMobileNumber;
	}


	public java.sql.Date getAdmissionUserDateOfBirth() {
		return admissionUserDateOfBirth;
	}


	public void setAdmissionUserDateOfBirth(java.sql.Date admissionUserDateOfBirth) {
		this.admissionUserDateOfBirth = admissionUserDateOfBirth;
	}


	public String getAdmissionUserPlaceOfBirth() {
		return admissionUserPlaceOfBirth;
	}


	public void setAdmissionUserPlaceOfBirth(String admissionUserPlaceOfBirth) {
		this.admissionUserPlaceOfBirth = admissionUserPlaceOfBirth;
	}


	public String getAdmissionUserDomicile() {
		return admissionUserDomicile;
	}


	public void setAdmissionUserDomicile(String admissionUserDomicile) {
		this.admissionUserDomicile = admissionUserDomicile;
	}


	public String getAdmissionUserState() {
		return admissionUserState;
	}


	public void setAdmissionUserState(String admissionUserState) {
		this.admissionUserState = admissionUserState;
	}


	public String getAdmissionUserNationality() {
		return admissionUserNationality;
	}


	public void setAdmissionUserNationality(String admissionUserNationality) {
		this.admissionUserNationality = admissionUserNationality;
	}


	public String getAdmissionUserReligion() {
		return admissionUserReligion;
	}


	public void setAdmissionUserReligion(String admissionUserReligion) {
		this.admissionUserReligion = admissionUserReligion;
	}


	public String getAdmissionUserCaste() {
		return admissionUserCaste;
	}


	public void setAdmissionUserCaste(String admissionUserCaste) {
		this.admissionUserCaste = admissionUserCaste;
	}


	public String getAdmissionUserPhyHandicapped() {
		return admissionUserPhyHandicapped;
	}


	public void setAdmissionUserPhyHandicapped(String admissionUserPhyHandicapped) {
		this.admissionUserPhyHandicapped = admissionUserPhyHandicapped;
	}


	public String getAdmissionUserEcoBackward() {
		return admissionUserEcoBackward;
	}


	public void setAdmissionUserEcoBackward(String admissionUserEcoBackward) {
		this.admissionUserEcoBackward = admissionUserEcoBackward;
	}


	public String getAdmissionUserMotherTongue() {
		return admissionUserMotherTongue;
	}


	public void setAdmissionUserMotherTongue(String admissionUserMotherTongue) {
		this.admissionUserMotherTongue = admissionUserMotherTongue;
	}


	public String getAdmissionUserBloodGroup() {
		return admissionUserBloodGroup;
	}


	public void setAdmissionUserBloodGroup(String admissionUserBloodGroup) {
		this.admissionUserBloodGroup = admissionUserBloodGroup;
	}


	public String getAdmissionUserRh() {
		return admissionUserRh;
	}


	public void setAdmissionUserRh(String admissionUserRh) {
		this.admissionUserRh = admissionUserRh;
	}


	public String getAdmissionUserType() {
		return admissionUserType;
	}


	public void setAdmissionUserType(String admissionUserType) {
		this.admissionUserType = admissionUserType;
	}


	public String getAdmissionUserGuardianName() {
		return admissionUserGuardianName;
	}


	public void setAdmissionUserGuardianName(String admissionUserGuardianName) {
		this.admissionUserGuardianName = admissionUserGuardianName;
	}


	public String getAdmissionUserFatherOccupation() {
		return admissionUserFatherOccupation;
	}


	public void setAdmissionUserFatherOccupation(
			String admissionUserFatherOccupation) {
		this.admissionUserFatherOccupation = admissionUserFatherOccupation;
	}


	public String getAdmissionUserMotherOccupation() {
		return admissionUserMotherOccupation;
	}


	public void setAdmissionUserMotherOccupation(
			String admissionUserMotherOccupation) {
		this.admissionUserMotherOccupation = admissionUserMotherOccupation;
	}


	public String getAdmissionUserGuardianOccupation() {
		return admissionUserGuardianOccupation;
	}


	public void setAdmissionUserGuardianOccupation(
			String admissionUserGuardianOccupation) {
		this.admissionUserGuardianOccupation = admissionUserGuardianOccupation;
	}


	public String getAdmissionUserFatherOfficeAddress() {
		return admissionUserFatherOfficeAddress;
	}


	public void setAdmissionUserFatherOfficeAddress(
			String admissionUserFatherOfficeAddress) {
		this.admissionUserFatherOfficeAddress = admissionUserFatherOfficeAddress;
	}


	public String getAdmissionUserMotherOfficeAddress() {
		return admissionUserMotherOfficeAddress;
	}


	public void setAdmissionUserMotherOfficeAddress(
			String admissionUserMotherOfficeAddress) {
		this.admissionUserMotherOfficeAddress = admissionUserMotherOfficeAddress;
	}


	public String getAdmissionUserGuardianOfficeAddress() {
		return admissionUserGuardianOfficeAddress;
	}


	public void setAdmissionUserGuardianOfficeAddress(
			String admissionUserGuardianOfficeAddress) {
		this.admissionUserGuardianOfficeAddress = admissionUserGuardianOfficeAddress;
	}


	public String getAdmissionUserFatherTelephoneNumber() {
		return admissionUserFatherTelephoneNumber;
	}


	public void setAdmissionUserFatherTelephoneNumber(
			String admissionUserFatherTelephoneNumber) {
		this.admissionUserFatherTelephoneNumber = admissionUserFatherTelephoneNumber;
	}


	public String getAdmissionUserMotherTelephoneNumber() {
		return admissionUserMotherTelephoneNumber;
	}


	public void setAdmissionUserMotherTelephoneNumber(
			String admissionUserMotherTelephoneNumber) {
		this.admissionUserMotherTelephoneNumber = admissionUserMotherTelephoneNumber;
	}


	public String getAdmissionUserGuardianTelephoneNumber() {
		return admissionUserGuardianTelephoneNumber;
	}


	public void setAdmissionUserGuardianTelephoneNumber(
			String admissionUserGuardianTelephoneNumber) {
		this.admissionUserGuardianTelephoneNumber = admissionUserGuardianTelephoneNumber;
	}


	public String getAdmissionUserFatherMobileNumber() {
		return admissionUserFatherMobileNumber;
	}


	public void setAdmissionUserFatherMobileNumber(
			String admissionUserFatherMobileNumber) {
		this.admissionUserFatherMobileNumber = admissionUserFatherMobileNumber;
	}


	public String getAdmissionUserMotherMobileNumber() {
		return admissionUserMotherMobileNumber;
	}


	public void setAdmissionUserMotherMobileNumber(
			String admissionUserMotherMobileNumber) {
		this.admissionUserMotherMobileNumber = admissionUserMotherMobileNumber;
	}


	public String getAdmissionUserGuardianMobileNumber() {
		return admissionUserGuardianMobileNumber;
	}


	public void setAdmissionUserGuardianMobileNumber(
			String admissionUserGuardianMobileNumber) {
		this.admissionUserGuardianMobileNumber = admissionUserGuardianMobileNumber;
	}


	public String getAdmissionUserFatherEmail() {
		return admissionUserFatherEmail;
	}


	public void setAdmissionUserFatherEmail(String admissionUserFatherEmail) {
		this.admissionUserFatherEmail = admissionUserFatherEmail;
	}


	public String getAdmissionUserMotherEmail() {
		return admissionUserMotherEmail;
	}


	public void setAdmissionUserMotherEmail(String admissionUserMotherEmail) {
		this.admissionUserMotherEmail = admissionUserMotherEmail;
	}


	public String getAdmissionUserGuardianEmail() {
		return admissionUserGuardianEmail;
	}


	public void setAdmissionUserGuardianEmail(String admissionUserGuardianEmail) {
		this.admissionUserGuardianEmail = admissionUserGuardianEmail;
	}


	public String getAdmissionUserFatherAnnualIncome() {
		return admissionUserFatherAnnualIncome;
	}


	public void setAdmissionUserFatherAnnualIncome(
			String admissionUserFatherAnnualIncome) {
		this.admissionUserFatherAnnualIncome = admissionUserFatherAnnualIncome;
	}


	public String getAdmissionUserMotherAnnualIncome() {
		return admissionUserMotherAnnualIncome;
	}


	public void setAdmissionUserMotherAnnualIncome(
			String admissionUserMotherAnnualIncome) {
		this.admissionUserMotherAnnualIncome = admissionUserMotherAnnualIncome;
	}


	public String getAdmissionUserGuardianAnnualIncome() {
		return admissionUserGuardianAnnualIncome;
	}


	public void setAdmissionUserGuardianAnnualIncome(
			String admissionUserGuardianAnnualIncome) {
		this.admissionUserGuardianAnnualIncome = admissionUserGuardianAnnualIncome;
	}


	public String getAdmissionUserStatus() {
		return admissionUserStatus;
	}


	public void setAdmissionUserStatus(String admissionUserStatus) {
		this.admissionUserStatus = admissionUserStatus;
	}


	public String getAdmissionUserRole() {
		return admissionUserRole;
	}


	public void setAdmissionUserRole(String admissionUserRole) {
		this.admissionUserRole = admissionUserRole;
	}


	public Integer getAdmissionUserCurrentSemester() {
		return admissionUserCurrentSemester;
	}


	public void setAdmissionUserCurrentSemester(Integer admissionUserCurrentSemester) {
		this.admissionUserCurrentSemester = admissionUserCurrentSemester;
	}


	public String getAdmissionUserBranch() {
		return admissionUserBranch;
	}


	public void setAdmissionUserBranch(String admissionUserBranch) {
		this.admissionUserBranch = admissionUserBranch;
	}


	public AdmissionUserFeAcademics getAdmissionUserFeAcademics() {
		return admissionUserFeAcademics;
	}


	public void setAdmissionUserFeAcademics(
			AdmissionUserFeAcademics admissionUserFeAcademics) {
		this.admissionUserFeAcademics = admissionUserFeAcademics;
	}


	public AcademicDetailsDse getAcademicDetailsDse() {
		return academicDetailsDse;
	}


	public void setAcademicDetailsDse(AcademicDetailsDse academicDetailsDse) {
		this.academicDetailsDse = academicDetailsDse;
	}


	public AdmissionUserBranchSelection getAdmUserBranchSelection() {
		return admUserBranchSelection;
	}


	public void setAdmUserBranchSelection(
			AdmissionUserBranchSelection admUserBranchSelection) {
		this.admUserBranchSelection = admUserBranchSelection;
	}


	public Collection<PaymentLog> getPaymentLog() {
		return paymentLog;
	}


	public void setPaymentLog(Collection<PaymentLog> paymentLog) {
		this.paymentLog = paymentLog;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	


	
	
	
	}