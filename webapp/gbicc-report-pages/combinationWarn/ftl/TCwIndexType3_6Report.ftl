<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="上海地区">
<style>
div.form1{
	width:90%;
	height:400px;
	text-align:center;
	border:1px solid #0099CC;
	float:left;
	margin:5px 2px 2px 2px;
	margin-left: 40px;
	}

</style>
<table align="left">
<tr><td align="center">
	<@CommonQueryMacro.CommonQuery id="TCwCreditAssetsMonitor3" init="false" submitMode="current" >
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" fieldStr="indexName" labelwidth="200" showButton="false" />
	</@CommonQueryMacro.CommonQuery>
						<@CommonQueryMacro.Button id="btHandle" />
	</td></tr>
	<tr><td>
      		<div id="report1" class="form1">无数据</div>
</td></tr>
<tr><td>
<@CommonQueryMacro.CommonQuery id="TCwCreditAssetsMonitor3" init="false" submitMode="current">
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" maxRow="3" fieldStr="INDEX_CODE[70],INDEX_NAME[250],COLO[70],MONITOR_FRE[70],NOW_VAL[100],TOP_VAL[100],YC_VAL[100],BSQ[70],BYC[70],THRESHOLD1[70],THRESHOLD2[70]"  width="100%" hasFrame="true"/>
					</@CommonQueryMacro.CommonQuery>
	</td></tr>

</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script language="JavaScript">
function creditRepotType1(id,dname,xlist,valList,defaultSeriesType){
	$(id).highcharts({  
        chart:{  
             defaultSeriesType: defaultSeriesType//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
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
       
         series:valList//动态解析
  			
         });
}

function btHandle_onClickCheck(button){
	var indexCode=TCwCreditAssetsMonitor3_interface_dataset.getValue("indexCode");
	var paramStr=["6",indexCode];
	AComninationWarnDAjax.warnValDDZXT(paramStr,function(y){
		if(y.success=="true"){
			creditRepotType1('div#report1',"一般行业集中度",y.jsonData1.listXdata,y.jsonData1.data,'line');
		}
	});
}

function initCallGetter_post(){
	
	TCwCreditAssetsMonitor3_dataset.setParameter("GATHER_TYPE","6");
	TCwCreditAssetsMonitor3_dataset.flushData(TCwCreditAssetsMonitor3_dataset.pageIndex);
	
	////ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
	/*
	AComninationWarnDAjax.warnValDDZXT("5",function(y){
		if(y.success=="true"){
			creditRepotType1('div#report1',"一般行业集中度",y.jsonData1.listXdata,y.jsonData1.data,'line');
		}
	});
	*/
	
}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
</@CommonQueryMacro.page>