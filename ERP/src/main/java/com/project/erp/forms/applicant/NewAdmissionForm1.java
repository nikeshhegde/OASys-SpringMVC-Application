package com.project.erp.forms.applicant;

//import javax.persistence.Column;

public class NewAdmissionForm1 {
	
	private Integer id;
	
	private String admissionUserFname;
	
	private String admissionUserSurName;
	

	private String admissionUserFatherName;
	

	private String admissionUserMotherName;
	
	
	private String admissionEmail;
	
	
	private String admissionUserPassword;
	
	
	private String admissionUserUserId;
	
	
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
	
	private Integer admissionUserCurrentSemester;
	
	private String admissionUserBranch;
	/*
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
	
	
	private String admissionUserGuardianAnnualIncome; */
	
	/*
	NewAdmissionForm1()
	{
		
		admissionUserFname="";
		
		admissionUserSurName="";
		

		admissionUserFatherName="";
		

		admissionUserMotherName="";
		
		
		admissionEmail="";
		
		
		admissionUserPassword="";
		
		
		admissionUserGender="";
		
		
		admissionUserAppliedUnder="";
		
		
		admissionUserPermanentAddress="";
		
		
		admissionUserCurrentAddress="";
		
		
		admissionUserLandlineNumber="";
		
		
		admissionUserMobileNumber="";
		
		
		//admissionUserDateOfBirth="";
		
		
		admissionUserPlaceOfBirth="";
		
		
		admissionUserDomicile="ABC".getBytes();
		
		
		admissionUserState="";
		
		
		admissionUserNationality="";;
		
		
		admissionUserReligion="";;
		
		
		admissionUserCaste="";;
		
		
		admissionUserPhyHandicapped="ABC".getBytes();
		
		admissionUserEcoBackward="Abc".getBytes();
		
		
		 admissionUserMotherTongue="";
		
		
		 admissionUserBloodGroup="";
		
		
		 admissionUserRh="";
		
		
		 admissionUserType="";
		
		
		 admissionUserGuardianName="";
		
		
		 admissionUserFatherOccupation="";
		
		
		 admissionUserMotherOccupation="";
		
		
		 admissionUserGuardianOccupation="";
		
		
		 admissionUserFatherOfficeAddress="";
		
		
		 admissionUserMotherOfficeAddress="";
		
		
		 admissionUserGuardianOfficeAddress="";
		
		
		 admissionUserFatherTelephoneNumber="";
		
		
		 admissionUserMotherTelephoneNumber="";
		
		
		 admissionUserGuardianTelephoneNumber="";
		
		
		 admissionUserFatherMobileNumber="";
		
		
		 admissionUserMotherMobileNumber="";
		
		
		 admissionUserGuardianMobileNumber="";

		
		 admissionUserFatherEmail="";
		
		
		 admissionUserMotherEmail="";
		
		
		 admissionUserGuardianEmail="";
		
		
		 admissionUserFatherAnnualIncome="";
		
		
		admissionUserMotherAnnualIncome="";
		
		
		 admissionUserGuardianAnnualIncome="";
		 

	}
	*/
	//monika
	public Integer getId() {
		return id;
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

	public String getAdmissionEmail() {
		return admissionEmail;
	}

	public void setAdmissionEmail(String admissionEmail) {
		this.admissionEmail = admissionEmail;
		this.admissionUserUserId=admissionEmail;
	}

	public String getAdmissionUserPassword() {
		return admissionUserPassword;
	}

	public void setAdmissionUserPassword(String admissionUserPassword) {
		this.admissionUserPassword = admissionUserPassword;
	}

	public String getAdmissionUserUserId() {
		return admissionUserUserId;
	}

	public void setAdmissionUserUserId(String admissionEmail) {
		this.admissionUserUserId = admissionEmail;
	}

	public String getAdmissionUserGender() {
		return admissionUserGender;
	}

	public void setAdmissionUserGender(String admissionUserGender) {
		this.admissionUserGender = admissionUserGender;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserAppliedUnder() {
		return admissionUserAppliedUnder;
	}

	public void setAdmissionUserAppliedUnder(String admissionUserAppliedUnder) {
		this.admissionUserAppliedUnder = admissionUserAppliedUnder;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserPermanentAddress() {
		return admissionUserPermanentAddress;
	}

	public void setAdmissionUserPermanentAddress(String admissionUserPermanentAddress) {
		this.admissionUserPermanentAddress = admissionUserPermanentAddress;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserCurrentAddress() {
		return admissionUserCurrentAddress;
	}

	public void setAdmissionUserCurrentAddress(String admissionUserCurrentAddress) {
		this.admissionUserCurrentAddress = admissionUserCurrentAddress;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserLandLineNumber() {
		return admissionUserLandlineNumber;
	}

	public void setAdmissionUserLandlineNumber(String admissionUserLandlineNumber) {
		this.admissionUserLandlineNumber = admissionUserLandlineNumber;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserMobileNumber() {
		return admissionUserMobileNumber;
	}

	public void setAdmissionUserMobileNumber(String admissionUserMobileNumber) {
		this.admissionUserMobileNumber = admissionUserMobileNumber;
	}
	
	
	/* Applied Under GET SETS */
	public java.sql.Date getAdmissionUserDateOfBirth() {
		return admissionUserDateOfBirth;
	}
	public void setAdmissionUserDateOfBirth(java.sql.Date admissionUserDateOfBirth) {
			this.admissionUserDateOfBirth = admissionUserDateOfBirth;
		};

	/* Applied Under GET SETS */
	public String getAdmissionUserPlaceOfBirth() {
		return admissionUserPlaceOfBirth;
	}

	public void setAdmissionUserPlaceOfBirth(String admissionUserPlaceOfBirth) {
		this.admissionUserPlaceOfBirth = admissionUserPlaceOfBirth;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserDomicile() {
		return admissionUserDomicile;
	}

	public void setAdmissionUserDomicile(String admissionUserDomicile) {
		this.admissionUserDomicile = admissionUserDomicile;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserState() {
		return admissionUserState;
	}

	public void setAdmissionUserState(String admissionUserState) {
		this.admissionUserState = admissionUserState;
	}
	/* Applied Under GET SETS */
	public String getAdmissionUserNationality() {
		return admissionUserNationality;
	}

	public void setAdmissionUserNationality(String admissionUserNationality) {
		this.admissionUserNationality = admissionUserNationality;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserReligion() {
		return admissionUserReligion;
	}

	public void setAdmissionUserReligion(String admissionUserReligion) {
		this.admissionUserReligion = admissionUserReligion;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserCaste() {
		return admissionUserCaste;
	}

	public void setAdmissionUserCaste(String admissionUserCaste) {
		this.admissionUserCaste = admissionUserCaste;
	}
	/* Applied Under GET SETS */
	public String getAdmissionUserPhyHandicapped() {
		return admissionUserPhyHandicapped;
	}

	public void setAdmissionUserPhyHandicapped(String admissionUserPhyHandicapped) {
		this.admissionUserPhyHandicapped = admissionUserPhyHandicapped;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserEcoBackward() {
		return admissionUserEcoBackward;
	}

	public void setAdmissionUserEcoBackward(String admissionUserEcoBackward) {
		this.admissionUserEcoBackward = admissionUserEcoBackward;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissioUserMotherTongue() {
		return admissionUserMotherTongue;
	}

	public void setAdmissionUserMotherTongue(String admissionUserMotherTongue) {
		this.admissionUserMotherTongue = admissionUserMotherTongue;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserBloodGroup() {
		return admissionUserBloodGroup;
	}

	public void setAdmissionUserBloodGroup(String admissionUserBloodGroup) {
		this.admissionUserBloodGroup = admissionUserBloodGroup;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserRh() {
		return admissionUserRh;
	}

	public void setAdmissionUserRh(String admissionUserRh) {
		this.admissionUserRh = admissionUserRh;
	}
	
	/* Applied Under GET SETS */
	public String getAdmissionUserType() {
		return admissionUserType;
	}

	public void setAdmissionUserType(String admissionUserType) {
		this.admissionUserType = admissionUserType;
	}
	
	
	public Integer getAdmissionUserCurrentSemester()
	{
		return admissionUserCurrentSemester;
	}
	
	public void setAdmissionUserCurrentSemester(Integer admissionUserCurrentSemester)
	{
		this.admissionUserCurrentSemester=admissionUserCurrentSemester;
	}
	
	public String getAdmissionUserBranch()
	{
		return admissionUserBranch;
	}
	
	public void setAdmissionUserBranch(String admissionUserBranch)
	{
		this.admissionUserBranch=admissionUserBranch;
	}
	
	/*
	
	public String getAdmissionGuardianName() {
		return admissionUserGuardianName;
	}

	public void setAdmissionGuardianName(String admissionUserGuardianName) {
		this.admissionUserGuardianName = admissionUserGuardianName;
	}
	
	
	public String getAdmissionFatherOccupation() {
		return admissionUserFatherOccupation;
	}

	public void setAdmissionFatherOccupation(String admissionUserFatherOccupation) {
		this.admissionUserFatherOccupation = admissionUserFatherOccupation;
	}
	
	
	public String getAdmissionMotherOccupation() {
		return admissionUserMotherOccupation;
	}

	public void setAdmissionMotherOccupation(String admissionUserMotherOccupation) {
		this.admissionUserMotherOccupation = admissionUserMotherOccupation;
	}
	
	
	
	public String getAdmissionGuardianOccupation() {
		return admissionUserGuardianOccupation;
	}

	public void setAdmissionGuardianOccupation(String admissionUserGuardianOccupation) {
		this.admissionUserGuardianOccupation = admissionUserGuardianOccupation;
	}
	
	
	public String getAdmissionFatherOfficeAddress() {
		return admissionUserFatherOfficeAddress;
	}

	public void setAdmissionFatherOfficeAddress(String admissionUserFatherOfficeAddress) {
		this.admissionUserFatherOfficeAddress = admissionUserFatherOfficeAddress;
	}
	
	
	
	public String getAdmissionMotherOfficeAddress() {
		return admissionUserMotherOfficeAddress;
	}

	public void setAdmissionMotherOfficeAddress(String admissionUserMotherOfficeAddress) {
		this.admissionUserMotherOfficeAddress = admissionUserMotherOfficeAddress;
	}
	
	

	public String getAdmissionGuardianOfficeAddress() {
		return admissionUserGuardianOfficeAddress;
	}

	public void setAdmissionGuardianOfficeAddress(String admissionUserGuardianOfficeAddress) {
		this.admissionUserGuardianOfficeAddress = admissionUserGuardianOfficeAddress;
	}
	
	
	public String getAdmissionFatherTelephoneNumber() {
		return admissionUserFatherTelephoneNumber;
	}

	public void setAdmissionFatherTelephoneNumber(String admissionUserFatherTelephoneNumber) {
		this.admissionUserFatherTelephoneNumber = admissionUserFatherTelephoneNumber;
	}
	
	
	
	public String getAdmissionMotherTelephoneNumber() {
		return admissionUserMotherTelephoneNumber;
	}

	public void setAdmissionMotherTelephoneNumber(String admissionUserMotherTelephoneNumber) {
		this.admissionUserMotherTelephoneNumber = admissionUserMotherTelephoneNumber;
	}

	
	
	public String getAdmissionGuardianTelephoneNumber() {
		return admissionUserGuardianTelephoneNumber;
	}

	public void setAdmissionGuardianTelephoneNumber(String admissionUserGuardianTelephoneNumber) {
		this.admissionUserGuardianTelephoneNumber = admissionUserGuardianTelephoneNumber;
	}
	
	
	
	public String getAdmissionFatherMobileNumber() {
		return admissionUserFatherMobileNumber;
	}

	public void setAdmissionFatherMobileNumber(String admissionUserFatherMobileNumber) {
		this.admissionUserFatherMobileNumber = admissionUserFatherMobileNumber;
	}
	
	
	public String getAdmissionMotherMobileNumber() {
		return admissionUserMotherMobileNumber;
	}

	public void setAdmissionMotherMobileNumber(String admissionUserMotherMobileNumber) {
		this.admissionUserMotherMobileNumber = admissionUserMotherMobileNumber;
	}
	
	
	public String getAdmissionGuardianMobileNumber() {
		return admissionUserGuardianMobileNumber;
	}

	public void setAdmissionGuardianMobileNumber(String admissionUserGuardianMobileNumber) {
		this.admissionUserGuardianMobileNumber = admissionUserGuardianMobileNumber;
	}
	
	
	
	public String getAdmissionFatherEmail() {
		return admissionUserFatherEmail;
	}

	public void setAdmissionFatherEmail(String admissionUserFatherEmail) {
		this.admissionUserFatherEmail = admissionUserFatherEmail;
	}
	
	
	public String getAdmissionMotherEmail() {
		return admissionUserMotherEmail;
	}

	public void setAdmissionMotherEmail(String admissionUserMotherEmail) {
		this.admissionUserMotherEmail = admissionUserMotherEmail;
	}
	
	
	
	public String getAdmissionGuardianEmail() {
		return admissionUserGuardianEmail;
	}

	public void setAdmissionGuardianEmail(String admissionUserGuardianEmail) {
		this.admissionUserGuardianEmail = admissionUserGuardianEmail;
	}
	
	
	
	public String getAdmissionFatherAnnualIncome() {
		return admissionUserFatherAnnualIncome;
	}

	public void setAdmissionFatherAnnualIncome(String admissionUserFatherAnnualIncome) {
		this.admissionUserFatherAnnualIncome = admissionUserFatherAnnualIncome;
	}
	
	
	public String getAdmissionMotherAnnualIncome() {
		return admissionUserMotherAnnualIncome;
	}

	public void setAdmissionMotherAnnualIncome(String admissionUserMotherAnnualIncome) {
		this.admissionUserMotherAnnualIncome = admissionUserMotherAnnualIncome;
	}
	
	
	public String getAdmissionGuardianAnnualIncome() {
		return admissionUserGuardianAnnualIncome;
	}

	public void setAdmissionGuardianAnnualIncome(String admissionUserGuardianAnnualIncome) {
		this.admissionUserGuardianAnnualIncome = admissionUserGuardianAnnualIncome;
	}
	
	
	*/
}
