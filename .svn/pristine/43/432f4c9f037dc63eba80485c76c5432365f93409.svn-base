<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="规则排除/恢复任务/工作台">
<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="RuleEliminateTask" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DataTable id ="ruleEliminateTaskTable" paginationbar="btHandle,moreHandle"
				fieldStr="loanacno[150],custname[150],custname[150],prodname[150],acflag[150],riskflag[150],handler[200],handleOrg[200],status[100],eliminateRuleDesc[200],openAcctDate[100],matureDate[100]" readonly="true" width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('RuleEliminateTask',"规则排除与恢复",'/gbicc-pages/rule_eliminate/ftl/rule_eliminate_task.ftl?flag=desk');
	}
	function btHandle_onClick(){
		var businessId=RuleEliminateTask_dataset.getValue("id");
		if(businessId!=null || businessId!=""){
			parent.parent.parent.GTab.addTab('RuleEliminateHandle',"规则排除与恢复处理",'/gbicc-pages/rule_eliminate/ftl/rule_eliminate_handle.ftl?businessId='+businessId);
		}
	}
</script>
</@CommonQueryMacro.page>