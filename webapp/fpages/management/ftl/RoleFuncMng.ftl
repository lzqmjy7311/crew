<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="��λȨ�޹���">
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'></script>
<@CommonQueryMacro.CommonQuery id="RoleFuncMng" init="true">
<table width="100%" align="left">
	<tr >
		<td  align="left">
				<@CommonQueryMacro.Group id ="branchFuncGroup" label="��λ��Ϣ" fieldStr="roleName,fucUrl,roleSysType" colNm="2"/>
		</td>
	</tr>
	<tr >
		<td  align="left">
		 	<@CommonQueryMacro.Button id= "btOpen" />
		 	&nbsp;&nbsp;&nbsp;&nbsp;
			<@CommonQueryMacro.Button id= "btSelectAll" />
			&nbsp;&nbsp;&nbsp;&nbsp;
	  		<@CommonQueryMacro.Button id= "btUnSelectAll" />
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<@CommonQueryMacro.Button id= "btSave" />
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<#-- 
	  		<@CommonQueryMacro.Button id= "btCancel" />
	  		 -->
	  	</td>
	</tr>
</@CommonQueryMacro.CommonQuery>
	<tr>
		<td>
		    <@CommonQueryMacro.CommonQuery id="roleFuncTree" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DynamicTree id="tree1" checkbox="true" mode="static"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_post(){
		//RoleFuncMng_dataset.setFieldReadOnly('roleName',false);
	}
	
	var expandAllFlag = false;
	
	function btOpen_onClick(){
		if(!expandAllFlag){
			DynamicTree_tree1.expandAll();
		}else{
			DynamicTree_tree1.collapseAll();
		}
		expandAllFlag=!expandAllFlag;
	}
	
	function btSelectAll_onClick(){
		DynamicTree_tree1.selectAll();
	}
	
	function btUnSelectAll_onClick(){
		DynamicTree_tree1.unSelectAll();
	}
	
	
	
	function btSave_onClick(){
		var roleName = RoleFuncMng_dataset.getString("id");
		var fucUrl = RoleFuncMng_dataset.getString("fucUrl");
		var roleSysType = RoleFuncMng_dataset.getString("roleSysType");
		var s = "";
		var flag = 0;
		var checkedArr = DynamicTree_tree1.getChecked();
		for(var i=0;i<checkedArr.length;i++){
			if(flag++>0){
				s+=",";
			}
			s+=checkedArr[i].id;
		}
		var indeterminateArr = DynamicTree_tree1.getIndeterminate();
		for(var i=0;i<indeterminateArr.length;i++){
			s+=",";
			s+=indeterminateArr[i].id;
		}
		TaskVariable.updateRoleFunc(roleName,fucUrl,roleSysType,s,function(data){
			var saveFlag = data==0;
			alert(saveFlag?"����ɹ�!":"����ʧ��!");
			if(saveFlag){
				window.parent.closeSubWin();
			}
			
		});
	}
</script>
</@CommonQueryMacro.page>