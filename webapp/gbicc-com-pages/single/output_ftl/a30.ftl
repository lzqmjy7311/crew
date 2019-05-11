<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="查冻扣登记簿">
<table>
	<@CommonQueryMacro.CommonQuery id="A30" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="A30Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="postDate[70],postTime[70],acctNo[130],customerName[200],governmentAgency[150],lawEnforceOfir[110],officerIdName[150],officerIdNo[200],legalDocName[150],noticeNo[200],freezeType[70],freezeReason[70],odInd[90],freezeAmount[100],oriFreezeJrnlNo[90],oriFreezeDate[90],freezeMatDate[80],seqNo[100],trfType[80],trfAmount[100],receiveAcctNo[130],receiveCustName[200],receiveBankName[200],trfSrnNo[110],enquiryContent[110],remark[100],subType[100],volumeNo[50],sequenceNo[50],priorityNo[90],acctBalance[100],availAmt[100],othGovFreeAmt[200],marFreeAmt[130],pleFreeFlg[100],realFreezeAmt[90],origFreezeAmt[90],warnId[80],dataDt[70],tellerNo[70],branchNo[70],supTellerNo[70],jrnlNo[70],businessType[70],status[50],socNo[50]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		A30_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>