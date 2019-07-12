package com.vision.erp.service.domain;

public class Department {

	//field
	private String departCodeNo;
	private String departCodeName;
	private String accessMenuCodeNo;
	private String accessMenuCodeName;
	private String departUsageStatusCodeNo;
	private String departUsageStatusCodeName;
	private String usageStatusCodeNo;
	
	//constructor
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartCodeNo() {
		return departCodeNo;
	}

	public void setDepartCodeNo(String departCodeNo) {
		this.departCodeNo = departCodeNo;
	}

	public String getDepartCodeName() {
		return departCodeName;
	}

	public void setDepartCodeName(String departCodeName) {
		this.departCodeName = departCodeName;
	}

	public String getAccessMenuCodeNo() {
		return accessMenuCodeNo;
	}

	public void setAccessMenuCodeNo(String accessMenuCodeNo) {
		this.accessMenuCodeNo = accessMenuCodeNo;
	}

	public String getAccessMenuCodeName() {
		return accessMenuCodeName;
	}

	public void setAccessMenuCodeName(String accessMenuCodeName) {
		this.accessMenuCodeName = accessMenuCodeName;
	}

	public String getDepartUsageStatusCodeNo() {
		return departUsageStatusCodeNo;
	}

	public void setDepartUsageStatusCodeNo(String departUsageStatusCodeNo) {
		this.departUsageStatusCodeNo = departUsageStatusCodeNo;
	}

	public String getDepartUsageStatusCodeName() {
		return departUsageStatusCodeName;
	}

	public void setDepartUsageStatusCodeName(String departUsageStatusCodeName) {
		this.departUsageStatusCodeName = departUsageStatusCodeName;
	}

	public String getUsageStatusCodeNo() {
		return usageStatusCodeNo;
	}

	public void setUsageStatusCodeNo(String usageStatusCodeNo) {
		this.usageStatusCodeNo = usageStatusCodeNo;
	}

	
	@Override
	public String toString() {
		return "Department [departCodeNo=" + departCodeNo + ", departCodeName=" + departCodeName + ", accessMenuCodeNo="
				+ accessMenuCodeNo + ", accessMenuCodeName=" + accessMenuCodeName + ", departUsageStatusCodeNo="
				+ departUsageStatusCodeNo + ", departUsageStatusCodeName=" + departUsageStatusCodeName
				+ ", usageStatusCodeNo=" + usageStatusCodeNo + "]";
	}

	
	
	
}