package com.vision.erp.service.domain;

public class BranchDailySales {

	//field
	private String branchNo;	
	private String salesDate;	
	private String dailyTotalAmount;
	
	//constructor
	public BranchDailySales() {		
		// TODO Auto-generated constructor stub
	}	
	
	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	public String getDailyTotalAmount() {
		return dailyTotalAmount;
	}

	public void setDailyTotalAmount(String dailyTotalAmount) {
		this.dailyTotalAmount = dailyTotalAmount;
	}


	@Override
	public String toString() {
		return "BranchDailySales [branchNo=" + branchNo + ", salesDate=" + salesDate + ", dailyTotalAmount="
				+ dailyTotalAmount + "]";
	}

}