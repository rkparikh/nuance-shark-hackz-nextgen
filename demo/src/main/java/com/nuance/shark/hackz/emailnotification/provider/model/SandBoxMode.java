package com.nuance.shark.hackz.emailnotification.provider.model;

import java.io.Serializable;

public class SandBoxMode implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean enable;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public static class Builder {
		private boolean enable;

		public Builder enable(boolean enable) {
			this.enable = enable;
			return this;
		}

		public SandBoxMode build() {
			return new SandBoxMode(this);
		}
	}

	private SandBoxMode(Builder builder) {
		this.enable = builder.enable;
	}
}
