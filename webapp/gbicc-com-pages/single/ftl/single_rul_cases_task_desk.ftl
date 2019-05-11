<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="单规则预警处置-案例管理列表">
<table>
	<@CommonQueryMacro.CommonQuery id="SingleRulCases" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="SingleRulCasesTable" readonly="false" remoteSort="true" sortable="true" paginationbar="btHandle,btn_Add,btnCasesDel,moreHandle" 
		fieldStr="casesCode,casesName,casesStatus,createDt,warnCount,inveCount,alreInveCount" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="SingleRulWarningSelect" init="false" submitMode="selected">
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	var casesWin=null;
	function initCallGetter_post(){
		var roleId=user_info.roleId;
		if(roleId=="559"||roleId=="561"){
			$("a[id=btn_Add]").hide();
			$("a[id=btnCasesDel]").hide();
		}
	}
	function casesWin_close(){
		casesWin.close();
	}
	function caseWin_and_parWin_close(){
		if(parent.parent.parent.GTab){
			parent.parent.parent.GTab.closeTab();
		}
	}
	function btnCasesDel_onClickCheck(){
		var casesStatus=SingleRulCases_dataset.getValue("casesStatus");
		var casesId=SingleRulCases_dataset.getValue("id");
		if(casesId==null || casesId==""){
			top.easyMsg.info("请选择要删除的案例！");
			return false;
		}
		if(casesStatus!="1"){
			top.easyMsg.info("只能删除草稿状态的案例！");
			return false;
		}
		SingleRulWarningSelect_dataset.setParameter("casesId",casesId);
		SingleRulWarningSelect_dataset.flushData(SingleRulWarningSelect_dataset.pageIndex);
		if(SingleRulWarningSelect_dataset.length>0){
			top.easyMsg.info("该案例中存在预警信号，无法删除！");
			return false;
		}
		SingleRulCases_dataset.setFieldRequired("casesNature",false);
		return confirm("确认删除该案例？");
	}
	function btnCasesDel_postSubmit(button){
		SingleRulCases_dataset.flushData(SingleRulCases_dataset.pageIndex);
	}
	function btn_Add_onClick(){
		casesWin=openSubWin("casesWin","新增案例","/gbicc-com-pages/single/ftl/single_rul_cases_add.ftl","950","300");
	}
	function SingleRulCasesTable_onDbClick(){
		btHandle_onClick();
	}
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('SingleRulCases',"案例管理",'/gbicc-com-pages/single/ftl/single_rul_cases_task.ftl?flag=desk');
	}
	function btHandle_onClick(){
		var businessId=SingleRulCases_dataset.getValue("id");
		if(businessId==null || businessId==""){
			top.easyMsg.info("请选择一条数据！");
			return false;
		}
		if(businessId!=null && businessId!=""){
			parent.parent.parent.GTab.addTab('SingleRulCases',"案例归档任务",'/gbicc-com-pages/single/ftl/single_rul_cases_handle.ftl?businessId='+businessId);
		}
	}
</script>
</@CommonQueryMacro.page>