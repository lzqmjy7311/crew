<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="票据信息">
<table>
	<@CommonQueryMacro.CommonQuery id="C09" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C09Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="id[50],draftNumber[130],remitDate[70],maturityDate[90],remitterId[70],remitterRole[90],remitterCmonid[140],remitterName[220],remitterAccount[130],remitterBankId[110],remitterBankName[150],dfDrwrCdtratgs[130],dfDrwrCdtratgsagcy[130],dfDrwrCdtratgduedt[130],acceptorRole[90],payeeName[200],payeeAccount[150],payeeBankId[150],payeeBankName[150],payeeId[100],payeeOrganCode[200],faceAmount[90],drftRemark[150],acceptor[100],acceptorBankId[150],acceptorActno[110],acceptorBankName[110],drawerBankFlag[100],belongBranchId[110],storeStatus[100],status[70],tmpStatus[90],collztnStatus[70],collztnId[100],lossStatus[70],rplossId[100],debitOrder[70],misc[70],lastUpdOperId[120],lastUpdTime[110],voucherNo[100],draftClass[50],draftTerm[70],dfclsCtl[110],srcType[70],buyContractId[90],endOrSementMk[110],draftAttr[60],draftType[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C09_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>