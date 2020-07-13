package com.project.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*KT applied students on submitting their forms
 *their data that is their rollNumber, subjectId (for subject chosen) and year would get stored 
 *It has a value object KtSubjectDetails that would store the roll number,subjectId and year
 */
@Table(name="ktappliedlist")
@Entity
public class KtAppliedList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String rollNumber;
	private String subjectCode;
	private String subject;
	private String semester;
	private String branchCode;
	private boolean theoryKt;
	private boolean practicalKt;
	private boolean oralKt;
	private boolean internalKt;
	

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isTheoryKt() {
		return theoryKt;
	}

	public void setTheoryKt(boolean theoryKt) {
		this.theoryKt = theoryKt;
	}

	public boolean isPracticalKt() {
		return practicalKt;
	}

	public void setPracticalKt(boolean practicalKt) {
		this.practicalKt = practicalKt;
	}

	public boolean isOralKt() {
		return oralKt;
	}

	public void setOralKt(boolean oralKt) {
		this.oralKt = oralKt;
	}

	public boolean isInternalKt() {
		return internalKt;
	}

	public void setInternalKt(boolean internalKt) {
		this.internalKt = internalKt;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public KtAppliedList copy(KtStudents record) {
		this.rollNumber = record.getRollNumber();
		this.subject = record.getSubject();
		this.subjectCode = record.getSubjectCode();
		this.semester = record.getSemester();
		this.branchCode=record.getBranchCode();
		this.theoryKt = false;
		this.internalKt = false;
		this.oralKt = false;
		this.practicalKt = false;

		return this;
	}

	
	public String getKtTypes() {
		String ktTypes = "";
		
		if(isTheoryKt())
			ktTypes=ktTypes+"_TH";
		
		if(isPracticalKt())
			ktTypes=ktTypes+"_PR";
		
		if(isOralKt())
			ktTypes=ktTypes+"_OR";
		
		if(isInternalKt())
			ktTypes=ktTypes+"_IA";
		
		return ktTypes;

	}

}
