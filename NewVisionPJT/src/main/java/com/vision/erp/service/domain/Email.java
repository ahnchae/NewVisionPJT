package com.vision.erp.service.domain;

public class Email {

	private String recipient;
	private String subject;
	private String contents;
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Email [recipient=" + recipient + ", subject=" + subject + ", contents=" + contents + "]";
	}
	
	
	
}
