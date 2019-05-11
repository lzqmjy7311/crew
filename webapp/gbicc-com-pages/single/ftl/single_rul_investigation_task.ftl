<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign taskType=RequestParameters["taskType"]?default("")>

<@CommonQueryMacro.page title="单规则待办协查任务列表">
<table>
	<@CommonQueryMacro.CommonQuery id="SingleRulInvestigationTask" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="SingleRulInvestigationTaskTable" readonly="true" paginationbar="btHandle" 
		fieldStr="inveCode[100],inveName[150],createOrg[150],createUser[100],status[100],createDt[100],matureDt[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	function initCallGetter_post(){
		var taskType='${taskType}';
		SingleRulInvestigationTask_dataset.setParameter("taskType",taskType);
	}
	function SingleRulInvestigationTaskTable_onDbClick(){
		btHandle_onClick();
	}
	//处理
	function btHandle_onClick(){
		var casesId=SingleRulInvestigationTask_dataset.getValue("casesId");
		var inveId=SingleRulInvestigationTask_dataset.getValue("id");
		var status=SingleRulInvestigationTask_dataset.getValue("status");
		var warningIds="";
		InveRelWarning.dwrFindWarningIds(inveId,function(y){
			if(y.length>0){
				for(var i=0;i<y.length;i++){
					warningIds=warningIds+y[i]+",";
				}
			}else{
				warningIds="0";
			}
			if(status=="2"){
				openInvestigationWin(casesId,warningIds,inveId,"waitInve");
			}else{
				openInvestigationWin(casesId,warningIds,inveId,"waitAgainInve");
			}
		});
	}
	var investigationWin=null;
	function investigationWin_close(){
		investigationWin.close();
		flushCurrentPage();
	}
	//打开任务协查窗口
	function openInvestigationWin(casesId,warningIds,inveId,oper){
		investigationWin=openSubWin("investigationWin","任务协查","/gbicc-com-pages/single/ftl/single_rul_investigation.ftl?casesId="+casesId+"&warningIds="+warningIds+"&inveId="+inveId+"&oper="+oper,"950","700");
	}
	//刷新
	function flushCurrentPage(){
		SingleRulInvestigationTask_dataset.flushData(SingleRulInvestigationTask_dataset.pageIndex);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/InveRelWarning.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>