package com.springboot.bank_demo.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseMsgDto {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	} 
	
	
}
