<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员角色管理">
	<table align="left">
		<tr align="center">
			<td>
<@CommonQueryMacro.CommonQuery id="operMngModCompare" init="true" navigate="false" submitMode="all" >
	<table align="left">
		 <tr align="center"  width="100%">
			<td>
			<FIELDSET name='group6' style="padding: 6px;">
				<LEGEND>双重授权 用户管理</LEGEND>
				<table frame=void width="100%" class="grouptable" id="detailTable">
				    <tr>
		              <td  class="labeltd"></td>
					  <td nowrap class="labeltd">修改前</td>
					  <td nowrap class="labeltd">修改后</td>
					</tr>
				  	<tr>
		            <td nowrap class="labeltd">用户号</td>
					  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="tlrnoOld"/></td>
					  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="tlrno"/></td>
					</tr>
	                <tr>
	                  <td nowrap class="labeltd">用户名</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="tlrNameOld"/></td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="tlrName"/></td>
	                </tr>
	                <tr>
	                  <td nowrap class="labeltd">机构名称</td>
	                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="branchNameOld"/></td>
	                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="branchName"/></td>
	                </tr>
	            	<tr>
	                  <td nowrap class="labeltd">有效状态</td>
	                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="flagOld"/></td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="flag"/></td>
	                </tr>
					<tr>
					  <td nowrap class="labeltd">锁定状态</td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="isLockOld"/></td>
					  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="isLock"/></td>
					</tr>
                </table>
                </FIELDSET>
        	</td>
        </tr>
        <tr>
	      	<td>
				<@CommonQueryMacro.Group id ="group1" label="重置密码" fieldStr="restFlg" colNm=4/>
        	</td>
		</tr>
   </table>
</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr align="center">
			<td>
<@CommonQueryMacro.CommonQuery id="operMngRoleInfoCompare" init="true" submitMode="all" navigate="false">
	<table align="left">
	      	<tr>
	      		<td valign="top">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="selectedFlg,selected,roleId,roleName" width="400"   height="200"  readonly="true"/>
				</td>
		 	</tr>
		 	<tr >
				<td  align="left">
		 			<@CommonQueryMacro.Button id= "btBack" />
	  			</td>
			</tr>
	 </table>
</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
</table>
<script language="javascript">
	function check(fieldname1,fieldname2){
	   var fieldvalue1 = document.getElementById(fieldname1);
	   var fieldvalue2 = document.getElementById(fieldname2);
	   if(fieldvalue1.value != fieldvalue2.value){
	         fieldvalue1.style.backgroundColor = '#fbeb71';
	   		 fieldvalue2.style.backgroundColor = '#fbeb71';
	   }
	}
	function initCallGetter_post(dataset) {
		check("tlrnoOld","tlrno");
		check("tlrNameOld","tlrName");
		check("branchNameOld","branchName");
		check("flagOld","flag");
		check("isLockOld","isLock");
		var restFlg = operMngModCompare_dataset.getValue("restFlg");
		if(restFlg==1){
			document.getElementById("restFlg").style.backgroundColor = '#fbeb71';
		}
	}
</script>
</@CommonQueryMacro.page>
