<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="�˹�Ԥ���������">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnPersonRule" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" showButton="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" frozens="20" readonly="true" paginationbar="btnAdd,-,btnUpd,-,btnDel" fieldStr="warnCode[80],warnName[150],warnSubjectCode[90],warnLevel[60],warnProcessLevel[150],desc[340],updated[80]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="TCmWarnPersonRuleWindow" label="�˹�Ԥ������" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label=""
        			  fieldStr="warnCode,warnSubjectCode,warnName,warnLevel,warnProcessLevel,desc" colNm=4/>
        			<br/>
					<@CommonQueryMacro.Button id="btnSave" />
      			</div>
     		</@CommonQueryMacro.FloatWindow>	
  		</td>
  	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
function btnAdd_onClick(){
	TCmWarnPersonRule_dataset.setFieldReadOnly("warnCode",false);
	TCmWarnPersonRule_dataset.setParameter("op","new");
	TCmWarnPersonRule_dataset.insertRecord("end");
	subwindow_TCmWarnPersonRuleWindow.show();
}
function btnUpd_onClick(){
	TCmWarnPersonRule_dataset.setFieldReadOnly("warnCode",true);
	TCmWarnPersonRule_dataset.setParameter("op","mol");
	subwindow_TCmWarnPersonRuleWindow.show();
}
function btnDel_onClickCheck(button){
	
	var id = TCmWarnPersonRule_dataset.getValue("id");
	if(id){
		if(confirm("�Ƿ�ȷ��ɾ����Ԥ������?")){
			TCmWarnPersonRule_dataset.setParameter("op","del");
		}else{
			return false;
		}
	}else{
		top.easyMsg.info("��ѡ��һ�����ݣ�");
		return false;
	}
}
function btnSave_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("�ύ�ɹ���");
	TCmWarnPersonRule_dataset.flushData(TCmWarnPersonRule_dataset.pageIndex);
	subwindow_TCmWarnPersonRuleWindow.close();
}
function btnDel_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("ɾ���ɹ���");
	TCmWarnPersonRule_dataset.flushData(TCmWarnPersonRule_dataset.pageIndex);
}

//�ظ�������,�ͷ�dataset
function TCmWarnPersonRuleWindow_floatWindow_beforeClose(subwindow) {
	TCmWarnPersonRule_dataset.cancelRecord();
	return true;
}
function TCmWarnPersonRuleWindow_floatWindow_beforeHide(subwindow) {
	return TCmWarnPersonRuleWindow_floatWindow_beforeClose(subwindow);
}
//���ò�ѯ����
function btnReset_onClick(button){
	TCmWarnPersonRule_interface_dataset.clearData();
}
</script>
</@CommonQueryMacro.page>