<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="单规则待办协查任务列表">
<table>
	<@CommonQueryMacro.CommonQuery id="SingleRulInvestigationTask" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="SingleRulInvestigationTaskTable" readonly="true" paginationbar="btHandle,moreHandle" 
		fieldStr="inveCode[100],inveName[150],createOrg[150],createUser[100],status[100],createDt[100],matureDt[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	function SingleRulInvestigationTaskTable_onDbClick(){
		btHandle_onClick();
	}
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('SingleRulInvestigationTask',"待办协查任务",'/gbicc-com-pages/single/ftl/single_rul_investigation_task.ftl?flag=desk');
	}
	function btHandle_onClick(){
		var businessId=SingleRulInvestigationTask_dataset.getValue("id");
		var casesId=SingleRulInvestigationTask_dataset.getValue("casesId");
		var status=SingleRulInvestigationTask_dataset.getValue("status");
		if(businessId==null||businessId==""){
			top.easyMsg.info("请选择一条数据！");
			return false;
		}
		if(businessId!=null && businessId!=""){
			var warningIds="";
			var oper="";
			InveRelWarning.dwrFindWarningIds(businessId,function(y){
				if(y.length>0){
					for(var i=0;i<y.length;i++){
						warningIds=warningIds+y[i]+",";
					}
				}else{
					warningIds="0";
				}
				if(status=="2"){
					oper="waitInve"
				}else{
					oper="waitAgainInve";
				}
				parent.parent.parent.GTab.addTab('SingleRulInvestigationTask',"待办协查任务",'/gbicc-com-pages/single/ftl/single_rul_investigation.ftl?casesId='+casesId+'&warningIds='+warningIds+'&inveId='+businessId+'&oper='+oper);
			});
		}
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/InveRelWarning.js'> </script>
</@CommonQueryMacro.page>