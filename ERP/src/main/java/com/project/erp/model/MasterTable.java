package com.project.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="mastertable")
@Entity
public class MasterTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String rollNumber;
	private String name;
	private String gender;
	private String branch;
	private String branchCode;
	private int year;
	private String semester;
	private String subject;
	private String subjectCode;
	private String subjectMarks;
	private String theoryGrade;
	private String practicalMarks;
	private String practicalGrade;
	private String oralMarks;
	private String oralGrade;
	private String internalMarks;
	private String internalGrade;

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(String subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	public String getTheoryGrade() {
		return theoryGrade;
	}

	public void setTheoryGrade(String theoryGrade) {
		this.theoryGrade = theoryGrade;
	}

	public String getPracticalMarks() {
		return practicalMarks;
	}

	public void setPracticalMarks(String practicalMarks) {
		this.practicalMarks = practicalMarks;
	}

	public String getPracticalGrade() {
		return practicalGrade;
	}

	public void setPracticalGrade(String practicalGrade) {
		this.practicalGrade = practicalGrade;
	}

	public String getOralMarks() {
		return oralMarks;
	}

	public void setOralMarks(String oralMarks) {
		this.oralMarks = oralMarks;
	}

	public String getOralGrade() {
		return oralGrade;
	}

	public void setOralGrade(String oralGrade) {
		this.oralGrade = oralGrade;
	}

	public String getInternalMarks() {
		return internalMarks;
	}

	public void setInternalMarks(String internalMarks) {
		this.internalMarks = internalMarks;
	}

	public String getInternalGrade() {
		return internalGrade;
	}

	public void setInternalGrade(String internalGrade) {
		this.internalGrade = internalGrade;
	}

	
}
