<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']?default('')}" />
<@CommonQueryMacro.page title="������Ϣά��">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="CurrencyManEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>������Ϣά����ϸ��Ϣ</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>

		                  <td nowrap class="labeltd" colspan=2>�޸�ǰ</td>

						   <td nowrap class="labeltd" colspan=2>�޸ĺ�</td>

						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">���ֻ��Ҵ���</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_id"/></td>
						   <td nowrap class="labeltd">���ֻ��Ҵ���</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">������������</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_cnname"/></td>
						   <td nowrap class="labeltd">������������</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="cnname"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">����Ӣ������</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_enname"/></td>
		                  <td nowrap class="labeltd">����Ӣ������</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="enname"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">EDI���ִ���</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_curedicd"/></td>
		                  <td nowrap class="labeltd">EDI���ִ���</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="curedicd"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">EDI��������</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_curediname"/></td>
		                  <td nowrap class="labeltd">EDI��������</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="curediname"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">������λ</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_baseunit"/></td>
		                  <td nowrap class="labeltd">������λ</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="baseunit"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">��С��λ</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_minunit"/></td>
		                  <td nowrap class="labeltd">��С��λ</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="minunit"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">���ַ���</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_cursymBol"/></td>
		                  <td nowrap class="labeltd">���ַ���</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="cursymBol"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">��Ч״̬</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_isUsd"/></td>
		                  <td nowrap class="labeltd">��Ч״̬</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="isUsd"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">����Ϣ��������</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_dratedays"/></td>
		                  <td nowrap class="labeltd">����Ϣ��������</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="dratedays"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">��ʾ˳��</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_showSeq"/></td>
		                  <td nowrap class="labeltd">��ʾ˳��</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="showSeq"/></td>
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
	<@CommonQueryMacro.CommonQuery id="CurrencyManEntryDetail" init="true" submitMode="all"  navigate="false">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="������Ϣά����ϸ��Ϣ" fieldStr="old_id,old_cnname,old_enname,old_isUsd,old_cursymBol,old_minunit,old_baseunit,old_curediname,old_curedicd,old_showSeq" colNm=2/>
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
