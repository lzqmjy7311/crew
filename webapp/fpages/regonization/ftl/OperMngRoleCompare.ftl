<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st=RequestParameters["st"]?default("")>
<#assign flag=RequestParameters["flag"]?default("")>
<@CommonQueryMacro.page title="操作员角色管理">
<table width="100%" align="left">
<tr>
<td width="50%" valign="top">
	<table align="left" width="100%">
		<tr align="center">
			<td width="100%" valign="top">
				<@CommonQueryMacro.CommonQuery id="operMngModCom" init="true" navigate="false" submitMode="all" >
						<table frame=void class="grouptable" width="100%">
						<tr>
							<td id="oldHead" nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改前 </td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" width="25%"> 操作员号 </td>
							<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> 操作员名称 </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
							
						</tr>
						<tr>
		                  <td align="center" nowrap class="labeltd" width="25%">有效状态</td>
						 <td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="flag"/></td>
						  <td align="center" nowrap class="labeltd"  width="25%">锁定状态</td>
						  <td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="isLock"/></td>
						</tr>
						<tr>
		                 <td align="center" nowrap class="labeltd" width="25%"> 登录状态</td>
						  <td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="status"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> 分支机构号 </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="brcode" /></td>
						</tr>
					   </table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr id="tohide">
			<td>
				<@CommonQueryMacro.CommonQuery id="bctlMngEntryCom" init="true" submitMode="all" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup1" label="授权机构信息" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
									<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brno[160],brname" hasFrame="true" height="120" width="100%" readonly="true"/>
								</td>
						 	</tr>

						 </table>
					 </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngRoleInfoCom" init="true" submitMode="selected" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup2" label="岗位信息" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
										<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="roleId[160],roleName" hasFrame="true" height="120" width="100%" readonly="false"/>
								</td>
						 	</tr>
						 </table>
					 </@CommonQueryMacro.GroupBox>
					 <br>
					 <@CommonQueryMacro.Button id="btCancel"/>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
</td>
<td width="50%" valign="top">
	<table align="left" width="100%" id="comSeri">
		<tr id="comSeriReset">
			<td width="100%">
				<table class="grouptable" width="100%">
					<tr>
						<td nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
					</tr>
					<tr>
						<td nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 重置密码 </td>
					</tr>
				</table>
			</td>
		</tr>
		<tr align="center" id="ComSeri1">
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngModComSeri" init="true" navigate="false" submitMode="all" >
						<table frame=void class="grouptable" width="100%">
						<tr>
							<td nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" width="25%"> 操作员号 </td>
							<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> 操作员名称 </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">有效状态</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="flag"/></td>
						  <td nowrap class="labeltd">锁定状态</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="isLock"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">登录状态</td>
						  <td class="datatd" nowrap colspan="3"><@CommonQueryMacro.SingleField fId="status"/></td>
						</tr>
					   </table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr id="ComSeri2">
			<td>
				<@CommonQueryMacro.CommonQuery id="bctlMngEntryComSeri" init="true" submitMode="all" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup1" label="授权机构信息" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
									<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brno[160],brname" hasFrame="true" height="120" width="100%" readonly="true"/>
								</td>
						 	</tr>

						 </table>
					 </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr id="ComSeri3">
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngRoleInfoComSeri" init="true" submitMode="selected" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup2" label="岗位信息" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
										<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="roleId[160],roleName" hasFrame="true" height="120" width="100%" readonly="false"/>
								</td>
						 	</tr>
						 </table>
					 </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
</td>
</tr>
<script language="javascript">
	var st = "${st}";
	var flag = "${flag}";
	var showRel = ${statics["com.huateng.ebank.business.management.service.SystemParamService"].queryParameter("ISAUTH","BCTL")};
	
	function initCallGetter_post(dataset){
		var backOp = operMngModComSeri_dataset.getValue("reset");
		if(st != "2" && flag != "1"){
			document.getElementById("comSeri").style.display="none";
			document.getElementById("oldHead").style.display="none";
		} else if (st == "2" && backOp == "reset") {
			document.getElementById("ComSeri1").style.display="none";
			document.getElementById("ComSeri2").style.display="none";
			document.getElementById("ComSeri3").style.display="none";
		} else if (st == "2" && backOp != "reset") {
			document.getElementById("comSeriReset").style.display="none";
		} else if (st == "1" && flag == "1") {
			document.getElementById("comSeriReset").style.display="none";
		}
		
		if(showRel!='1'){
			$('#tohide').css('display','none');
		}
		
		
	}

	function btCancel_onClick(){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>
