<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="��λ����">
<@CommonQueryMacro.CommonQuery id="ebankCustRoleMng" init="true" submitMode="current">
	<table align="left" width="100%">
      <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>

	  </tr>
      </tr>
      <tr>
      		<td valign="top" colspan="2">
      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAddRole,-,btStatus,-,btRoleAuthorityManagement,-,btnViewOper" fieldStr="id[80],roleName,status,st" readonly="true" width="100%"/></br>
      		</td>
      </tr>

      <tr>
      		<td valign="top" colspan="2">
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id ="group1" label="��ϸ��Ϣ" fieldStr="roleName"/>
        			<div align="left"><font color="red">*</font>�����,���������Ȩ����Ϣ.</div>
      				<@CommonQueryMacro.Button id= "btSave"/>
      			</div>
     		 </@CommonQueryMacro.FloatWindow>
      		</td>
      </tr>
      <tr>
      		<td style="display:none">
      			<@CommonQueryMacro.Button id= "btDeleteRole"/>
      			<@CommonQueryMacro.Button id= "btRoleAuthorityManagement"/>
      			<@CommonQueryMacro.Button id= "btSelectRole"/>
      		</td>
      </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<span style="display:none">
<@CommonQueryMacro.CommonQuery id="PosiNameCheck" init="false" navigate="false" >
</@CommonQueryMacro.CommonQuery>
</span>
<script language="JavaScript">
 
 function btButtonAuth_onClickCheck(button){
	var id=ebankCustRoleMng_dataset.getValue("id");
	var roleName=ebankCustRoleMng_dataset.getValue("roleName");
	//id, title, url, width, height
	openSubWin("buttonAuth",roleName+"�İ�ťȨ���趨","/fpages/regonization/ftl/ButtonMng.ftl?roleId="+id,'','','','','',true);
	 return false;
}


	//��λһ����¼
	function locate(id) {
		var record = ebankCustRoleMng_dataset.find(["id"],[id]);
		if (record) {
			ebankCustRoleMng_dataset.setRecord(record);
		}
	}

	function openRoleDtl(id){
		locate(id);
		subwindow_signWindow.show();
	}

	function btAddRole_onClickCheck(button){
		var url = "/fpages/management/ftl/RoleFuncAdd.ftl?id=0";
		currentSubWin = openSubWin("pageWinId2", "������λ", url,650,450);
		return false;
	}
	function btStatus_onClickCheck(button) {
		var status = ebankCustRoleMng_dataset.getValue("status");
		if(status == '0'){
			if(confirm("ȷ�Ͻ��ø�λ����Ϊ��Ч?")){
			    ebankCustRoleMng_dataset.setParameter("statu", "1");
				return true;
			}else{
				return false;
			}
		} else {
			if(confirm("ȷ�Ͻ��ø�λ����Ϊ��Ч?")){
				ebankCustRoleMng_dataset.setParameter("statu", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	function btStatus_postSubmit(button) {
		alert("���óɹ�");
		ebankCustRoleMng_dataset.flushData(ebankCustRoleMng_dataset.pageIndex);
	}
	function datatable1_opr_onRefresh(cell, value, record)
	{
		if(record&&record!=null){
			var id = record.getValue("id");
			var Lock =record.getValue("isLock");
			var innerText="";
			if (Lock=="1") {
			innerText= "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"��¼�����������ܲ���\">��ɫȨ������</a> ";
		}
		else{
		innerText="<center><a href=\"JavaScript:rolePrivShow("+id+")\">��ɫȨ������</a> "
		}
			cell.innerHTML = innerText+" <a href=\"JavaScript:btRoleUserShow("+id+")\">�鿴��Ա</a></center>";

	}
	else{
	cell.innerHTML="";}

	}
	
	function btnViewOper_onClick(){
		var id = ebankCustRoleMng_dataset.getValue('id');
		btRoleUserShow(id);
	}
	
	function datatable1_rolename_onRefresh2(cell, value, record)
	{
		if(record!=null){
			var st = record.getValue("st");
			var id = record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+st+"')\">"+value+"</a>";

		} else {
			cell.innerHTML = ""
		}
	}
	//function showDetail(id,st){
		//var paramMap = new Map();
		//paramMap.put("id",id);
		//paramMap.put("st",st);
		//paramMap.put("op","detail");
		//loadPageWindows("partWin", "��ɫ������ϸ��Ϣ","/fpages/management/ftl/RoleFuncMng.ftl", paramMap, "winZone");
    //}
	//��ϸ
	function showDetail(id,st) {

		locate(id);
		showWin("��ɫ������ϸ��Ϣ","${contextPath}/fpages/system/ftl/RoleFuncMngWithEdit.ftl?id="+id+"&st="+st+"&flag=0",null,null,window);
	}


	function btRoleUserShow(id){
		var paramMap = new Map();
	    paramMap.put("roleId", id);
	    loadPageWindows("userWin", "�鿴��Ա��Ϣ", "/fpages/management/ftl/ebankCustRoleMngUser.ftl", paramMap, "winZone");
	    return;
	}

	function btRoleAuthorityManagement_onClickCheck(){
		var id = ebankCustRoleMng_dataset.getValue('id');
		currentSubWin = openSubWin("pageWinId1", "", "/fpages/management/ftl/RoleFuncMng.ftl?id="+id);
		return false;
	}
	
	
	
	var currentSubWin;
	
	function closeSubWin(){
		if(currentSubWin){
			currentSubWin.close();
		}
	}
	
	function btSave_postSubmit(){
       //alert('����ɹ���');
       subwindow_signWindow.hide();
       ebankCustRoleMng_dataset.flushData(ebankCustRoleMng_dataset.pageIndex);
    }
	function signWindow_floatWindow_beforeClose(subwindow){
		ebankCustRoleMng_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow){
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	function ebankCustRoleMng_dataset_afterInsert(dataset, mode){
		ebankCustRoleMng_dataset.setValue2("status", "1");
	}

	function ebankCustRoleMng_dataset_afterChange(dataset,field,value){
		if(field.fieldName == "roleName"){
			PosiNameCheck_dataset.setParameter("roleName",ebankCustRoleMng_dataset.getValue("roleName"));
			PosiNameCheck_dataset.flushData(0);
			var v_flag = PosiNameCheck_dataset.getValue("flag");
			if(v_flag == "true"){
				alert("�ø�λ�����Ѵ��ڣ�����������");
				ebankCustRoleMng_dataset.setValue("roleName","");
				return false;
			}
		}

	}
	function ebankCustRoleMng_dataset_afterScroll(dataset){

		var Lock =dataset.getValue("isLock");
		if (Lock=="1") {
			btStatus.disable(true);
		}
		else
		{btStatus.disable(false);}
	}
</script>
</@CommonQueryMacro.page>
