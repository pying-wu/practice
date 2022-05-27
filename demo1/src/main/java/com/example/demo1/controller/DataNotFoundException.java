package com.example.demo1.controller;

public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errMsg = "查無資料";

	public DataNotFoundException() {

	}

	public DataNotFoundException(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String getMessage() {
		return (errMsg);
	}

	@Override
	public String toString() {

		return "";
	}

	@Override
	public synchronized Throwable fillInStackTrace() {

		return null;
	}

}
