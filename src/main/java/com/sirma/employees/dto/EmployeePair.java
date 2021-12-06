package com.sirma.employees.dto;

public class EmployeePair {

	private long firstEmpId;
	private long secondEmpId;
	private long projectId;

	public long getFirstEmpId() {
		return firstEmpId;
	}

	public void setFirstEmpId(long firstEmpId) {
		this.firstEmpId = firstEmpId;
	}

	public long getSecondEmpId() {
		return secondEmpId;
	}

	public void setSecondEmpId(long secondEmpId) {
		this.secondEmpId = secondEmpId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "EmployeePair [firstEmpId=" + firstEmpId + ", secondEmpId=" + secondEmpId + ", projectId=" + projectId
				+ "]";
	}

}
