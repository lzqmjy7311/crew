<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign INDEX_CODE=RequestParameters["INDEX_CODE"]?default("")>
<#assign INDUSTRY_CODE=RequestParameters["INDUSTRY_CODE"]?default("")>
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
<table align="left">
	<tr><td>
      		<div id="report1" class="form1">������</div>
</td></tr>
<tr><td>
<@CommonQueryMacro.CommonQuery id="TCwIndexINDUSTRY" init="false" submitMode="current">
			<@CommonQueryMacro.GroupBox id="box1" label="��ҵ����">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" maxRow="3" fieldStr="INDUSTRY_NAME,INDUSTRY_CODE,NOW_VAL,COLO,TOP_VAL,BSQCOUNT,BSQANG,YC_VAL,BYCCOUNT,BYCANG,opr"  width="100%" hasFrame="true"/>
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
	if (record) {//�����ڼ�¼ʱ
		cell.innerHTML="<a href='JavaScript:selectIndexReport(\""+record.getValue("INDEX_CODE")+"\",\""+record.getValue("INDUSTRY_CODE")+"\",\""+record.getValue("INDUSTRY_NAME")+"\",\""+record.getValue("GATHER_TYPE")+"\",\""+record.getValue("ORG_CODE")+"\")'>�鿴</a>";
	} else {//�������ڼ�¼ʱ
		cell.innerHTML="&nbsp;";
	}
}

function selectIndexReport(codeVal,INDUSTRY_CODE,INDUSTRY_NAME,GATHER_TYPE,ORG_CODE){
	openSubWin("selectINDUSTRY_CODEWin"+INDUSTRY_CODE,"�Ŵ��ʲ����ָ��չʾ_��ҵ_"+INDUSTRY_NAME,"/gbicc-report-pages/combinationWarn/ftl/TCwIndexIndustryReport.ftl?INDEX_CODE="+codeVal+"&GATHER_TYPE="+GATHER_TYPE+"&INDUSTRY_CODE="+INDUSTRY_CODE+"&ORG_CODE="+ORG_CODE,"1100","750");
}


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
        credits:{text:'<span style="color:blue;font-size:12px"  title="���ͼ���������ʾ���������ͼ��">ʹ����ʾ</span>'},
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
	var INDUSTRY_CODE='${INDUSTRY_CODE}';
	var GATHER_TYPE='${GATHER_TYPE}';
	var ORG_CODE='${ORG_CODE}';
	TCwIndexINDUSTRY_dataset.setParameter("ORG_PARENT","");
	TCwIndexINDUSTRY_dataset.setParameter("ORG_CODE",ORG_CODE);
	TCwIndexINDUSTRY_dataset.setParameter("INDEX_CODE",INDEX_CODE);
	TCwIndexINDUSTRY_dataset.setParameter("PRODUCT_TYPE","");
	TCwIndexINDUSTRY_dataset.setParameter("PRODUCT_CODE","-");
	TCwIndexINDUSTRY_dataset.setParameter("INDUSTRY_PARENT",INDUSTRY_CODE);
	TCwIndexINDUSTRY_dataset.setParameter("INDUSTRY_TYPE","");
	TCwIndexINDUSTRY_dataset.setParameter("INDUSTRY_CODE","");
	TCwIndexINDUSTRY_dataset.setParameter("GATHER_TYPE",GATHER_TYPE);
	TCwIndexINDUSTRY_dataset.flushData(TCwIndexINDUSTRY_dataset.pageIndex);
	var PRODUCT='-';
	////ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
	var paramStr=[ORG_CODE, PRODUCT, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE];
	
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