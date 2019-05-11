<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="岗位权限管理">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/js/tree.js"></script>
<script type="text/javascript" src="${contextPath}/js/xtree.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<@CommonQueryMacro.CommonQuery id="RoleFuncMng" init="true">
<table align="left">
	<tr >
		<td  align="left">
				<@CommonQueryMacro.Group id ="branchFuncGroup" label="岗位信息" fieldStr="roleName,status" colNm=4/>
		</td>
	</tr>
	<tr >
		<td  align="left">
		 	<@CommonQueryMacro.Button id= "btOpen" />
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  		<@CommonQueryMacro.Button id= "btCancel" />
	  	</td>
	</tr>
	<tr >
		<td  align="left" >
		 <div id="tree">
			<script language="javascript">
				var functree = null;
				dwr.engine.setAsync(false);
				PrivAction.getFuncArray(
					function(data){
						functree = data;
					}
				);
				dwr.engine.setAsync(true);
                createTree(functree,0,0);
				var len = document.getElementsByName("id").length;
                var pid = document.getElementsByName("pid");
				for(var i = pid.length - 1; i >= 0; i --){
	                pid[i].disabled='true';
				}
				for(i=0;i<len;i++){
					document.getElementsByName("id")[i].disabled = 'true' ;
				}
           </script>
           </div>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">

	_close_flag = true;

	function load(){
		funSelectNo();
		var value = RoleFuncMng_dataset.getString("id");
		if(value==""){
			RoleFuncMng_dataset.setFieldReadOnly("rolename",false);
		}else{
			RoleFuncMng_dataset.setFieldReadOnly("rolename",true);
			PrivAction.getRoleFuncByid(value,selectFunction);
		}
	}

	function initCallGetter_post(){
		load();
	}

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
		var id = RoleFuncMng_dataset.getString("id");
		if(id==""){
			RoleFuncMng_dataset.setValue("id","0");
			var s = getCheckDatas();
			var roleName = RoleFuncMng_dataset.getString("roleName");
			PrivAction.updateRoleFunc(roleName,s,checkResult);
		}
			var len = document.getElementsByName("id").length;
			var s = "";
			var flag=0;
			v_funcListNew = "";
			for(i=0;i<len;i++){
				var tmpCheck = document.getElementsByName("id")[i];
				if(tmpCheck.checked == true){
					v_funcListNew = v_funcListNew + tmpCheck.value+",1"+":";
				}
			}
			RoleFuncMng_dataset.setValue("funcListNew",v_funcListNew);
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

	function btOpen_onClick(button){
		viewtree();
	}
	function btSelectAll_onClick(button){
		funSelectAll();
	}
	function btUnSelectAll_onClick(button){
		funSelectNo();
	}
	function btSave_onClickCheck(button){
		save();
	}

	function selectFunction(data)
	{
		for(var i=0;i <data.length;i++){
		 	var num = "id" + data[i];
	        if(document.getElementById(num) != null)
		 	{
	         document.getElementById(num).checked=true;
	         }
        }
        <#--20110818 BMSA-54 权限树目录菜单可全选 begin -->
		pcheck();
		<#--20110818 BMSA-54 权限树目录菜单可全选 end -->
	}
	function btStatus_onClickCheck(button) {
	    var status = RoleFuncMng_dataset.getValue("status");
		if(status == '0'){
			    RoleFuncMng_dataset.setValue("status", "1");
		} else {
				RoleFuncMng_dataset.setValue("status", "0");
		}
		RoleFuncMng_dataset.refreshControls();
		return false;
	}
</script>

</@CommonQueryMacro.page>
