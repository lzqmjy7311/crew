<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="工商经营异常">
<@CommonQueryMacro.CommonQuery id="TDataGsxtIcException" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,registorNo,legalName,certNo,fdInExceptionReson,fdInExceptionDate,fdOutExceptionReson,fdOutExceptionDate,fdDecisionOrg,enterStatus,busstartDate,busendDate,busscope,registorAmt,enterOrg,address,checkDate,shareHolder"  readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TDataGsxtIcException_dataset.setParameter("typeid",typeId);
	TDataGsxtIcException_dataset.setParameter("data",fdDate);
	TDataGsxtIcException_dataset.setParameter("relaId",customerNum);
	TDataGsxtIcException_dataset.flushData();
}

function datatable1_fdinexceptionreson_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdinexceptionreson\')">查看详细内容</a>';
		}
	}
}

function datatable1_fdoutexceptionreson_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdoutexceptionreson\')">查看详细内容</a>';
		}
	}
}

function aclick(id,type){
	if(!!type&&type=='fdinexceptionreson'){
		contentWin=openSubWin('fdInExceptionReson','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdInExceptionReson.ftl?id='+id+"&type="+type,800,600);
	}else if(!!type&&type=='fdoutexceptionreson'){
		contentWin=openSubWin('fdOutExceptionReson','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdOutExceptionReson.ftl?id='+id+"&type="+type,800,600);
	}
}
</script>
</@CommonQueryMacro.page>
