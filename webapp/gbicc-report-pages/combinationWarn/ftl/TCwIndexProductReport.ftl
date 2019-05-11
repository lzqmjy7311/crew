<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign INDEX_CODE=RequestParameters["INDEX_CODE"]?default("")>
<#assign PRODUCT_CODE=RequestParameters["PRODUCT_CODE"]?default("")>
<#assign GATHER_TYPE=RequestParameters["GATHER_TYPE"]?default("")>
<#assign ORG_CODE=RequestParameters["ORG_CODE"]?default("")>
<@CommonQueryMacro.page title="信贷资产监测指标展示_行业排名">
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
</style>
<table align="left" style="width: 100%">
	<tr><td>
      		<div id="report1" class="form1">无数据</div>
</td></tr>

</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
<script language="JavaScript">



/*
function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("PRODUCT_CODE")+"\",\""+record.getValue("GATHER_TYPE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport(codeVal,PRODUCT_CODE,GATHER_TYPE){
	openSubWin("selectCustomerWin","信贷资产监测指标展示_产品排名","/gbicc-report-pages/combinationWarn/ftl/TCwIndexProductReport.ftl?INDEX_CODE="+codeVal+"&GATHER_TYPE="+GATHER_TYPE+"&PRODUCT_CODE="+PRODUCT_CODE,"1100","750");
}

*/
function creditRepotType1(id,dname,xlist,valList,defaultSeriesType){
	$(id).highcharts({  
        chart:{  
             defaultSeriesType: defaultSeriesType,//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
             marginRight: 125,//上下左右空隙  
             marginBottom: 25 //上下左右空隙  
        },  
        title:{  
            text: dname,//主表题  
                x: -20 //center  
        },  
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
	
	var INDEX_CODE='${INDEX_CODE}';
	var PRODUCT_CODE='${PRODUCT_CODE}';
	var GATHER_TYPE='${GATHER_TYPE}';
	/*
	TCwIndexPRODUCT_dataset.setParameter("ORG_PARENT","");
	TCwIndexPRODUCT_dataset.setParameter("ORG_CODE",'${ORG_CODE}');
	TCwIndexPRODUCT_dataset.setParameter("INDEX_CODE",INDEX_CODE);
	TCwIndexPRODUCT_dataset.setParameter("PRODUCT_TYPE","");
	TCwIndexPRODUCT_dataset.setParameter("PRODUCT_CODE",PRODUCT_CODE);
	TCwIndexPRODUCT_dataset.setParameter("INDUSTRY_PARENT","");
	TCwIndexPRODUCT_dataset.setParameter("INDUSTRY_TYPE","");
	TCwIndexPRODUCT_dataset.setParameter("INDUSTRY_CODE","-");
	TCwIndexPRODUCT_dataset.setParameter("GATHER_TYPE",GATHER_TYPE);
	TCwIndexPRODUCT_dataset.flushData(TCwIndexPRODUCT_dataset.pageIndex);
	*/
	var INDUSTRY_CODE='-';
	var ORG_CODE='${ORG_CODE}';
	////ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
	var paramStr=[ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE];
	AComninationWarnDAjax.findIndexInfoAjx(INDEX_CODE,function(yyy){
		AComninationWarnDAjax.warnValZXT(paramStr,function(y){
			if(y.success=="true"){
				creditRepotType1('div#report1',yyy.INDEX_NAME,y.jsonData1.listXdata,y.jsonData1.data,'line');
			}
		});
	});
	
}

	
</script>
</@CommonQueryMacro.page>