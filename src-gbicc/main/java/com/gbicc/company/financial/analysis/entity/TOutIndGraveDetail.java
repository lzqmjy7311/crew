package com.gbicc.company.financial.analysis.entity;

// Generated 2016-6-27 13:30:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Entity: 工商严重违法
 */
public class TOutIndGraveDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * ID.
	 */
	private String id;

	/** 
	 * 纳入原因.
	 */
	private String addReason;

	/** 
	 * 纳入日期.
	 */
	private Date addDate;

	/** 
	 * 移出原因.
	 */
	private String remReason;

	/** 
	 * 移出日期.
	 */
	private Date remDate;

	/** 
	 * 决定机关.
	 */
	private String decideOrg;

	/** 
	 * 关联基本信息主键.
	 */
	private String baseId;

	private String rowDate;

	public TOutIndGraveDetail() {
	}

	public TOutIndGraveDetail(String id, String addReason, Date addDate,
			String remReason, Date remDate, String decideOrg, String baseId,
			String rowDate) {
		this.id = id;
		this.addReason = addReason;
		this.addDate = addDate;
		this.remReason = remReason;
		this.remDate = remDate;
		this.decideOrg = decideOrg;
		this.baseId = baseId;
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
		buffer.append("\"addReason\":\"" + addReason + "\",");
		buffer.append("\"addDate\":\"" + addDate + "\",");
		buffer.append("\"remReason\":\"" + remReason + "\",");
		buffer.append("\"remDate\":\"" + remDate + "\",");
		buffer.append("\"decideOrg\":\"" + decideOrg + "\",");
		buffer.append("\"baseId\":\"" + baseId + "\",");
		buffer.append("\"rowDate\":\"" + rowDate + "\",");
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("工商严重违法[");

		buffer.append("\"ID\":\"" + id + "\",");

		buffer.append("\"纳入原因\":\"" + addReason + "\",");

		buffer.append("\"纳入日期\":\"" + addDate + "\",");

		buffer.append("\"移出原因\":\"" + remReason + "\",");

		buffer.append("\"移出日期\":\"" + remDate + "\",");

		buffer.append("\"决定机关\":\"" + decideOrg + "\",");

		buffer.append("\"关联基本信息主键\":\"" + baseId + "\",");

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

	public String getAddReason() {
		return this.addReason;
	}

	public void setAddReason(String addReason) {
		this.addReason = addReason;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getRemReason() {
		return this.remReason;
	}

	public void setRemReason(String remReason) {
		this.remReason = remReason;
	}

	public Date getRemDate() {
		return this.remDate;
	}

	public void setRemDate(Date remDate) {
		this.remDate = remDate;
	}

	public String getDecideOrg() {
		return this.decideOrg;
	}

	public void setDecideOrg(String decideOrg) {
		this.decideOrg = decideOrg;
	}

	public String getBaseId() {
		return this.baseId;
	}

	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}

	public String getRowDate() {
		return this.rowDate;
	}

	public void setRowDate(String rowDate) {
		this.rowDate = rowDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TOutIndGraveDetail))
			return false;
		TOutIndGraveDetail castOther = (TOutIndGraveDetail) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAddReason() == castOther.getAddReason()) || (this
						.getAddReason() != null
						&& castOther.getAddReason() != null && this
						.getAddReason().equals(castOther.getAddReason())))
				&& ((this.getAddDate() == castOther.getAddDate()) || (this
						.getAddDate() != null && castOther.getAddDate() != null && this
						.getAddDate().equals(castOther.getAddDate())))
				&& ((this.getRemReason() == castOther.getRemReason()) || (this
						.getRemReason() != null
						&& castOther.getRemReason() != null && this
						.getRemReason().equals(castOther.getRemReason())))
				&& ((this.getRemDate() == castOther.getRemDate()) || (this
						.getRemDate() != null && castOther.getRemDate() != null && this
						.getRemDate().equals(castOther.getRemDate())))
				&& ((this.getDecideOrg() == castOther.getDecideOrg()) || (this
						.getDecideOrg() != null
						&& castOther.getDecideOrg() != null && this
						.getDecideOrg().equals(castOther.getDecideOrg())))
				&& ((this.getBaseId() == castOther.getBaseId()) || (this
						.getBaseId() != null && castOther.getBaseId() != null && this
						.getBaseId().equals(castOther.getBaseId())))
				&& ((this.getRowDate() == castOther.getRowDate()) || (this
						.getRowDate() != null && castOther.getRowDate() != null && this
						.getRowDate().equals(castOther.getRowDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAddReason() == null ? 0 : this.getAddReason().hashCode());
		result = 37 * result
				+ (getAddDate() == null ? 0 : this.getAddDate().hashCode());
		result = 37 * result
				+ (getRemReason() == null ? 0 : this.getRemReason().hashCode());
		result = 37 * result
				+ (getRemDate() == null ? 0 : this.getRemDate().hashCode());
		result = 37 * result
				+ (getDecideOrg() == null ? 0 : this.getDecideOrg().hashCode());
		result = 37 * result
				+ (getBaseId() == null ? 0 : this.getBaseId().hashCode());
		result = 37 * result
				+ (getRowDate() == null ? 0 : this.getRowDate().hashCode());
		return result;
	}

}
