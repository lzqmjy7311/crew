<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign INDEX_CODE=RequestParameters["INDEX_CODE"]?default("")>
<#assign PRODUCT_CODE=RequestParameters["PRODUCT_CODE"]?default("")>
<#assign GATHER_TYPE=RequestParameters["GATHER_TYPE"]?default("")>
<#assign ORG_CODE=RequestParameters["ORG_CODE"]?default("")>
<@CommonQueryMacro.page title="�Ŵ��ʲ����ָ��չʾ_��ҵ����">
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
      		<div id="report1" class="form1">������</div>
</td></tr>

</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
<script language="JavaScript">



/*
function datatable1_opr_onRefresh(cell,value,record) {
	if (record) {//�����ڼ�¼ʱ
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("PRODUCT_CODE")+"\",\""+record.getValue("GATHER_TYPE")+"\")'>�鿴</a>";
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport(codeVal,PRODUCT_CODE,GATHER_TYPE){
	openSubWin("selectCustomerWin","�Ŵ��ʲ����ָ��չʾ_��Ʒ����","/gbicc-report-pages/combinationWarn/ftl/TCwIndexProductReport.ftl?INDEX_CODE="+codeVal+"&GATHER_TYPE="+GATHER_TYPE+"&PRODUCT_CODE="+PRODUCT_CODE,"1100","750");
}

*/
function creditRepotType1(id,dname,xlist,valList,defaultSeriesType){
	$(id).highcharts({  
        chart:{  
             defaultSeriesType: defaultSeriesType,//ͼ������ʾ���ͣ�line,spline,scatter,splinearea bar,pie,area,column��  
             marginRight: 125,//�������ҿ�϶  
             marginBottom: 25 //�������ҿ�϶  
        },  
        title:{  
            text: dname,//������  
                x: -20 //center  
        },  
        xAxis: {   //������  
        	//             categories: dataJson.listXdata ��̬����
        	categories:xlist
        },  
           yAxis: {  
           title: {  
             text: '��ֵ' //������  
               },  
               plotLines: [{  //��������  
            value: -100,  
             width: 1,  
             color: 'yellow'  
                }]  
              },  
             tooltip: { //���ݵ����ʾ��  
 				valueSuffix:''
        },  
        legend: {  
              layout: 'vertical',  
              align: 'right',  
              verticalAlign: 'middle',   
              borderWidth: 0  
             },   
         series:valList//��̬����
  			
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