package com.nuance.shark.hackz.emailnotification.model;

public class EmailResponse {
	private int statusCode;

	public EmailResponse(int status) {
		this.statusCode = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
