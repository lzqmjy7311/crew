<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="申请信息">

<table align="left">
	<tr valign="center">
       	<td valign="top" align="center">
		<@CommonQueryMacro.CommonQuery id="ebank_BatchInfoView" init="true" submitMode="allchange">
	</td></tr>
	<tr>
		<td valign="top" rowspan="1"  valign="top">
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="draftType,draftAmount,remitDate,maturityDate,remitterName,acceptorName,payeeName"  readonly="true"/>
		</td>

	</tr>
	<tr>
		<td valign="top" rowspan="2"  valign="top">
			<table>
				<tr><td>
					<@CommonQueryMacro.Group id="group1" label="申请信息" fieldStr="draftType,draftAmount,remitDate,maturityDate,remitterName,payeeName,remitterAccount,payeeAccount,remitterBankId,payeeBankId,acceptorName,acceptorAccount,acceptorBankId,consignmentCode,transferFlag,remark" colNm=4/>
			  	</td></tr>
			  	<tr align="center"><td>
			  		<@CommonQueryMacro.Button id="btBack"/>
				</td></tr>
			</table>
		</td>
	</tr>

	</@CommonQueryMacro.CommonQuery>
</table>

<script language="JavaScript">

function btBack_onClickCheck(){
     unloadPageWindows("userWin");
     return false;
}

</script>
</@CommonQueryMacro.page>