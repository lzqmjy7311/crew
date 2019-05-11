package com.huateng.ebank.business.parammng.bean;

public class BhProcStepView {
	private      String      id                    ;
	private      String      jobno                 ;
	private      String      step                  ;
	private      String      subStep              ;
	private      String      processFunction      ;
	private      String      processParam         ;
	private      String      processTlrno         ;
	private      String      runtime               ;
	private      String      subFlag              ;
	private      String      reportFlag           ;
	private      String      maxproc               ;
	private      String      tempFlag             ;
	private      String      suspend               ;
	private      String      singleFlag           ;
	private      String      desc                  ;
	private      String      desc1                 ;
	private      String      desc2                 ;
	//---------------------------------------------------------------------------------------------------------------
	//虚拟字段，该字段用于区分页面的该记录是从数据库读出来的，还是用户在页面新增的，如果该字段不为空则是页面上用户新增的字段
	//在查询的getter方法中给该字段赋值
    private String v_id;
	public String getV_id() {
		return v_id;
	}
	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
//---------------------------------页面上显示的字段----------------------------------------------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getSubStep() {
		return subStep;
	}
	public void setSubStep(String sub_step) {
		this.subStep = sub_step;
	}
	public String getProcessFunction() {
		return processFunction;
	}
	public void setProcessFunction(String process_function) {
		this.processFunction = process_function;
	}
	public String getProcessParam() {
		return processParam;
	}
	public void setProcessParam(String process_param) {
		this.processParam = process_param;
	}
	public String getProcessTlrno() {
		return processTlrno;
	}
	public void setProcessTlrno(String process_tlrno) {
		this.processTlrno = process_tlrno;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getSubFlag() {
		return subFlag;
	}
	public void setSubFlag(String sub_flag) {
		this.subFlag = sub_flag;
	}
	public String getReportFlag() {
		return reportFlag;
	}
	public void setReportFlag(String report_flag) {
		this.reportFlag = report_flag;
	}
	public String getMaxproc() {
		return maxproc;
	}
	public void setMaxproc(String maxproc) {
		this.maxproc = maxproc;
	}
	public String getTempFlag() {
		return tempFlag;
	}
	public void setTempFlag(String temp_flag) {
		this.tempFlag = temp_flag;
	}
	public String getSuspend() {
		return suspend;
	}
	public void setSuspend(String suspend) {
		this.suspend = suspend;
	}
	public String getSingleFlag() {
		return singleFlag;
	}
	public void setSingleFlag(String single_flag) {
		this.singleFlag = single_flag;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

}
