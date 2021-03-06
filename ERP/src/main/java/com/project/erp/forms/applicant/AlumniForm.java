package com.project.erp.forms.applicant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AlumniForm {
 
	
	private Integer id;
	
	
	private String alumniSurname;
	private String alumniFname;
	private String alumniFatherName;
	private String alumniContactNumber;
	private String alumniEmail;
	private String alumniYearOfPassing;
	private String alumniDepartment;
	
	private String alumniCurrentEmployment;
	private String alumniCurrentWorkPlace;
	private String alumniAreaOfExpertise;
	private String alumniPassword;
	public String getAlumniPassword() {
		return alumniPassword;
	}
	public void setAlumniPassword(String alumniPassword) {
		this.alumniPassword = alumniPassword;
	}
	public String getAlumniCurrentEmployment() {
		return alumniCurrentEmployment;
	}
	public void setAlumniCurrentEmployment(String alumniCurrentEmployment) {
		this.alumniCurrentEmployment = alumniCurrentEmployment;
	}
	public String getAlumniCurrentWorkPlace() {
		return alumniCurrentWorkPlace;
	}
	public void setAlumniCurrentWorkPlace(String alumniCurrentWorkPlace) {
		this.alumniCurrentWorkPlace = alumniCurrentWorkPlace;
	}
	public String getAlumniAreaOfExpertise() {
		return alumniAreaOfExpertise;
	}
	public void setAlumniAreaOfExpertise(String alumniAreaOfExpertise) {
		this.alumniAreaOfExpertise = alumniAreaOfExpertise;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlumniSurname() {
		return alumniSurname;
	}
	public void setAlumniSurname(String alumniSurname) {
		this.alumniSurname = alumniSurname;
	}
	public String getAlumniFname() {
		return alumniFname;
	}
	public void setAlumniFname(String alumniFname) {
		this.alumniFname = alumniFname;
	}
	public String getAlumniFatherName() {
		return alumniFatherName;
	}
	public void setAlumniFatherName(String alumniFatherName) {
		this.alumniFatherName = alumniFatherName;
	}
	public String getAlumniContactNumber() {
		return alumniContactNumber;
	}
	public void setAlumniContactNumber(String alumniContactNumber) {
		this.alumniContactNumber = alumniContactNumber;
	}
	public String getAlumniEmail() {
		return alumniEmail;
	}
	public void setAlumniEmail(String alumniEmail) {
		this.alumniEmail = alumniEmail;
	}
	public String getAlumniYearOfPassing() {
		return alumniYearOfPassing;
	}
	public void setAlumniYearOfPassing(String alumniYearOfPassing) {
		this.alumniYearOfPassing = alumniYearOfPassing;
	}
	public String getAlumniDepartment() {
		return alumniDepartment;
	}
	public void setAlumniDepartment(String alumniDepartment) {
		this.alumniDepartment = alumniDepartment;
	}
	
}	
	
