<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="国家地区代码维护">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="BiNationregionEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left"  width="100%">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>国家地区代码维护详细信息</LEGEND>
					<table frame=void width="80%" class="grouptable" id="detailTable">
					<tr>	             
		                  <td nowrap class="labeltd" colspan=2>修改前</td>	          
						   <td nowrap class="labeltd" colspan=2>修改后</td>					 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">国家地区代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_id"/></td>
						   <td nowrap class="labeltd">国家地区代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">国家地区数字代码</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_nationregionNumber"/></td>
		                  <td nowrap class="labeltd">国家地区数字代码</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="nationregionNumber"/></td>
		                </tr>	
		            	<tr>
		                  <td nowrap class="labeltd">中文全称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_chinaName"/></td>
						   <td nowrap class="labeltd">中文全称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="chinaName"/></td>
						</tr>
						
						<tr>
		                  <td nowrap class="labeltd">中文简称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_chinaShortName"/></td>
						   <td nowrap class="labeltd">中文简称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="chinaShortName"/></td>
						</tr>
						
							<tr>
		                  <td nowrap class="labeltd">英文全称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_engName"/></td>
						   <td nowrap class="labeltd">英文全称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="engName"/></td>
						</tr>
						
						<tr>
		                  <td nowrap class="labeltd">英文简称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_engShortName"/></td>
						   <td nowrap class="labeltd">英文简称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="engShortName"/></td>
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
	<@CommonQueryMacro.CommonQuery id="BiNationregionEntryDetail" init="true" submitMode="all"  navigate="false">
	<table align="left" >
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="国家地区代码维护详细信息" fieldStr="old_id,old_chinaName,old_nationregionNumber,old_chinaShortName,old_engName,old_engShortName" colNm=2/>
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
