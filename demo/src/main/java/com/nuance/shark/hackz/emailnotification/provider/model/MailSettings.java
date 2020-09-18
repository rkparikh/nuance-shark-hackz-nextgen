package com.nuance.shark.hackz.emailnotification.provider.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailSettings implements Serializable {
	private static final long serialVersionUID = 1L;
	private SandBoxMode sandBoxMode;

	@JsonProperty("sandbox_mode")
	public SandBoxMode getSandBoxMode() {
		return sandBoxMode;
	}

	public void setSandBoxMode(SandBoxMode sandBoxMode) {
		this.sandBoxMode = sandBoxMode;
	}

	public static class Builder {
		private SandBoxMode sandBoxMode;

		public Builder sandBoxMode(SandBoxMode sandBoxMode) {
			this.sandBoxMode = sandBoxMode;
			return this;
		}

		public MailSettings build() {
			return new MailSettings(this);
		}
	}

	private MailSettings(Builder builder) {
		this.sandBoxMode = builder.sandBoxMode;
	}
}
