<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 风险清单工作台">
	<@CommonQueryMacro.CommonQuery id="TRiskruleList" init="true" submitMode="current" >
			<@CommonQueryMacro.DataTable paginationbar="moreHandle" id="QualityTable" height="560" width="600" fieldStr="warnSignal[100],ruleCode[100],ruleDesc[150],warningLevel[100],lounAcc[180],custName[100],productName[200],loanAmt[120],loanBalance[120],operator[100],bankName[160],warnDate[100],isNewcust[40]" width="100%" hasFrame="true"/>
 	</@CommonQueryMacro.CommonQuery>
 	<script>
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('TRiskruleList',"风险清单",'/gbicc-pages/riskrulelist/ftl/RiskruleList.ftl');
	}
	function initCallGetter_post(){
		TRiskruleList_dataset.setParameter("roleId",user_info.roleId);
		TRiskruleList_dataset.setParameter("orgId",user_info.orgId);
		TRiskruleList_dataset.setParameter("userId",user_info.userId);
		TRiskruleList_dataset.flushData();
	}
	function btShow_onClick(button) {
		var loanAccount = TRiskruleList_dataset.getValue("lounAcc");
//		var ruleId = WarningEntry_dataset.getValue("ruleId");
//		var createDate = WarningEntry_dataset.getValue("createDate");
	
		if (loanAccount == null || loanAccount == ""){
			return false;
		}
//		var year = createDate.getYear() + 1900;
//		var month = createDate.getMonth() + 1;
//		if (month < 10) {
//			month = "0" + month;
//		}
//		var day = createDate.getDate();
//		var date = year + "-" + month + "-" + day;

		var path = "/gbicc-pages/riskrulelist/ftl/RiskruleListA.ftl?flag=list";
		openSubWin("good", "触发规则详情列表", path + "?lounAcc=" + loanAccount+"&flag=list&roleId="+user_info.roleId,"1100","600");
	}
	</script>
</@CommonQueryMacro.page>