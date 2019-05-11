<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="客户信息管理">
<table width="800px" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="CustomerReaEntry" init="true" submitMode="current">
	<table width="100%">
		<tr>
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Interface id="interface" label="机构查询" colNm=4 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td >
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="9" showArrow="true" pageCache="false"/>
			</td>
				<td align="right">
	    				<a href="javascript:btNewClick();">新增</a>
	       			 </td>
			
		</tr>	
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.DataTable id="dataTable1" fieldStr="id[60],orgId[60],customerType[80],customerName[60],paperType[100],paperCode[100],registrationMoney[60],corporationRepname[80],stockFlag[60],opr[80]" />
			</td>
		</tr>
		<tr style="display:none">
		<td>
			<@CommonQueryMacro.Button id= "btNew"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
		</td>
		</tr>
		<tr>
			<td>
				<span id="size"> </span>&nbsp;&nbsp;<span id="show"> </span>
			</td>
		</tr>
	</table>	
	</@CommonQueryMacro.CommonQuery>
<td>
</tr>	 	
</table>
<script language="javascript">
	function btNewClick(){
	//	subwindow_signWindow.show();
	  CustomerReaEntry_dataset.insertRecord("end");
		btNew.click();
	}
	
		//当系统刷新单元格的内容时被触发 
	function dataTable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			cell.innerHTML="<a href='JavaScript:doModify("+value+")'><@bean.message key="修改" /></a> &nbsp; <a href='JavaScript:doDelete("+value+")'><@bean.message key="删除" /></a>";
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}
	
	//定位一条记录
function locate(id) {
	var record = CustomerReaEntry_dataset.find(["id"],[id]);
	if (record) {
		CustomerReaEntry_dataset.setRecord(record); 
	}
}

	//修改
function doModify(id) {
	locate(id);
	btMod.click();
}

//删除
function doDelete(id) {
	locate(id);
	if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	
}


//删除后处理
function btDel_postSubmit(button) {
	alert('删除记录成功');
	CustomerReaEntry_dataset.flushData(CustomerReaEntry_dataset.pageIndex);
}
	
</script>
</@CommonQueryMacro.page>			
