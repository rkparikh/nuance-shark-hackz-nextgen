package com.nuance.shark.hackz.emailnotification.provider.model;

import java.io.Serializable;

public class Content implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static class Builder {
		private String type;
		private String value;

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder value(String value) {
			this.value = value;
			return this;
		}

		public Content build() {
			return new Content(this);
		}
	}

	private Content(Builder builder) {
		this.type = builder.type;
		this.value = builder.value;
	}
}
