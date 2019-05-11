package com.gbicc.log.entity;
// Generated 2016-3-3 15:11:14 by Hibernate Tools 3.2.2.GA



/**
 * TEtlErrorLogId generated by hbm2java
 */
public class TEtlErrorLog  implements java.io.Serializable {


    /*
    */
    private String etlErrorLogId;
    /*
    */
    private String procName;
    /*
    */
    private String errMsg;
    /*
    */
    private String errSql;
    /*
    */
    private String errTimestamp;

    public TEtlErrorLog() {
    }

    public TEtlErrorLog(String etlErrorLogId, String procName, String errMsg, String errSql, String errTimestamp) {
       this.etlErrorLogId = etlErrorLogId;
       this.procName = procName;
       this.errMsg = errMsg;
       this.errSql = errSql;
       this.errTimestamp = errTimestamp;
    }
   
    public String getEtlErrorLogId() {
        return this.etlErrorLogId;
    }
    
    public void setEtlErrorLogId(String etlErrorLogId) {
        this.etlErrorLogId = etlErrorLogId;
    }
    public String getProcName() {
        return this.procName;
    }
    
    public void setProcName(String procName) {
        this.procName = procName;
    }
    public String getErrMsg() {
        return this.errMsg;
    }
    
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public String getErrSql() {
        return this.errSql;
    }
    
    public void setErrSql(String errSql) {
        this.errSql = errSql;
    }
    public String getErrTimestamp() {
        return this.errTimestamp;
    }
    
    public void setErrTimestamp(String errTimestamp) {
        this.errTimestamp = errTimestamp;
    }
}


