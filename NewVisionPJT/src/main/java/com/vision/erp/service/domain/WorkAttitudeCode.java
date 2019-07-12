package com.vision.erp.service.domain;

public class WorkAttitudeCode {
	//field
	private String workAttitudeCodeNo;
	private String workAttitudeCodeName;
	private String commuteApplyCode;
	private String applyStartTime;
	private String applyEndTime;
	private String workType;
	private String workDayOfWeek;
	private String usageStatusCodeNo;
	
	//constructor
	public WorkAttitudeCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getter, setter
	public String getWorkAttitudeCodeNo() {
		return workAttitudeCodeNo;
	}
	public void setWorkAttitudeCodeNo(String workAttitudeCodeNo) {
		this.workAttitudeCodeNo = workAttitudeCodeNo;
	}
	public String getWorkAttitudeCodeName() {
		return workAttitudeCodeName;
	}
	public void setWorkAttitudeCodeName(String workAttitudeCodeName) {
		this.workAttitudeCodeName = workAttitudeCodeName;
	}
	public String getCommuteApplyCode() {
		return commuteApplyCode;
	}
	public void setCommuteApplyCode(String commuteApplyCode) {
		this.commuteApplyCode = commuteApplyCode;
	}
	
	public String getApplyStartTime() {
		return applyStartTime;
	}

	public void setApplyStartTime(String applyStartTime) {
		this.applyStartTime = applyStartTime;
	}

	public String getApplyEndTime() {
		return applyEndTime;
	}

	public void setApplyEndTime(String applyEndTime) {
		this.applyEndTime = applyEndTime;
	}

	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorkDayOfWeek() {
		return workDayOfWeek;
	}
	public void setWorkDayOfWeek(String workDayOfWeek) {
		this.workDayOfWeek = workDayOfWeek;
	}
	

	public String getUsageStatusCode() {
		return usageStatusCodeNo;
	}

	public void setUsageStatusCode(String usageStatusCode) {
		this.usageStatusCodeNo = usageStatusCode;
	}

	@Override
	public String toString() {
		return "WorkAttitudeCode [workAttitudeCodeNo=" + workAttitudeCodeNo + ", workAttitudeCodeName="
				+ workAttitudeCodeName + ", commuteApplyCode=" + commuteApplyCode + ", applyStartTime=" + applyStartTime
				+ ", applyEndTime=" + applyEndTime + ", workType=" + workType + ", workDayOfWeek=" + workDayOfWeek
				+ ", usageStatusCode=" + usageStatusCodeNo + "]";
	}

	//toString
	
	

}
