package com.zjc.springboot.common;

public class JsonResult {
	
	private String status;
	private Object result;
	private static JsonResult jsonResult = new JsonResult();
	public static JsonResult getIntance() {
		return jsonResult;
	}
	public JsonResult() {
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
