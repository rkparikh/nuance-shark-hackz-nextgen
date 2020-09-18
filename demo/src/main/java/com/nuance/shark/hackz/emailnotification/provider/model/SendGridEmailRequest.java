package com.nuance.shark.hackz.emailnotification.provider.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nuance.shark.hackz.emailnotification.model.From;

public class SendGridEmailRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Personalization> personalizations = null;
	private From from;
	private List<Content> content = null;
	private MailSettings mailSettings;

	public List<Personalization> getPersonalizations() {
		return personalizations;
	}

	public void setPersonalizations(List<Personalization> personalizations) {
		this.personalizations = personalizations;
	}

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	@JsonProperty("mail_settings")
	public MailSettings getMailSettings() {
		return mailSettings;
	}

	public void setMailSettings(MailSettings mailSettings) {
		this.mailSettings = mailSettings;
	}

	public static class Builder {
		private List<Personalization> personalizations;
		private From from;
		private List<Content> content;
		private MailSettings mailSettings;

		public Builder personalizations(List<Personalization> personalizations) {
			this.personalizations = personalizations;
			return this;
		}

		public Builder from(From from) {
			this.from = from;
			return this;
		}

		public Builder content(List<Content> content) {
			this.content = content;
			return this;
		}

		public Builder mailSettings(MailSettings mailSettings) {
			this.mailSettings = mailSettings;
			return this;
		}

		public SendGridEmailRequest build() {
			return new SendGridEmailRequest(this);
		}
	}

	private SendGridEmailRequest(Builder builder) {
		this.personalizations = builder.personalizations;
		this.from = builder.from;
		this.content = builder.content;
		this.mailSettings = builder.mailSettings;
	}
}
