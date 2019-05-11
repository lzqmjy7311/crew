<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="我参与的流程  &gt;  我参与的流程">
	<@CommonQueryMacro.CommonQuery id="MyLaunchProcess" init="true" submitMode="current">
		<@CommonQueryMacro.Interface id="intface2222" label="请输入查询条件" showButton="false" labelwidth="100" colNm=8/>
      		<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		<@CommonQueryMacro.DataTable remoteSort="true" sortable="true" frozens="20" id="MyLaunchProcessTable" isHiddenScoll="false" readonly="true" paginationbar="btnRead2" 
		fieldStr="procInstId[100],procName[150],taskId[100],taskName[200],taskDesc[300],assignee[200],createTime[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.FloatWindow id="MyProcessHistoryFW" modal="true" label="查看流转历史" 
	resize="true" minimize="false" width="1000" height="500" maximize="true" closure="true" show="false" defaultZoom="normal">
	<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
		<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable"
			fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.FloatWindow>
<script>
	function procName_DropDown_beforeOpen(dropDown){
		var roleType="PL";
		if(user_info.roleType!=null && user_info.roleType!=""){
			roleType=user_info.roleType;
		}
		subAutoProcessType_DropDownDataset.setParameter("roleType",roleType);
		procName_DropDown.cached=false;//让qGroupId不存入缓存
	}
	function btnReset_onClick(){
		MyLaunchProcess_interface_dataset.clearData();
	}
	function btnRead2_onClick(){
		var businessId=MyLaunchProcess_dataset.getValue("businessId");
		if(businessId!=null && businessId!=""){
			subwindow_MyProcessHistoryFW.show();
			TaskApprovalHistory_dataset.setParameter("businessId",businessId);
			TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
		}
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>