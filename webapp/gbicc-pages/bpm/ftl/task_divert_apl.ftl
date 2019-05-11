<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���̹���  &gt;  ����ת��/�ط������">
<table>
	<@CommonQueryMacro.CommonQuery id="TaskDivertApl" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="taskDivertAplTable" readonly="true" paginationbar="btHandle" 
		fieldStr="id,aplDate,aplPer,assignee,oldAssignee" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.FloatWindow id="taskDivertAplFW" modal="true" label="����ת��/���·������" 
	resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<@CommonQueryMacro.CommonQuery id="TaskDivertApl" init="true" submitMode="current">
			<@CommonQueryMacro.Group id="taskDivertAplGroup" label="" colNm=4
			fieldStr="oldAssignee,assignee,oldAssigneeOrg,assigneeOrg"/>
		</@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="TaskDivertDtl" init="false" submitMode="current">
			<@CommonQueryMacro.DataTable id="taskDivertDtlTable" readonly="true" paginationbar="" 
			fieldStr="procInstId,procName,taskDesc,taskName,taskId,assignee,createTime" width="100%" hasFrame="true"/>
			<center>
				<@CommonQueryMacro.Button id= "btnSubmit"/>
				<@CommonQueryMacro.Button id= "btnBack"/>
			</center>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.FloatWindow>
</table>
<script>
	//����
	function btHandle_onClick(){
		subwindow_taskDivertAplFW.show();
		TaskDivertDtl_dataset.setParameter("taskDivertId",TaskDivertApl_dataset.getValue("id"));
		TaskDivertDtl_dataset.flushData(TaskDivertDtl_dataset.pageIndex);
	}
	function btnSubmit_onClickCheck(){
		TaskDivertApl_dataset.setParameter("op","submit");
	}
	function btnBack_onClickCheck(){
		TaskDivertApl_dataset.setParameter("op","back");
	}
	//�ύ��ر�ҳ�棬ˢ�±��
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_taskDivertAplFW.close();
		flushCurrentPage();
	}
	//�ύ��ر�ҳ�棬ˢ�±��
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_taskDivertAplFW.close();
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TaskDivertApl_dataset.flushData(TaskDivertApl_dataset.pageIndex);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>