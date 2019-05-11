<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="SysParamsEntry.title">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="sysParamsEntry" init="false" submitMode="current">
<table width="900px">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="sysParamsEntry.interface.interface.label" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="paramgroupId,paramId,paramName,paramVal,memo,st,operation"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false"
			maximize="false" closure="true" float="true" exclusive="true" position="center" show="false">
				<@CommonQueryMacro.Group id="group1" fieldStr="paramgroupId,paramId,paramName,paramVal,memo" label="sysParamsEntry.group.group1.label" colNm="4" />
				<br/>
				<@CommonQueryMacro.Button id="btMod" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<@CommonQueryMacro.Button id="btCancel" />
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
	//ϵͳˢ�µ�Ԫ���Ǵ���
	function datatable1_operation_onRefresh(cell,value,record) {
		//��¼������
		if(record) {
			var paramgroupId = record.getValue("paramgroupId");
			var paramId = record.getValue("paramId");
			//��ֹ�����Զ�ת�������Դ�һ��ֵ
			var par = "p"+paramgroupId+"p"+paramId+"p";
			var lock=record.getValue("lock");
			if(isTrue(lock)){
				cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"��¼�����������ܲ���\"><@bean.message key="SysParamsEntry.button.btMod" /></a> </center>";
			}else{
				cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+par+"')\"><@bean.message key='SysParamsEntry.button.btMod'/></a></center>";

			}
		}else{
			cell.innerHTML="";
		}


	}
	//չʾ�Աȹ��ܵ�js
	function datatable1_paramgroupid_onRefresh(cell, value, record){
	if(record!=null){
		var st = record.getValue("st");
		var id1 = record.getValue("paramgroupId");
		var id2 = record.getValue("paramId");
		var id = id2+"#"+id1;



		cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+st+"')\">"+id1+"</a>";

	} else {
		cell.innerHTML = ""
	}
}


function showDetail(id,st){

	var paramMap = new Map();

	paramMap.put("id",id);
	paramMap.put("st",st);
	paramMap.put("flag","0");
	paramMap.put("action","detail");
	loadPageWindows("partWin", "ϵͳ����","/fpages/system/ftl/SysParamsEntryDetail.ftl", paramMap, "winZone");
}




	function openModifyWindow(par) {

		var parArra = par.split("p");
		var paramgroupId = parArra[1];
		var paramId = parArra[2];
		locate(paramgroupId,paramId);
		sysParamsEntry_dataset.setFieldReadOnly("paramgroupId",true);
		sysParamsEntry_dataset.setFieldReadOnly("paramId",true);
		sysParamsEntry_dataset.setFieldReadOnly("paramName",false);
		sysParamsEntry_dataset.setFieldReadOnly("paramVal",false);
		sysParamsEntry_dataset.setFieldReadOnly("memo",false);
		subwindow_signWindow.show();
	}


	//��λһ����¼
	function locate(paramgroupId,paramId) {
		var record = sysParamsEntry_dataset.find(["paramgroupId","paramId"],[paramgroupId,paramId]);
		if(record) {
			sysParamsEntry_dataset.setRecord(record);
		}
	}
	function btCancel_onClickCheck(button) {
		//�رո�������
		subwindow_signWindow.close();
	}
	//�ظ�������,�ͷ�dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		sysParamsEntry_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//ȷ�ϰ�ť��ˢ�µ�ǰҳ
	function btMod_postSubmit(button) {
	    button.url="#";
		subwindow_signWindow.close();

		sysParamsEntry_dataset.flushData(sysParamsEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>