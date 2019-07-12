package com.vision.erp.service.domain;

public class SalesProduct {
	//field
	private String salesNumbering;
	private String branchNo;
	private String salesDate;
	private String menuNo;
	private String menuName;
	private String salesPrice;
	private String salesAmount;
	private String salesQuantity;	
	
	//constructor
	public SalesProduct() {		
		// TODO Auto-generated constructor stub
	}

	public String getSalesNumbering() {
		return salesNumbering;
	}

	public void setSalesNumbering(String salesNumbering) {
		this.salesNumbering = salesNumbering;
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

	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(String salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	@Override
	public String toString() {
		return "SalesProduct [salesNumbering=" + salesNumbering + ", branchNo=" + branchNo + ", salesDate=" + salesDate
				+ ", menuNo=" + menuNo + ", menuName=" + menuName + ", salesPrice=" + salesPrice + ", salesAmount="
				+ salesAmount + ", salesQuantity=" + salesQuantity + "]";
	}
			
}