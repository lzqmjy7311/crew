<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="工商变更">
<@CommonQueryMacro.CommonQuery id="TOutIndBaseInfo" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,registorNo,legalName,certNo,fdModifyItem,fdInfoBeforeModify,fdInfoAfterModify,cancelDate,enterStatus,busstartDate,busendDate,busscope,registorAmt,enterOrg,address,checkDate,shareHolder"  readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
var contentWin=null;
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TOutIndBaseInfo_dataset.setParameter("typeid",typeId);
	TOutIndBaseInfo_dataset.setParameter("data",fdDate);
	TOutIndBaseInfo_dataset.setParameter("relaId",customerNum);
	TOutIndBaseInfo_dataset.flushData();
}
function datatable1_busscope_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'busscope\')">查看详细内容</a>';
		}
	}
}
function datatable1_fdinfobeforemodify_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdinfobeforemodify\')">查看详细内容</a>';
		}
	}
}
function datatable1_fdinfoaftermodify_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("id");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\',\'fdinfoaftermodify\')">查看详细内容</a>';
		}
	}
}
function aclick(id,type){
	contentWin=openSubWin('BaseInfoClob','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/BaseInfoClob.ftl?id='+id+'&relaId='+customerNum+'&type='+type,800,200);
}
</script>
</@CommonQueryMacro.page>
