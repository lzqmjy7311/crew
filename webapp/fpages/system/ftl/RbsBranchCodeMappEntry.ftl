<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣά��">
<table width="1000px" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="RbsBranchCodeMappEntry" init="false" submitMode="current">
	<table width="100%">
		<tr>
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Interface id="interface" label="������Ϣ��ѯ" colNm=6 showButton="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.PagePilot id="pagePilot"  maxpagelink="9" showArrow="true" pageCache="false"/>
			</td>
			<td align="right"><a href="JavaScript:doAdd()">����</a></td>
		</tr>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.DataTable id="dataTable1" fieldStr="busitype,rbsbranchcode,branchcode,status,crtTm,crtTlr,lstUpdTm,lstUpdTlr,operation[80]"  width="100%" hasFrame="true" height="100%"  />
			</td>
		</tr>
		
		<tr>
      		<td colspan="2">
      			<@CommonQueryMacro.FloatWindow id="addModWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      				<div align="center">
      					<@CommonQueryMacro.Group id="group1" label="" colNm=4 fieldStr="busitype,rbsbranchcode,branchcode,status"/>
        				<br/>
        				<@CommonQueryMacro.Button id="btModOrAdd" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<@CommonQueryMacro.Button id="btCancel" />
      				</div>
     			</@CommonQueryMacro.FloatWindow>	
  			</td>
  		</tr>
		<tr>
			<td>
				<span id="size"> </span>&nbsp;&nbsp;<span id="show"> </span>
			</td>
		</tr>
		<tr align="left">
			<td colspan ="2">
				<@CommonQueryMacro.Button id= "btStatus"/>&nbsp;&nbsp;
			</td>
		</tr>
	</@CommonQueryMacro.CommonQuery>
<td>
</tr>
</table>
<script language="javascript">
	var ds = RbsBranchCodeMappEntry_dataset;
	
	//��λһ�м�¼
	function locate(id) {
		var record = ds.find(["id"],[id]);
		if(record) {
			ds.setRecord(record);
		}
	}
	function dataTable1_operation_onRefresh(cell,value,record) {
		if(record) {
			var content = "<center><a href=\"JavaScript:doMod('"+value+"')\">�޸�</a></center>";
			cell.innerHTML = content;
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}
	
	//�޸�
	function doMod(id) {
		locate(id);
		subwindow_addModWindow.show();
	}
	
	function doAdd() {
		ds.insertRecord("end");
		subwindow_addModWindow.show();
	}
	
	function btModOrAdd_postSubmit(button) {
		alert("����ɹ���");
		subwindow_addModWindow.close();
		flushCurrentPage();
	}

	//������ĺ���
	function btCancel_onClickCheck() {
		subwindow_addModWindow.close();
		return true;
	}
	//�ظ�������,�ͷ�dataset
	function addModWindow_floatWindow_beforeClose(subwindow) {
		ds.cancelRecord();
		return true;
	}
	function addModWindow_floatWindow_beforeHide(subwindow) {
		return addModWindow_floatWindow_beforeClose(subwindow);
	}
	function btStatus_onClickCheck(button) {
		var status = ds.getValue("status");
		ds.setParameter("valid","valid");
		if(status == '0'){
			if(confirm("ȷ�Ͻ��û�����Ϣ����Ϊ��Ч?")){
			    ds.setValue("status", "1");
				return true;
			}else{
				return false;
			}
		} else {
			if(confirm("ȷ�Ͻ��û�����Ϣ����Ϊ��Ч?")){
				ds.setValue("status", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	
	function btStatus_postSubmit(button) {
		alert("���óɹ�");
		//ˢ�µ�ǰҳ
		flushCurrentPage();
	}
	
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		ds.flushData(ds.pageIndex);
	}
</script>
</@CommonQueryMacro.page>