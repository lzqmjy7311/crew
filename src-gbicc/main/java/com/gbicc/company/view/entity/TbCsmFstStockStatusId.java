package com.gbicc.company.view.entity;
// Generated 2015-11-30 17:00:32 by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;

/**
 * TbCsmFstStockStatusId generated by hbm2java
 */
public class TbCsmFstStockStatusId  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
    /*
    */
    private String firstCustomerStockId;
    /*
    */
    private String customerNum;
    /*
    */
    private String stockholderName;
    /*
    */
    private BigDecimal totalInvest;
    /*
    */
    private String certificateTypeCd;
    /*
    */
    private BigDecimal holdingStockRate;
    /*
    */
    private String firstCustomerId;
    /*
    */
    private String certificateNum;
    /*
    */
    private String currencyCd;

    public TbCsmFstStockStatusId() {
    }

	
    public TbCsmFstStockStatusId(String firstCustomerStockId) {
        this.firstCustomerStockId = firstCustomerStockId;
    }
    public TbCsmFstStockStatusId(String firstCustomerStockId, String customerNum, String stockholderName, BigDecimal totalInvest, String certificateTypeCd, BigDecimal holdingStockRate, String firstCustomerId, String certificateNum, String currencyCd) {
       this.firstCustomerStockId = firstCustomerStockId;
       this.customerNum = customerNum;
       this.stockholderName = stockholderName;
       this.totalInvest = totalInvest;
       this.certificateTypeCd = certificateTypeCd;
       this.holdingStockRate = holdingStockRate;
       this.firstCustomerId = firstCustomerId;
       this.certificateNum = certificateNum;
       this.currencyCd = currencyCd;
    }
   
    public String getFirstCustomerStockId() {
        return this.firstCustomerStockId;
    }
    
    public void setFirstCustomerStockId(String firstCustomerStockId) {
        this.firstCustomerStockId = firstCustomerStockId;
    }
    public String getCustomerNum() {
        return this.customerNum;
    }
    
    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }
    public String getStockholderName() {
        return this.stockholderName;
    }
    
    public void setStockholderName(String stockholderName) {
        this.stockholderName = stockholderName;
    }
    public BigDecimal getTotalInvest() {
        return this.totalInvest;
    }
    
    public void setTotalInvest(BigDecimal totalInvest) {
        this.totalInvest = totalInvest;
    }
    public String getCertificateTypeCd() {
        return this.certificateTypeCd;
    }
    
    public void setCertificateTypeCd(String certificateTypeCd) {
        this.certificateTypeCd = certificateTypeCd;
    }
    public BigDecimal getHoldingStockRate() {
        return this.holdingStockRate;
    }
    
    public void setHoldingStockRate(BigDecimal holdingStockRate) {
        this.holdingStockRate = holdingStockRate;
    }
    public String getFirstCustomerId() {
        return this.firstCustomerId;
    }
    
    public void setFirstCustomerId(String firstCustomerId) {
        this.firstCustomerId = firstCustomerId;
    }
    public String getCertificateNum() {
        return this.certificateNum;
    }
    
    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }
    public String getCurrencyCd() {
        return this.currencyCd;
    }
    
    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TbCsmFstStockStatusId) ) return false;
		 TbCsmFstStockStatusId castOther = ( TbCsmFstStockStatusId ) other; 
         
		 return ( (this.getFirstCustomerStockId()==castOther.getFirstCustomerStockId()) || ( this.getFirstCustomerStockId()!=null && castOther.getFirstCustomerStockId()!=null && this.getFirstCustomerStockId().equals(castOther.getFirstCustomerStockId()) ) )
 && ( (this.getCustomerNum()==castOther.getCustomerNum()) || ( this.getCustomerNum()!=null && castOther.getCustomerNum()!=null && this.getCustomerNum().equals(castOther.getCustomerNum()) ) )
 && ( (this.getStockholderName()==castOther.getStockholderName()) || ( this.getStockholderName()!=null && castOther.getStockholderName()!=null && this.getStockholderName().equals(castOther.getStockholderName()) ) )
 && ( (this.getTotalInvest()==castOther.getTotalInvest()) || ( this.getTotalInvest()!=null && castOther.getTotalInvest()!=null && this.getTotalInvest().equals(castOther.getTotalInvest()) ) )
 && ( (this.getCertificateTypeCd()==castOther.getCertificateTypeCd()) || ( this.getCertificateTypeCd()!=null && castOther.getCertificateTypeCd()!=null && this.getCertificateTypeCd().equals(castOther.getCertificateTypeCd()) ) )
 && ( (this.getHoldingStockRate()==castOther.getHoldingStockRate()) || ( this.getHoldingStockRate()!=null && castOther.getHoldingStockRate()!=null && this.getHoldingStockRate().equals(castOther.getHoldingStockRate()) ) )
 && ( (this.getFirstCustomerId()==castOther.getFirstCustomerId()) || ( this.getFirstCustomerId()!=null && castOther.getFirstCustomerId()!=null && this.getFirstCustomerId().equals(castOther.getFirstCustomerId()) ) )
 && ( (this.getCertificateNum()==castOther.getCertificateNum()) || ( this.getCertificateNum()!=null && castOther.getCertificateNum()!=null && this.getCertificateNum().equals(castOther.getCertificateNum()) ) )
 && ( (this.getCurrencyCd()==castOther.getCurrencyCd()) || ( this.getCurrencyCd()!=null && castOther.getCurrencyCd()!=null && this.getCurrencyCd().equals(castOther.getCurrencyCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFirstCustomerStockId() == null ? 0 : this.getFirstCustomerStockId().hashCode() );
         result = 37 * result + ( getCustomerNum() == null ? 0 : this.getCustomerNum().hashCode() );
         result = 37 * result + ( getStockholderName() == null ? 0 : this.getStockholderName().hashCode() );
         result = 37 * result + ( getTotalInvest() == null ? 0 : this.getTotalInvest().hashCode() );
         result = 37 * result + ( getCertificateTypeCd() == null ? 0 : this.getCertificateTypeCd().hashCode() );
         result = 37 * result + ( getHoldingStockRate() == null ? 0 : this.getHoldingStockRate().hashCode() );
         result = 37 * result + ( getFirstCustomerId() == null ? 0 : this.getFirstCustomerId().hashCode() );
         result = 37 * result + ( getCertificateNum() == null ? 0 : this.getCertificateNum().hashCode() );
         result = 37 * result + ( getCurrencyCd() == null ? 0 : this.getCurrencyCd().hashCode() );
         return result;
   }   


}


