package com.huateng.fs.micro.demo.bean;

import java.math.BigDecimal;

/*
 <Buffer id="Purchase" desc="交易信息" name="CEReq_Purchase" xpath="com.huateng.fs.micro.demo.bean.Purchase">
 			<Field id="pan" type="S" desc="卡号" name="" length="19" xpath="/pan" />
			<Field id="purchAmount" type="LZN" desc="交易金额" name="" length="12" xpath="/purchAmount" />
			<Field id="currency" type="S" desc="交易币种" name="" length="3" xpath="/currency" />
			<Field id="exponent" type="S" desc="货币指数" name="" length="1" xpath="/exponent" />
			<Field id="trsFeeAmount" type="LZN" desc="交易手续费" name="" length="9" xpath="trsFeeAmount" />
		</Buffer>
 */
public class Purchase {
	private String pan;
	private BigDecimal purchAmount;
	private String currency;
	private String exponent;
	private BigDecimal trsFeeAmount;
	public BigDecimal getPurchAmount() {
		return purchAmount;
	}
	public void setPurchAmount(BigDecimal purchAmount) {
		this.purchAmount = purchAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExponent() {
		return exponent;
	}
	public void setExponent(String exponent) {
		this.exponent = exponent;
	}
	public BigDecimal getTrsFeeAmount() {
		return trsFeeAmount;
	}
	public void setTrsFeeAmount(BigDecimal trsFeeAmount) {
		this.trsFeeAmount = trsFeeAmount;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	

}
