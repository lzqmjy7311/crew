<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign INDEX_CODE=RequestParameters["INDEX_CODE"]?default("")>
<#assign ORG_CODE=RequestParameters["ORG_CODE"]?default("")>
<#assign GATHER_TYPE=RequestParameters["GATHER_TYPE"]?default("")>
<@CommonQueryMacro.page title="信贷资产监测指标展示">
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
<table align="left">
	<tr><td>
      		<div id="report1" class="form1">无数据</div>
</td></tr>
<tr><td>
<@CommonQueryMacro.CommonQuery id="TCwIndexORG" init="false" submitMode="current">
			<@CommonQueryMacro.GroupBox id="box1" label="机构排名">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" maxRow="3" fieldStr="ORG_NAME,ORG_CODE,NOW_VAL,COLO,TOP_VAL,BSQCOUNT,BSQANG,YC_VAL,BYCCOUNT,BYCANG,opr"  width="100%" hasFrame="true"/>
			</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
	</td></tr>

</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
<script language="JavaScript">




function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("ORG_CODE")+"\",\""+record.getValue("ORG_NAME")+"\",\""+record.getValue("GATHER_TYPE")+"\",\""+record.getValue("MONITOR_FRE")+"\")'>查看</a>";
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport(codeVal,ORG_CODE,ORG_NAME,GATHER_TYPE,MONITOR_FRE){
	parent.parent.GTab.addTab("selectCustomerWin"+ORG_CODE,"信贷资产监测指标展示_机构_"+ORG_NAME,"/gbicc-report-pages/combinationWarn/ftl/TCwIndexOrgReport.ftl?INDEX_CODE="+codeVal+"&ORG_CODE="+ORG_CODE+"&GATHER_TYPE="+GATHER_TYPE);
}


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
	
	
	var INDEX_CODE='${INDEX_CODE}';
	var ORG_PARENT='${ORG_CODE}';
	var ORG_CODE='${ORG_CODE}';
	var GATHER_TYPE='0';
	TCwIndexORG_dataset.setParameter("ORG_PARENT",ORG_CODE);
	TCwIndexORG_dataset.setParameter("ORG_CODE","");
	TCwIndexORG_dataset.setParameter("INDEX_CODE",INDEX_CODE);
	TCwIndexORG_dataset.setParameter("PRODUCT_TYPE","");
	TCwIndexORG_dataset.setParameter("PRODUCT_CODE","-");
	TCwIndexORG_dataset.setParameter("INDUSTRY_PARENT","");
	TCwIndexORG_dataset.setParameter("INDUSTRY_TYPE","");
	TCwIndexORG_dataset.setParameter("INDUSTRY_CODE","-");
	TCwIndexORG_dataset.setParameter("GATHER_TYPE","0");
	TCwIndexORG_dataset.flushData(TCwIndexORG_dataset.pageIndex);
	var PRODUCT='-';
	var INDUSTRY='-';
	////ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
	var paramStr=[ORG_CODE, PRODUCT, INDEX_CODE, INDUSTRY, GATHER_TYPE];
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