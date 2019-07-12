package com.vision.erp.service.domain;

public class NoticeHeader {
	
	private String headerCodeNo;
	private String headerCodeName;

	public NoticeHeader() {		
	}

	public String getHeaderCodeNo() {
		return headerCodeNo;
	}

	public void setHeaderCodeNo(String headerCodeNo) {
		this.headerCodeNo = headerCodeNo;
	}

	public String getHeaderCodeName() {
		return headerCodeName;
	}

	public void setHeaderCodeName(String headerCodeName) {
		this.headerCodeName = headerCodeName;
	}

	@Override
	public String toString() {
		return "NoticeHeader [headerCodeNo=" + headerCodeNo + ", headerCodeName=" + headerCodeName + "]";
	}

}
