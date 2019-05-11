<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ԥ�����������б�">
<br>
<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
<@CommonQueryMacro.GroupBox id="Baseinfo" label="���ͻ�Ԥ�����������б�">
<table width="100%">
	<tr>
		<@CommonQueryMacro.DataTable  id="datatable1" frozens="20" paginationbar="btHandle,moreHandle" fieldStr="taskCode[100],taskType[70],custcode[100],custname[200],warnCunt[70],status[70],taskCreatDate[100],taskMatureDate[100],startType[80],taskOverran[70]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
var warnDisposalWin;
function warnDisposalWin_close(){
	warnDisposalWin.close();
	TCmWarnTask_dataset.flushData(TCmWarnTask_dataset.pageIndex);
}
function datatable1_onDbClick(){
	btHandle_onClick();
}
function btHandle_onClick(button) {
	var taskId=TCmWarnTask_dataset.getValue("id");
	if(taskId){
		var customerId=TCmWarnTask_dataset.getValue("customerId");
		var taskType=TCmWarnTask_dataset.getValue("taskType");
		var rptStatus=TCmWarnTask_dataset.getValue("status");
		var startType=TCmWarnTask_dataset.getValue("startType");
		var title="������";
		if(taskType=="RC"){
			title=title+"�����÷�����";
		}else{
			title="��Ԥ�����á�";
		}
		if(rptStatus=="1"||rptStatus=="2"){//���
			title=title+">����ˡ�";
		}else if(rptStatus=="3"){
			title=title+">�����ȷ�ϡ�";
		}
		var path="/gbicc-com-pages/cmWarnDisposal/ftl/warnDisposalWin.ftl";
		if(startType=="1"){//�������������Ϊ�ֹ�
			path="/gbicc-com-pages/cmWarnDisposal/ftl/personWarnDisposalWin.ftl";
		}
	   parent.parent.parent.GTab.addTab("warnDisposalWin","�ͻ�Ԥ������",path+"?taskId="+taskId+"&customerId="+customerId+"&businessId="+taskId);
	}else{
		top.easyMsg.info("��ѡ��һ�����ݣ�");
		return false;
	}
}
function moreHandle_onClick(){
   parent.parent.parent.GTab.addTab('SingleRulInvestigationTask',"�ͻ�Ԥ�����������б�",'/gbicc-com-pages/cmWarnDisposal/ftl/TCmWarnTask.ftl');
}
</script>

</@CommonQueryMacro.page>