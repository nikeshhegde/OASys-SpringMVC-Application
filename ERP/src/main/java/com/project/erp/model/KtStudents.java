package com.project.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ktstudents")
@Entity
public class KtStudents {

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
	
	

}
