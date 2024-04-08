package com.prowings.model;

public class MyCustomError {
	
	private String massage;
	private String rootCause;
	private int status;
	
	public MyCustomError() {
		super();
	}

	public MyCustomError(String massage, String rootCause, int status) {
		super();
		this.massage = massage;
		this.rootCause = rootCause;
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MyCustomError [massage=" + massage + ", rootCause=" + rootCause + ", status=" + status + "]";
	}
	
	

}
