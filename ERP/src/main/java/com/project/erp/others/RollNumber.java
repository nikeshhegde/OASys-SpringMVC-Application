package com.project.erp.others;

public class RollNumber {
	
	private Integer type;
	private Integer year;
	private String constant;
	private Integer base;
	
	
	public RollNumber( Integer type,Integer year,String constant,Integer base)
	{
		this.type=type;
		this.year=year;
		this.constant=constant;
		this.base=base*1000;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getConstant() {
		return constant;
	}

	public void setConstant(String constant) {
		this.constant = constant;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	

}
