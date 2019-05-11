<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="任务表格">
	<@CommonQueryMacro.CommonQuery id="AdjustMonitorFreq" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" showButton="false" label="调整监控频率" />
		<@CommonQueryMacro.DataTable id="adjustMonitorFreqTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,handler,handleOrg,sysMonitorFreq,adjustBehiFreq" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="RuleRemove" submitMode="current">
		<@CommonQueryMacro.Interface id="interface2" showButton="false" label="规则排除" />
		<@CommonQueryMacro.DataTable id="ruleRemoveTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,handler,handleOrg,status,removeRuleDesc,openAcctDate,matureDate" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="RuleRecover" submitMode="current">
		<@CommonQueryMacro.Interface id="interface3" showButton="false" label="规则恢复" />
		<@CommonQueryMacro.DataTable id="ruleRecoverTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,status,warningRule,removeRuleDesc,openAcctDate,matureDate,recoverStartDate" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="WaitHandleTask" submitMode="current">
		<@CommonQueryMacro.Interface id="interface4" showButton="false" label="一级支行处理岗待办任务" />
		<@CommonQueryMacro.DataTable id="waitHandleTaskTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,status,handler,monitorType,taskMatureDate,IfTimeout" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="WarningInfo" submitMode="current">
		<@CommonQueryMacro.Interface id="interface5" showButton="false" label="一级支行处理岗预警信息" />
		<@CommonQueryMacro.DataTable id="warningInfoTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,warningRule,openAcctDate,matureDate" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="RemindInfo" submitMode="current">
		<@CommonQueryMacro.Interface id="interface6" showButton="false" label="一级支行处理岗提醒信息" />
		<@CommonQueryMacro.DataTable id="remindInfoTable" readonly="true" paginationbar="" 
			fieldStr="warnLevel,loanAcct,custName,prodName,loanAmt,loanBalance,loanTerm,remindInfo,openAcctDate,matureDate" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>