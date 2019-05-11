package com.gbicc.tools.dbmeta;


public class Column {
	private String name;
	private String description;
	private String type;
	private int size;
	private boolean primary;
	private boolean nullAble;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public boolean isNullAble() {
		return nullAble;
	}
	public void setNullAble(boolean nullAble) {
		this.nullAble = nullAble;
	}
}
