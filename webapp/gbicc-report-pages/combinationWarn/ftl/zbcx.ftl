<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="信贷资产监测指标">
<style>
div.form1{
	width:90%;
	height:250px;
	text-align:center;
	border:1px solid #0099CC;
	float:left;
	margin:5px 2px 2px 2px;
	margin-left: 40px;
	}
div.form2{
	width:45%;
	height:250px;
	text-align:center;
	border:1px solid #0099CC;
	float:left;
	margin:5px 2px 2px 2px;
	margin-left: 40px;
	}
div.group{
	width:99%;
	height:25px;
	text-align:left;
	border:1px solid #0099CC;
	float:left;
	margin:5px 2px 2px 2px;
	border: 0px solid #0099CC;
	}

group.h5 {
    background: url('images/bg_maintab.gif') 0 0 repeat-x;
    height: 25px;
    line-height: 25px;
    font-weight: bold;
    padding-left: 10px;
}

</style>
<table align="left">
<tr><td>
<@CommonQueryMacro.CommonQuery id="TCwFinancialAllValMonitor" init="false" submitMode="current">
			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
			<@CommonQueryMacro.DataTable id="datatable2" paginationbar="" maxRow="3" fieldStr="INDEX_NAME,industryopr,INDUSTRY_TYPE,MONITOR_FRE,均值{NOW_VAL_1|TOP_VAL_1|YC_VAL_1},90%分位{NOW_VAL_2|TOP_VAL_2|YC_VAL_2},70%分位{NOW_VAL_3|TOP_VAL_3|YC_VAL_3},50%分位{NOW_VAL_4|TOP_VAL_4|YC_VAL_4},30%分位{NOW_VAL_5|TOP_VAL_5|YC_VAL_5},10%分位{NOW_VAL_6|TOP_VAL_6|YC_VAL_6},上市公司行业均值{NOW_VAL_7|TOP_VAL_7|YC_VAL_7},opr"  width="100%" hasFrame="true"/>
</@CommonQueryMacro.CommonQuery>
</td></tr>
</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script language="JavaScript">

function initCallGetter_post(){
	
	
}


//提交_参数
function btHandle_onClickCheck(button){
}


function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDUSTRY_CODE")+"\",\""+record.getValue("INDEX_NAME")+"\",\""+record.getValue("INDUSTRY_NAME")+"\",\""+record.getValue("DATA_DATE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable2_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport2(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDUSTRY_CODE")+"\",\""+record.getValue("INDEX_NAME")+"\",\""+record.getValue("INDUSTRY_NAME")+"\",\""+record.getValue("DATA_DATE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function datatable2_industryopr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport3(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDUSTRY_CODE")+"\",\""+record.getValue("INDEX_NAME")+"\",\""+record.getValue("INDUSTRY_NAME")+"\",\""+record.getValue("DATA_DATE")+"\")'>"+record.getValue("INDUSTRY_NAME")+"</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}


function selectIndexReport(codeVal,INDUSTRY_CODE,INDEX_NAME,INDUSTRY_NAME,DATA_DATE){
	window.constWinTitleNameStr=INDEX_NAME+"-"+INDUSTRY_NAME;
	openSubWin("selectCustomerWin","图表展示——>指标趋势分析","/gbicc-report-pages/combinationWarn/ftl/TCwIndustryValReport1.ftl?INDEX_CODE="+codeVal+"&INDUSTRY_CODE="+INDUSTRY_CODE+"&DATA_DATE="+DATA_DATE,"1200","350");
}
function selectIndexReport2(codeVal,INDUSTRY_CODE,INDEX_NAME,INDUSTRY_NAME,DATA_DATE){
	window.constWinTitleNameStr=INDEX_NAME+"-"+INDUSTRY_NAME;
	openSubWin("selectCustomerWin","图表展示——>指标趋势分析","/gbicc-report-pages/combinationWarn/ftl/TCwIndustryValReport2.ftl?INDEX_CODE="+codeVal+"&INDUSTRY_CODE="+INDUSTRY_CODE+"&DATA_DATE="+DATA_DATE,"1200","450");
}
function selectIndexReport3(codeVal,INDUSTRY_CODE,INDEX_NAME,INDUSTRY_NAME,DATA_DATE){
	window.constWinTitleNameStr=INDEX_NAME;
	openSubWin("selectCustomerWin","图表展示——>指标趋势分析","/gbicc-report-pages/combinationWarn/ftl/TCwIndustryValReport3.ftl?INDEX_CODE="+codeVal+"&INDUSTRY_CODE="+INDUSTRY_CODE+"&DATA_DATE="+DATA_DATE,"1200","650");
}

	
</script>
</@CommonQueryMacro.page>