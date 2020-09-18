package com.nuance.shark.hackz.emailnotification.model;

import java.io.Serializable;

public class From implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String name;

	public From() {
		super();
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class Builder {
		private String email;
		private String name;

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public From build() {
			return new From(this);
		}
	}

	private From(Builder builder) {
		this.email = builder.email;
		this.name = builder.name;
	}
}
