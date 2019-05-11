<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign orgId=RequestParameters["orgId"]?default("")>
<#assign roleId=RequestParameters["roleId"]?default("")>

<@CommonQueryMacro.page title="任务发送至">
	<@CommonQueryMacro.CommonQuery id="TaskAssignee" init="true" submitMode="current">
		<@CommonQueryMacro.Group id="TaskAssigneeGroup" label="" colNm=2 labelwidth="150" 
			fieldStr="taskAssignee"/>
		<center>
		<@CommonQueryMacro.Button id= "btnConfirm"/>
		<@CommonQueryMacro.Button id= "btnCancel"/>
		</center>
	</@CommonQueryMacro.CommonQuery>
<script>
	function btnCancel_onClick(){
		window.parent.mushSubmitAllCancelFun();
	}
	function btnConfirm_onClick(){
		var taskAssignee=TaskAssignee_dataset.getValue("taskAssignee");
		if(!taskAssignee){
			top.easyMsg.info("请选择任务接收人！");
			return;
		}else{
			window.parent.muchSubmitAllFun(taskAssignee);
		}
	}
	function taskAssignee_DropDown_beforeOpen(dropDown){
		var orgId='${orgId}';
		var roleId='${roleId}';
		subAutoTaskAssignee_DropDownDataset.setParameter("orgId",orgId);
		subAutoTaskAssignee_DropDownDataset.setParameter("roleId",roleId);
		taskAssignee_DropDown.cached=false;//让qGroupId不存入缓存
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>