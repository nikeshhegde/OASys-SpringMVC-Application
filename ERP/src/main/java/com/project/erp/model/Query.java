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

@Table(name="query")
@Entity
public class Query {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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