<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign id=RequestParameters["id"]?default("")>
<@CommonQueryMacro.page title="基础信息管理  &gt;  客户">
<table align="left"><tr><td>

<table width="100%">
  
	<tr>
		<td >
		<@CommonQueryMacro.CommonQuery id="TCustomerInfoEntry"  init="true" navigate="false" submitMode="all" >
		  <@CommonQueryMacro.Group id="group1" label="客户基本信息"
               fieldStr="custCode,custName,zjlx,zjhm,sex,hyzk,zgxl,zy,gj,mz,jg,sfbdr,address,hkxz,gzdw,gzsj,loanAccount,productCode,loanAmount,loanBalance,loanPeriod,operator,operBank" colNm=4/>
		  </@CommonQueryMacro.CommonQuery>	
		</td>
	</tr>


	<@CommonQueryMacro.CommonQuery id="TEdwPlsSocietalRelV"  init="true" navigate="false" submitMode="all" >   
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" showButton="false" label="关键联系人" />
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
//页面初始化
function initCallGetter_post(){

		//设置页面只读
		setPageReadOnlyFun();			
};
	
	//设置页面所有字段只读
function setPageReadOnlyFun(){
	
	var fieldName="";
	for(var i=0;i<TCustomerInfoEntry_dataset.fields.length;i++){
		fieldName=TCustomerInfoEntry_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCustomerInfoEntry_dataset.setFieldReadOnly(fieldName,true);
		}
	}
}	
	//定位一行记录
	function locate(id) {
		var record = TCustomerInfoEntry_dataset.find(["id"],[id]);
		if(record) {
			TCustomerInfoEntry_dataset.setRecord(record);
		}
	}
	//系统刷新单元格
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			if( !(''==id || null == id))
			{
				cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+id+"')\">修改</a> &nbsp; <a href=\"JavaScript:doDel('"+id+"')\">删除</a></center>";
			}
			
		}else {
			cell.innerHTML="&nbsp;";
		}
	}
	function btAdd_onClick(button) {
			btNewClick();
	}
	//取消功能
	function btCancel_onClickCheck(button) {
		//关闭浮动窗口
		subwindow_signWindow.close();
	}
	//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		TCustomerInfoEntry_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		TCustomerInfoEntry_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	//展示对比功能的js
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

	
	//修改功能
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
	    loadPageWindows("userWin", "客户信息", "/fpages/customer/ftl/TCustomerInfoEntry.ftl", paramMap, "winZone");
	    
	}
	
	function doDel(id) {
		locate(id);
		btDel.click();
	}
	
	function btDel_onClickCheck(button) {
		return confirm("确认删除该条记录？");
	}
	function btDel_postSubmit(button) {
		
		button.url="#";
		//刷新当前页
		flushCurrentPage();
	}
	function btModOrAdd_onClickCheck(button) {
		var id = TCustomerInfoEntry_dataset.getValue("id");
		return true;
	}
	//保存后刷新当前页
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		TCustomerInfoEntry_dataset.flushData(TCustomerInfoEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>