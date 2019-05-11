package com.gbicc.company.financial.analysis.entity;

// Generated 2016-6-27 13:30:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Entity: 税务机关-欠缴税款
 */
public class TOutTaxItemDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * ID.
	 */
	private String id;

	/** 
	 * 企业名称.
	 */
	private String companyName;

	/** 
	 * 税务登记号.
	 */
	private String taxEnterNo;

	/** 
	 * 法定代表人.
	 */
	private String legalName;

	/** 
	 * 法定代表人证件号.
	 */
	private String legalCertNo;

	/** 
	 * 欠税税种.
	 */
	private String taxType;

	/** 
	 * 本年度新欠税额.
	 */
	private String newTaxAmt;

	/** 
	 * 累计欠缴税额.
	 */
	private String sumTaxAmt;

	/** 
	 * 税款所属税务机关.
	 */
	private String belongOrg;

	/** 
	 * 关联ID.
	 */
	private String relaId;

	/** 
	 * 数据日期.
	 */
	private Date rowDate;

	public TOutTaxItemDetail() {
	}

	public TOutTaxItemDetail(String id, String companyName,
			String taxEnterNo, String legalName, String legalCertNo,
			String taxType, String newTaxAmt, String sumTaxAmt,
			String belongOrg, String relaId, Date rowDate) {
		this.id = id;
		this.companyName = companyName;
		this.taxEnterNo = taxEnterNo;
		this.legalName = legalName;
		this.legalCertNo = legalCertNo;
		this.taxType = taxType;
		this.newTaxAmt = newTaxAmt;
		this.sumTaxAmt = sumTaxAmt;
		this.belongOrg = belongOrg;
		this.relaId = relaId;
		this.rowDate = rowDate;
	}

	/**
	 * toJson
	 * 
	 * @return String
	 */
	public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"" + id + "\",");
		buffer.append("\"companyName\":\"" + companyName + "\",");
		buffer.append("\"taxEnterNo\":\"" + taxEnterNo + "\",");
		buffer.append("\"legalName\":\"" + legalName + "\",");
		buffer.append("\"legalCertNo\":\"" + legalCertNo + "\",");
		buffer.append("\"taxType\":\"" + taxType + "\",");
		buffer.append("\"newTaxAmt\":\"" + newTaxAmt + "\",");
		buffer.append("\"sumTaxAmt\":\"" + sumTaxAmt + "\",");
		buffer.append("\"belongOrg\":\"" + belongOrg + "\",");
		buffer.append("\"relaId\":\"" + relaId + "\",");
		buffer.append("\"rowDate\":\"" + rowDate + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("税务机关-欠缴税款[");

		buffer.append("\"ID\":\"" + id + "\",");

		buffer.append("\"企业名称\":\"" + companyName + "\",");

		buffer.append("\"税务登记号\":\"" + taxEnterNo + "\",");

		buffer.append("\"法定代表人\":\"" + legalName + "\",");

		buffer.append("\"法定代表人证件号\":\"" + legalCertNo + "\",");

		buffer.append("\"欠税税种\":\"" + taxType + "\",");

		buffer.append("\"本年度新欠税额\":\"" + newTaxAmt + "\",");

		buffer.append("\"累计欠缴税额\":\"" + sumTaxAmt + "\",");

		buffer.append("\"税款所属税务机关\":\"" + belongOrg + "\",");

		buffer.append("\"关联ID\":\"" + relaId + "\",");

		buffer.append("\"数据日期\":\"" + rowDate + "\",");

		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxEnterNo() {
		return this.taxEnterNo;
	}

	public void setTaxEnterNo(String taxEnterNo) {
		this.taxEnterNo = taxEnterNo;
	}

	public String getLegalName() {
		return this.legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalCertNo() {
		return this.legalCertNo;
	}

	public void setLegalCertNo(String legalCertNo) {
		this.legalCertNo = legalCertNo;
	}

	public String getTaxType() {
		return this.taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getNewTaxAmt() {
		return this.newTaxAmt;
	}

	public void setNewTaxAmt(String newTaxAmt) {
		this.newTaxAmt = newTaxAmt;
	}

	public String getSumTaxAmt() {
		return this.sumTaxAmt;
	}

	public void setSumTaxAmt(String sumTaxAmt) {
		this.sumTaxAmt = sumTaxAmt;
	}

	public String getBelongOrg() {
		return this.belongOrg;
	}

	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}

	public String getRelaId() {
		return this.relaId;
	}

	public void setRelaId(String relaId) {
		this.relaId = relaId;
	}

	public Date getRowDate() {
		return this.rowDate;
	}

	public void setRowDate(Date rowDate) {
		this.rowDate = rowDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TOutTaxItemDetail))
			return false;
		TOutTaxItemDetail castOther = (TOutTaxItemDetail) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCompanyName() == castOther.getCompanyName()) || (this
						.getCompanyName() != null
						&& castOther.getCompanyName() != null && this
						.getCompanyName().equals(castOther.getCompanyName())))
				&& ((this.getTaxEnterNo() == castOther.getTaxEnterNo()) || (this
						.getTaxEnterNo() != null
						&& castOther.getTaxEnterNo() != null && this
						.getTaxEnterNo().equals(castOther.getTaxEnterNo())))
				&& ((this.getLegalName() == castOther.getLegalName()) || (this
						.getLegalName() != null
						&& castOther.getLegalName() != null && this
						.getLegalName().equals(castOther.getLegalName())))
				&& ((this.getLegalCertNo() == castOther.getLegalCertNo()) || (this
						.getLegalCertNo() != null
						&& castOther.getLegalCertNo() != null && this
						.getLegalCertNo().equals(castOther.getLegalCertNo())))
				&& ((this.getTaxType() == castOther.getTaxType()) || (this
						.getTaxType() != null && castOther.getTaxType() != null && this
						.getTaxType().equals(castOther.getTaxType())))
				&& ((this.getNewTaxAmt() == castOther.getNewTaxAmt()) || (this
						.getNewTaxAmt() != null
						&& castOther.getNewTaxAmt() != null && this
						.getNewTaxAmt().equals(castOther.getNewTaxAmt())))
				&& ((this.getSumTaxAmt() == castOther.getSumTaxAmt()) || (this
						.getSumTaxAmt() != null
						&& castOther.getSumTaxAmt() != null && this
						.getSumTaxAmt().equals(castOther.getSumTaxAmt())))
				&& ((this.getBelongOrg() == castOther.getBelongOrg()) || (this
						.getBelongOrg() != null
						&& castOther.getBelongOrg() != null && this
						.getBelongOrg().equals(castOther.getBelongOrg())))
				&& ((this.getRelaId() == castOther.getRelaId()) || (this
						.getRelaId() != null && castOther.getRelaId() != null && this
						.getRelaId().equals(castOther.getRelaId())))
				&& ((this.getRowDate() == castOther.getRowDate()) || (this
						.getRowDate() != null && castOther.getRowDate() != null && this
						.getRowDate().equals(castOther.getRowDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCompanyName() == null ? 0 : this.getCompanyName()
						.hashCode());
		result = 37
				* result
				+ (getTaxEnterNo() == null ? 0 : this.getTaxEnterNo()
						.hashCode());
		result = 37 * result
				+ (getLegalName() == null ? 0 : this.getLegalName().hashCode());
		result = 37
				* result
				+ (getLegalCertNo() == null ? 0 : this.getLegalCertNo()
						.hashCode());
		result = 37 * result
				+ (getTaxType() == null ? 0 : this.getTaxType().hashCode());
		result = 37 * result
				+ (getNewTaxAmt() == null ? 0 : this.getNewTaxAmt().hashCode());
		result = 37 * result
				+ (getSumTaxAmt() == null ? 0 : this.getSumTaxAmt().hashCode());
		result = 37 * result
				+ (getBelongOrg() == null ? 0 : this.getBelongOrg().hashCode());
		result = 37 * result
				+ (getRelaId() == null ? 0 : this.getRelaId().hashCode());
		result = 37 * result
				+ (getRowDate() == null ? 0 : this.getRowDate().hashCode());
		return result;
	}

}
