<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="�����Ŀ���Ʒ���">

	<@CommonQueryMacro.CommonQuery id="TbCsmFinanceIndexTendencyData" init="false" submitMode="selected" navigate="false">
			<#assign jzyear=''>
			<#assign caliber=''>
			<#assign repno=''>
			<#assign customerNum=RequestParameters["customerNum"]?default("")>
			
			<table align="left" width="100%">
			    <tr>
					<td>
						<@CommonQueryMacro.Group id="group22" label="" colNm=16  
						fieldStr="startDate,backQs,caliber,project,checkBox,checkBox1"/>
						<center>
           			           <@CommonQueryMacro.Button id="btModOrAdd23" />
						</center>
					</td>
				</tr>
			</table>
	</@CommonQueryMacro.CommonQuery>

<style>
div.form1{width:35%;
	height:350px;
	text-align:center;
	border:1px solid #0099CC;
	float:left;
	margin:10px 5% 2px 5%;
	}
div.clear{
	clear:both;
	}
span.style1{
	color:red;
}
</style>

<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>

<div id="claer" style="clear:both"></div>
<div id="container" class="form1" style="width: 90%;"></div>
	






<script language="JavaScript">
function btModOrAdd23_onClickCheck(button){
	// var jzyear =TbCsmFinanceIndexTendencyData_dataset.getValue('jzyear');
	 var caliber =TbCsmFinanceIndexTendencyData_dataset.getValue('caliber');
	 var project  =TbCsmFinanceIndexTendencyData_dataset.getValue('project');
	 var startDate  =TbCsmFinanceIndexTendencyData_dataset.getValue('startDate');
	 var backQs  =TbCsmFinanceIndexTendencyData_dataset.getValue('backQs');
	 var checkBox  =TbCsmFinanceIndexTendencyData_dataset.getValue('checkBox');
	 var checkBox1  =TbCsmFinanceIndexTendencyData_dataset.getValue('checkBox1');
	 var customerNum='${customerNum}';
	 if(caliber==''){
	 easyMsg.info('�ھ�����Ϊ��');
	 return false;
	 }else if(project==''){
	 easyMsg.info('����ָ�겻��Ϊ��');
	 return false;
	 }else if(caliber=='4'&&backQs>36){ //�±�
		 easyMsg.info('��ѯ���±��������������ܳ���36�ڣ��£���')
		 return false; 
	 }else if(caliber=='3'&&backQs>12){ //����
		 easyMsg.info('��ѯ�������������������ܳ���12�ڣ�������')
		 return false; 
	 }
	 var arrys=new Array();
	 arrys= project.split(",");
	//console.log("length"+arrys.length);
	 if(arrys.length>6){
	    top.easyMsg.info("��ѡ��ָ�겻�ܳ���6����");
	    return false;
	 }
	 var chart;  
		//����ǰ��������ʾ
		$.messager.progress({title:'���Ժ�',msg:'��������...'});
	 	//�첽�ύ����
			$.ajax({								
				url :"${contextPath}/char/GetHighCharServlet",
		        type : "post",
				data:{
				   caliber:caliber,
				   project:project,
				   startDate:startDate,
				   backQs:backQs,
				   customerNum:customerNum,
				   checkBox:checkBox,
				   checkBox1:checkBox1,
				   type:'index'	
				},
				success:function(data){
				//ͼ������
				var dataJson=eval("("+data+")");
				   
					 //�˴���������  
                     $('#container').highcharts({  
				        chart:{  
				             defaultSeriesType: 'line',//ͼ������ʾ���ͣ�line,spline,scatter,splinearea bar,pie,area,column��  

				        },  
				        title:{  
				            text: 'ָ�����Ʒ�����ͼ',//������  
				                x: -20 //center  
				        },  
				        xAxis: {   //������  
				               categories: dataJson.listXdata //��̬����
				        },  
				            yAxis: {  
				           title: {  
				             text: '' //������  
				               },  
				               plotLines: [{  //��������  
				            value: 0,  
				             width: 1,  
				             color: 'red'  
				                }]  
				              },  
				             tooltip: { //���ݵ����ʾ��  
				             formatter: function() { //formatter��ʽ������  
				             return '<b>'+ this.series.name +'</b><br/>'+  
				             this.x +': '+ this.y;  
				            }  
				        },  
				        legend: {  
				              layout: 'vertical',  
				              align: 'right',  
				              verticalAlign: 'top',  
				              x: -10,  
				              y: 100,  
				              borderWidth: 0  
				             },   
				         series:dataJson.data//��̬����
				         });
                   //ͼ�����ƺ�رս�����
                     $.messager.progress('close');
				}
			});
			
 
  }

function caliber_DropDown_onSelect(dropdown,record,editor){
	if(record.getValue('data')!=1){
		TbCsmFinanceIndexTendencyData_dataset.setValue('checkbox1','0');
		TbCsmFinanceIndexTendencyData_dataset.setFieldReadOnly('checkbox1',true);
	}else{
		TbCsmFinanceIndexTendencyData_dataset.setFieldReadOnly('checkbox1',false);
	}
	return true;
}
  
  function project_DropDown_beforeOpen(dropdown){
	  if(TbCsmFinanceIndexTendencyData_dataset.getValue("caliber")!='3'){
		  TbCsmFinanceIndexCd_DropDownDataset.setParameter('caliber','0');
	  }else{
		  TbCsmFinanceIndexCd_DropDownDataset.setParameter('caliber','1');
	  }
	  project_DropDown.cached=false;//��qGroupId�����뻺��
	}




</script>
</@CommonQueryMacro.page>