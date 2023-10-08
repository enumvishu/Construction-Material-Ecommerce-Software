package com.EMS.Exception;

public class EmployeeManagementSystemException extends Exception {

	private String msg;

	public EmployeeManagementSystemException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
