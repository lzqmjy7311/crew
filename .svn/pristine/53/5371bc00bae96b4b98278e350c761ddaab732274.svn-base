<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="岗位权限管理">
<table align="left" border="0" width="900">
  	<tr>
		<td width="50%">
			<table width="100%">
			<tr><td width="100%">
			<@CommonQueryMacro.CommonQuery id="RoleFuncMngComp" mode="1" init="true" navigate="false">
				<table class="grouptable" width="100%">
					<tr>
						<td id="oldHead" nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改前 </td>
					</tr>
					<tr>
						<td align="center" nowrap class="labeltd" width="25%"> 岗位编号 </td>
						<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="idOld"/></td>
						<td align="center" nowrap class="labeltd"  width="25%"> 岗位名称 </td>
						<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="roleNameOld" /></td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
			</td></tr>
			<tr><td width="100%" align="left" height="300" valign="top" style="boerder:1px solid #ededed">
				<iframe id="frame1"  height="100%" width="100%"  scrolling="auto" frameborder="0"></iframe>
			</td></tr>
			</table>
		</td>
		<td width="50%" >
			<table width="100%" id="comSeri">
			<tr><td width="100%">
			<@CommonQueryMacro.CommonQuery id="RoleFuncMngComp"  init="true" navigate="false">
				<table class="grouptable" width="100%">
					<tr>
						<td nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
					</tr>
					<tr>
						<td align="center" nowrap class="labeltd" width="25%"> 岗位编号 </td>
						<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="id"/></td>
						<td align="center" nowrap class="labeltd"  width="25%"> 岗位名称 </td>
						<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="roleName" /></td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
			</td></tr>
			<tr><td width="100%" align="left" height="300" valign="top" style="boerder:1px solid #ededed">
				<iframe id="frame2"  height="100%" width="100%"  scrolling="auto" frameborder="0" ></iframe>
			</td></tr>
			</table>
		</td>
   </tr>
   	<tr>
	 	<td>
	 		<@CommonQueryMacro.CommonQuery id="RoleFuncMng" init="true" navigate="false">
			<table align="left">
			<tr>
				<td>
			  		<@CommonQueryMacro.Button id= "btCancel" />
		  		</td>
			</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	var flag = "${RequestParameters["flag"]?default('')}";
	var varid = "${RequestParameters["id"]?default('')}";
	var st = "${RequestParameters["st"]?default('')}";
	var tskId = "${RequestParameters["tskId"]?default('')}";

	function load(){
		var value = RoleFuncMng_dataset.getString("id");
		document.getElementById("frame1").src="${contextPath}/fpages/system/ftl/RoleFuncMngWithEditTreeDiv1.ftl?flag="+flag+"&id="+value+"&st="+st+"&tskId="+tskId;
		document.getElementById("frame2").src="${contextPath}/fpages/system/ftl/RoleFuncMngWithEditTreeDiv2.ftl?flag="+flag+"&id="+value+"&st="+st+"&tskId="+tskId;
		RoleFuncMng_dataset.setFieldReadOnly("rolename",false);
	}

	function initCallGetter_post(){
		if(st != "2" && flag != "1"){
			document.getElementById("comSeri").style.display="none";
			document.getElementById("oldHead").style.display="none";
		} 
		load();
	}
	
	function btCancel_onClickCheck()
	{
		closeWin();
		return false;
	}
	
</script>


</@CommonQueryMacro.page>
