<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="安全参数设置">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="SysParamsSecDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>安全参数设置</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>       
		                  <td nowrap class="labeltd" colspan=2>修改前</td>       
						   <td nowrap class="labeltd" colspan=2>修改后</td>				 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">参数标识</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_magicId"/></td>
						   <td nowrap class="labeltd">参数标识</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="magicId"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">系统参数</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_paramValueTx"/></td>
						   <td nowrap class="labeltd">系统参数</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="paramValueTx"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">参数说明</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_desc0"/></td>
		                  <td nowrap class="labeltd">参数说明</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="desc0"/></td>
		                </tr>
		                
					</table>
					</FIELDSET>	
		 <tr valign="top">
      		   <td valign="CENTER">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr> 
					
	  			</td>
	  		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
<#else>
	<@CommonQueryMacro.CommonQuery id="SysParamsSecDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="安全参数设置" fieldStr="old_magicId,old_paramValueTx,old_desc0" colNm=2/>
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
