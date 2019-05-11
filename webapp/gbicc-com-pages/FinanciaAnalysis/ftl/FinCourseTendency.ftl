<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="�����Ŀ���Ʒ���">

	<@CommonQueryMacro.CommonQuery id="TbCsmFinanceStatementTendencyData" init="false" submitMode="selected" navigate="false">
			<#assign jzyear=''>
			<#assign caliber=''>
			<#assign repno=''>
			<#assign customerNum=RequestParameters["customerNum"]?default("")>
			
			<table align="left" width="100%">
			    <tr>
					<td>
						<@CommonQueryMacro.Group id="group22" label="" colNm=16  
						fieldStr="startDate,backQs,caliber,project,checkBox"/>
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
	// var jzyear =TbCsmFinanceStatementTendencyData_dataset.getValue('jzyear');
	 var caliber =TbCsmFinanceStatementTendencyData_dataset.getValue('caliber');
	 var project  =TbCsmFinanceStatementTendencyData_dataset.getValue('project');
	 var startDate  =TbCsmFinanceStatementTendencyData_dataset.getValue('startDate');
	 var backQs  =TbCsmFinanceStatementTendencyData_dataset.getValue('backQs');
	 var checkBox  =TbCsmFinanceStatementTendencyData_dataset.getValue('checkBox');
	 var customerNum='${customerNum}';
	 
	 if(caliber==''){
	 easyMsg.info('�ھ�����Ϊ��');
	 return false;
	 }else if(project==''){
	 easyMsg.info('�����Ŀ����Ϊ��');
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
	 if(arrys.length>5){
	    top.easyMsg.info("��ѡ�Ŀ�Ŀ���ܳ���5����");
	    return false;
	 }
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
				   checkBox1:'',
				   type:'course'				   
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
				            text: '�����Ŀ������ͼ',//������  
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

//����ͳ����
	function project_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}



 
</script>
</@CommonQueryMacro.page>