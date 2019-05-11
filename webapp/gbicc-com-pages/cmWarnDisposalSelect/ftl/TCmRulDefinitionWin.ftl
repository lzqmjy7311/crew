<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<@CommonQueryMacro.page title="Ԥ������  &gt;  Ԥ��ѡ��">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnPersonRule" init="true" submitMode="current">
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
			<@CommonQueryMacro.DataTable id="datatable9" paginationbar="ruleAddBtn" fieldStr="opr,warnCode[60],warnName[150],warnSubjectCode[90],warnLevel[60],warnProcessLevel[150],desc[340]"  width="100%" hasFrame="true"/>
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

function datatable9_opr_onRefresh(cell,value,record) {
	if (record) {//�����ڼ�¼ʱ
		var id=record.getValue("id");
		cell.innerHTML="<input type='checkbox' name='ss' value='checkbox' onchange='checkedFun(\""+id+"\",this)' />";
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
}
var ids="";
function checkedFun(id,che){
	
	if(che.checked==true){
		ids=ids+","+id;
	}else{
		ids=ids.replace(","+id,"");
	}
}
function ruleAddBtn_onClick(button) {
	if(ids==""){
		top.easyMsg.info("��ѡ��һ����¼��");
		return false;
	}
	var businessId='${businessId}';
	var paramStr=[ids,businessId];
	TCmWarnTaskRelAjax.addTCmWarnTaskRel(paramStr,function(f){
		 if(f.success=="true"){
			window.parent.TCmWarnTaskRel_dataset.flushData(window.parent.TCmWarnTaskRel_dataset.pageIndex);
			window.parent.selectWarnWin.close();
		 }else{
			 top.easyMsg.info(f.message);
		 }
	});
}

</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TCmWarnTaskRelAjax.js'> </script>
</@CommonQueryMacro.page>
