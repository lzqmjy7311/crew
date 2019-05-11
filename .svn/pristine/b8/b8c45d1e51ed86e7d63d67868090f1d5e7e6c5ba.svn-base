package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.BhProcStatus;


/**
 * This is an object that contains data related to the BH_PROC_STATUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BH_PROC_STATUS"
 */

public abstract class BaseBhProcStatus  implements Serializable {

	public static String REF = "BhProcStatus";
	public static String PROP_STEP = "Step";
	public static String PROP_BHDATE = "Bhdate";
	public static String PROP_JOBNO = "Jobno";
	public static String PROP_SUB_STEP = "SubStep";
	public static String PROP_BRANCHLIST = "Branchlist";
	public static String PROP_DESC1 = "Desc1";
	public static String PROP_DESC2 = "Desc2";
	public static String PROP_PROCESS_FUNCTION = "ProcessFunction";
	public static String PROP_STATUS = "Status";
	public static String PROP_PROCESSID = "Processid";
	public static String PROP_SUB_FLAG = "SubFlag";
	public static String PROP_ID = "Id";
	public static String PROP_TIMESTAMPS = "Timestamps";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_START_TIME = "StartTime";


	// constructors
	public BaseBhProcStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBhProcStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBhProcStatus (
		java.lang.Integer id,
		java.util.Date bhdate,
		java.lang.Integer jobno,
		java.lang.Integer step,
		java.lang.Integer subStep) {

		this.setId(id);
		this.setBhdate(bhdate);
		this.setJobno(jobno);
		this.setStep(step);
		this.setSubStep(subStep);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date bhdate;
	private java.lang.Integer jobno;
	private java.lang.Integer step;
	private java.lang.Integer subStep;
	private java.lang.String processFunction;
	private java.lang.Integer processid;
	private java.sql.Timestamp startTime;
	private java.sql.Timestamp endTime;
	private java.lang.String subFlag;
	private java.lang.String status;
	private java.lang.String branchlist;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.sql.Timestamp timestamps;



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
	 * Return the value associated with the column: BHDATE
	 */
	public java.util.Date getBhdate () {
		return bhdate;
	}

	/**
	 * Set the value related to the column: BHDATE
	 * @param bhdate the BHDATE value
	 */
	public void setBhdate (java.util.Date bhdate) {
		this.bhdate = bhdate;
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
	 * Return the value associated with the column: PROCESSID
	 */
	public java.lang.Integer getProcessid () {
		return processid;
	}

	/**
	 * Set the value related to the column: PROCESSID
	 * @param processid the PROCESSID value
	 */
	public void setProcessid (java.lang.Integer processid) {
		this.processid = processid;
	}



	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.sql.Timestamp getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.sql.Timestamp startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.sql.Timestamp getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.sql.Timestamp endTime) {
		this.endTime = endTime;
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
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: BRANCHLIST
	 */
	public java.lang.String getBranchlist () {
		return branchlist;
	}

	/**
	 * Set the value related to the column: BRANCHLIST
	 * @param branchlist the BRANCHLIST value
	 */
	public void setBranchlist (java.lang.String branchlist) {
		this.branchlist = branchlist;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof BhProcStatus)) return false;
		else {
			BhProcStatus bhProcStatus = (BhProcStatus) obj;
			if (null == this.getId() || null == bhProcStatus.getId()) return false;
			else return (this.getId().equals(bhProcStatus.getId()));
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