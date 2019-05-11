package com.gbicc.person.product.entity;

import java.io.Serializable;

/**
 * @author likm
 * @time   2015年10月27日10:40:32
 * @desc   产品实体类
 */
public class Product implements Serializable {

	private static final long serialVersionUID = -2631760787710321152L;

	private String id;
	private String prodCode;
	private String prodName;
	private String prodType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
}
