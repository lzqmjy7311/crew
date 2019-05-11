package com.gbicc.engine.rule.piecewise;

public class Range {
	private String condition;
	private String value;
	
	public Range(String condition,String value){
		this.condition =condition;
		this.value =value;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
