package com.example.demo.dto.response;

public class CompanyResponse {
	private String message;

	public CompanyResponse() {
		super();
	}

	public CompanyResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
