
package com.nuance.shark.hackz.emailnotification.model;

import java.util.List;

public class EmailRequest {
	private List<EmailRecipient> to;
	private From from;
	private String subject;
	private String content;

	public EmailRequest() {
		super();
	}

	public List<EmailRecipient> getTo() {
		return to;
	}

	public void setTo(List<EmailRecipient> to) {
		this.to = to;
	}

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
