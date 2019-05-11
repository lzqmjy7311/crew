<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign userInfo_=Session["USER_SESSION_INFO"] />
<@CommonQueryMacro.page title="任务管理  &gt; 监控任务查询">
	<@CommonQueryMacro.CommonQuery id="TRiskruleListA" init="true" submitMode="current" >
			<@CommonQueryMacro.DataTable id="QualityTable" height="560" paginationbar="forminfo"  width="600" fieldStr="warnSignal[120],ruleCode[120],ruleDesc[150],warningLevel[120],lounAcc[180],custName[100],productName[200],loanAmt[120],loanBalance[120],operator[80],bankName[160],warnDate[100],isNewcust[40]" width="100%" hasFrame="true"/>
 	</@CommonQueryMacro.CommonQuery>



<script language="JavaScript">
function forminfo_onClick(){
	if(!TRiskruleListA_dataset.record){
		alert('请选择一条内容!');
		return;		
	}
	var contextPath="${contextPath}";
	var date=TRiskruleListA_dataset.getValue('warnDateStr');
	var ruleId=TRiskruleListA_dataset.getValue('ruleID');
	var loanAccount=TRiskruleListA_dataset.getValue('lounAcc');
	window.open(contextPath+"/gbicc-pages/warn/ftl/warn_table.ftl?ruleId="+ruleId
		+"&date="+date+"&loanAccount="+loanAccount);
}
</script>	
</@CommonQueryMacro.page>