<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="ϵͳ����">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="SysParamsEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>ϵͳ������ϸ��Ϣ</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>       
		                  <td nowrap class="labeltd" colspan=2>�޸�ǰ</td>       
						   <td nowrap class="labeltd" colspan=2>�޸ĺ�</td>				 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">�����α��</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_paramgroupId"/></td>
						   <td nowrap class="labeltd">�����α��</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="paramgroupId"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">�������</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_paramId"/></td>
						   <td nowrap class="labeltd">�������</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="paramId"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">����˵��</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_paramName"/></td>
		                  <td nowrap class="labeltd">����˵��</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="paramName"/></td>
		                </tr>
		                <tr>
		                  <td nowrap class="labeltd">����ֵ</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_paramVal"/></td>
		                   <td nowrap class="labeltd">����ֵ</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="paramVal"/></td>
		                </tr>
		                <tr>
		                  <td nowrap class="labeltd">��ע</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_memo"/></td>
						  <td nowrap class="labeltd">��ע</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="memo"/></td>
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
	<@CommonQueryMacro.CommonQuery id="SysParamsEntryDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="ϵͳ������ϸ��Ϣ" fieldStr="old_paramgroupId,old_paramId,old_paramName,old_paramVal,old_memo" colNm=2/>
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
