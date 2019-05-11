<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="岗位权限管理对比">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/js/tree.js"></script>
<script type="text/javascript" src="${contextPath}/js/xtree.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<@CommonQueryMacro.CommonQuery id="RoleFuncMngCompare" init="true">
<table align="left">
	<tr >
		<td  align="left">
				<FIELDSET name='group6' style="padding: 6px;">
				<LEGEND>双重授权 权限设置修改查看</LEGEND>
				 <table frame=void width="100%" class="grouptable" id="detailTable">
					 <tr>
			              <td  class="labeltd"></td>
						  <td nowrap class="labeltd">修改前</td>
						  <td nowrap class="labeltd">修改后</td>
					</tr>
					<tr>
		            	  <td nowrap class="labeltd">岗位名称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="roleName"/></td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="roleName"/></td>
					</tr>
					<tr>
						  <td nowrap class="labeltd">有效标志</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="statusOld"/></td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="status"/></td>
					</tr>
				</table>
			</FIELDSET>
		</td>
	</tr>
	<tr >
		<td  align="left">
		 	<@CommonQueryMacro.Button id= "btOpen" />
		 	&nbsp;&nbsp;
		 	<@CommonQueryMacro.Button id= "btCancel" />
	  	</td>
	  	<td bgcolor="red" width="20"></td><td>新增</td>
	  	<td bgcolor="blue" width="20"></td><td>删除</td>
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
	var v_funcList ;
	_close_flag = true;

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

	function btOpen_onClick(button){
		viewtree();
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

	function initCallGetter_post(){

		check("roleName","roleName");
		check("statusOld","status");

		var id = RoleFuncMngCompare_dataset.getValue("id");
		//PrivAction.getFunctionByid(id,selectFunction);alert(222);
		v_funcList = RoleFuncMngCompare_dataset.getString("funcList");
		var data = v_funcList.split(":");
		for(var i=0;i <data.length;i++){
			var tempArray = data[i].split(",");
		 	var checkId = "id" + tempArray[0];
		 	var status = tempArray[1];
		 	var checkObj = document.getElementById(checkId);//节点
		 	if( checkObj != null)
		 	{
		 		if(status == "1"){//新增
		 			checkObj.style.backgroundColor = 'red';
		 			checkObj.checked=true;
		 		}
		 		else if(status == "2"){//去除
		 			checkObj.style.backgroundColor = 'blue';
		 			checkObj.checked=false;
		 		}
	        }
        }
        viewtree();
	}
	function check(fieldname1,fieldname2){
	   var fieldvalue1 = document.getElementById(fieldname1);
	   var fieldvalue2 = document.getElementById(fieldname2);
	   if(fieldvalue1.value != fieldvalue2.value){
	         fieldvalue1.style.backgroundColor = '#fbeb71';
	   		 fieldvalue2.style.backgroundColor = '#fbeb71';
	   }
	}
</script>

</@CommonQueryMacro.page>
