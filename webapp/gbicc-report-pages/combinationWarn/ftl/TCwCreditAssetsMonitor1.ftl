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
<@CommonQueryMacro.CommonQuery id="TCwCreditAssetsMonitor" init="true" submitMode="current">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" maxRow="3" fieldStr="INDEX_CODE[70],INDEX_NAME[200],INDEX_TYPE[100],COLO[70],MONITOR_FRE[70],NOW_VAL[70],TOP_VAL[70],YC_VAL[70],BSQ[70],BYC[70],THRESHOLD1[70],THRESHOLD2[70],opr[50]"  width="100%" hasFrame="true"/>
</@CommonQueryMacro.CommonQuery>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/ComninationWarnSAjax.js'> </script>
<script language="JavaScript">

function creditRepotType1(id,dname,xlist,valList,defaultSeriesType){
	$(id).highcharts({  
        chart:{  
             defaultSeriesType: defaultSeriesType,//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
             marginRight: 125,//上下左右空隙  
             marginBottom: 45 //上下左右空隙  
        },  
        title:{  
            text: dname,//主表题  
                x: -20 //center  
        },  
        credits:{text:'<span style="color:blue;font-size:12px"  title="点击图列项可以显示或隐藏相关图例">使用提示</span>'},
        xAxis: {   //横坐表  
        	//             categories: dataJson.listXdata 动态解析
        	categories:xlist
        },  
           yAxis: {  
           title: {  
             text: '数值' //纵坐表  
               },  
               plotLines: [{  //表线属性  
            value: -100,  
             width: 1,  
             color: 'yellow'  
                }]  
              },  
             tooltip: { //数据点的提示框  
 				valueSuffix:''
        },  
        legend: {  
              layout: 'vertical',  
              align: 'right',  
              verticalAlign: 'middle',   
              borderWidth: 0  
             },   
         series:valList//动态解析
         });
}


function initCallGetter_post(){

}


//提交_参数
function btHandle_onClickCheck(button){
	var year1 = TCwIndexORG_dataset.getValue("year1");
	var yearQ1 = TCwIndexORG_dataset.getValue("yearQ1");
	var year2 = TCwIndexORG_dataset.getValue("year2");
	var yearQ2 = TCwIndexORG_dataset.getValue("yearQ2");
	if(year1&&yearQ1&&year2&&yearQ2){
		if(year1>year2){
			top.easyMsg.info("请正确填写起止日期！");
			return false;
		}else if(year1==year2){
			if(yearQ1>yearQ2){
				top.easyMsg.info("请正确填写起止日期！");
			}
		}
	}else{
		top.easyMsg.info("请填写具体日期！");
		return false;
	}
	var orgId=user_info.orgId;
	var orgSelectparamStr=[year1,yearQ1,year2,yearQ2,"orgSelect",orgId];
	var productSelectparamStr=[year1,yearQ1,year2,yearQ2,"productSelect"];
	var industrySelectparamStr=[year1,yearQ1,year2,yearQ2,"industrySelect"];
	ComninationWarnSAjax.warnCountTXT(orgSelectparamStr,function(y){
		creditRepotType1('div#report1','预警数量时段统计-按机构',y.jsonData.listXdata,y.jsonData.data,'column');
	});
	ComninationWarnSAjax.warnCountTXT(productSelectparamStr,function(y){
		creditRepotType1('div#report2','预警数量时段统计-按产品',y.jsonData.listXdata,y.jsonData.data,'column');
	});
	ComninationWarnSAjax.warnCountTXT(industrySelectparamStr,function(y){
		creditRepotType1('div#report3','预警数量时段统计-按行业',y.jsonData.listXdata,y.jsonData.data,'column');
	});
}


function datatable1_opr_onRefresh(cell,value,record) {
	//alert(record.getValue("ORG_CODE"));
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDEX_NAME")+"\",\""+record.getValue("ORG_CODE")+"\",\""+record.getValue("GATHER_TYPE")+"\",\""+record.getValue("MONITOR_FRE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport(codeVal,INDEX_NAME,ORG_CODE,GATHER_TYPE,MONITOR_FRE){
	window.constWinTitleNameStr=INDEX_NAME;
	//openSubWin("selectCustomerWin","信贷资产监测指标展示","/gbicc-report-pages/combinationWarn/ftl/TCwIndexType.ftl?INDEX_CODE="+codeVal+"&ORG_CODE="+ORG_CODE+"&ORG_PARENT="+ORG_CODE+"&GATHER_TYPE="+GATHER_TYPE+"&MONITOR_FRE="+MONITOR_FRE,"1200","750");
	parent.parent.parent.GTab.addTab('selectCustomerWin',"信贷资产监测指标展示"+"("+INDEX_NAME+")","/gbicc-report-pages/combinationWarn/ftl/TCwIndexType.ftl?INDEX_CODE="+codeVal+"&ORG_CODE="+ORG_CODE+"&ORG_PARENT="+ORG_CODE+"&GATHER_TYPE="+GATHER_TYPE+"&MONITOR_FRE="+MONITOR_FRE,"1200");
	
}

function datatable1_bsq_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("BSQ")=="1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/up.png' width='20' height='15' />";
		}else if(record.getValue("BSQ")=="2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/down.png' width='20' height='15' />";
		}else{
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/clo.png' width='20' height='15' />";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable1_byc_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("BYC")=="1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/up.png' width='20' height='15' />";
		}else if(record.getValue("BYC")=="2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/down.png' width='20' height='15' />";
		}else{
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/clo.png' width='20' height='15' />";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function datatable1_colo_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("COLO")=="LV1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/red.png' width='20' height='15' />";
		}else if(record.getValue("COLO")=="LV2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/yellow.png' width='20' height='15' />";
		}else{
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/green.png' width='20' height='15' />";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function datatable2_colo_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("COLO")=="LV1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/red.png' width='20' height='15' />";
		}else if(record.getValue("COLO")=="LV2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/yellow.png' width='20' height='15' />";
		}else if(record.getValue("COLO")=="LV3"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/green.png' width='20' height='15' />";
		}else {
			cell.innerHTML="&nbsp;";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function datatable2_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport2(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDEX_NAME")+"\",\""+record.getValue("ORG_CODE")+"\",\""+record.getValue("GATHER_TYPE")+"\",\""+record.getValue("MONITOR_FRE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport2(codeVal,INDEX_NAME,ORG_CODE,GATHER_TYPE,MONITOR_FRE){
	window.constWinTitleNameStr=INDEX_NAME;
	openSubWin("selectCustomerWin","信贷资产监测指标展示","/gbicc-report-pages/combinationWarn/ftl/TCwIndexType2.ftl?INDEX_CODE="+codeVal+"&ORG_CODE="+ORG_CODE+"&ORG_PARENT="+ORG_CODE+"&GATHER_TYPE="+GATHER_TYPE+"&MONITOR_FRE="+MONITOR_FRE,"1200","450");
	
}

function readFinaAnal_onClick(){
	//openSubWin("selectCustomerWin","一般行业集中度分析","/gbicc-report-pages/combinationWarn/ftl/TCwIndexType3.ftl","1200","650");
	parent.GTab.addTab('TCwIndexType3_DESK',"一般行业集中度分析",'/gbicc-report-pages/combinationWarn/ftl/TCwIndexType3.ftl?flag=desk');
	
}

function readFinaInte_onClick(){
	parent.GTab.addTab('TCwIdnexManage_DESK',"监测指标阀值管理",'/gbicc-report-pages/thresholdManage/ftl/TCwIdnexManage.ftl?flag=desk');
}

function datatable2_bsq_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("BSQ")=="1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/up.png' width='20' height='15' />";
		}else if(record.getValue("BSQ")=="2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/down.png' width='20' height='15' />";
		}else{
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/clo.png' width='20' height='15' />";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function datatable2_byc_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("BYC")=="1"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/up.png' width='20' height='15' />";
		}else if(record.getValue("BYC")=="2"){
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/down.png' width='20' height='15' />";
		}else{
			cell.innerHTML="<img src='${contextPath}/templets/lib/functionTree/imgs/clo.png' width='20' height='15' />";
		}
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}


	
</script>
</@CommonQueryMacro.page>