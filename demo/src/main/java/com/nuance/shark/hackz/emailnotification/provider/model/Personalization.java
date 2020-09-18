package com.nuance.shark.hackz.emailnotification.provider.model;

import java.io.Serializable;
import java.util.List;

import com.nuance.shark.hackz.emailnotification.model.EmailRecipient;


public class Personalization implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<EmailRecipient> to = null;
	private String subject;

	public List<EmailRecipient> getTo() {
		return to;
	}

	public void setTo(List<EmailRecipient> to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static class Builder {
		private List<EmailRecipient> to;
		private String subject;

		public Builder to(List<EmailRecipient> to) {
			this.to = to;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Personalization build() {
			return new Personalization(this);
		}
	}

	private Personalization(Builder builder) {
		this.to = builder.to;
		this.subject = builder.subject;
	}
}
