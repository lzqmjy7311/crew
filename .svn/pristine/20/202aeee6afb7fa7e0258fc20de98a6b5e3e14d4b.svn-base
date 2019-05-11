<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基础信息管理  &gt;  国家">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="BiNationregionEntry" init="false" submitMode="current">
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
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAdd" fieldStr="id,chinaName,nationregionNumber,chinaShortName,engName,engShortName,st,operation"  width="100%" hasFrame="true"/>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="国家/地区代码维护"
        			  fieldStr="id,nationregionNumber,chinaName,chinaShortName,engName,engShortName" colNm=4/>
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
	//定位一行记录
	function locate(id) {
		var record = BiNationregionEntry_dataset.find(["id"],[id]);
		if(record) {
			BiNationregionEntry_dataset.setRecord(record);
		}
	}
	//系统刷新单元格
	function datatable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("id");
			var lock = record.getValue("lock");
			
			if( !(''==id || null == id))
			{
			
				if(isTrue(lock))
				{
					cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a> &nbsp; <a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">删除</a></center>";
				}else{
					cell.innerHTML="<center><a href=\"JavaScript:openModifyWindow('"+id+"')\">修改</a> &nbsp; <a href=\"JavaScript:doDel('"+id+"')\">删除</a></center>";
				}
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
		BiNationregionEntry_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		BiNationregionEntry_dataset.insertRecord("end");
		subwindow_signWindow.show();
	}
	//展示对比功能的js
	function datatable1_id_onRefresh(cell, value, record){
	if(record!=null){
		var sta = record.getValue("st");
		var id=record.getValue("id");


		cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+sta+"')\">"+id+"</a>";

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
	loadPageWindows("partWin", "国家地区代码详细信息","/fpages/basis/ftl/BiNationregionEntryDetail.ftl", paramMap, "winZone");
	
}


	
	//修改功能
	function openModifyWindow(id) {
		locate(id);
		BiNationregionEntry_dataset.setFieldReadOnly("id",true);
		BiNationregionEntry_dataset.setFieldReadOnly("chinaName",false);
		BiNationregionEntry_dataset.setFieldReadOnly("chinaShortName",false);
		BiNationregionEntry_dataset.setFieldReadOnly("engName",false);
		BiNationregionEntry_dataset.setFieldReadOnly("engShortName",false);
		
		BiNationregionEntry_dataset.setFieldReadOnly("nationregionNumber",false);
		subwindow_signWindow.show();	
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
		var id = BiNationregionEntry_dataset.getValue("id");
		if(id == null || "" == id ) {
			alert("字段[国家/地区代码]不能为空");
			return false;
		}
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
		BiNationregionEntry_dataset.flushData(BiNationregionEntry_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>