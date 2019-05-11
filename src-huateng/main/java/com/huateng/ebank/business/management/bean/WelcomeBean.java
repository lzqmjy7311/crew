package com.huateng.ebank.business.management.bean;


/**
 * 首页统计信息
 * @author kangbyron
 *
 */
public final class WelcomeBean{
	private static final long serialVersionUID = 1L;
	private Integer cnt1 = 0;	//待办任务
	private Integer cnt2 = 0;	//我的业务
	private Integer cnt3 = 0;	//贷款放款提示
	private Integer cnt4 = 0;	//贷款收回提示
	private Integer cnt5 = 0;	//我的客户
	private Integer cnt6 = 0;	//我的重点客户
	private Integer cnt7 = 0;	//我的记事本

	public Integer getCnt1() {
		return cnt1;
	}
	public void setCnt1(Integer cnt1) {
		this.cnt1 = cnt1;
	}
	public Integer getCnt2() {
		return cnt2;
	}
	public void setCnt2(Integer cnt2) {
		this.cnt2 = cnt2;
	}
	public Integer getCnt3() {
		return cnt3;
	}
	public void setCnt3(Integer cnt3) {
		this.cnt3 = cnt3;
	}
	public Integer getCnt4() {
		return cnt4;
	}
	public void setCnt4(Integer cnt4) {
		this.cnt4 = cnt4;
	}
	public Integer getCnt5() {
		return cnt5;
	}
	public void setCnt5(Integer cnt5) {
		this.cnt5 = cnt5;
	}
	public Integer getCnt6() {
		return cnt6;
	}
	public void setCnt6(Integer cnt6) {
		this.cnt6 = cnt6;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public Integer getCnt7() {
		return cnt7;
	}
	public void setCnt7(Integer cnt7) {
		this.cnt7 = cnt7;
	}

}

