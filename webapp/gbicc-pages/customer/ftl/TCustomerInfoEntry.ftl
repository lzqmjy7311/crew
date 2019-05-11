<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign id=RequestParameters["id"]?default("")>
<@CommonQueryMacro.page title="������Ϣ����  &gt;  �ͻ�">
<table align="left"><tr><td>

<table width="100%">
  
	<tr>
		<td >
		<@CommonQueryMacro.CommonQuery id="TCustomerInfoEntry"  init="true" navigate="false" submitMode="all" >
		  <@CommonQueryMacro.Group id="group1" label="�ͻ�������Ϣ"
               fieldStr="custCode,custName,zjlx,zjhm,sex,hyzk,zgxl,zy,gj,mz,jg,sfbdr,address,hkxz,gzdw,gzsj,loanAccount,productCode,loanAmount,loanBalance,loanPeriod,operator,operBank" colNm=4/>
		  </@CommonQueryMacro.CommonQuery>	
		</td>
	</tr>


	<@CommonQueryMacro.CommonQuery id="TEdwPlsSocietalRelV"  init="true" navigate="false" submitMode="all" >   
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" showButton="false" label="�ؼ���ϵ��" />
		</td>
	</tr>
	<tr>
	    <td valign="center">
			<@CommonQueryMacro.DataTable id="datatable1"  paginationbar="" fieldStr="familycustid,familycustname,relasign,operid"   hasFrame="true"/>
		</td>
	</tr>
	</@CommonQueryMacro.CommonQuery>
</table>


<script language="JavaScript">
//ҳ���ʼ��
function initCallGetter_post(){

		//����ҳ��ֻ��
		setPageReadOnlyFun();			
};
	
	//����ҳ�������ֶ�ֻ��
function setPageReadOnlyFun(){
	
	var fieldName="";
	for(var i=0;i<TCustomerInfoEntry_dataset.fields.length;i++){
		fieldName=TCustomerInfoEntry_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCustomerInfoEntry_dataset.setFieldReadOnly(fieldName,true);
		}
	}
}	
	//��λһ�м�¼
	function locate(id) {
		var record = TCustomerInfoEntry_dataset.find(["id"],[id]);
		if(record) {
			TCustomerInfoEntry_dataset.setRecord(record);
		}
	}
	//ϵͳˢ�µ�Ԫ��
	function datatable1_operation_onRefresh(cell,value,record) {
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
		TCustomerInfoEntry_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//��������
	function btNewClick() {
		TCustomerInfoEntry_dataset.insertRecord("end");
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
		TCustomerInfoEntry_dataset.setFieldReadOnly("id",true);
		TCustomerInfoEntry_dataset.setFieldReadOnly("custcode",true);
		subwindow_signWindow.show();	
	}
	
	function custinfo_onClick(){
		var id = TCustomerInfoEntry_dataset.getValue('id');
		btCustomerShow(id);
	}
	function btCustomerShow(id){
		var paramMap = new Map();
	    paramMap.put("id", id);
	    loadPageWindows("userWin", "�ͻ���Ϣ", "/fpages/customer/ftl/TCustomerInfoEntry.ftl", paramMap, "winZone");
	    
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
		var id = TCustomerInfoEntry_dataset.getValue("id");
		return true;
	}
	//�����ˢ�µ�ǰҳ
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TCustomerInfoEntry_dataset.flushData(TCustomerInfoEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>