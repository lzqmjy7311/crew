<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="人工预警规则管理">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnPersonRule" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" readonly="true" paginationbar="btnAdd,-,btnUpd,-,btnDel" fieldStr="warnCode[60],warnName[150],warnSubjectCode[90],warnLevel[60],warnProcessLevel[150],desc[340],updated[60]"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="TCmWarnPersonRuleWindow" label="人工预警规则" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
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
		if(confirm("是否确认删除该预警规则?")){
			TCmWarnPersonRule_dataset.setParameter("op","del");
		}else{
			return false;
		}
	}else{
		top.easyMsg.info("请选择一条数据！");
		return false;
	}
}
function btnSave_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("提交成功！");
	TCmWarnPersonRule_dataset.flushData(TCmWarnPersonRule_dataset.pageIndex);
	subwindow_TCmWarnPersonRuleWindow.close();
}
function btnDel_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("删除成功！");
	TCmWarnPersonRule_dataset.flushData(TCmWarnPersonRule_dataset.pageIndex);
}

//关浮动窗口,释放dataset
function TCmWarnPersonRuleWindow_floatWindow_beforeClose(subwindow) {
	TCmWarnPersonRule_dataset.cancelRecord();
	return true;
}
function TCmWarnPersonRuleWindow_floatWindow_beforeHide(subwindow) {
	return TCmWarnPersonRuleWindow_floatWindow_beforeClose(subwindow);
}

</script>
</@CommonQueryMacro.page>
