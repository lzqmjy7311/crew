package com.gbicc.person.importtext.entity;

import java.util.Date;

public class Importpublictext  implements java.io.Serializable {
	   /*
	    */
	    private String id;
	    /*
	    * 主键
	    */
	    private String bankCode;
	    /*
	    * 本行业务分支行机构代码.
	    */
	    private String middleSigncode;
	    /*
	    * 中征码.
	    */
	    private String  organizationCode;
	    /*
	    * 组织机构代码.
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
	    public String getMiddleSigncode() {
	        return this.middleSigncode;
	    }
	    
	    public void setMiddleSigncode(String middleSigncode) {
	        this.middleSigncode = middleSigncode;
	    }
	    public String getOrganizationCode() {
	        return this.organizationCode;
	    }
	    
	    public void setOrganizationCode(String organizationCode) {
	        this.organizationCode = organizationCode;
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

		public Date getImportTime() {
			return importTime;
		}

		public void setImportTime(Date importTime) {
			this.importTime = importTime;
		}



}
