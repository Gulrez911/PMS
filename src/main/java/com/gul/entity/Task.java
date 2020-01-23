package com.gul.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table
@Proxy(lazy = false)
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String taskName;
	private String taskDescription;
	private Date startDate;
	private Date endDate;
	private Long projectId;
	private Long managerId;
	private String empEmail;
	private String action;
	private String taskStatus;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", projectId=" + projectId
				+ ", managerId=" + managerId + ", empEmail=" + empEmail + ", action=" + action
				+ ", taskStatus=" + taskStatus + "]";
	}
}
