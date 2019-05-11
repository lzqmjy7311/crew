<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="工商严重违法">
<@CommonQueryMacro.CommonQuery id="TDataGsxtIcIllegal" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,registorNo,legalName,certNo,fdInIllegalReson,fdInIllegalDate,fdOutIllegalReson,fdOutIllegalDate,fdDecisionOrg,enterStatus,busstartDate,busendDate,busscope,registorAmt,enterOrg,address,checkDate,shareHolder"  readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TDataGsxtIcIllegal_dataset.setParameter("typeid",typeId);
	TDataGsxtIcIllegal_dataset.setParameter("data",fdDate);
	TDataGsxtIcIllegal_dataset.setParameter("relaId",customerNum);
	TDataGsxtIcIllegal_dataset.flushData();
}

function datatable1_fdinillegalreson_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdinillegalreson\')">查看详细内容</a>';
		}
	}
}

function datatable1_fdoutillegalreson_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdoutillegalreson\')">查看详细内容</a>';
		}
	}
}

function datatable1_busscope_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdbusinessscope\')">查看详细内容</a>';
		}
	}
}

function aclick(id,type){
	if(type&&type=='fdinillegalreson'){
		contentWin=openSubWin('fdInIllegalReson','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdInIllegalReson.ftl?id='+id+"&type="+type,800,600);
	}else if(type&&type=='fdoutillegalreson'){
		contentWin=openSubWin('fdOutIllegalReson','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/fdOutIllegalReson.ftl?id='+id+"&type="+type,800,600);
	}else if(type&&type=='fdbusinessscope'){
		contentWin=openSubWin('TDataGsxtIcIllegalscop','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtIcIllegalscop.ftl?id='+id+"&type="+type,800,600);
	}
}

</script>
</@CommonQueryMacro.page>
