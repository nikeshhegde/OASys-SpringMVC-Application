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

@Table(name="academicdetailsdse")
@Entity
public class AcademicDetailsDse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private String academicDetailsDseSscMarksMathsObtained;
	
	private String academicDetailsDseSscMarksTotalMaths;
	
	private String academicDetailsDseSscMarksGrandObtained;
	
	private String academicDetailsDseSscMarksTotalGrand;
	
	private String academicDetailsDseSscPercentageObtained;
	
	private String academicDetailsDseSscYearOfPassing;
	
	

	private String academicDetailsDseDiplomaMarksFirstYearObtained;
	
	private String academicDetailsDseDiplomaMarksTotalFirstYear;
	
	private String academicDetailsDseDiplomaMarksSecondYearObtained;
	
	private String academicDetailsDseDiplomaMarksTotalSecondYear;
	
	private String academicDetailsDseDiplomaMarksThirdYearObtained;
	
	private String academicDetailsDseDiplomaMarksTotalThirdYear;
	
	
	private String academicDetailsDseDiplomaYearOfPassing;
	
	private String academicDetailsDseDiplomaStateRank;
	
	private String academicDetailsDseDiplomaUniversityRank;
	
	private String academicDetailsDseDiplomaCategoryRank;
	
	private Integer admissionUserId;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcademicDetailsDseSscMarksMathsObtained() {
		return academicDetailsDseSscMarksMathsObtained;
	}

	public void setAcademicDetailsDseSscMarksMathsObtained(
			String academicDetailsDseSscMarksMathsObtained) {
		this.academicDetailsDseSscMarksMathsObtained = academicDetailsDseSscMarksMathsObtained;
	}

	public String getAcademicDetailsDseSscMarksTotalMaths() {
		return academicDetailsDseSscMarksTotalMaths;
	}

	public void setAcademicDetailsDseSscMarksTotalMaths(
			String academicDetailsDseSscMarksTotalMaths) {
		this.academicDetailsDseSscMarksTotalMaths = academicDetailsDseSscMarksTotalMaths;
	}

	public String getAcademicDetailsDseSscMarksGrandObtained() {
		return academicDetailsDseSscMarksGrandObtained;
	}

	public void setAcademicDetailsDseSscMarksGrandObtained(
			String academicDetailsDseSscMarksGrandObtained) {
		this.academicDetailsDseSscMarksGrandObtained = academicDetailsDseSscMarksGrandObtained;
	}

	public String getAcademicDetailsDseSscMarksTotalGrand() {
		return academicDetailsDseSscMarksTotalGrand;
	}

	public void setAcademicDetailsDseSscMarksTotalGrand(
			String academicDetailsDseSscMarksTotalGrand) {
		this.academicDetailsDseSscMarksTotalGrand = academicDetailsDseSscMarksTotalGrand;
	}

	public String getAcademicDetailsDseSscPercentageObtained() {
		return academicDetailsDseSscPercentageObtained;
	}

	public void setAcademicDetailsDseSscPercentageObtained(
			String academicDetailsDseSscPercentageObtained) {
		this.academicDetailsDseSscPercentageObtained = academicDetailsDseSscPercentageObtained;
	}

	public String getAcademicDetailsDseSscYearOfPassing() {
		return academicDetailsDseSscYearOfPassing;
	}

	public void setAcademicDetailsDseSscYearOfPassing(
			String academicDetailsDseSscYearOfPassing) {
		this.academicDetailsDseSscYearOfPassing = academicDetailsDseSscYearOfPassing;
	}

	public String getAcademicDetailsDseDiplomaMarksFirstYearObtained() {
		return academicDetailsDseDiplomaMarksFirstYearObtained;
	}

	public void setAcademicDetailsDseDiplomaMarksFirstYearObtained(
			String academicDetailsDseDiplomaMarksFirstYearObtained) {
		this.academicDetailsDseDiplomaMarksFirstYearObtained = academicDetailsDseDiplomaMarksFirstYearObtained;
	}

	public String getAcademicDetailsDseDiplomaMarksTotalFirstYear() {
		return academicDetailsDseDiplomaMarksTotalFirstYear;
	}

	public void setAcademicDetailsDseDiplomaMarksTotalFirstYear(
			String academicDetailsDseDiplomaMarksTotalFirstYear) {
		this.academicDetailsDseDiplomaMarksTotalFirstYear = academicDetailsDseDiplomaMarksTotalFirstYear;
	}

	public String getAcademicDetailsDseDiplomaMarksSecondYearObtained() {
		return academicDetailsDseDiplomaMarksSecondYearObtained;
	}

	public void setAcademicDetailsDseDiplomaMarksSecondYearObtained(
			String academicDetailsDseDiplomaMarksSecondYearObtained) {
		this.academicDetailsDseDiplomaMarksSecondYearObtained = academicDetailsDseDiplomaMarksSecondYearObtained;
	}

	public String getAcademicDetailsDseDiplomaMarksTotalSecondYear() {
		return academicDetailsDseDiplomaMarksTotalSecondYear;
	}

	public void setAcademicDetailsDseDiplomaMarksTotalSecondYear(
			String academicDetailsDseDiplomaMarksTotalSecondYear) {
		this.academicDetailsDseDiplomaMarksTotalSecondYear = academicDetailsDseDiplomaMarksTotalSecondYear;
	}

	public String getAcademicDetailsDseDiplomaMarksThirdYearObtained() {
		return academicDetailsDseDiplomaMarksThirdYearObtained;
	}

	public void setAcademicDetailsDseDiplomaMarksThirdYearObtained(
			String academicDetailsDseDiplomaMarksThirdYearObtained) {
		this.academicDetailsDseDiplomaMarksThirdYearObtained = academicDetailsDseDiplomaMarksThirdYearObtained;
	}

	public String getAcademicDetailsDseDiplomaMarksTotalThirdYear() {
		return academicDetailsDseDiplomaMarksTotalThirdYear;
	}

	public void setAcademicDetailsDseDiplomaMarksTotalThirdYear(
			String academicDetailsDseDiplomaMarksTotalThirdYear) {
		this.academicDetailsDseDiplomaMarksTotalThirdYear = academicDetailsDseDiplomaMarksTotalThirdYear;
	}

	public String getAcademicDetailsDseDiplomaYearOfPassing() {
		return academicDetailsDseDiplomaYearOfPassing;
	}

	public void setAcademicDetailsDseDiplomaYearOfPassing(
			String academicDetailsDseDiplomaYearOfPassing) {
		this.academicDetailsDseDiplomaYearOfPassing = academicDetailsDseDiplomaYearOfPassing;
	}

	public String getAcademicDetailsDseDiplomaStateRank() {
		return academicDetailsDseDiplomaStateRank;
	}

	public void setAcademicDetailsDseDiplomaStateRank(
			String academicDetailsDseDiplomaStateRank) {
		this.academicDetailsDseDiplomaStateRank = academicDetailsDseDiplomaStateRank;
	}

	public String getAcademicDetailsDseDiplomaUniversityRank() {
		return academicDetailsDseDiplomaUniversityRank;
	}

	public void setAcademicDetailsDseDiplomaUniversityRank(
			String academicDetailsDseDiplomaUniversityRank) {
		this.academicDetailsDseDiplomaUniversityRank = academicDetailsDseDiplomaUniversityRank;
	}

	public String getAcademicDetailsDseDiplomaCategoryRank() {
		return academicDetailsDseDiplomaCategoryRank;
	}

	public void setAcademicDetailsDseDiplomaCategoryRank(
			String academicDetailsDseDiplomaCategoryRank) {
		this.academicDetailsDseDiplomaCategoryRank = academicDetailsDseDiplomaCategoryRank;
	}

	public Integer getAdmissionUserId() {
		return admissionUserId;
	}

	public void setAdmissionUserId(Integer admissionUserId) {
		this.admissionUserId = admissionUserId;
	}
}