package com.project.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="subjectallotment")
@Entity
public class SubjectAllotment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	private int year;
	private String semester;
	private String branch;
	private String subject;
	private String subjectCode;
	private String theoryMax;
	private String practicalOralMax;
	private String termWorkMax;
	private String internalAssessmentMax;
	private String theoryMaxCredit;
	private String practicalOralMaxCredit;
	private String termWorkMaxCredit;
	private String internalAssessmentMaxCredit;
	
	@Column
	public int getSubjectId() {
		return subjectId;
	}
	
	
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	@Column
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	@Column
	public String getSubject() {
		return subject;
	}
	
	@Column
	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	@Column
	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

@Column
	public String getTheoryMax() {
		return theoryMax;
	}


	public void setTheoryMax(String theoryMax) {
		this.theoryMax = theoryMax;
	}


	@Column
	public String getPracticalOralMax() {
		return practicalOralMax;
	}


	public void setPracticalOralMax(String practicalOralMax) {
		this.practicalOralMax = practicalOralMax;
	}


	@Column
	public String getTermWorkMax() {
		return termWorkMax;
	}


	public void setTermWorkMax(String termWorkMax) {
		this.termWorkMax = termWorkMax;
	}


	@Column
	public String getInternalAssessmentMax() {
		return internalAssessmentMax;
	}


	public void setInternalAssessmentMax(String internalAssessmentMax) {
		this.internalAssessmentMax = internalAssessmentMax;
	}


	@Column
	public String getTheoryMaxCredit() {
		return theoryMaxCredit;
	}


	public void setTheoryMaxCredit(String theoryMaxCredit) {
		this.theoryMaxCredit = theoryMaxCredit;
	}


	@Column
	public String getPracticalOralMaxCredit() {
		return practicalOralMaxCredit;
	}


	public void setPracticalOralMaxCredit(String practicalOralMaxCredit) {
		this.practicalOralMaxCredit = practicalOralMaxCredit;
	}


	@Column
	public String getTermWorkMaxCredit() {
		return termWorkMaxCredit;
	}


	public void setTermWorkMaxCredit(String termWorkMaxCredit) {
		this.termWorkMaxCredit = termWorkMaxCredit;
	}


	@Column
	public String getInternalAssessmentMaxCredit() {
		return internalAssessmentMaxCredit;
	}


	public void setInternalAssessmentMaxCredit(String internalAssessmentMaxCredit) {
		this.internalAssessmentMaxCredit = internalAssessmentMaxCredit;
	}
	
}	