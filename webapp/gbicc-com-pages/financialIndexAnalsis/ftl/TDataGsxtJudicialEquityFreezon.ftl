<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="工商经营异常">
<@CommonQueryMacro.CommonQuery id="TDataGsxtJudicialEquityFreezon" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,registorNo,legalName,certNo,fdSubjectedPerson,fdEquityAmount,fdExeCourt,fdDocNum,fdStatus,enterStatus,busstartDate,busendDate,busscope,registorAmt,enterOrg,address,checkDate,shareHolder"  readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TDataGsxtJudicialEquityFreezon_dataset.setParameter("typeid",typeId);
	TDataGsxtJudicialEquityFreezon_dataset.setParameter("data",fdDate);
	TDataGsxtJudicialEquityFreezon_dataset.setParameter("relaId",customerNum);
	TDataGsxtJudicialEquityFreezon_dataset.flushData();
}
function datatable1_busscope_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'busscope\')">查看详细内容</a>';
		}
	}
}
function aclick(id,type){
	var contentWin=openSubWin('TDataGsxtJudicialEquityFreezonScoop','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtJudicialEquityFreezonScoop.ftl?id='+id+'&relaId='+customerNum,800,600);
}
</script>
</@CommonQueryMacro.page>
