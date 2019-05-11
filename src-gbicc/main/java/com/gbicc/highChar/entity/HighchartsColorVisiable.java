package com.gbicc.highChar.entity;


import java.util.ArrayList;
import java.util.List;

public class HighchartsColorVisiable {  
    private String name;  
    private Boolean visible;  
    private List data = new ArrayList();
    private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}      
      
    //get and set  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

} 