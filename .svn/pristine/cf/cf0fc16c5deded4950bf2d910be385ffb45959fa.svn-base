<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">

<@CommonQueryMacro.CommonQuery id="parammng_TlrInfo2" init="true" navigate="false" parameters="action=query" readOnly="false">
	<table align="left">
			<tr>
       		<td valign="top"  valign="top">
         		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="select1,roleid,rolename" width="200" readonly="false"/>
       		</td>
      		</tr>

   </table>
</@CommonQueryMacro.CommonQuery>
</td>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="parammng_TlrInfo3" init="true" navigate="false" submitMode="all" parameters="action=query">
	<table align="left">
			<tr>
       			<td rowspan="1"  valign="top"  width="500">
        		<@CommonQueryMacro.Group id="group1" label="操作员信息" fieldStr="brcode,tlrno,tlrName,defRoleid,status,effectDate,expireDate,email" colNm=4/>
        		</td>
      		</tr>
      		<tr>
       			<td align="center">
         		<@CommonQueryMacro.Button id= "btSave"/>
         		&nbsp;&nbsp;
         		<@CommonQueryMacro.Button id= "btdel"/>
     			<#-- add by zhaozhiguo 20110620 BMS-3153 begin -->
     			&nbsp;&nbsp;
  				<@CommonQueryMacro.Button id= "unLock" />
  				<#-- add by zhaozhiguo 20110620 BMS-3153 end -->
        		</td>
      	  	</tr>
   </table>
      <script language="javascript">
      <#-- added by junzhong.duan 20110422 LNDN-201 begin -->
      	function initCallGetter_post(){
      		var record = parammng_TlrInfo2_dataset.firstUnit;
			defRoleid_DropDownDataset.clearData();
			while(record){
				var v_selected = record.getValue("select1");
				var v_roleId,v_roleName;
				if( v_selected == true ){
					v_roleId = record.getValue("roleId");
					v_roleName = record.getValue("roleName");
					defRoleid_DropDownDataset.insertRecord();
					defRoleid_DropDownDataset.setValue("data",v_roleId);
					defRoleid_DropDownDataset.setValue("dataName",v_roleId + "-" + v_roleName);
				}
				record=record.nextUnit;
			}
      	}
		 <#-- added by junzhong.duan 20110422 LNDN-201 end -->
		function btdel_onClickCheck(button) {
			var tlrno = parammng_TlrInfo3_dataset.getValue("tlrno");
			var tlrnoname = parammng_TlrInfo3_dataset.getValue("tlrName");
			var msg = "删除操作员：" + tlrno + "-" + tlrnoname + "及其所有岗位信息，请确认？";
			if(confirm(msg)) {
				parammng_TlrInfo3_dataset.setParameter("cmd","del");
				return true;
			}else{
				return false;
			}
		}

		function btSave_postSubmit()
		{
        alert('保存成功');
        }

        function parammng_TlrInfo2_dataset_afterChange(dataset,field){
		if(field.fieldName == "select1"){
			var record = dataset.firstUnit;
			defRoleid_DropDownDataset.clearData();
			while(record){
				var v_selected = record.getValue("select1");
				var v_roleId,v_roleName;
				if( v_selected == true ){
					v_roleId = record.getValue("roleId");
					v_roleName = record.getValue("roleName");
					defRoleid_DropDownDataset.insertRecord();
					defRoleid_DropDownDataset.setValue("data",v_roleId);
					defRoleid_DropDownDataset.setValue("dataName",v_roleId + "-" + v_roleName);
				}else{
					v_roleId = record.getValue("roleId");
					var v_defRoleid = parammng_TlrInfo3_dataset.getValue("defRoleid");
					if( v_defRoleid == v_roleId ){
						 parammng_TlrInfo2_dataset.setValue("defRoleid","");
						 parammng_TlrInfo2_dataset.setValue("defRoleidName","");
					}
				}
				record=record.nextUnit;
			}
		}
	}
	</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">
<#-- add by zhaozhiguo 20110620 BMS-3153 begin -->
function unLock_onClickCheck(button) {
	parammng_TlrInfo3_dataset.setParameter("cmd","unlock");
}
function unLock_postSubmit(button) {
	alert("解锁成功！");
	parammng_TlrInfo3_dataset.flushData(parammng_TlrInfo3_dataset.pageIndex);
}

function parammng_TlrInfo3_dataset_afterScroll(dataset){
	var userid = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}";
	//add by zhaozhiguo BMS-3153
	unLock.disable(dataset.getValue("isLock") != '1' || dataset.getValue("tlrno") == userid);
	btdel.disable(dataset.getValue("tlrno") == userid);
	
}
<#-- add by zhaozhiguo 20110620 BMS-3153 end -->
</script>
</@CommonQueryMacro.page>

