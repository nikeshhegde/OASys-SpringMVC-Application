package com.project.erp.forms.applicant;



public class QueryForm {

	
	
	
	private Integer id;
	
	private String queryName;

	private String queryAttributes;
	
	private String queryWhere;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryAttributes() {
		return queryAttributes;
	}

	public void setQueryAttributes(String queryAttributes) {
		this.queryAttributes = queryAttributes;
	}

	public String getQueryWhere() {
		return queryWhere;
	}

	public void setQueryWhere(String queryWhere) {
		this.queryWhere = queryWhere;
	}

}