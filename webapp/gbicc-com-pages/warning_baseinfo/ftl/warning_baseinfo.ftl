<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基本信息">
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMonitorBaseinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Baseinfo" label="基本信息">
						<@CommonQueryMacro.Group id="group12" label="" colNm=6
						fieldStr="chineseName,customerNum,businessLicenseNum,legalrepresentative,membershipgroup,newEvalResult,orgnNum,registeredCapital,customerSizeCd,industryLevelOneCd"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		 <tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorShareHolder" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="ShareHolderinfo" label="股东信息">
						<@CommonQueryMacro.DataTable id="Shinfo"  fieldStr="stockholderName,certificateTypeCd,certificateNum,holdingStockRate,totalInvest"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorCalinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Calinfo" label="信贷信息">
						<@CommonQueryMacro.Group id="group1" label="" colNm=6 fieldStr="advanceAmount,creditAmount,creditBalance,usedBalance,advanceBalance,overdueAdvanceBal,normalAdvanceBal,mentionAdvanceBal,substdAdvanceBalance,doutfulAdvanceBal,lossAdvanceBal,outsideGuaranteeAmount"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>				
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorList" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="listinfo" label="在本行授信业务列表">
						<@CommonQueryMacro.DataTable id="group1"  fieldStr="contractStatusCd,contractNum,guarantyNote,contractTotalAmt,comprBizContractInd,contractSignDate,expirationDate,loanTypeInstructionCd,classificationResult"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorLendlist" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Lendlist" label="借据列表">
						<@CommonQueryMacro.DataTable id="group1" fieldStr="borrowNum,lendingdate,expirationDate,advBal,loanBal,bucketP,bocketI,bailSum,fiveLevel,status,loanaccount,balanceAccounts"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorAssureinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Assureinfo" label="在本行担保信息列表">
						<@CommonQueryMacro.DataTable id="assureinfo" fieldStr="contractStatusCdAAA,debtPersonName,contractNum,contractTotalAmt,comprBizContractInd,contractSignDate,expirationDate"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr> 		
	</table>
<script>



</script>
</@CommonQueryMacro.page>