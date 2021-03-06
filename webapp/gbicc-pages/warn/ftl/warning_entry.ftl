<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 监控任务查询">
	<@CommonQueryMacro.CommonQuery id="WarningEntry" init="false" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" showButton="false" colNm=6 />
		<center><@CommonQueryMacro.Button id="btQuery"/>&nbsp;&nbsp;&nbsp;&nbsp;<@CommonQueryMacro.Button id="btRest"/></center>
		<@CommonQueryMacro.DataTable id="taskTable"  paginationbar="btShow"   fieldStr="custCode[100],ruleLevel[80],custName[100],loanAccount[120],productName[180],loanPeriod[80],operator[100],operBank[120],createDate[100],staChangeDate[100],isNewCustomer[60]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>

<script>
	function initCallGetter_post(){
		//设置用户信息
	    WarningEntry_dataset.setParameter("roleId",user_info.roleId);
		WarningEntry_dataset.setParameter("orgId",user_info.orgId);
		WarningEntry_dataset.setParameter("userId",user_info.userId);
		WarningEntry_dataset.flushData(WarningEntry_dataset.pageIndex);
	
	}
	function btRest_onClick(button){
		WarningEntry_interface_dataset.clearData();
	}
	function btQuery_onClick(button){
		//设置用户信息
		    WarningEntry_dataset.setParameter("roleId",user_info.roleId);
			WarningEntry_dataset.setParameter("orgId",user_info.orgId);
			WarningEntry_dataset.setParameter("userId",user_info.userId);
		//var id=WarningEntry_interface_dataset.getValue("id");
		//var customerId=WarningEntry_interface_dataset.getValue("customerId");
		var ruleLevel=WarningEntry_interface_dataset.getValue("ruleLevel");
		var createDate=WarningEntry_interface_dataset.getValue("createDate");
		var lastwarnDate=WarningEntry_interface_dataset.getValue("lastwarnDate");
		var custName=WarningEntry_interface_dataset.getValue("custName");
		var operator=WarningEntry_interface_dataset.getValue("operator");
		var loanAccount=WarningEntry_interface_dataset.getValue("loanAccount");
		var productName=WarningEntry_interface_dataset.getValue("productName");
		var operBank=WarningEntry_interface_dataset.getValue("operBank");
		//WarningEntry_dataset.setParameter("id",id);
		//WarningEntry_dataset.setParameter("customerId",customerId);
		WarningEntry_dataset.setParameter("ruleLevel",ruleLevel);
		WarningEntry_dataset.setParameter("createDate",createDate);
		WarningEntry_dataset.setParameter("lastwarnDate",lastwarnDate);
		WarningEntry_dataset.setParameter("custName",custName);
		WarningEntry_dataset.setParameter("operator",operator);
		WarningEntry_dataset.setParameter("loanAccount",loanAccount);
		WarningEntry_dataset.setParameter("productName",productName);
		WarningEntry_dataset.setParameter("operBank",operBank);
		WarningEntry_dataset.flushData();
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

	function btnSave_postSubmit(button) {
		button.url = "#";
		top.easyMsg.info("保存成功！");
		flushCurrentPage();
	}
	//删除确认
	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	//删除后刷新当前页
	function btDel_postSubmit(button) {
		button.url = "#";
		top.easyMsg.info("删除成功！");
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		//设置用户信息
	    WarningEntry_dataset.setParameter("roleId",user_info.roleId);
		WarningEntry_dataset.setParameter("orgId",user_info.orgId);
		WarningEntry_dataset.setParameter("userId",user_info.userId);
		WarningEntry_dataset.flushData(WarningEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>
