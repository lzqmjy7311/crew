<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']?default('')}" />
<@CommonQueryMacro.page title="币种信息维护">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="CurrencyManEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left">
	      <tr valign="top">
	  			<td valign="top">
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>币种信息维护详细信息</LEGEND>
					<table frame=void width="100%" class="grouptable" id="detailTable">
					<tr>

		                  <td nowrap class="labeltd" colspan=2>修改前</td>

						   <td nowrap class="labeltd" colspan=2>修改后</td>

						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">币种货币代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_id"/></td>
						   <td nowrap class="labeltd">币种货币代码</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="id"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd">币种中文名称</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_cnname"/></td>
						   <td nowrap class="labeltd">币种中文名称</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="cnname"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd">币种英文名称</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_enname"/></td>
		                  <td nowrap class="labeltd">币种英文名称</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="enname"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">EDI币种代码</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_curedicd"/></td>
		                  <td nowrap class="labeltd">EDI币种代码</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="curedicd"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">EDI币种名称</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_curediname"/></td>
		                  <td nowrap class="labeltd">EDI币种名称</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="curediname"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">基本单位</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_baseunit"/></td>
		                  <td nowrap class="labeltd">基本单位</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="baseunit"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">最小单位</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_minunit"/></td>
		                  <td nowrap class="labeltd">最小单位</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="minunit"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">币种符号</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_cursymBol"/></td>
		                  <td nowrap class="labeltd">币种符号</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="cursymBol"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">有效状态</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_isUsd"/></td>
		                  <td nowrap class="labeltd">有效状态</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="isUsd"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">日利息计算天数</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_dratedays"/></td>
		                  <td nowrap class="labeltd">日利息计算天数</td>
		                  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="dratedays"/></td>
		                </tr>
						<tr>
		                  <td nowrap class="labeltd">显示顺序</td>
		                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="old_showSeq"/></td>
		                  <td nowrap class="labeltd">显示顺序</td>
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
  			<@CommonQueryMacro.Group id ="group1" label="币种信息维护详细信息" fieldStr="old_id,old_cnname,old_enname,old_isUsd,old_cursymBol,old_minunit,old_baseunit,old_curediname,old_curedicd,old_showSeq" colNm=2/>
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
