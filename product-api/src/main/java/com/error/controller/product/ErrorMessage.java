package com.error.controller.product;

public class ErrorMessage {
	private String errorCode;
	private String titile;
	private String message;

	public ErrorMessage(String errorCode, String titile, String message) {
		this.message = message;
		this.errorCode = errorCode;
		this.titile = titile;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
