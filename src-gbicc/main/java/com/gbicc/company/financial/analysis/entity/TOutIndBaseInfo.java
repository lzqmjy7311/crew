package com.gbicc.company.financial.analysis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TOutIndBaseInfo {
	/*
	    * ID.
	    */
	    private String id;
	    /*
	    * 企业名称.
	    */
	    private String companyName;
	    /*
	    * 注册号.
	    */
	    private String registorNo;
	    /*
	    * 法定代表人.
	    */
	    private String legalName;
	    /*
	    * 证件号码.
	    */
	    private String certNo;
	    /*
	    * 注销日期/吊销日期.
	    */
	    private Date cancelDate;
	    /*
	    * 登记状态.
	    */
	    private String enterStatus;
	    /*
	    * 经营期限起始日.
	    */
	    private Date busstartDate;
	    /*
	    * 经营期限结束日.
	    */
	    private Date busendDate;
	    /*
	    * 经营范围.
	    */
	    private String busscope;
	    /*
	    * 注册资本.
	    */
	    private BigDecimal registorAmt;
	    /*
	    * 登记机关.
	    */
	    private String enterOrg;
	    /*
	    * 住所.
	    */
	    private String address;
	    /*
	    * 核准日期.
	    */
	    private Date checkDate;
	    /*
	    * 股东.
	    */
	    private String shareHolder;
	    /*
	    * 原链接.
	    */
	    private String sourceLink;
	    /*
	    * 数据日期.
	    */
	    private Date rowDate;
	    /*
	    * 关联ID.
	    */
	    private String relaId;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getRegistorNo() {
			return registorNo;
		}
		public void setRegistorNo(String registorNo) {
			this.registorNo = registorNo;
		}
		public String getLegalName() {
			return legalName;
		}
		public void setLegalName(String legalName) {
			this.legalName = legalName;
		}
		public String getCertNo() {
			return certNo;
		}
		public void setCertNo(String certNo) {
			this.certNo = certNo;
		}
		public Date getCancelDate() {
			return cancelDate;
		}
		public void setCancelDate(Date cancelDate) {
			this.cancelDate = cancelDate;
		}
		public String getEnterStatus() {
			return enterStatus;
		}
		public void setEnterStatus(String enterStatus) {
			this.enterStatus = enterStatus;
		}
		public Date getBusstartDate() {
			return busstartDate;
		}
		public void setBusstartDate(Date busstartDate) {
			this.busstartDate = busstartDate;
		}
		public Date getBusendDate() {
			return busendDate;
		}
		public void setBusendDate(Date busendDate) {
			this.busendDate = busendDate;
		}
		public String getBusscope() {
			return busscope;
		}
		public void setBusscope(String busscope) {
			this.busscope = busscope;
		}
		public BigDecimal getRegistorAmt() {
			return registorAmt;
		}
		public void setRegistorAmt(BigDecimal registorAmt) {
			this.registorAmt = registorAmt;
		}
		public String getEnterOrg() {
			return enterOrg;
		}
		public void setEnterOrg(String enterOrg) {
			this.enterOrg = enterOrg;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Date getCheckDate() {
			return checkDate;
		}
		public void setCheckDate(Date checkDate) {
			this.checkDate = checkDate;
		}
		public String getShareHolder() {
			return shareHolder;
		}
		public void setShareHolder(String shareHolder) {
			this.shareHolder = shareHolder;
		}
		public String getSourceLink() {
			return sourceLink;
		}
		public void setSourceLink(String sourceLink) {
			this.sourceLink = sourceLink;
		}
		public Date getRowDate() {
			return rowDate;
		}
		public void setRowDate(Date rowDate) {
			this.rowDate = rowDate;
		}
		public String getRelaId() {
			return relaId;
		}
		public void setRelaId(String relaId) {
			this.relaId = relaId;
		}
}
