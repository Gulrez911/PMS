package com.gul.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table
@Proxy(lazy = false)
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String projectName;
	private String projectDescription;
	private Date startDat;
	private Date endDate;
	private Long managerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartDat() {
		return startDat;
	}

	public void setStartDat(Date startDat) {
		this.startDat = startDat;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", startDat=" + startDat + ", endDate=" + endDate
				+ ", managerId=" + managerId + "]";
	}

}
