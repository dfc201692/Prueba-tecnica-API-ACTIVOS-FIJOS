package com.prueba.spring.api.activos.dto;

import java.util.List;

import com.prueba.spring.api.activos.model.Activos;

public class ResponseDto {

	private Integer code;
	private String msg;
	private List<Activos> info;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Activos> getInfo() {
		return info;
	}
	public void setInfo(List<Activos> info) {
		this.info = info;
	}
	
}
