<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="票据信息">
<CENTER><H1 id="draftTitle"></H1></CENTER>
<@CommonQueryMacro.CommonQuery id="EB_DraftInfo" navigate="false" init="true">
<table align="center" >
<tr>
<td valign="center" align="center">
<table align="center"  width="800px" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2"><table frame=void class="grouptable">
               <tr>
                  <td colspan="2" align="center" nowrap class="labeltd"> 出票日 </td>
				  <td class="datatd" ><@CommonQueryMacro.SingleField fId="remitDate"/></td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 票据类型 </td>
                 <td class="datatd"><@CommonQueryMacro.SingleField fId="draftTypeName"/></td>
                </tr>
               <tr>
                  <td colspan="2" align="center" nowrap class="labeltd"> 汇票到期日 </td>
 			      <td class="datatd"><@CommonQueryMacro.SingleField fId="maturityDate"/> </td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 票据号码 </td>
                   <td class="datatd"><@CommonQueryMacro.SingleField fId="id"/> </td>
                </tr>
              
                <tr>
                  <td width="4%" rowspan="4" align="center" nowrap class="labeltd"> 出 <br> 票 <br> 人 </td>
                  <td width="7%" align="center" nowrap class="labeltd" > 全&nbsp;&nbsp;称 </td>
                  <td width="39%" class="datatd"><@CommonQueryMacro.SingleField fId="remitterName"/></td>
                  <td width="4%" rowspan="4" align="center" nowrap class="labeltd"> 收 <br> 款 <br> 人 </td>
                  <td width="10%" align="center" nowrap class="labeltd"> 全&nbsp;&nbsp;称 </td>
                  <td width="36%" class="datatd"> 
                  	<@CommonQueryMacro.SingleField fId="payeeName"/> 
                  </td>
                </tr>
                <tr>
                  <td align="center" nowrap class="labeltd" > 帐&nbsp;&nbsp;号 </td>
                  <td class="datatd"><@CommonQueryMacro.SingleField fId="remitterAccount"/></td>
                  <td align="center" nowrap class="labeltd" > 帐&nbsp;&nbsp;号 </td>
                  <td class="datatd"><@CommonQueryMacro.SingleField fId="payeeAccount"/></tr>
                <tr>
                  <td align="center" nowrap class="labeltd" > 行&nbsp;&nbsp;号 </td>
                  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="remitterBankId"/></tr>                 
                  <td align="center" nowrap class="labeltd"> 行&nbsp;&nbsp;号 </td>
 				  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="payeeBankId"/></tr> 
                </tr>
                <tr>
                  <td align="center" nowrap class="labeltd"> 开户行 </td>
                  <td class="datatd" nowrap>
                    <@CommonQueryMacro.SingleField fId="remitterBankName"/>
                    </tr>   
                   <td align="center" nowrap class="labeltd"> 开户行 </td>
                   <td class="datatd" nowrap>
                   <@CommonQueryMacro.SingleField fId="payeeBankName"/>
                   </tr>   
                </tr>
                <tr height="50">
				  <td colspan="2" align="center" nowrap class="labeltd"> 票据金额 </td>
 				  <td colspan="1" class="datatd" >人民币 (大写) &nbsp; &nbsp;<@CommonQueryMacro.SingleField fId="draftAmountCH"/></td> 
 				  <td colspan="3" class="datatd" ><div align="center"><@CommonQueryMacro.SingleField fId="draftAmount"/></div></td> 
                </tr>
                
                <tr>
                  <td width="4%" rowspan="2" align="center" nowrap class="labeltd"> 承 <br> 兑 <br> 人 <br> 信 <br> 息 </td>
                  <td align="center" nowrap class="labeltd" >全 &nbsp;&nbsp;称</td>
                  <td class="datatd">
                  	<@CommonQueryMacro.SingleField fId="acceptorName"/>
                  </td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 开户行行号 </td>
  				  <td class="datatd"><@CommonQueryMacro.SingleField fId="acceptorBankId"/></td>
                </tr>
                
                <tr>
				  <td align="center" nowrap class="labeltd" >帐&nbsp;&nbsp;号</td>
 				  <td class="datatd"><@CommonQueryMacro.SingleField fId="acceptorAccount"/></td>
                  <td colspan="2" align="center" nowrap class="labeltd">开户行名称 </td>
				  <td class="datatd">
				  	<@CommonQueryMacro.SingleField fId="acceptorBankName"/>
				  </td>
                </tr>
                
                <tr>
                  <td colspan="2" align="center" nowrap class="labeltd" >到期无条件 <br>支付委托 </td>
				  <td class="datatd"><@CommonQueryMacro.SingleField fId="consignmentCode"/> </td>
                  <td colspan="2" align="center" nowrap class="labeltd" >允许背书 </td>
                 <td class="datatd"><@CommonQueryMacro.SingleField fId="transferFlag"/></td>
                </tr>
                 <tr>
				  <td colspan="2" align="center" nowrap class="labeltd"> 出票备注 </td>
 				  <td colspan="4" class="datatd"><@CommonQueryMacro.SingleField fId="remark"/></td>   
                </tr>
               
            </table>
          </tr>
</table>
</td>
</tr>
</table>
<br/>
<br/>
<CENTER>	
<div id="btnDiv">
	<@CommonQueryMacro.Button id="btPrint"/> 
	&nbsp;&nbsp;&nbsp;&nbsp;
	<@CommonQueryMacro.Button id="btBack1"/> 
</div>
</CENTER>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
function initCallGetter_post(){
	var draftType = EB_DraftInfo_dataset.getString("draftType");
	if( draftType == "AC01"){
		document.getElementById('draftTitle').innerHTML = '电子银行承兑汇票';
	}else if(draftType == "AC02"){
		document.getElementById('draftTitle').innerHTML = '电子商业承兑汇票';
	}
	
}

function initCall_post(){

}

function btBack1_onClick(button){
	window.close();
}
function btPrint_onClick(button){
	document.getElementById("btnDiv").style.visibility="hidden";
	window.print();
	document.getElementById("btnDiv").style.visibility="visible";
}
</script>


</@CommonQueryMacro.page>