package com.gbicc.company.single.outputentity;
// Generated 2016-1-12 19:22:04 by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;

/**
 * TRewC03ContractId generated by hbm2java
 */
public class C03  implements java.io.Serializable {

	private static final long serialVersionUID = 4537546207024174086L;
	
	/*
    */
    private String contractId;
    /*
    */
    private String contractNum;
    /*
    */
    private String contractManualNum;
    /*
    */
    private String customerNum;
    /*
    */
    private String bizNum;
    /*
    */
    private String creditLimitNum;
    /*
    */
    private String contractSignDate;
    /*
    */
    private String comprBizContractInd;
    /*
    */
    private String creditProductCd;
    /*
    */
    private String superContractNum;
    /*
    */
    private String currencyCd;
    /*
    */
    private BigDecimal contractTotalAmt;
    /*
    */
    private String approveNum;
    /*
    */
    private String startDate;
    /*
    */
    private String expirationDate;
    /*
    */
    private Integer contractTerm;
    /*
    */
    private String contractLoanCd;
    /*
    */
    private String contractProvidePurpose;
    /*
    */
    private BigDecimal exchangeRate;
    /*
    */
    private Integer remitPSum;
    /*
    */
    private String contractTypeCd;
    /*
    */
    private String contractNatureCd;
    /*
    */
    private String contractStatusCd;
    /*
    */
    private String contractTerminationWayCd;
    /*
    */
    private String lowRiskInd;
    /*
    */
    private String lowRiskBizTypeCd;
    /*
    */
    private String contractCycleInd;
    /*
    */
    private String contractTerminationDate;
    /*
    */
    private String handlingOrgCd;
    /*
    */
    private String handlingUserNum;
    /*
    */
    private String disbOrgCd;
    /*
    */
    private String transferedToWrInd;
    /*
    */
    private String ifCorpHoustLoan;
    /*
    */
    private String wrOrgCd;
    /*
    */
    private String classificationResult;
    /*
    */
    private String originalGuarantyContractNum;
    /*
    */
    private String topGuarantyInd;
    /*
    */
    private String originalContractManualNum;
    /*
    */
    private String extendField;
    /*
    */
    private String extendFlagField;
    /*
    */
    private String partyId;
    /*
    */
    private String creditLimitId;
    /*
    */
    private String bizId;
    /*
    */
    private String freezenInd;
    /*
    */
    private String lcNum;
    /*
    */
    private String lastMaintainDate;
    /*
    */
    private String loanTypeInstructionCd;
    /*
    */
    private String debtReformTypeCd;
    /*
    */
    private String postPonementTypeCd;
    /*
    */
    private String contractSignPlace;
    /*
    */
    private String contractOtherCondition;
    /*
    */
    private String contractSupplement;
    /*
    */
    private BigDecimal payDiscountAmt;
    /*
    */
    private String topFinancingStartDate;
    /*
    */
    private String topFinancingEndDate;
    /*
    */
    private Integer shortOperationMatureTerm;
    /*
    */
    private String firstPayStartTerm;
    /*
    */
    private Integer tipFinancingAmtTerm;
    /*
    */
    private String mainSuretyMode;
    /*
    */
    private String mainSuertySubchild;
    /*
    */
    private String otherBankSuertyMode;
    /*
    */
    private String otherBankSuertySubchild;
    /*
    */
    private String suertyCd;
    /*
    */
    private String prerequisitionComment;
    /*
    */
    private String guarantyNote;
    /*
    */
    private String guarantyType;
    /*
    */
    private String reportSuertyMode;
    /*
    */
    private String reportSuertySubchild;
    /*
    */
    private String contractChangeInd;
    /*
    */
    private BigDecimal guarantyRate;
    /*
    */
    private Integer widthTerm;
    /*
    */
    private BigDecimal promisesAmt;
    /*
    */
    private String promisesAmtCollectionType;
    /*
    */
    private String yhCurrencyCd;
    /*
    */
    private String termEndDate;
    /*
    */
    private String relaBizNum;
    /*
    */
    private String payoutApproveLevel;
    /*
    */
    private String gdTemp1;
    /*
    */
    private String gdTemp2;
    /*
    */
    private String oldContractDetailId;
    /*
    */
    private String originalContractExpDate;
    /*
    */
    private String postponementInd;
    /*
    */
    private String oldBizDetailId;
    /*
    */
    private String bankTeamRole;
    /*
    */
    private String noteCustomerNum;
    /*
    */
    private String peasantLoanType;
    /*
    */
    private String payoutInd;
    /*
    */
    private String reformLoanInd;
    /*
    */
    private String representModalityInd;
    /*
    */
    private String industryLevelTwoCd;
    /*
    */
    private String restrictIndustryInd;
    /*
    */
    private String realtyLoanType;
    /*
    */
    private String realtyLoanTypeInd;
    /*
    */
    private String agriForeAnimFishLoanType;
    /*
    */
    private String govCreditType;
    /*
    */
    private String loanLendSourceType;
    /*
    */
    private String exportPresentNum;
    /*
    */
    private BigDecimal assureAddAmt;
    /*
    */
    private String assureEndDate;
    /*
    */
    private String exportCurrencyCd;
    /*
    */
    private BigDecimal exportAmt;
    /*
    */
    private String paymentBank;
    /*
    */
    private BigDecimal ourbankBuyAmt;
    /*
    */
    private String forfaitingType;
    /*
    */
    private BigDecimal assureAddAmtMod;
    /*
    */
    private String adjustInd;
    /*
    */
    private String custname;
    /*
    * 预警表ID.
    */
    private String warnId;
    /*
    * 数据日期.
    */
    private String dataDt;

    public C03() {
    }

    public C03(String contractId) {
        this.contractId = contractId;
    }
   
	/**
    */	
    public String getContractId() {
        return this.contractId;
    }
	/**
    */	
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
	/**
    */	
    public String getContractNum() {
        return this.contractNum;
    }
	/**
    */	
    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }
	/**
    */	
    public String getContractManualNum() {
        return this.contractManualNum;
    }
	/**
    */	
    public void setContractManualNum(String contractManualNum) {
        this.contractManualNum = contractManualNum;
    }
	/**
    */	
    public String getCustomerNum() {
        return this.customerNum;
    }
	/**
    */	
    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }
	/**
    */	
    public String getBizNum() {
        return this.bizNum;
    }
	/**
    */	
    public void setBizNum(String bizNum) {
        this.bizNum = bizNum;
    }
	/**
    */	
    public String getCreditLimitNum() {
        return this.creditLimitNum;
    }
	/**
    */	
    public void setCreditLimitNum(String creditLimitNum) {
        this.creditLimitNum = creditLimitNum;
    }
	/**
    */	
    public String getContractSignDate() {
        return this.contractSignDate;
    }
	/**
    */	
    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }
	/**
    */	
    public String getComprBizContractInd() {
        return this.comprBizContractInd;
    }
	/**
    */	
    public void setComprBizContractInd(String comprBizContractInd) {
        this.comprBizContractInd = comprBizContractInd;
    }
	/**
    */	
    public String getCreditProductCd() {
        return this.creditProductCd;
    }
	/**
    */	
    public void setCreditProductCd(String creditProductCd) {
        this.creditProductCd = creditProductCd;
    }
	/**
    */	
    public String getSuperContractNum() {
        return this.superContractNum;
    }
	/**
    */	
    public void setSuperContractNum(String superContractNum) {
        this.superContractNum = superContractNum;
    }
	/**
    */	
    public String getCurrencyCd() {
        return this.currencyCd;
    }
	/**
    */	
    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }
	/**
    */	
    public BigDecimal getContractTotalAmt() {
        return this.contractTotalAmt;
    }
	/**
    */	
    public void setContractTotalAmt(BigDecimal contractTotalAmt) {
        this.contractTotalAmt = contractTotalAmt;
    }
	/**
    */	
    public String getApproveNum() {
        return this.approveNum;
    }
	/**
    */	
    public void setApproveNum(String approveNum) {
        this.approveNum = approveNum;
    }
	/**
    */	
    public String getStartDate() {
        return this.startDate;
    }
	/**
    */	
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
	/**
    */	
    public String getExpirationDate() {
        return this.expirationDate;
    }
	/**
    */	
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
	/**
    */	
    public Integer getContractTerm() {
        return this.contractTerm;
    }
	/**
    */	
    public void setContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
    }
	/**
    */	
    public String getContractLoanCd() {
        return this.contractLoanCd;
    }
	/**
    */	
    public void setContractLoanCd(String contractLoanCd) {
        this.contractLoanCd = contractLoanCd;
    }
	/**
    */	
    public String getContractProvidePurpose() {
        return this.contractProvidePurpose;
    }
	/**
    */	
    public void setContractProvidePurpose(String contractProvidePurpose) {
        this.contractProvidePurpose = contractProvidePurpose;
    }
	/**
    */	
    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }
	/**
    */	
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
	/**
    */	
    public Integer getRemitPSum() {
        return this.remitPSum;
    }
	/**
    */	
    public void setRemitPSum(Integer remitPSum) {
        this.remitPSum = remitPSum;
    }
	/**
    */	
    public String getContractTypeCd() {
        return this.contractTypeCd;
    }
	/**
    */	
    public void setContractTypeCd(String contractTypeCd) {
        this.contractTypeCd = contractTypeCd;
    }
	/**
    */	
    public String getContractNatureCd() {
        return this.contractNatureCd;
    }
	/**
    */	
    public void setContractNatureCd(String contractNatureCd) {
        this.contractNatureCd = contractNatureCd;
    }
	/**
    */	
    public String getContractStatusCd() {
        return this.contractStatusCd;
    }
	/**
    */	
    public void setContractStatusCd(String contractStatusCd) {
        this.contractStatusCd = contractStatusCd;
    }
	/**
    */	
    public String getContractTerminationWayCd() {
        return this.contractTerminationWayCd;
    }
	/**
    */	
    public void setContractTerminationWayCd(String contractTerminationWayCd) {
        this.contractTerminationWayCd = contractTerminationWayCd;
    }
	/**
    */	
    public String getLowRiskInd() {
        return this.lowRiskInd;
    }
	/**
    */	
    public void setLowRiskInd(String lowRiskInd) {
        this.lowRiskInd = lowRiskInd;
    }
	/**
    */	
    public String getLowRiskBizTypeCd() {
        return this.lowRiskBizTypeCd;
    }
	/**
    */	
    public void setLowRiskBizTypeCd(String lowRiskBizTypeCd) {
        this.lowRiskBizTypeCd = lowRiskBizTypeCd;
    }
	/**
    */	
    public String getContractCycleInd() {
        return this.contractCycleInd;
    }
	/**
    */	
    public void setContractCycleInd(String contractCycleInd) {
        this.contractCycleInd = contractCycleInd;
    }
	/**
    */	
    public String getContractTerminationDate() {
        return this.contractTerminationDate;
    }
	/**
    */	
    public void setContractTerminationDate(String contractTerminationDate) {
        this.contractTerminationDate = contractTerminationDate;
    }
	/**
    */	
    public String getHandlingOrgCd() {
        return this.handlingOrgCd;
    }
	/**
    */	
    public void setHandlingOrgCd(String handlingOrgCd) {
        this.handlingOrgCd = handlingOrgCd;
    }
	/**
    */	
    public String getHandlingUserNum() {
        return this.handlingUserNum;
    }
	/**
    */	
    public void setHandlingUserNum(String handlingUserNum) {
        this.handlingUserNum = handlingUserNum;
    }
	/**
    */	
    public String getDisbOrgCd() {
        return this.disbOrgCd;
    }
	/**
    */	
    public void setDisbOrgCd(String disbOrgCd) {
        this.disbOrgCd = disbOrgCd;
    }
	/**
    */	
    public String getTransferedToWrInd() {
        return this.transferedToWrInd;
    }
	/**
    */	
    public void setTransferedToWrInd(String transferedToWrInd) {
        this.transferedToWrInd = transferedToWrInd;
    }
	/**
    */	
    public String getIfCorpHoustLoan() {
        return this.ifCorpHoustLoan;
    }
	/**
    */	
    public void setIfCorpHoustLoan(String ifCorpHoustLoan) {
        this.ifCorpHoustLoan = ifCorpHoustLoan;
    }
	/**
    */	
    public String getWrOrgCd() {
        return this.wrOrgCd;
    }
	/**
    */	
    public void setWrOrgCd(String wrOrgCd) {
        this.wrOrgCd = wrOrgCd;
    }
	/**
    */	
    public String getClassificationResult() {
        return this.classificationResult;
    }
	/**
    */	
    public void setClassificationResult(String classificationResult) {
        this.classificationResult = classificationResult;
    }
	/**
    */	
    public String getOriginalGuarantyContractNum() {
        return this.originalGuarantyContractNum;
    }
	/**
    */	
    public void setOriginalGuarantyContractNum(String originalGuarantyContractNum) {
        this.originalGuarantyContractNum = originalGuarantyContractNum;
    }
	/**
    */	
    public String getTopGuarantyInd() {
        return this.topGuarantyInd;
    }
	/**
    */	
    public void setTopGuarantyInd(String topGuarantyInd) {
        this.topGuarantyInd = topGuarantyInd;
    }
	/**
    */	
    public String getOriginalContractManualNum() {
        return this.originalContractManualNum;
    }
	/**
    */	
    public void setOriginalContractManualNum(String originalContractManualNum) {
        this.originalContractManualNum = originalContractManualNum;
    }
	/**
    */	
    public String getExtendField() {
        return this.extendField;
    }
	/**
    */	
    public void setExtendField(String extendField) {
        this.extendField = extendField;
    }
	/**
    */	
    public String getExtendFlagField() {
        return this.extendFlagField;
    }
	/**
    */	
    public void setExtendFlagField(String extendFlagField) {
        this.extendFlagField = extendFlagField;
    }
	/**
    */	
    public String getPartyId() {
        return this.partyId;
    }
	/**
    */	
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
	/**
    */	
    public String getCreditLimitId() {
        return this.creditLimitId;
    }
	/**
    */	
    public void setCreditLimitId(String creditLimitId) {
        this.creditLimitId = creditLimitId;
    }
	/**
    */	
    public String getBizId() {
        return this.bizId;
    }
	/**
    */	
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
	/**
    */	
    public String getFreezenInd() {
        return this.freezenInd;
    }
	/**
    */	
    public void setFreezenInd(String freezenInd) {
        this.freezenInd = freezenInd;
    }
	/**
    */	
    public String getLcNum() {
        return this.lcNum;
    }
	/**
    */	
    public void setLcNum(String lcNum) {
        this.lcNum = lcNum;
    }
	/**
    */	
    public String getLastMaintainDate() {
        return this.lastMaintainDate;
    }
	/**
    */	
    public void setLastMaintainDate(String lastMaintainDate) {
        this.lastMaintainDate = lastMaintainDate;
    }
	/**
    */	
    public String getLoanTypeInstructionCd() {
        return this.loanTypeInstructionCd;
    }
	/**
    */	
    public void setLoanTypeInstructionCd(String loanTypeInstructionCd) {
        this.loanTypeInstructionCd = loanTypeInstructionCd;
    }
	/**
    */	
    public String getDebtReformTypeCd() {
        return this.debtReformTypeCd;
    }
	/**
    */	
    public void setDebtReformTypeCd(String debtReformTypeCd) {
        this.debtReformTypeCd = debtReformTypeCd;
    }
	/**
    */	
    public String getPostPonementTypeCd() {
        return this.postPonementTypeCd;
    }
	/**
    */	
    public void setPostPonementTypeCd(String postPonementTypeCd) {
        this.postPonementTypeCd = postPonementTypeCd;
    }
	/**
    */	
    public String getContractSignPlace() {
        return this.contractSignPlace;
    }
	/**
    */	
    public void setContractSignPlace(String contractSignPlace) {
        this.contractSignPlace = contractSignPlace;
    }
	/**
    */	
    public String getContractOtherCondition() {
        return this.contractOtherCondition;
    }
	/**
    */	
    public void setContractOtherCondition(String contractOtherCondition) {
        this.contractOtherCondition = contractOtherCondition;
    }
	/**
    */	
    public String getContractSupplement() {
        return this.contractSupplement;
    }
	/**
    */	
    public void setContractSupplement(String contractSupplement) {
        this.contractSupplement = contractSupplement;
    }
	/**
    */	
    public BigDecimal getPayDiscountAmt() {
        return this.payDiscountAmt;
    }
	/**
    */	
    public void setPayDiscountAmt(BigDecimal payDiscountAmt) {
        this.payDiscountAmt = payDiscountAmt;
    }
	/**
    */	
    public String getTopFinancingStartDate() {
        return this.topFinancingStartDate;
    }
	/**
    */	
    public void setTopFinancingStartDate(String topFinancingStartDate) {
        this.topFinancingStartDate = topFinancingStartDate;
    }
	/**
    */	
    public String getTopFinancingEndDate() {
        return this.topFinancingEndDate;
    }
	/**
    */	
    public void setTopFinancingEndDate(String topFinancingEndDate) {
        this.topFinancingEndDate = topFinancingEndDate;
    }
	/**
    */	
    public Integer getShortOperationMatureTerm() {
        return this.shortOperationMatureTerm;
    }
	/**
    */	
    public void setShortOperationMatureTerm(Integer shortOperationMatureTerm) {
        this.shortOperationMatureTerm = shortOperationMatureTerm;
    }
	/**
    */	
    public String getFirstPayStartTerm() {
        return this.firstPayStartTerm;
    }
	/**
    */	
    public void setFirstPayStartTerm(String firstPayStartTerm) {
        this.firstPayStartTerm = firstPayStartTerm;
    }
	/**
    */	
    public Integer getTipFinancingAmtTerm() {
        return this.tipFinancingAmtTerm;
    }
	/**
    */	
    public void setTipFinancingAmtTerm(Integer tipFinancingAmtTerm) {
        this.tipFinancingAmtTerm = tipFinancingAmtTerm;
    }
	/**
    */	
    public String getMainSuretyMode() {
        return this.mainSuretyMode;
    }
	/**
    */	
    public void setMainSuretyMode(String mainSuretyMode) {
        this.mainSuretyMode = mainSuretyMode;
    }
	/**
    */	
    public String getMainSuertySubchild() {
        return this.mainSuertySubchild;
    }
	/**
    */	
    public void setMainSuertySubchild(String mainSuertySubchild) {
        this.mainSuertySubchild = mainSuertySubchild;
    }
	/**
    */	
    public String getOtherBankSuertyMode() {
        return this.otherBankSuertyMode;
    }
	/**
    */	
    public void setOtherBankSuertyMode(String otherBankSuertyMode) {
        this.otherBankSuertyMode = otherBankSuertyMode;
    }
	/**
    */	
    public String getOtherBankSuertySubchild() {
        return this.otherBankSuertySubchild;
    }
	/**
    */	
    public void setOtherBankSuertySubchild(String otherBankSuertySubchild) {
        this.otherBankSuertySubchild = otherBankSuertySubchild;
    }
	/**
    */	
    public String getSuertyCd() {
        return this.suertyCd;
    }
	/**
    */	
    public void setSuertyCd(String suertyCd) {
        this.suertyCd = suertyCd;
    }
	/**
    */	
    public String getPrerequisitionComment() {
        return this.prerequisitionComment;
    }
	/**
    */	
    public void setPrerequisitionComment(String prerequisitionComment) {
        this.prerequisitionComment = prerequisitionComment;
    }
	/**
    */	
    public String getGuarantyNote() {
        return this.guarantyNote;
    }
	/**
    */	
    public void setGuarantyNote(String guarantyNote) {
        this.guarantyNote = guarantyNote;
    }
	/**
    */	
    public String getGuarantyType() {
        return this.guarantyType;
    }
	/**
    */	
    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType;
    }
	/**
    */	
    public String getReportSuertyMode() {
        return this.reportSuertyMode;
    }
	/**
    */	
    public void setReportSuertyMode(String reportSuertyMode) {
        this.reportSuertyMode = reportSuertyMode;
    }
	/**
    */	
    public String getReportSuertySubchild() {
        return this.reportSuertySubchild;
    }
	/**
    */	
    public void setReportSuertySubchild(String reportSuertySubchild) {
        this.reportSuertySubchild = reportSuertySubchild;
    }
	/**
    */	
    public String getContractChangeInd() {
        return this.contractChangeInd;
    }
	/**
    */	
    public void setContractChangeInd(String contractChangeInd) {
        this.contractChangeInd = contractChangeInd;
    }
	/**
    */	
    public BigDecimal getGuarantyRate() {
        return this.guarantyRate;
    }
	/**
    */	
    public void setGuarantyRate(BigDecimal guarantyRate) {
        this.guarantyRate = guarantyRate;
    }
	/**
    */	
    public Integer getWidthTerm() {
        return this.widthTerm;
    }
	/**
    */	
    public void setWidthTerm(Integer widthTerm) {
        this.widthTerm = widthTerm;
    }
	/**
    */	
    public BigDecimal getPromisesAmt() {
        return this.promisesAmt;
    }
	/**
    */	
    public void setPromisesAmt(BigDecimal promisesAmt) {
        this.promisesAmt = promisesAmt;
    }
	/**
    */	
    public String getPromisesAmtCollectionType() {
        return this.promisesAmtCollectionType;
    }
	/**
    */	
    public void setPromisesAmtCollectionType(String promisesAmtCollectionType) {
        this.promisesAmtCollectionType = promisesAmtCollectionType;
    }
	/**
    */	
    public String getYhCurrencyCd() {
        return this.yhCurrencyCd;
    }
	/**
    */	
    public void setYhCurrencyCd(String yhCurrencyCd) {
        this.yhCurrencyCd = yhCurrencyCd;
    }
	/**
    */	
    public String getTermEndDate() {
        return this.termEndDate;
    }
	/**
    */	
    public void setTermEndDate(String termEndDate) {
        this.termEndDate = termEndDate;
    }
	/**
    */	
    public String getRelaBizNum() {
        return this.relaBizNum;
    }
	/**
    */	
    public void setRelaBizNum(String relaBizNum) {
        this.relaBizNum = relaBizNum;
    }
	/**
    */	
    public String getPayoutApproveLevel() {
        return this.payoutApproveLevel;
    }
	/**
    */	
    public void setPayoutApproveLevel(String payoutApproveLevel) {
        this.payoutApproveLevel = payoutApproveLevel;
    }
	/**
    */	
    public String getGdTemp1() {
        return this.gdTemp1;
    }
	/**
    */	
    public void setGdTemp1(String gdTemp1) {
        this.gdTemp1 = gdTemp1;
    }
	/**
    */	
    public String getGdTemp2() {
        return this.gdTemp2;
    }
	/**
    */	
    public void setGdTemp2(String gdTemp2) {
        this.gdTemp2 = gdTemp2;
    }
	/**
    */	
    public String getOldContractDetailId() {
        return this.oldContractDetailId;
    }
	/**
    */	
    public void setOldContractDetailId(String oldContractDetailId) {
        this.oldContractDetailId = oldContractDetailId;
    }
	/**
    */	
    public String getOriginalContractExpDate() {
        return this.originalContractExpDate;
    }
	/**
    */	
    public void setOriginalContractExpDate(String originalContractExpDate) {
        this.originalContractExpDate = originalContractExpDate;
    }
	/**
    */	
    public String getPostponementInd() {
        return this.postponementInd;
    }
	/**
    */	
    public void setPostponementInd(String postponementInd) {
        this.postponementInd = postponementInd;
    }
	/**
    */	
    public String getOldBizDetailId() {
        return this.oldBizDetailId;
    }
	/**
    */	
    public void setOldBizDetailId(String oldBizDetailId) {
        this.oldBizDetailId = oldBizDetailId;
    }
	/**
    */	
    public String getBankTeamRole() {
        return this.bankTeamRole;
    }
	/**
    */	
    public void setBankTeamRole(String bankTeamRole) {
        this.bankTeamRole = bankTeamRole;
    }
	/**
    */	
    public String getNoteCustomerNum() {
        return this.noteCustomerNum;
    }
	/**
    */	
    public void setNoteCustomerNum(String noteCustomerNum) {
        this.noteCustomerNum = noteCustomerNum;
    }
	/**
    */	
    public String getPeasantLoanType() {
        return this.peasantLoanType;
    }
	/**
    */	
    public void setPeasantLoanType(String peasantLoanType) {
        this.peasantLoanType = peasantLoanType;
    }
	/**
    */	
    public String getPayoutInd() {
        return this.payoutInd;
    }
	/**
    */	
    public void setPayoutInd(String payoutInd) {
        this.payoutInd = payoutInd;
    }
	/**
    */	
    public String getReformLoanInd() {
        return this.reformLoanInd;
    }
	/**
    */	
    public void setReformLoanInd(String reformLoanInd) {
        this.reformLoanInd = reformLoanInd;
    }
	/**
    */	
    public String getRepresentModalityInd() {
        return this.representModalityInd;
    }
	/**
    */	
    public void setRepresentModalityInd(String representModalityInd) {
        this.representModalityInd = representModalityInd;
    }
	/**
    */	
    public String getIndustryLevelTwoCd() {
        return this.industryLevelTwoCd;
    }
	/**
    */	
    public void setIndustryLevelTwoCd(String industryLevelTwoCd) {
        this.industryLevelTwoCd = industryLevelTwoCd;
    }
	/**
    */	
    public String getRestrictIndustryInd() {
        return this.restrictIndustryInd;
    }
	/**
    */	
    public void setRestrictIndustryInd(String restrictIndustryInd) {
        this.restrictIndustryInd = restrictIndustryInd;
    }
	/**
    */	
    public String getRealtyLoanType() {
        return this.realtyLoanType;
    }
	/**
    */	
    public void setRealtyLoanType(String realtyLoanType) {
        this.realtyLoanType = realtyLoanType;
    }
	/**
    */	
    public String getRealtyLoanTypeInd() {
        return this.realtyLoanTypeInd;
    }
	/**
    */	
    public void setRealtyLoanTypeInd(String realtyLoanTypeInd) {
        this.realtyLoanTypeInd = realtyLoanTypeInd;
    }
	/**
    */	
    public String getAgriForeAnimFishLoanType() {
        return this.agriForeAnimFishLoanType;
    }
	/**
    */	
    public void setAgriForeAnimFishLoanType(String agriForeAnimFishLoanType) {
        this.agriForeAnimFishLoanType = agriForeAnimFishLoanType;
    }
	/**
    */	
    public String getGovCreditType() {
        return this.govCreditType;
    }
	/**
    */	
    public void setGovCreditType(String govCreditType) {
        this.govCreditType = govCreditType;
    }
	/**
    */	
    public String getLoanLendSourceType() {
        return this.loanLendSourceType;
    }
	/**
    */	
    public void setLoanLendSourceType(String loanLendSourceType) {
        this.loanLendSourceType = loanLendSourceType;
    }
	/**
    */	
    public String getExportPresentNum() {
        return this.exportPresentNum;
    }
	/**
    */	
    public void setExportPresentNum(String exportPresentNum) {
        this.exportPresentNum = exportPresentNum;
    }
	/**
    */	
    public BigDecimal getAssureAddAmt() {
        return this.assureAddAmt;
    }
	/**
    */	
    public void setAssureAddAmt(BigDecimal assureAddAmt) {
        this.assureAddAmt = assureAddAmt;
    }
	/**
    */	
    public String getAssureEndDate() {
        return this.assureEndDate;
    }
	/**
    */	
    public void setAssureEndDate(String assureEndDate) {
        this.assureEndDate = assureEndDate;
    }
	/**
    */	
    public String getExportCurrencyCd() {
        return this.exportCurrencyCd;
    }
	/**
    */	
    public void setExportCurrencyCd(String exportCurrencyCd) {
        this.exportCurrencyCd = exportCurrencyCd;
    }
	/**
    */	
    public BigDecimal getExportAmt() {
        return this.exportAmt;
    }
	/**
    */	
    public void setExportAmt(BigDecimal exportAmt) {
        this.exportAmt = exportAmt;
    }
	/**
    */	
    public String getPaymentBank() {
        return this.paymentBank;
    }
	/**
    */	
    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }
	/**
    */	
    public BigDecimal getOurbankBuyAmt() {
        return this.ourbankBuyAmt;
    }
	/**
    */	
    public void setOurbankBuyAmt(BigDecimal ourbankBuyAmt) {
        this.ourbankBuyAmt = ourbankBuyAmt;
    }
	/**
    */	
    public String getForfaitingType() {
        return this.forfaitingType;
    }
	/**
    */	
    public void setForfaitingType(String forfaitingType) {
        this.forfaitingType = forfaitingType;
    }
	/**
    */	
    public BigDecimal getAssureAddAmtMod() {
        return this.assureAddAmtMod;
    }
	/**
    */	
    public void setAssureAddAmtMod(BigDecimal assureAddAmtMod) {
        this.assureAddAmtMod = assureAddAmtMod;
    }
	/**
    */	
    public String getAdjustInd() {
        return this.adjustInd;
    }
	/**
    */	
    public void setAdjustInd(String adjustInd) {
        this.adjustInd = adjustInd;
    }
	/**
    */	
    public String getCustname() {
        return this.custname;
    }
	/**
    */	
    public void setCustname(String custname) {
        this.custname = custname;
    }
	/**
    * Get the 预警表ID
    */	
    public String getWarnId() {
        return this.warnId;
    }
	/**
    * Set the 预警表ID
    */	
    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }
	/**
    * Get the 数据日期
    */	
    public String getDataDt() {
        return this.dataDt;
    }
	/**
    * Set the 数据日期
    */	
    public void setDataDt(String dataDt) {
        this.dataDt = dataDt;
    }
}