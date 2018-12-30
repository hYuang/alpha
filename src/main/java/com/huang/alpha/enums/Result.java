package com.huang.alpha.enums;

public enum Result{

	SUCCESS("success"),
	FAIL("fail"),
	SUCCESS_CODE("200"),
	FAIL_CODE("500");
	
	private String value;
	Result(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
