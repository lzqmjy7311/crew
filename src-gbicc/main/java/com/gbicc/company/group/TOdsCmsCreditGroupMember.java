package com.gbicc.company.group;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the T_ODS_CMS_CREDIT_GROUP_MEMBER database table.
 * 
 */
// @Entity
// @Table(name="T_ODS_CMS_CREDIT_GROUP_MEMBER")
// @NamedQuery(name="TOdsCmsCreditGroupMember.findAll",
// query="SELECT t FROM TOdsCmsCreditGroupMember t")
public class TOdsCmsCreditGroupMember implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Column(name="CREDIT_GROUP_LEVEL")
	private String creditGroupLevel;

	// @Column(name="CREDIT_GROUP_MEMBER_ID")
	private String creditGroupMemberId;

	// @Column(name="CREDIT_GROUP_PARTICIPANT_ID")
	private String creditGroupParticipantId;

	// @Column(name="CREDIT_GROUP_REL_INSTRUCT")
	private String creditGroupRelInstruct;

	// @Column(name="CREDIT_GROUP_RELATION_STATUS")
	private String creditGroupRelationStatus;

	// @Column(name="CREDIT_GROUP_SUPERIOR_ID")
	private String creditGroupSuperiorId;

	// @Column(name="CUSTOMER_NUM")
	private String customerNum;

	// @Column(name="EFFECTIVE_FLAG")
	private String effectiveFlag;

	// @Column(name="GROUP_INFO_NUM")
	private String groupInfoNum;

	// @Column(name="GROUP_REL_TYPE_CD")
	private String groupRelTypeCd;

	// @Column(name="IS_CORE_CUSTOMER")
	private String isCoreCustomer;

	// @Column(name="MAINTAIN_ORG_NAME")
	private String maintainOrgName;

	// @Column(name="MAINTAIN_TIME")
	private Timestamp maintainTime;

	// @Column(name="MAINTAIN_TYPE_CD")
	private String maintainTypeCd;

	// @Column(name="MEMBER_TYPE_CD")
	private String memberTypeCd;

	// @Column(name="PARTY_ID")
	private String partyId;

	// @Column(name="RELALATION_REL_ID")
	private String relalationRelId;

	public TOdsCmsCreditGroupMember() {
	}

	public String getCreditGroupLevel() {
		return this.creditGroupLevel;
	}

	public void setCreditGroupLevel(String creditGroupLevel) {
		this.creditGroupLevel = creditGroupLevel;
	}

	public String getCreditGroupMemberId() {
		return this.creditGroupMemberId;
	}

	public void setCreditGroupMemberId(String creditGroupMemberId) {
		this.creditGroupMemberId = creditGroupMemberId;
	}

	public String getCreditGroupParticipantId() {
		return this.creditGroupParticipantId;
	}

	public void setCreditGroupParticipantId(String creditGroupParticipantId) {
		this.creditGroupParticipantId = creditGroupParticipantId;
	}

	public String getCreditGroupRelInstruct() {
		return this.creditGroupRelInstruct;
	}

	public void setCreditGroupRelInstruct(String creditGroupRelInstruct) {
		this.creditGroupRelInstruct = creditGroupRelInstruct;
	}

	public String getCreditGroupRelationStatus() {
		return this.creditGroupRelationStatus;
	}

	public void setCreditGroupRelationStatus(String creditGroupRelationStatus) {
		this.creditGroupRelationStatus = creditGroupRelationStatus;
	}

	public String getCreditGroupSuperiorId() {
		return this.creditGroupSuperiorId;
	}

	public void setCreditGroupSuperiorId(String creditGroupSuperiorId) {
		this.creditGroupSuperiorId = creditGroupSuperiorId;
	}

	public String getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getEffectiveFlag() {
		return this.effectiveFlag;
	}

	public void setEffectiveFlag(String effectiveFlag) {
		this.effectiveFlag = effectiveFlag;
	}

	public String getGroupInfoNum() {
		return this.groupInfoNum;
	}

	public void setGroupInfoNum(String groupInfoNum) {
		this.groupInfoNum = groupInfoNum;
	}

	public String getGroupRelTypeCd() {
		return this.groupRelTypeCd;
	}

	public void setGroupRelTypeCd(String groupRelTypeCd) {
		this.groupRelTypeCd = groupRelTypeCd;
	}

	public String getIsCoreCustomer() {
		return this.isCoreCustomer;
	}

	public void setIsCoreCustomer(String isCoreCustomer) {
		this.isCoreCustomer = isCoreCustomer;
	}

	public String getMaintainOrgName() {
		return this.maintainOrgName;
	}

	public void setMaintainOrgName(String maintainOrgName) {
		this.maintainOrgName = maintainOrgName;
	}

	public Timestamp getMaintainTime() {
		return this.maintainTime;
	}

	public void setMaintainTime(Timestamp maintainTime) {
		this.maintainTime = maintainTime;
	}

	public String getMaintainTypeCd() {
		return this.maintainTypeCd;
	}

	public void setMaintainTypeCd(String maintainTypeCd) {
		this.maintainTypeCd = maintainTypeCd;
	}

	public String getMemberTypeCd() {
		return this.memberTypeCd;
	}

	public void setMemberTypeCd(String memberTypeCd) {
		this.memberTypeCd = memberTypeCd;
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getRelalationRelId() {
		return this.relalationRelId;
	}

	public void setRelalationRelId(String relalationRelId) {
		this.relalationRelId = relalationRelId;
	}

}