package com.huateng.ebank.entity.data.mng.base;
import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.TblCronTaskJob;


/**
 * This is an object that contains data related to the TBL_SWT_BMS_TASK_JOB table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TBL_SWT_BMS_TASK_JOB"
 */

public abstract class BaseTblCronTaskJob  implements Comparable, Serializable {

	public static String REF = "TblCronTaskJob";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_DESC2 = "desc2";
	public static String PROP_JOBNO = "jobno";
	public static String PROP_DESC1 = "desc1";
	public static String PROP_DUE_TIME = "dueTime";
	public static String PROP_RUNTIME = "runtime";
	public static String PROP_FAIL_FLAG = "failFlag";
	public static String PROP_MAXPROC = "maxproc";
	public static String PROP_REPEAT_CNT = "repeatCnt";
	public static String PROP_DESC0 = "desc0";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_LAST_RUN_TIME = "lastRunTime";
	public static String PROP_PROCESS_PARAM = "processParam";
	public static String PROP_DAYS_OF_MONTH = "daysOfMonth";
	public static String PROP_PROCESS_FUNCTION = "processFunction";
	public static String PROP_LOCK_OWN = "lockOwn";
	public static String PROP_AUTO = "auto";
	public static String PROP_ID = "id";
	public static String PROP_SUC_FLAG = "sucFlag";
	public static String PROP_REPEAT_TIME = "repeatTime";


	// constructors
	public BaseTblCronTaskJob () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblCronTaskJob (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTblCronTaskJob (
		java.lang.String id,
		java.lang.Integer jobno,
		java.lang.String processFunction) {

		this.setId(id);
		this.setJobno(jobno);
		this.setProcessFunction(processFunction);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer jobno;
	private java.lang.String processFunction;
	private java.lang.String processParam;
	private java.lang.Integer maxproc;
	private java.lang.String runtime;
	private java.lang.Integer daysOfMonth;
	private java.lang.Long repeatTime;
	private java.lang.Integer repeatCnt;
	private java.lang.String startTime;
	private java.lang.String endTime;
	private java.lang.String lastRunTime;
	private java.lang.String dueTime;
	private java.lang.String sucFlag;
	private java.lang.String failFlag;
	private java.lang.String auto;
	private java.lang.String lockOwn;
	private java.lang.String desc0;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.lang.String timestamps;
	/**BMSA-40 4Eye功能开发—周涛 定时任务管理**/
	private java.lang.String dualcontrolLockstatus;

	public java.lang.String getDualcontrolLockstatus() {
		return dualcontrolLockstatus;
	}

	public void setDualcontrolLockstatus(java.lang.String dualcontrolLockstatus) {
		this.dualcontrolLockstatus = dualcontrolLockstatus;
	}
	/**BMSA-40 4Eye功能开发—周涛 定时任务管理**/
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
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
	 * Return the value associated with the column: DAYS_OF_MONTH
	 */
	public java.lang.Integer getDaysOfMonth () {
		return daysOfMonth;
	}

	/**
	 * Set the value related to the column: DAYS_OF_MONTH
	 * @param daysOfMonth the DAYS_OF_MONTH value
	 */
	public void setDaysOfMonth (java.lang.Integer daysOfMonth) {
		this.daysOfMonth = daysOfMonth;
	}



	/**
	 * Return the value associated with the column: REPEAT_TIME
	 */
	public java.lang.Long getRepeatTime () {
		return repeatTime;
	}

	/**
	 * Set the value related to the column: REPEAT_TIME
	 * @param repeatTime the REPEAT_TIME value
	 */
	public void setRepeatTime (java.lang.Long repeatTime) {
		this.repeatTime = repeatTime;
	}



	/**
	 * Return the value associated with the column: REPEAT_CNT
	 */
	public java.lang.Integer getRepeatCnt () {
		return repeatCnt;
	}

	/**
	 * Set the value related to the column: REPEAT_CNT
	 * @param repeatCnt the REPEAT_CNT value
	 */
	public void setRepeatCnt (java.lang.Integer repeatCnt) {
		this.repeatCnt = repeatCnt;
	}



	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.lang.String getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.lang.String startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.lang.String getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.lang.String endTime) {
		this.endTime = endTime;
	}



	/**
	 * Return the value associated with the column: LAST_RUN_TIME
	 */
	public java.lang.String getLastRunTime () {
		return lastRunTime;
	}

	/**
	 * Set the value related to the column: LAST_RUN_TIME
	 * @param lastRunTime the LAST_RUN_TIME value
	 */
	public void setLastRunTime (java.lang.String lastRunTime) {
		this.lastRunTime = lastRunTime;
	}



	/**
	 * Return the value associated with the column: DUE_TIME
	 */
	public java.lang.String getDueTime () {
		return dueTime;
	}

	/**
	 * Set the value related to the column: DUE_TIME
	 * @param dueTime the DUE_TIME value
	 */
	public void setDueTime (java.lang.String dueTime) {
		this.dueTime = dueTime;
	}



	/**
	 * Return the value associated with the column: SUC_FLAG
	 */
	public java.lang.String getSucFlag () {
		return sucFlag;
	}

	/**
	 * Set the value related to the column: SUC_FLAG
	 * @param sucFlag the SUC_FLAG value
	 */
	public void setSucFlag (java.lang.String sucFlag) {
		this.sucFlag = sucFlag;
	}



	/**
	 * Return the value associated with the column: FAIL_FLAG
	 */
	public java.lang.String getFailFlag () {
		return failFlag;
	}

	/**
	 * Set the value related to the column: FAIL_FLAG
	 * @param failFlag the FAIL_FLAG value
	 */
	public void setFailFlag (java.lang.String failFlag) {
		this.failFlag = failFlag;
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
	 * Return the value associated with the column: LOCK_OWN
	 */
	public java.lang.String getLockOwn () {
		return lockOwn;
	}

	/**
	 * Set the value related to the column: LOCK_OWN
	 * @param lockOwn the LOCK_OWN value
	 */
	public void setLockOwn (java.lang.String lockOwn) {
		this.lockOwn = lockOwn;
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
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.lang.String getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.lang.String timestamps) {
		this.timestamps = timestamps;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof TblCronTaskJob)) return false;
		else {
			TblCronTaskJob tblCronTaskJob = (TblCronTaskJob) obj;
			if (null == this.getId() || null == tblCronTaskJob.getId()) return false;
			else return (this.getId().equals(tblCronTaskJob.getId()));
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

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}