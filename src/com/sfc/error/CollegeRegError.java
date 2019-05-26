package com.sfc.error;

public class CollegeRegError {

	private int errorCode;
	private String message;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CollegeRegError() {
		// TODO Auto-generated constructor stub
	}

	public CollegeRegError(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public String toString() {
		return "CollegeRegError [errorCode=" + errorCode + ", message=" + message + "]";
	}

}
