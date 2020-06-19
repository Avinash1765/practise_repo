package com.nextconnect.constants;

public enum StatusEnum {
	ACTIVE("A"), INACTIVE("I");

	private String status;

	private StatusEnum(String status) {
		this.status = status;
	}

	public String getDBStatus() {
		return status;
	}

}
