package com.huateng.ebank.business.dataquery.bean;

import java.io.Serializable;
/**
 * 查询登陆情况汇总信息
 * @author shao_mying
 *
 */
public class TlrLoginLogCount implements Serializable {
	private String tlrno;// 操作员编号；
	private String brno;// 机构编号；
	private String startDate;// 开始日期；
	private String endDate;// 结束日期；
	private int count;

	public TlrLoginLogCount() {
		// TODO Auto-generated constructor stub
	}

	public TlrLoginLogCount(String tlrno, String brno, String startDate,
			String endate, int count) {
		super();
		this.tlrno = tlrno;
		this.brno = brno;
		this.startDate = startDate;
		this.endDate = endDate;
		this.count = count;

	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getBrno() {
		return brno;
	}

	public void setBrno(String brno) {
		this.brno = brno;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
