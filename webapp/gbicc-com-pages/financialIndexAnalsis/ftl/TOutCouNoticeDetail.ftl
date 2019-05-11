<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="��ͥ����">
<@CommonQueryMacro.CommonQuery id="TOutCouNoticeDetail" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="courtName,court2Name,tryDate,caseNo,caseReason,mainDept,tryName,accuser,defendant,sourceLink,rowDate" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TOutCouNoticeDetail_dataset.setParameter("typeid",typeId);
	TOutCouNoticeDetail_dataset.setParameter("data",fdDate);
	TOutCouNoticeDetail_dataset.setParameter("relaId",customerNum);
	TOutCouNoticeDetail_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>
