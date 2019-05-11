<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="������Ϣ">
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMonitorBaseinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Baseinfo" label="������Ϣ">
						<@CommonQueryMacro.Group id="group12" label="" colNm=6
						fieldStr="chineseName,customerNum,businessLicenseNum,legalrepresentative,membershipgroup,newEvalResult,orgnNum,registeredCapital,customerSizeCd,industryLevelOneCd"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		 <tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorShareHolder" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="ShareHolderinfo" label="�ɶ���Ϣ">
						<@CommonQueryMacro.DataTable id="Shinfo"  fieldStr="stockholderName,certificateTypeCd,certificateNum,holdingStockRate,totalInvest"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorCalinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Calinfo" label="�Ŵ���Ϣ">
						<@CommonQueryMacro.Group id="group1" label="" colNm=6 fieldStr="advanceAmount,creditAmount,creditBalance,usedBalance,advanceBalance,overdueAdvanceBal,normalAdvanceBal,mentionAdvanceBal,substdAdvanceBalance,doutfulAdvanceBal,lossAdvanceBal,outsideGuaranteeAmount"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>				
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorList" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="listinfo" label="�ڱ�������ҵ���б�">
						<@CommonQueryMacro.DataTable id="group1"  fieldStr="contractStatusCd,contractNum,guarantyNote,contractTotalAmt,comprBizContractInd,contractSignDate,expirationDate,loanTypeInstructionCd,classificationResult"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorLendlist" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Lendlist" label="����б�">
						<@CommonQueryMacro.DataTable id="group1" fieldStr="borrowNum,lendingdate,expirationDate,advBal,loanBal,bucketP,bocketI,bailSum,fiveLevel,status,loanaccount,balanceAccounts"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMontitorAssureinfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="Assureinfo" label="�ڱ��е�����Ϣ�б�">
						<@CommonQueryMacro.DataTable id="assureinfo" fieldStr="contractStatusCdAAA,debtPersonName,contractNum,contractTotalAmt,comprBizContractInd,contractSignDate,expirationDate"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr> 		
	</table>
<script>



</script>
</@CommonQueryMacro.page>