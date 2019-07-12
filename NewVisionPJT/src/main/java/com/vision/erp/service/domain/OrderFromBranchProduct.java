package com.vision.erp.service.domain;

public class OrderFromBranchProduct {
	//field
	private String numbering;
	private String productNo;
	private String productName;
	private String price;
	private String orderFromBranchProductStatusCodeNo;
	private String orderFromBranchProductStatusCodeName;
	private String orderFromBranchNo;
	private String orderFromBranchProductQuantity;
	private String orderFromBranchProductAmount;
	
	//constructor
	public OrderFromBranchProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderFromBranchProduct(String productNo, String price, String orderFromBranchNo,
			String orderFromBranchProductQuantity, String orderFromBranchProductAmount) {
		super();
		this.productNo = productNo;
		this.price = price;
		this.orderFromBranchNo = orderFromBranchNo;
		this.orderFromBranchProductQuantity = orderFromBranchProductQuantity;
		this.orderFromBranchProductAmount = orderFromBranchProductAmount;
	}



	//method
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrderFromBranchProductStatusCodeNo() {
		return orderFromBranchProductStatusCodeNo;
	}

	public void setOrderFromBranchProductStatusCodeNo(String orderFromBranchProductStatusCodeNo) {
		this.orderFromBranchProductStatusCodeNo = orderFromBranchProductStatusCodeNo;
	}

	public String getOrderFromBranchProductStatusCodeName() {
		return orderFromBranchProductStatusCodeName;
	}

	public void setOrderFromBranchProductStatusCodeName(String orderFromBranchProductStatusCodeName) {
		this.orderFromBranchProductStatusCodeName = orderFromBranchProductStatusCodeName;
	}

	public String getOrderFromBranchNo() {
		return orderFromBranchNo;
	}

	public OrderFromBranchProduct setOrderFromBranchNo(String orderFromBranchNo) {
		this.orderFromBranchNo = orderFromBranchNo;
		return this;
	}

	public String getOrderFromBranchProductQuantity() {
		return orderFromBranchProductQuantity;
	}

	public void setOrderFromBranchProductQuantity(String orderFromBranchProductQuantity) {
		this.orderFromBranchProductQuantity = orderFromBranchProductQuantity;
	}

	public String getOrderFromBranchProductAmount() {
		return orderFromBranchProductAmount;
	}

	public void setOrderFromBranchProductAmount(String orderFromBranchProductAmount) {
		this.orderFromBranchProductAmount = orderFromBranchProductAmount;
	}

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}

	//toString
	@Override
	public String toString() {
		return "OrderFromBranchProduct [numbering=" + numbering + ", productNo=" + productNo + ", productName="
				+ productName + ", price=" + price + ", orderFromBranchProductStatusCodeNo="
				+ orderFromBranchProductStatusCodeNo + ", orderFromBranchProductStatusCodeName="
				+ orderFromBranchProductStatusCodeName + ", orderFromBranchNo=" + orderFromBranchNo
				+ ", orderFromBranchProductQuantity=" + orderFromBranchProductQuantity
				+ ", orderFromBranchProductAmount=" + orderFromBranchProductAmount + "]";
	}
	
}
