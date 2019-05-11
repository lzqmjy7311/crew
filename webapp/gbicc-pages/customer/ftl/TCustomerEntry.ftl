<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣ����  &gt;  �ͻ�">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCustomerEntry" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" colNm=6 label="�������ѯ����"  showButton="false"/>
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
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="custinfo,-,taskinfo,-,ruleinfo" fieldStr="custCode[130],custName[130],loanAccount,productCode[200],loanAmount,loanBalance,loanPeriod,operator,operBank"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="�ͻ�����"
        			  fieldStr="custCode,custName,loanAccount,productCode,loanAmount,loanBalance,loanPeriod,operator,operBank" colNm=4/>
        			<br/>
        			<@CommonQueryMacro.Button id="btModOrAdd" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btCancel" />
      			</div>
     		</@CommonQueryMacro.FloatWindow>	
  		</td>  
  	</tr>
	<tr style="display:none">
		<td><@CommonQueryMacro.Button id="btDel" /></td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
</table>
<script language="JavaScript">
	//���ò�ѯ����
	function btnReset_onClick(button){
		TCustomerEntry_interface_dataset.clearData();
	}
	//��λһ�м�¼
	function locate(id) {
		var record = TCustomerEntry_dataset.find(["id"],[id]);
		if(record) {
			TCustomerEntry_dataset.setRecord(record);
		}
	}
	//ϵͳˢ�µ�Ԫ��
	function datatablefincour_upDown_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			if( !(''==id || null == id))
			{
				cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+id+"')\">�޸�</a> &nbsp; <a href=\"JavaScript:doDel('"+id+"')\">ɾ��</a></center>";
			}
			
		}else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	
	function btAdd_onClick(button) {
			btNewClick();
	}
	//ȡ������
	function btCancel_onClickCheck(button) {
		//�رո�������
		subwindow_signWindow.close();
	}
	//�ظ�������,�ͷ�dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		TCustomerEntry_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		TCustomerEntry_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	//չʾ�Աȹ��ܵ�js
	function datatable1_id_onRefresh(cell, value, record){
		if(record!=null){
			var id=record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"')\">"+id+"</a>";
	
		} else {
			cell.innerHTML = ""
		}
	}


	function showDetail(id,sta){
	
		var paramMap = new Map();
		paramMap.put("id",id);
		paramMap.put("st",sta);
		paramMap.put("action","detail");
		paramMap.put("flag","0");
		
	}

	
	//�޸Ĺ���
	function openModifyWindow(id) {
		TCustomerEntry_dataset.setFieldReadOnly("id",true);
		TCustomerEntry_dataset.setFieldReadOnly("custcode",true);
		subwindow_signWindow.show();	
	}
	
	function custinfo_onClick(){
		var loanAccount = TCustomerEntry_dataset.getValue('loanAccount');
		var custCode = TCustomerEntry_dataset.getValue('custCode');
		btCustomerShow(loanAccount,custCode);
	}
	function btCustomerShow(loanAccount,custCode){
		var paramMap = new Map();
	    paramMap.put("loanAccount", loanAccount);	    
	    paramMap.put("custCode", custCode);	    
	   // loadPageWindows("userWin", "�ͻ���Ϣ", "/gbicc-pages/customer/ftl/TCustomerInfoEntry.ftl", paramMap, "winZone");
	    eventWin=openSubWin("eventWin","�ͻ���Ϣ","/gbicc-pages/customer/ftl/TCustomerInfoEntry.ftl"+"?loanAccount="+loanAccount+"&custCode="+custCode,"1100","700");
	    return;
	}
	
	function taskinfo_onClick(){
	  var  loanAccount=TCustomerEntry_dataset.getValue('loanAccount');
	  btTaskListShow(loanAccount);
	}
	
	function btTaskListShow(loanAccount){
		var paramMap = new Map();
	    paramMap.put("loanAccount", loanAccount);	    
	    //loadPageWindows("taskWin", "������Ϣ", "/gbicc-pages/task/ftl/task_info_entry.ftl", paramMap, "winZone");
	    eventWin=openSubWin("eventWin","������Ϣ","/gbicc-pages/task/ftl/task_entry.ftl"+"?loanAcct="+loanAccount,"1100","700");
	    return;
	}
	function ruleinfo_onClick(){
	  var  loanAccount=TCustomerEntry_dataset.getValue('loanAccount');
	  btRuleListShow(loanAccount);
	}
	
	function btRuleListShow(loanAccount){
		var paramMap = new Map();
	    paramMap.put("loanAccount", loanAccount);	    
	   // loadPageWindows("warnWin", "Ԥ����Ϣ", "/gbicc-pages/warn/ftl/warning_info_entry.ftl", paramMap, "winZone");
	    eventWin=openSubWin("eventWin","Ԥ���嵥","/gbicc-pages/warn/ftl/warning_info_entry.ftl"+"?loanAccount="+loanAccount,"1100","700");
	    return;
	}
	
	function doDel(id) {
		locate(id);
		btDel.click();
	}
	
	function btDel_onClickCheck(button) {
		return confirm("ȷ��ɾ��������¼��");
	}
	function btDel_postSubmit(button) {
		
		button.url="#";
		//ˢ�µ�ǰҳ
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = TCustomerEntry_dataset.getValue("id");
		return true;
	}
	//�����ˢ�µ�ǰҳ
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}
	var eventWin;
	function eventWin_close(){
		eventWin.close();
		TCustomerEntry_dataset.flushData(TCustomerEntry_dataset.pageIndex);
	}
	//�����ش��¼�
	function btAddEvent_onClick(button){
		var id = TCustomerEntry_dataset.getValue('id');
		if(id==null || id==""){
			top.easyMsg.info("��ѡ��Ҫ���ӵĿͻ���");
			return;
		}
		eventWin=openSubWin("eventWin","�����ش��¼�","/gbicc-pages/customer/ftl/great_event_dtl.ftl"+"?custId="+id,"1100","700");
	}
	function btReadEvent_onClick(button){
		var id = TCustomerEntry_dataset.getValue('id');
		if(id==null || id==""){
			top.easyMsg.info("����ѡ��Ҫ�鿴�Ŀͻ���");
			return;
		}
		eventWin=openSubWin("eventWin","�鿴�ش��¼�","/gbicc-pages/customer/ftl/read_great_event_dtl.ftl"+"?custId="+id,"1100","700");
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TCustomerEntry_dataset.flushData(TCustomerEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>