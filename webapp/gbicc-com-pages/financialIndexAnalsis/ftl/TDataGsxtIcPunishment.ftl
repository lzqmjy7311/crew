<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="工商经营异常">
<@CommonQueryMacro.CommonQuery id="TDataGsxtIcPunishment" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,registorNo,legalName,certNo,fdPunishmentDocNum,fdPunishmentType,fdPunishmentContent,fdPunishmentDate,fdPunishmentOrg,enterStatus,busstartDate,busendDate,busscope,registorAmt,enterOrg,address,checkDate,shareHolder"  readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TDataGsxtIcPunishment_dataset.setParameter("typeid",typeId);
	TDataGsxtIcPunishment_dataset.setParameter("data",fdDate);
	TDataGsxtIcPunishment_dataset.setParameter("relaId",customerNum);
	TDataGsxtIcPunishment_dataset.flushData();
}

function datatable1_fdpunishmentcontent_onRefresh(cell,value,record){
	if(record){
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+id+'\',\'fdPunishmentContent\')">查看详细内容</a>';
		}
	}
}

function datatable1_busscope_onRefresh(cell,value,record){
	if(record){
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+id+'\',\'busscope\')">查看详细内容</a>';
		}
	}
}

function aclick(id,type){
	if(!!type&&type=='fdPunishmentContent'){
		var fdPunishmentContent=openSubWin('fdPunishmentContent','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdPunishmentContent.ftl?id='+id+'&type='+type,800,600);
	}else if(!!type&&type=='busscope'){
		var busscope=openSubWin('fdBusinessScope','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdBusinessScope.ftl?id='+id+'&type='+type,800,600);
	}
}

</script>
</@CommonQueryMacro.page>
