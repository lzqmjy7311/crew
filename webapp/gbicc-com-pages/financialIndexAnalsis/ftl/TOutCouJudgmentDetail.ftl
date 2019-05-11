<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="判决公告">
<@CommonQueryMacro.CommonQuery id="TOutCouJudgmentDetail" init="false" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"
				fieldStr="companyAnme,caseType,writNo,writTitle,judgCourt,judgDate,content,sourceLink" 
				readonly="true" width="100%"/></br>
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
	TOutCouJudgmentDetail_dataset.setParameter("typeid",typeId);
	TOutCouJudgmentDetail_dataset.setParameter("data",fdDate);
	TOutCouJudgmentDetail_dataset.setParameter("relaId",customerNum);
	TOutCouJudgmentDetail_dataset.flushData();
}

function datatable1_content_onRefresh(cell,value,record){
	if (record) {//当存在记录时
		var id=record.getValue("content");
		if(!!id){
			cell.innerHTML='<a href="JavaScript:aclick(\''+record.getValue("id")+'\')">查看详细内容</a>';
		}
	}
}

function aclick(id){
	contentWin=openSubWin('JudgmentClob','详细内容','/gbicc-com-pages/financialIndexAnalsis/ftl/JudgmentClob.ftl?id='+id,800,600);
}

</script>
</@CommonQueryMacro.page>
