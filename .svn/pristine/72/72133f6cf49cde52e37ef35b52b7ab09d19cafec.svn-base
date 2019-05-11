<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="岗位权限管理">
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<@CommonQueryMacro.CommonQuery id="ebankCustRoleMng" init="false">
<table width="600px" align="left">
	<tr >
		<td  align="left">
				<@CommonQueryMacro.Group id ="branchFuncGroup" label="岗位信息" fieldStr="roleName" colNm="4" />
				<div style="display:none">
					<@CommonQueryMacro.Button id="btSave" />
				</div>
		</td>
	</tr>
	<tr >
		<td  align="left">
		 	<@CommonQueryMacro.SimpleButton id= "btOpen" desc="展开/闭合" />
		 	&nbsp;&nbsp;&nbsp;&nbsp;
			<@CommonQueryMacro.SimpleButton id= "btSelectAll" desc="选定全部"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
	  		<@CommonQueryMacro.SimpleButton id= "btUnSelectAll" desc="取消选定"/>
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<@CommonQueryMacro.SimpleButton id= "btnSave" desc="保存"/>
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<#-- <@CommonQueryMacro.SimpleButton id= "btCancel" desc="返回" /> -->
	  	</td>
	</tr>
</@CommonQueryMacro.CommonQuery>
	<tr>
		<td>
		    <@CommonQueryMacro.CommonQuery id="roleFuncTree" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DynamicTree id="tree1" checkbox="true" />
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_post(){
		ebankCustRoleMng_dataset.setFieldReadOnly('roleName',false);
		ebankCustRoleMng_dataset.insertRecord();
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
	
	function btSave_postSubmit(button) {
		alert('保存成功！');
		window.parent.closeSubWin();
	}
	
	
	function btnSave_onClick(){
		//强制标记插入
		ebankCustRoleMng_dataset.setParameter('forceInsert','1');
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
		ebankCustRoleMng_dataset.setParameter('funcStr',s);
		btSave.click();
	}
	
	function doSaveTree(){
		var roleName = ebankCustRoleMng_dataset.getValue("roleName");
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
		PrivAction.updateRoleFuncByName(roleName,s,function(data){
			alert(data==0?"保存成功!":"保存失败!");
			window.parent.closeSubWin();
		});
	}
</script>
</@CommonQueryMacro.page>
