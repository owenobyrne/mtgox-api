package com.owenobyrne.mtgox.api.model;

public class Quote {
	String result;
	QuoteDatum data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public QuoteDatum getData() {
		return data;
	}
	public void setData(QuoteDatum data) {
		this.data = data;
	}
}
