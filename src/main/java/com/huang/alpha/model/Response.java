package com.huang.alpha.model;

import com.alibaba.fastjson.JSON;

public class Response {
	private String msg;
	private String msg_code;
	private JSON data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	public JSON getData() {
		return data;
	}
	public void setData(JSON data) {
		this.data = data;
	}
	
	
}
