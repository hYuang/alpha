package com.huang.alpha.enums;

public enum ResultMsgCode {
	SUCCESS_CODE("200"),
	FAIL_CODE("500");
	
	private String value;
	ResultMsgCode(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
