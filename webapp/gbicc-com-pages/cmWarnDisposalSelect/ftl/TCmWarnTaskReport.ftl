<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="Ԥ������  &gt;  �ҵ�����">
<script type='text/javascript' src='${contextPath}/dwr/interface/TCmWarnDisposalAjax.js'> </script>
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="selectTheTask" fieldStr="taskCode,taskType,warnCunt,status,taskCreatDate,taskMatureDate,taskOverran"  width="100%" hasFrame="true"/>
		</td>
	</tr>
		<tr>
      	<td colspan="2">
  		</td>
  	</tr>
  		
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
function selectTheTask_onClick(button) {
	var taskId = TCmWarnTask_dataset.getValue("id");
	if(taskId){
		
	}else{
		top.easyMsg.info("��ѡ��һ����¼��");
		return;
	}
	top.easyMsg.confirm("�Ƿ�ȷ�Ϸ���������÷�������?", function(){
		TCmWarnDisposalAjax.personStartRC(taskId,function(y){
			 if(y.success=="true"){//
				TCmWarnTask_dataset.flushData(TCmWarnTask_dataset.pageIndex);
				window.parent.TCmWarnTask_dataset.flushData(window.parent.TCmWarnTask_dataset.pageIndex);
				window.parent.selectWarnTaskWin.close();
			 }else{
				 top.easyMsg.info(y.message);
			 }
			   
			
		});
	}, function(){
	    top.easyMsg.info("ȡ��");
	} );
}
	
</script>
</@CommonQueryMacro.page>