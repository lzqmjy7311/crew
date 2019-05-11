<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="机构管理信息维护">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="branchManageDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>机构管理信息维护详细信息</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>
					             
		                  <td nowrap class="labeltd" colspan=2>修改前</td>
						          
						   <td nowrap class="labeltd" colspan=2>修改后</td>
						 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">机构代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_brno"/></td>
						   <td nowrap class="labeltd">机构代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="brno"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">机构名称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_brname"/></td>
						   <td nowrap class="labeltd">机构名称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="brname"/></td>
						</tr>
						
						<tr>
		                  <td nowrap class="labeltd">机构地址</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_address"/></td>
						   <td nowrap class="labeltd">机构地址</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="address"/></td>
						</tr>
						 <tr>
		                  <td nowrap class="labeltd">邮政编码</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_postno"/></td>
		                  <td nowrap class="labeltd">邮政编码</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="postno"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">联系电话</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_teleno"/></td>
		                  <td nowrap class="labeltd">联系电话</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="teleno"/></td>
		                </tr>
						
						
						
						<tr>
		                  <td nowrap class="labeltd">机构级别</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_brclass"/></td>
		                  <td nowrap class="labeltd">机构级别</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="brclass"/></td>
		                </tr>
		                
		               
		                  <tr>
		                  <td nowrap class="labeltd">上级机构</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_blnUpBrcode"/></td>
		                  <td nowrap class="labeltd">上级机构</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="blnUpBrcode"/></td>
		                </tr>
		                 <tr>
		                  <td nowrap class="labeltd">财务机构</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_blnManageBrcode"/></td>
		                  <td nowrap class="labeltd">财务机构</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="blnManageBrcode"/></td>
		                </tr>
		                
		                
		                  <tr>
		                  <td nowrap class="labeltd">机构属性</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_brattr"/></td>
		                  <td nowrap class="labeltd">机构属性</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="brattr"/></td>
		                </tr>
		                 </tr>
		                  <tr>
		                  <td nowrap class="labeltd">异地行标志</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_otherAreaFlag"/></td>
		                  <td nowrap class="labeltd">异地行标志</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="otherAreaFlag"/></td>
		                </tr>
		                
		                  <tr>
		                  <td nowrap class="labeltd">有效标志</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_status"/></td>
		                  <td nowrap class="labeltd">有效标志</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="status"/></td>
		                </tr>
		            <tr valign="top">
      		   <td valign="CENTER">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr> 
					</table>
					</FIELDSET>
	  			</td>
	  		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
<#else>
	<@CommonQueryMacro.CommonQuery id="branchManageDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="机构管理详细信息" fieldStr="old_brno,old_brname,old_address,old_postno,old_teleno,old_brclass,old_blnUpBrcode,old_blnManageBrcode,old_brattr,old_otherAreaFlag,old_status" colNm=2/>
  			</td>
  		</tr>
  		<tr valign="top">
      		   <td valign="CENTER">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr> 
	</table>
	</@CommonQueryMacro.CommonQuery>
</#if>

<script language="javascript">
     function btClose_onClickCheck(button){
       unloadPageWindows("partWin");
       return false;
     }
</script>
</@CommonQueryMacro.page>
