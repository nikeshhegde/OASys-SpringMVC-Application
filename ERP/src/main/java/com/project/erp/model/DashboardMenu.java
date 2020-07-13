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

@Table(name="dashboardmenu")
@Entity
public class DashboardMenu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	private String dashboardMenuRoleId;
	
	public void setDashboardMenuRoleId(String dashboardMenuRoleId) {
		this.dashboardMenuRoleId = dashboardMenuRoleId;
	}

	private String dashboardMenuUserStatus;
	
	private String dashboardMenuName;
	
	private String dashboardMenuCaption;

	private String dashboardMenuCssClass;
	
	private String dashboardMenuUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDashboardMenuName() {
		return dashboardMenuName;
	}

	public void setDashboardMenuName(String dashboardMenuName) {
		this.dashboardMenuName = dashboardMenuName;
	}

	public String getDashboardMenuCaption() {
		return dashboardMenuCaption;
	}

	public void setDashboardMenuCaption(String dashboardMenuCaption) {
		this.dashboardMenuCaption = dashboardMenuCaption;
	}

	public String getDashboardMenuCssClass() {
		return dashboardMenuCssClass;
	}

	public void setDashboardMenuCssClass(String dashboardMenuCssClass) {
		this.dashboardMenuCssClass = dashboardMenuCssClass;
	}
	

	public String getDashboardMenuUrl() {
		return dashboardMenuUrl;
	}

	public void setDashboardMenuUrl(String dashboardMenuUrl) {
		this.dashboardMenuUrl = dashboardMenuUrl;
	}

	

	public String getDashboardMenuRoleId() {
		return dashboardMenuRoleId;
	}

	public String getDashboardMenuUserStatus() {
		return dashboardMenuUserStatus;
	}

	public void setDashboardMenuUserStatus(String dashboardMenuUserStatus) {
		this.dashboardMenuUserStatus = dashboardMenuUserStatus;
	}
}	