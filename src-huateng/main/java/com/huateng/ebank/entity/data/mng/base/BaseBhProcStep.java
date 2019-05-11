package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.BhProcStep;


/**
 * This is an object that contains data related to the BH_PROC_STEP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BH_PROC_STEP"
 */

public abstract class BaseBhProcStep  implements Serializable {

	public static String REF = "BhProcStep";
	public static String PROP_STEP = "Step";
	public static String PROP_REPORT_DATA_FLAG = "ReportDataFlag";
	public static String PROP_JOBNO = "Jobno";
	public static String PROP_SUB_STEP = "SubStep";
	public static String PROP_RUNTIME = "Runtime";
	public static String PROP_PROCESS_PARAM = "ProcessParam";
	public static String PROP_TEMP_FLAG = "TempFlag";
	public static String PROP_DESC1 = "Desc1";
	public static String PROP_DESC2 = "Desc2";
	public static String PROP_MAXPROC = "Maxproc";
	public static String PROP_PROCESS_FUNCTION = "ProcessFunction";
	public static String PROP_DESC0 = "Desc0";
	public static String PROP_PROCESS_TLRNO = "ProcessTlrno";
	public static String PROP_SUSPEND = "Suspend";
	public static String PROP_SUB_FLAG = "SubFlag";
	public static String PROP_AUTO = "Auto";
	public static String PROP_ID = "Id";
	public static String PROP_TIMESTAMPS = "Timestamps";
	public static String PROP_REPORT_FLAG = "ReportFlag";
	public static String PROP_REPEAT_CNT = "repeatCnt";

	// constructors
	public BaseBhProcStep () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBhProcStep (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBhProcStep (
		java.lang.Integer id,
		java.lang.Integer jobno,
		java.lang.Integer step,
		java.lang.Integer subStep,
		java.lang.String processFunction) {

		this.setId(id);
		this.setJobno(jobno);
		this.setStep(step);
		this.setSubStep(subStep);
		this.setProcessFunction(processFunction);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer jobno;
	private java.lang.Integer step;
	private java.lang.Integer subStep;
	private java.lang.String processFunction;
	private java.lang.String processParam;
	private java.lang.String processTlrno;
	private java.lang.String runtime;
	private java.lang.String subFlag;
	private java.lang.Integer maxproc;
	private java.lang.String tempFlag;
	private java.lang.String suspend;
	private java.lang.String auto;
	private java.sql.Timestamp timestamps;
	private java.lang.String desc0;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.lang.String reportFlag;
	private java.lang.String reportDataFlag;
	private java.lang.Integer repeatCnt;


	public java.lang.Integer getRepeatCnt() {
		return repeatCnt;
	}

	public void setRepeatCnt(java.lang.Integer repeatCnt) {
		this.repeatCnt = repeatCnt;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: JOBNO
	 */
	public java.lang.Integer getJobno () {
		return jobno;
	}

	/**
	 * Set the value related to the column: JOBNO
	 * @param jobno the JOBNO value
	 */
	public void setJobno (java.lang.Integer jobno) {
		this.jobno = jobno;
	}



	/**
	 * Return the value associated with the column: STEP
	 */
	public java.lang.Integer getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: STEP
	 * @param step the STEP value
	 */
	public void setStep (java.lang.Integer step) {
		this.step = step;
	}



	/**
	 * Return the value associated with the column: SUB_STEP
	 */
	public java.lang.Integer getSubStep () {
		return subStep;
	}

	/**
	 * Set the value related to the column: SUB_STEP
	 * @param subStep the SUB_STEP value
	 */
	public void setSubStep (java.lang.Integer subStep) {
		this.subStep = subStep;
	}



	/**
	 * Return the value associated with the column: PROCESS_FUNCTION
	 */
	public java.lang.String getProcessFunction () {
		return processFunction;
	}

	/**
	 * Set the value related to the column: PROCESS_FUNCTION
	 * @param processFunction the PROCESS_FUNCTION value
	 */
	public void setProcessFunction (java.lang.String processFunction) {
		this.processFunction = processFunction;
	}



	/**
	 * Return the value associated with the column: PROCESS_PARAM
	 */
	public java.lang.String getProcessParam () {
		return processParam;
	}

	/**
	 * Set the value related to the column: PROCESS_PARAM
	 * @param processParam the PROCESS_PARAM value
	 */
	public void setProcessParam (java.lang.String processParam) {
		this.processParam = processParam;
	}



	/**
	 * Return the value associated with the column: PROCESS_TLRNO
	 */
	public java.lang.String getProcessTlrno () {
		return processTlrno;
	}

	/**
	 * Set the value related to the column: PROCESS_TLRNO
	 * @param processTlrno the PROCESS_TLRNO value
	 */
	public void setProcessTlrno (java.lang.String processTlrno) {
		this.processTlrno = processTlrno;
	}



	/**
	 * Return the value associated with the column: RUNTIME
	 */
	public java.lang.String getRuntime () {
		return runtime;
	}

	/**
	 * Set the value related to the column: RUNTIME
	 * @param runtime the RUNTIME value
	 */
	public void setRuntime (java.lang.String runtime) {
		this.runtime = runtime;
	}



	/**
	 * Return the value associated with the column: SUB_FLAG
	 */
	public java.lang.String getSubFlag () {
		return subFlag;
	}

	/**
	 * Set the value related to the column: SUB_FLAG
	 * @param subFlag the SUB_FLAG value
	 */
	public void setSubFlag (java.lang.String subFlag) {
		this.subFlag = subFlag;
	}



	/**
	 * Return the value associated with the column: MAXPROC
	 */
	public java.lang.Integer getMaxproc () {
		return maxproc;
	}

	/**
	 * Set the value related to the column: MAXPROC
	 * @param maxproc the MAXPROC value
	 */
	public void setMaxproc (java.lang.Integer maxproc) {
		this.maxproc = maxproc;
	}



	/**
	 * Return the value associated with the column: TEMP_FLAG
	 */
	public java.lang.String getTempFlag () {
		return tempFlag;
	}

	/**
	 * Set the value related to the column: TEMP_FLAG
	 * @param tempFlag the TEMP_FLAG value
	 */
	public void setTempFlag (java.lang.String tempFlag) {
		this.tempFlag = tempFlag;
	}



	/**
	 * Return the value associated with the column: SUSPEND
	 */
	public java.lang.String getSuspend () {
		return suspend;
	}

	/**
	 * Set the value related to the column: SUSPEND
	 * @param suspend the SUSPEND value
	 */
	public void setSuspend (java.lang.String suspend) {
		this.suspend = suspend;
	}



	/**
	 * Return the value associated with the column: AUTO
	 */
	public java.lang.String getAuto () {
		return auto;
	}

	/**
	 * Set the value related to the column: AUTO
	 * @param auto the AUTO value
	 */
	public void setAuto (java.lang.String auto) {
		this.auto = auto;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.sql.Timestamp getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.sql.Timestamp timestamps) {
		this.timestamps = timestamps;
	}



	/**
	 * Return the value associated with the column: DESC0
	 */
	public java.lang.String getDesc0 () {
		return desc0;
	}

	/**
	 * Set the value related to the column: DESC0
	 * @param desc0 the DESC0 value
	 */
	public void setDesc0 (java.lang.String desc0) {
		this.desc0 = desc0;
	}



	/**
	 * Return the value associated with the column: DESC1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: DESC1
	 * @param desc1 the DESC1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: DESC2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: DESC2
	 * @param desc2 the DESC2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}



	/**
	 * Return the value associated with the column: REPORT_FLAG
	 */
	public java.lang.String getReportFlag () {
		return reportFlag;
	}

	/**
	 * Set the value related to the column: REPORT_FLAG
	 * @param reportFlag the REPORT_FLAG value
	 */
	public void setReportFlag (java.lang.String reportFlag) {
		this.reportFlag = reportFlag;
	}



	/**
	 * Return the value associated with the column: REPORT_DATA_FLAG
	 */
	public java.lang.String getReportDataFlag () {
		return reportDataFlag;
	}

	/**
	 * Set the value related to the column: REPORT_DATA_FLAG
	 * @param reportDataFlag the REPORT_DATA_FLAG value
	 */
	public void setReportDataFlag (java.lang.String reportDataFlag) {
		this.reportDataFlag = reportDataFlag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof BhProcStep)) return false;
		else {
			BhProcStep bhProcStep = (BhProcStep) obj;
			if (null == this.getId() || null == bhProcStep.getId()) return false;
			else return (this.getId().equals(bhProcStep.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}