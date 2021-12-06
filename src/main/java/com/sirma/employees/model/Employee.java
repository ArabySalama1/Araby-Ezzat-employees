package com.sirma.employees.model;

import java.time.LocalDate;

public class Employee {

	private Long empId;
	private Long projectId;
	private LocalDate dateFrom;
	private LocalDate dataTo;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDataTo() {
		return dataTo;
	}

	public void setDataTo(LocalDate dataTo) {
		this.dataTo = dataTo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", projectId=" + projectId + ", dateFrom=" + dateFrom + ", dataTo=" + dataTo
				+ "]";
	}
	

}
