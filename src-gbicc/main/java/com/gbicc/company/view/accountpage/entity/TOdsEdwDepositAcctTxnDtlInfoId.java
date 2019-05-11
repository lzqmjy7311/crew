package com.gbicc.company.view.accountpage.entity;

// default package
// Generated 2016-8-16 8:24:36 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TOdsEdwDepositAcctTxnDtlInfoId generated by hbm2java
 */
public class TOdsEdwDepositAcctTxnDtlInfoId implements java.io.Serializable {

	private String txnSerialId;
	private String recdId;


	public TOdsEdwDepositAcctTxnDtlInfoId() {
	}

	public TOdsEdwDepositAcctTxnDtlInfoId(String txnSerialId, String recdId) {
		this.txnSerialId = txnSerialId;
		this.recdId = recdId;
	}

	public String getTxnSerialId() {
		return this.txnSerialId;
	}

	public void setTxnSerialId(String txnSerialId) {
		this.txnSerialId = txnSerialId;
	}

	public String getRecdId() {
		return this.recdId;
	}

	public void setRecdId(String recdId) {
		this.recdId = recdId;
	}


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TOdsEdwDepositAcctTxnDtlInfoId))
			return false;
		TOdsEdwDepositAcctTxnDtlInfoId castOther = (TOdsEdwDepositAcctTxnDtlInfoId) other;

		return ((this.getTxnSerialId() == castOther.getTxnSerialId()) || (this
				.getTxnSerialId() != null && castOther.getTxnSerialId() != null && this
				.getTxnSerialId().equals(castOther.getTxnSerialId())))
				&& ((this.getRecdId() == castOther.getRecdId()) || (this
						.getRecdId() != null && castOther.getRecdId() != null && this
						.getRecdId().equals(castOther.getRecdId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTxnSerialId() == null ? 0 : this.getTxnSerialId()
						.hashCode());
		result = 37 * result
				+ (getRecdId() == null ? 0 : this.getRecdId().hashCode());
		return result;
	}

}
