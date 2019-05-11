package com.gbicc.person.monitor.entity;

import java.util.Calendar;
import java.util.Date;

import com.huateng.ebank.entity.data.mng.TlrInfo;

/**
 * 
 * @date    2015年11月5日
 * @author  tangdu
 * @desc    任务主表
 */
public class TPlTask  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 7751217268900746135L;
	/*
    * ID主键.
    */
    private String id;
    /*
     * ID主键.
     */
    private String fdId;

	public String getFdId() {
		return fdId;
	}
	public void setFdId(String fdId) {
		this.fdId = fdId;
		this.id=fdId;
	}

	/*
    * 预警等级.
    */
    private String warnLevel;
    /*
    * 贷款账号.
    */
    private String loanAcct;
    /*
    * 客户姓名.
    */
    private String custName;
    /*
    * 客户编号.
    */
    private String custCode;
    /*
    * 贷款品种.
    */
    private String loanVariety;
    /*
    * 贷款金额.
    */
    private Double loanAmt;
    /*
    * 贷款余额.
    */
    private Double loanBalance;
    /*
    * 贷款期限.
    */
    private String loanTerm;
    /*
    * 报告状态.
    */
    private String rptStatus;
    /*
     * 任务生成日期.
     */
    private Date taskCreatDate=new Date();
    /*
    * 任务到期日.
    */
    private Date taskMatureDate;
    /*
     * 任务流程结束期日.
     */
    private Date completeDate;
    /*
    * 经办人.
    */
    private TlrInfo handler;
    /*
     * 经办人原业务机构ID
     */
    private String bankId;
    public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	/**
     * 经办人原业务机构名称
     */
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
     * 经办人编号 -无映射
     */
    private String handlerNo;
	/**
     * 经办人名称 -无映射
     */
    private String handlerName;
    /**
     * 经办人所在机构编号 -无映射
     */
    private String handlerOrgNo;
    /**
     * 经办人所在机构编号 -无映射
     */
    private String handlerOrgName;
    /**
     * 是否有页面权限
     * 1 可处理
     * 0 只读
     */
    private String pageReadOnly;
    /**
     * 当前用户 
     */
    private String currentUser;
    public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	/**
     * 当前用户名称
     */
	private String currentUserName;
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public String getPageReadOnly() {
		return pageReadOnly;
	}
	public void setPageReadOnly(String pageReadOnly) {
		this.pageReadOnly = pageReadOnly;
	}
	public String getHandlerOrgNo() {
		return handlerOrgNo;
	}
	public void setHandlerOrgNo(String handlerOrgNo) {
		this.handlerOrgNo = handlerOrgNo;
	}
	public String getHandlerOrgName() {
		return handlerOrgName;
	}
	public void setHandlerOrgName(String handlerOrgName) {
		this.handlerOrgName = handlerOrgName;
	}
	public String getHandlerNo() {
		return handlerNo;
	}
	public void setHandlerNo(String handlerNo) {
		this.handlerNo = handlerNo;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	/*
    * 报告ID.
    */
    private String reportId;
    /*
    * 报告模板Url.
    */
    private String reportUrl;
    /*
     * 是否超时(该字段为临时字段，不存在数据表中)
     */
    private String ifTimeout;
    /*
     * 任务类型
     */
    private String taskType;
    /*
     * 任务触发来源
     * 默认系统发起：
     * 手工发起: USER
     * 系统发起: SYS
     */
    private String taskSourceType="SYS";

    public String getTaskSourceType() {
		return taskSourceType;
	}
	public void setTaskSourceType(String taskSourceType) {
		this.taskSourceType = taskSourceType;
	}
	public TPlTask() {
    }

	
    public TPlTask(String id) {
        this.id = id;
    }
    public TPlTask(String id, String warnLevel, String loanAcct, String custName, String custCode, String loanVariety, Double loanAmt, Double loanBalance, String loanTerm, String rptStatus,Date taskCreatDate,Date completeDate, Date taskMatureDate, TlrInfo handler, String reportId, String reportUrl) {
       this.id = id;
       this.warnLevel = warnLevel;
       this.loanAcct = loanAcct;
       this.custName = custName;
       this.custCode = custCode;
       this.loanVariety = loanVariety;
       this.loanAmt = loanAmt;
       this.loanBalance = loanBalance;
       this.loanTerm = loanTerm;
       this.rptStatus = rptStatus;
       this.taskCreatDate=taskCreatDate;
       this.completeDate=completeDate;
       this.taskMatureDate = taskMatureDate;
       this.handler = handler;
       this.reportId = reportId;
       this.reportUrl = reportUrl;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getWarnLevel() {
        return this.warnLevel;
    }
    
    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel;
    }
    public String getLoanAcct() {
        return this.loanAcct;
    }
    
    public void setLoanAcct(String loanAcct) {
        this.loanAcct = loanAcct;
    }
    public String getCustName() {
        return this.custName;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustCode() {
        return this.custCode;
    }
    
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    public String getLoanVariety() {
        return this.loanVariety;
    }
    
    public void setLoanVariety(String loanVariety) {
        this.loanVariety = loanVariety;
    }
    public Double getLoanAmt() {
        return this.loanAmt;
    }
    
    public void setLoanAmt(Double loanAmt) {
        this.loanAmt = loanAmt;
    }
    public Double getLoanBalance() {
        return this.loanBalance;
    }
    
    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public String getLoanTerm() {
        return this.loanTerm;
    }
    
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }
    public String getRptStatus() {
        return this.rptStatus;
    }
    
    public void setRptStatus(String rptStatus) {
        this.rptStatus = rptStatus;
    }
    
    public Date getTaskCreatDate() {
		return taskCreatDate;
	}


	public void setTaskCreatDate(Date taskCreatDate) {
		this.taskCreatDate = taskCreatDate;
	}


	public Date getCompleteDate() {
		return completeDate;
	}


	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}


	public Date getTaskMatureDate() {
        return this.taskMatureDate;
    }
    
    public void setTaskMatureDate(Date taskMatureDate) {
        this.taskMatureDate = taskMatureDate;
    }
    public TlrInfo getHandler() {
        return this.handler;
    }
    
    public void setHandler(TlrInfo handler) {
        this.handler = handler;
    }
    public String getReportId() {
        return this.reportId;
    }
    
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
    public String getReportUrl() {
        return this.reportUrl;
    }
    
    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

	public String getIfTimeout() {
		if(null!=this.getTaskMatureDate()){
			Calendar calendar1=Calendar.getInstance();
			calendar1.setTime(this.getTaskMatureDate());//过期日期
			calendar1.set(Calendar.HOUR_OF_DAY, 0);
			calendar1.set(Calendar.MINUTE, 0);
			calendar1.set(Calendar.SECOND, 0);
			calendar1.set(Calendar.MILLISECOND, 0);
			Calendar calendar2=Calendar.getInstance();//当前日期
			calendar2.setTime(new Date());
			calendar2.set(Calendar.HOUR_OF_DAY, 0);
			calendar2.set(Calendar.MINUTE, 0);
			calendar2.set(Calendar.SECOND, 0);
			calendar2.set(Calendar.MILLISECOND, 0);
			if(calendar1.before(calendar2)){
				this.ifTimeout="是";
			}else{
				this.ifTimeout="否";
			}
		}
		return this.ifTimeout;
	}

	public void setIfTimeout(String ifTimeout) {
		this.ifTimeout = ifTimeout;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
}


