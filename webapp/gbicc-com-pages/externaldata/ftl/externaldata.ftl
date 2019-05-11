<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="外部风险数据">
<@CommonQueryMacro.CommonQuery id="externaldatastatistics" init="true" submitMode="current" navigate="false">
<@CommonQueryMacro.DataTable id="externaldatatable"  title="外部数据" fieldStr="fdType,onemonth,threemonth,halfYear,oneYear,twoyear" />
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>

<script>
function externaldatatable_onemonth_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		var fdType=record.getValue("fdType");
		var typeId=record.getValue("typeId");
		cell.innerHTML="<a href=\"JavaScript:aclick('"+fdType+"','"+typeId+"','time1')\">"+value+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function externaldatatable_threemonth_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		var fdType=record.getValue("fdType");
		var typeId=record.getValue("typeId");
		cell.innerHTML="<a href=\"JavaScript:aclick('"+fdType+"','"+typeId+"','time3')\">"+value+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function externaldatatable_halfyear_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		var fdType=record.getValue("fdType");
		var typeId=record.getValue("typeId");
		cell.innerHTML="<a href=\"JavaScript:aclick('"+fdType+"','"+typeId+"','timehalf')\">"+value+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function externaldatatable_oneyear_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		var fdType=record.getValue("fdType");
		var typeId=record.getValue("typeId");
		cell.innerHTML="<a href=\"JavaScript:aclick('"+fdType+"','"+typeId+"','timeyear')\">"+value+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function externaldatatable_twoyear_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		var fdType=record.getValue("fdType");
		var typeId=record.getValue("typeId");
		cell.innerHTML="<a href=\"JavaScript:aclick('"+fdType+"','"+typeId+"','timetwo')\">"+value+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function aclick(fdType,typeId,fdDate){
	var customerNum='${customerNum}';
	switch(typeId){
	case 'AP':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TOutCouJudgmentDetail.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'AK':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TOutCouNoticeDetail.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'GB':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TOutIndBaseInfo.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'SZ':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TOutDataTax.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"800","300",false,true,'',true);
	case 'SQ':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataOwingTaxes.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"800","300",false,true,'',true);
	case 'SF':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataUnnormalTaxes.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"800","300",false,true,'',true);	
	case 'GG':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtJudicialEquityFreezon.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'GX':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtIcPunishment.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'GJ':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtIcException.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	case 'GY':
		windows = openSubWin("wbdata", "外部数据明细：&nbsp;"+fdType, "/gbicc-com-pages/financialIndexAnalsis/ftl/TDataGsxtIcIllegal.ftl?typeId="+typeId+"&fdDate="+fdDate+"&customerNum="+customerNum,"1024","300",false,true,'',true);
	
	}
	
}
//$(document).ready(function(){
//	var strid;
//	$("a").mouseover(function(){
//		var str1=$(this).attr("id");
//		strid="#div"+str1;
//		$("#div").css('display','block');
//		$("#div").text("现在点击的表格ID是"+strid);
//	});
//	$("a").mouseleave(function(){
//		$("#div").css('display','none');
//	});
//})
</script>