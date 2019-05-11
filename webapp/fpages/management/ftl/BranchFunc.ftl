<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="机构权限管理">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/js/tree.js"></script>
<script type="text/javascript" src="${contextPath}/js/xtree.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<@CommonQueryMacro.CommonQuery id="Management_branchFunc" init="false">
<table align="left">
	<tr >
		<td  align="left">
				<@CommonQueryMacro.Group id ="branchFuncGroup" label="机构选择" fieldStr="brcode" colNm=4/>
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
	  	</td>
	</tr>
	<tr >
		<td  align="left" >
		 <div id="tree">
			<script language="javascript">
				var functree = null;
				dwr.engine.setAsync(false);
				PrivAction.getFuncArray(function(data)
				{
					functree = data;
				});
				dwr.engine.setAsync(true);
                createTree(functree,0,0);

           </script>
           </div>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">

	_close_flag = true;

	//全选
	function funSelectAll(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = true;
			}
		}
		<#--20110818 BMSA-54 权限树目录菜单可全选 begin -->
		pcheck(1);
		<#--20110818 BMSA-54 权限树目录菜单可全选 end -->
	}
	//全不选
	function funSelectNo(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = false;
			}
		}
		<#--20110818 BMSA-54 权限树目录菜单可全选 begin -->
		pcheck(0);
		<#--20110818 BMSA-54 权限树目录菜单可全选 end -->
	}
	//得到所选的权限
	function getCheckDatas(){
	    var obj = document.getElementsByName("id");
		var len = document.getElementsByName("id").length;
		var s = "";
		var flag=0;
		for(i=0;i<len;i++){
			if(document.getElementsByName("id")[i].checked == true){
				if(flag > 0) s += ",";
				s += document.getElementsByName("id")[i].value;
				flag++;
			}
		}
		return s;

	}

	//展开节点树
	function viewtree(){
		if(_close_flag){
			closeAll(1);
			_close_flag = false;
		}else{
			closeAll(0);
			_close_flag = true;
		}
	}

	function save(){
		var brcode = Management_branchFunc_dataset.getString("brcode");
		if(brcode == null || brcode == "")
		{
			alert("请选择机构");
			return false;
		}
		var s = getCheckDatas();
		PrivAction.updateBranchFunc(brcode,s,checkResult);
	}
	function checkResult(data)
	{
		if(data == 0)
		{
			alert("保存成功！");
		}
		else
		{
			alert("保存失败！");
		}
	}
	function Management_branchFunc_dataset_afterChange(dataset,field)
	{
		if( field.fieldName == "brcode" ){
			var value = Management_branchFunc_dataset.getString("brcode");
			if(value != ""){
				funSelectNo();
				PrivAction.getFunctionByBranchId(value,selectFunction);
			}
		}
	}
	function btOpen_onClick(button){
		viewtree();
	}
	function btSelectAll_onClick(button){
		funSelectAll();
	}
	function btUnSelectAll_onClick(button){
		funSelectNo();
	}
	function btSave_onClick(button){
		save();
	}

	function selectFunction(data)
	{
		if(data!=null){
			for(var i=0;i <data.length;i++){
			 	var num = "id" + data[i];
			 	if(document.getElementById(num) != null){
		        	document.getElementById(num).checked=true;
		        }
	        }
        }
        <#--20110818 BMSA-54 权限树目录菜单可全选 begin -->
		pcheck();
		<#--20110818 BMSA-54 权限树目录菜单可全选 end -->
	}
</script>


</@CommonQueryMacro.page>
