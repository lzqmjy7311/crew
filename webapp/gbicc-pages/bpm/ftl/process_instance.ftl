<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���̹���  &gt;  ʵ������">
	<@CommonQueryMacro.CommonQuery id="ProcessInstance" init="true" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" label="�������ѯ����" labelwidth="100" colNm=8 showButton="false"/>
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
				</div>
			</td>
		</tr>
		<@CommonQueryMacro.DataTable id="productTable" readonly="true" paginationbar="btAdd,btDel,btProcDiag" 
		fieldStr="select,id,processName,businessKey,processDefinitionId,statusDesc,startUserId,startTime,assignee[100],brName" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="diagramFW" modal="true" label="����ͼ�鿴" 
		resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<img id="img" data="${contextPath}/common/ProcessDiagramServlet">
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
<script>
	function btAdd_onClickCheck(button) {
		var str="";
		if(ProcessInstance_dataset.getValue("status")=="2"){
			str="ȷ�ϼ���ѡ��ļ�¼��";
		}else{
			str="ȷ�Ϲ���ѡ��ļ�¼��";
		}
		return confirm(str);
	}
	//����/�����ˢ�µ�ǰҳ
	function btAdd_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("�����ɹ���");
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
		return confirm("ǿ����ֹ��ɾ���������ʵ����ص����ݣ�ȷ����ֹ��?");
	}
	//��ֹ��ˢ�µ�ǰҳ
	function btDel_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("�����ɹ���");
		flushCurrentPage();
	}
	//����ͼ
	function btProcDiag_onClick(button) {
		subwindow_diagramFW.show();
		var src=$("#img").attr("data")+"?flag=runtime&executionId="+ProcessInstance_dataset.getValue("id")+"&t="+new Date();
		$("#img").attr("src",src);
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		ProcessInstance_dataset.flushData(ProcessInstance_dataset.pageIndex);
	}
	//���ò�ѯ����
	function btnReset_onClick(button){
		ProcessInstance_interface_dataset.clearData();
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>