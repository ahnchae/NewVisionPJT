package com.vision.erp.service.domain;

import java.util.List;

public class OrderFromBranch {

	//field
	private String statementNo;
	private String orderFromBranchNo;
	private String orderFromBranchStatusCodeNo;
	private String orderFromBranchStatusCodeName;
	private String orderFromBranchTotalAmount;
	private String branchName;
	private String branchNo;
	private String orderDate;
	private String accountNo;
	private List<OrderFromBranchProduct> orderFromBranchProductList;
	
	//constructor
	public OrderFromBranch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderFromBranch(String statementNo, String orderFromBranchTotalAmount, String branchNo, String orderDate) {
		super();
		this.statementNo = statementNo;
		this.orderFromBranchTotalAmount = orderFromBranchTotalAmount;
		this.branchNo = branchNo;
		this.orderDate = orderDate;
	}

	public OrderFromBranch(String statementNo, String orderFromBranchNo, String orderFromBranchStatusCodeNo,
			String orderFromBranchStatusCodeName, String orderFromBranchTotalAmount, String branchName, String branchNo,
			String orderDate, List<OrderFromBranchProduct> orderFromBranchProductList) {
		super();
		this.statementNo = statementNo;
		this.orderFromBranchNo = orderFromBranchNo;
		this.orderFromBranchStatusCodeNo = orderFromBranchStatusCodeNo;
		this.orderFromBranchStatusCodeName = orderFromBranchStatusCodeName;
		this.orderFromBranchTotalAmount = orderFromBranchTotalAmount;
		this.branchName = branchName;
		this.branchNo = branchNo;
		this.orderDate = orderDate;
		this.orderFromBranchProductList = orderFromBranchProductList;
	}


	//method
	public String getStatementNo() {
		return statementNo;
	}

	public void setStatementNo(String statementNo) {
		this.statementNo = statementNo;
	}

	public String getOrderFromBranchNo() {
		return orderFromBranchNo;
	}

	public void setOrderFromBranchNo(String orderFromBranchNo) {
		this.orderFromBranchNo = orderFromBranchNo;
	}

	public String getOrderFromBranchStatusCodeNo() {
		return orderFromBranchStatusCodeNo;
	}

	public void setOrderFromBranchStatusCodeNo(String orderFromBranchStatusCodeNo) {
		this.orderFromBranchStatusCodeNo = orderFromBranchStatusCodeNo;
	}

	public String getOrderFromBranchStatusCodeName() {
		return orderFromBranchStatusCodeName;
	}

	public void setOrderFromBranchStatusCodeName(String orderFromBranchStatusCodeName) {
		this.orderFromBranchStatusCodeName = orderFromBranchStatusCodeName;
	}

	public String getOrderFromBranchTotalAmount() {
		return orderFromBranchTotalAmount;
	}

	public void setOrderFromBranchTotalAmount(String orderFromBranchTotalAmount) {
		this.orderFromBranchTotalAmount = orderFromBranchTotalAmount;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public List<OrderFromBranchProduct> getOrderFromBranchProductList() {
		return orderFromBranchProductList;
	}

	public void setOrderFromBranchProductList(List<OrderFromBranchProduct> orderFromBranchProductList) {
		this.orderFromBranchProductList = orderFromBranchProductList;
	}

	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "OrderFromBranch [statementNo=" + statementNo + ", orderFromBranchNo=" + orderFromBranchNo
				+ ", orderFromBranchStatusCodeNo=" + orderFromBranchStatusCodeNo + ", orderFromBranchStatusCodeName="
				+ orderFromBranchStatusCodeName + ", orderFromBranchTotalAmount=" + orderFromBranchTotalAmount
				+ ", branchName=" + branchName + ", branchNo=" + branchNo + ", orderDate=" + orderDate + ", accountNo="
				+ accountNo + ", orderFromBranchProductList=" + orderFromBranchProductList + "]";
	}

}
