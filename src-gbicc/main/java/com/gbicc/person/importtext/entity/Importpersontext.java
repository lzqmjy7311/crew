package com.gbicc.person.importtext.entity;

import java.util.Date;

public class Importpersontext  implements java.io.Serializable {
	   /*
	    */
	    private String id;
	    /*
	    * 主键
	    */
	    private String bankCode;
	    /*
	    * 本机构业务分支机构代码.
	    */
	    private String name;
	    /*
	    * 姓名.
	    */
	    private String  cardType;
	    /*
	    * 证件类型.
	    */
	    private String cardNo;
	    /*
	    * 证件号码.
	    */
	    private String informationCode;
	    /*
	    * 信息代码.
	    */
	    private Date creatTime;
	    /*
	    * 提示信息生成时间.
	    */
	    private Date importTime;
	    /*
	    * 信息导入时间.
	    */
		
	   
	    public String getId() {
	        return this.id;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getBankCode() {
	        return this.bankCode;
	    }
	    
	    public void setBankCode(String bankCode) {
	        this.bankCode = bankCode;
	    }
	    public String getName() {
	        return this.name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getCardType() {
	        return this.cardType;
	    }
	    
	    public void setCardType(String cardType) {
	        this.cardType = cardType;
	    }
	    public String getInformationCode() {
	        return this.informationCode;
	    }
	    
	    public void setInformationCode(String informationCode) {
	        this.informationCode = informationCode;
	    }
	    public Date getCreatTime() {
	        return this.creatTime;
	    }
	    
	    public void setCreatTime(Date creatTime) {
	        this.creatTime = creatTime;
	    }

	    public String getCardNo() {
	        return this.cardNo;
	    }
	    
	    public void setCardNo(String cardNo) {
	        this.cardNo = cardNo;
	    }

		public Date getImportTime() {
			return importTime;
		}

		public void setImportTime(Date importTime) {
			this.importTime = importTime;
		}

}
