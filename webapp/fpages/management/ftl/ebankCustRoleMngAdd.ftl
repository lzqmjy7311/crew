<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="��λȨ�޹���">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/js/tree.js"></script>
<script type="text/javascript" src="${contextPath}/js/xtree.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<@CommonQueryMacro.CommonQuery id="ebankCustRoleMngAdd" init="false">
<table align="left">
	<tr >
		<td  align="left">
				<@CommonQueryMacro.Group id ="branchFuncGroup" label="��λ��Ϣ" fieldStr="id,roleName" colNm=4/>
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
		//var value = ebankCustRoleMngAdd_dataset.getString("id");
		var value = 0;
		PrivAction.getRoleFuncByid(value,selectFunction);
	}

	function initCallGetter_post(){
		load();
	}

	//ȫѡ
	function funSelectAll(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = true;
			}
		}
		<#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ begin -->
		pcheck(1);
		<#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ end -->
	}
	//ȫ��ѡ
	function funSelectNo(){
		var len = document.getElementsByName("id").length;
		for(i=0;i<len;i++){
			if (document.getElementsByName("id")[i].disabled == false){
				document.getElementsByName("id")[i].checked = false;
			}
		}
		<#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ begin -->
		pcheck(0);
		<#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ end -->
	}
	//�õ���ѡ��Ȩ��
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

	//չ���ڵ���
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
		var roleName = RoleFuncMng_dataset.getString("id");
		if(roleName == null || roleName == "")
		{
			alert("��ѡ���λ");
			return false;
		}
		var s = getCheckDatas();
		PrivAction.updateRoleFunc(roleName,s,checkResult);
	}
	function checkResult(data)
	{
		if(data == 0)
		{
			alert("����ɹ���");
		}
		else
		{
			alert("����ʧ�ܣ�");
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
		for(var i=0;i <data.length;i++){
		 	var num = "id" + data[i];
	        if(document.getElementById(num) != null)
		 	{
	         document.getElementById(num).checked=true;
	         }
        }
        <#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ begin -->
		pcheck();
		<#--20110818 BMSA-54 Ȩ����Ŀ¼�˵���ȫѡ end -->
	}
	function btSave_needCheck(button) {
	return false;
}
</script>


</@CommonQueryMacro.page>
