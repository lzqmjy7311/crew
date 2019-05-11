<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 预警清单工作台">
	<@CommonQueryMacro.CommonQuery id="WarningEntry" init="false" submitMode="current">
		<@CommonQueryMacro.DataTable   id="taskTable" paginationbar="btShow"   fieldStr="custCode[100],ruleLevel[80],custName[100],loanAccount[120],productName[180],loanPeriod[80],operator[100],operBank[120],createDate[100],staChangeDate[100],isNewCustomer[60]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
<script>
	function initCallGetter_post(){
		//设置用户信息
	    WarningEntry_dataset.setParameter("roleId",user_info.roleId);
		WarningEntry_dataset.setParameter("orgId",user_info.orgId);
		WarningEntry_dataset.setParameter("userId",user_info.userId);
		WarningEntry_dataset.flushData(WarningEntry_dataset.pageIndex);
	}
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('WarningEntry',"预警清单",'/gbicc-pages/warn/ftl/warning_entry.ftl?flag=desk');
	}
	function btShow_onClick(button) {
		var loanAccount = WarningEntry_dataset.getValue("loanAccount");
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

		var path = "/gbicc-pages/warn/ftl/TPlTaskRuleTrigA.ftl";
		openSubWin("page", "触发规则详情列表", path + "?accId=" + loanAccount,"1100","600");
	}

</script>
</@CommonQueryMacro.page>