package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.TblCronTaskJobLog;



/**
 * This is an object that contains data related to the TBL_SWT_BMS_TASK_JOB_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TBL_SWT_BMS_TASK_JOB_LOG"
 */

public abstract class BaseTblCronTaskJobLog  implements Comparable, Serializable {

	public static String REF = "TblCronTaskJob";
	public static String PROP_EXCEPTION_MSG = "exceptionMsg";
	public static String PROP_EXCUTE_OWN = "excuteOwn";
	public static String PROP_JOBNO = "jobno";
	public static String PROP_EXCUTE_TIME = "excuteTime";
	public static String PROP_END_EXCUTE_FLAG = "endExcuteFlag";
	public static String PROP_SUB_PROCE_FUNCTION = "subProceFunction";
	public static String PROP_FAIL_FLAG = "failFlag";
	public static String PROP_ID = "id";
	public static String PROP_SUC_FLAG = "sucFlag";
	public static String PROP_EXCUTE_RESULT = "excuteResult";


	// constructors
	public BaseTblCronTaskJobLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblCronTaskJobLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTblCronTaskJobLog (
		java.lang.String id,
		java.lang.Integer jobno,
		java.lang.String subProceFunction) {

		this.setId(id);
		this.setJobno(jobno);
		this.setSubProceFunction(subProceFunction);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer jobno;
	private java.lang.String subProceFunction;
	private java.lang.String excuteTime;
	private java.lang.String excuteResult;
	private java.lang.String excuteOwn;
	private java.lang.String failFlag;
	private java.lang.String sucFlag;
	private java.lang.String exceptionMsg;
	private java.lang.String endExcuteFlag;



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
	 * Return the value associated with the column: SUB_PROCE_FUNCTION
	 */
	public java.lang.String getSubProceFunction () {
		return subProceFunction;
	}

	/**
	 * Set the value related to the column: SUB_PROCE_FUNCTION
	 * @param subProceFunction the SUB_PROCE_FUNCTION value
	 */
	public void setSubProceFunction (java.lang.String subProceFunction) {
		this.subProceFunction = subProceFunction;
	}



	/**
	 * Return the value associated with the column: EXCUTE_TIME
	 */
	public java.lang.String getExcuteTime () {
		return excuteTime;
	}

	/**
	 * Set the value related to the column: EXCUTE_TIME
	 * @param excuteTime the EXCUTE_TIME value
	 */
	public void setExcuteTime (java.lang.String excuteTime) {
		this.excuteTime = excuteTime;
	}



	/**
	 * Return the value associated with the column: EXCUTE_RESULT
	 */
	public java.lang.String getExcuteResult () {
		return excuteResult;
	}

	/**
	 * Set the value related to the column: EXCUTE_RESULT
	 * @param excuteResult the EXCUTE_RESULT value
	 */
	public void setExcuteResult (java.lang.String excuteResult) {
		this.excuteResult = excuteResult;
	}



	/**
	 * Return the value associated with the column: EXCUTE_OWN
	 */
	public java.lang.String getExcuteOwn () {
		return excuteOwn;
	}

	/**
	 * Set the value related to the column: EXCUTE_OWN
	 * @param excuteOwn the EXCUTE_OWN value
	 */
	public void setExcuteOwn (java.lang.String excuteOwn) {
		this.excuteOwn = excuteOwn;
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
	 * Return the value associated with the column: EXCEPTION_MSG
	 */
	public java.lang.String getExceptionMsg () {
		return exceptionMsg;
	}

	/**
	 * Set the value related to the column: EXCEPTION_MSG
	 * @param exceptionMsg the EXCEPTION_MSG value
	 */
	public void setExceptionMsg (java.lang.String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}



	/**
	 * Return the value associated with the column: END_EXCUTE_FLAG
	 */
	public java.lang.String getEndExcuteFlag () {
		return endExcuteFlag;
	}

	/**
	 * Set the value related to the column: END_EXCUTE_FLAG
	 * @param endExcuteFlag the END_EXCUTE_FLAG value
	 */
	public void setEndExcuteFlag (java.lang.String endExcuteFlag) {
		this.endExcuteFlag = endExcuteFlag;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof TblCronTaskJobLog)) return false;
		else {
			 TblCronTaskJobLog tblCronTaskJobLog = (TblCronTaskJobLog) obj;
			if (null == this.getId() || null == tblCronTaskJobLog.getId()) return false;
			else return (this.getId().equals(tblCronTaskJobLog.getId()));
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