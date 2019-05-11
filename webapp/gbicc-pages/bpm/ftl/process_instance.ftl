<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="流程管理  &gt;  实例管理">
	<@CommonQueryMacro.CommonQuery id="ProcessInstance" init="true" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" labelwidth="100" colNm=8 showButton="false"/>
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="查询" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
				</div>
			</td>
		</tr>
		<@CommonQueryMacro.DataTable id="productTable" readonly="true" paginationbar="btAdd,btDel,btProcDiag" 
		fieldStr="select,id,processName,businessKey,processDefinitionId,statusDesc,startUserId,startTime,assignee[100],brName" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="diagramFW" modal="true" label="流程图查看" 
		resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<img id="img" data="${contextPath}/common/ProcessDiagramServlet">
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
<script>
	function btAdd_onClickCheck(button) {
		var str="";
		if(ProcessInstance_dataset.getValue("status")=="2"){
			str="确认激活选择的记录？";
		}else{
			str="确认挂起选择的记录？";
		}
		return confirm(str);
	}
	//挂起/激活后刷新当前页
	function btAdd_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		flushCurrentPage();
	}
	
	
	function btDel_onClickCheck(button) {
		var ids="";
		var record = ProcessInstance_dataset.getFirstRecord();
		while(record){
			if(record.getValue("select")){
				ids=ids+(record.getValue("id"))+",";
			}
			record=record.getNextRecord();
	   	}
	   	ProcessInstance_dataset.setParameter("idList",ids);
		return confirm("强制终止会删除所有与该实例相关的数据，确认终止吗?");
	}
	//终止后刷新当前页
	function btDel_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		flushCurrentPage();
	}
	//流程图
	function btProcDiag_onClick(button) {
		subwindow_diagramFW.show();
		var src=$("#img").attr("data")+"?flag=runtime&executionId="+ProcessInstance_dataset.getValue("id")+"&t="+new Date();
		$("#img").attr("src",src);
	}
	//刷新当前页
	function flushCurrentPage() {
		ProcessInstance_dataset.flushData(ProcessInstance_dataset.pageIndex);
	}
	//重置查询条件
	function btnReset_onClick(button){
		ProcessInstance_interface_dataset.clearData();
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>