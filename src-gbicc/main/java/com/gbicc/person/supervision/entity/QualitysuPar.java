package com.gbicc.person.supervision.entity;

import java.io.Serializable;
import java.util.Date;

	/**
	 * @author kfc
	 * @time   2015年11月11日14:40:32
	 * @desc   质量监督参数维护表
	 */
	public class QualitysuPar implements Serializable {

		private static final long serialVersionUID = -2631760787710321155L;

		private String id;
		
		private String bankName;//支行名称
		private String productName;//产品名称
		private String riskSignal;//风险信号
		private String assureType;//担保方式
		private String warningLevel;//预警优先级
		private Double qualitysupPerc;//质量监督比例
		private String status;// 状态
		private Date startTime;//启用开始时间
		private Date endTime;//启用结束时间
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getRiskSignal() {
			return riskSignal;
		}
		public void setRiskSignal(String riskSignal) {
			this.riskSignal = riskSignal;
		}
		public String getAssureType() {
			return assureType;
		}
		public void setAssureType(String assureType) {
			this.assureType = assureType;
		}
		public String getWarningLevel() {
			return warningLevel;
		}
		public void setWarningLevel(String warningLevel) {
			this.warningLevel = warningLevel;
		}
		public Double getQualitysupPerc() {
			return qualitysupPerc;
		}
		public void setQualitysupPerc(Double qualitysupPerc) {
			this.qualitysupPerc = qualitysupPerc;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		
		
		
		
		
	}

