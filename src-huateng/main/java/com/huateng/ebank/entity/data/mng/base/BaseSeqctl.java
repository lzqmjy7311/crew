package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SEQCTL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SEQCTL"
 */

public abstract class BaseSeqctl  implements  Serializable {

	public static String REF = "Seqctl";
	public static String PROP_MIN_VALUE = "minValue";
	public static String PROP_VALUE_INDEX = "valueIndex";
	public static String PROP_VALUE_NO = "valueNo";
	public static String PROP_MAX_VALUE = "maxValue";
	public static String PROP_VALUE_CURR = "valueCurr";
	public static String PROP_ID = "id";


	// constructors
	public BaseSeqctl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSeqctl (String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String id;

	// fields
	private java.lang.Integer valueNo;
	private java.lang.String valueIndex;
	private java.lang.Integer valueCurr;
	private java.lang.Integer maxValue;
	private java.lang.Integer minValue;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
     */
	public String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: VALUE_NO
	 */
	public java.lang.Integer getValueNo () {
		return valueNo;
	}

	/**
	 * Set the value related to the column: VALUE_NO
	 * @param valueNo the VALUE_NO value
	 */
	public void setValueNo (java.lang.Integer valueNo) {
		this.valueNo = valueNo;
	}



	/**
	 * Return the value associated with the column: VALUE_INDEX
	 */
	public java.lang.String getValueIndex () {
		return valueIndex;
	}

	/**
	 * Set the value related to the column: VALUE_INDEX
	 * @param valueIndex the VALUE_INDEX value
	 */
	public void setValueIndex (java.lang.String valueIndex) {
		this.valueIndex = valueIndex;
	}



	/**
	 * Return the value associated with the column: VALUE_CURR
	 */
	public java.lang.Integer getValueCurr () {
		return valueCurr;
	}

	/**
	 * Set the value related to the column: VALUE_CURR
	 * @param valueCurr the VALUE_CURR value
	 */
	public void setValueCurr (java.lang.Integer valueCurr) {
		this.valueCurr = valueCurr;
	}



	/**
	 * Return the value associated with the column: MAX_VALUE
	 */
	public java.lang.Integer getMaxValue () {
		return maxValue;
	}

	/**
	 * Set the value related to the column: MAX_VALUE
	 * @param maxValue the MAX_VALUE value
	 */
	public void setMaxValue (java.lang.Integer maxValue) {
		this.maxValue = maxValue;
	}



	/**
	 * Return the value associated with the column: MIN_VALUE
	 */
	public java.lang.Integer getMinValue () {
		return minValue;
	}

	/**
	 * Set the value related to the column: MIN_VALUE
	 * @param minValue the MIN_VALUE value
	 */
	public void setMinValue (java.lang.Integer minValue) {
		this.minValue = minValue;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.Seqctl)) return false;
		else {
			com.huateng.ebank.entity.data.mng.Seqctl seqctl = (com.huateng.ebank.entity.data.mng.Seqctl) obj;
			return (this.getId().equals(seqctl.getId()));
		}
	}

	public int hashCode () {
		
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