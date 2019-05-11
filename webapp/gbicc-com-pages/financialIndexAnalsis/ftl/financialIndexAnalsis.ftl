<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign customerNum=RequestParameters["customerNum"]?default("")>

<@CommonQueryMacro.page title="����ָ�����">
<style>
div.form1{width:35%;
	height:350px;
	text-align:center;
	border:1px solid #0099CC;
	float:left;
	margin:5px 2px 2px 2px;
	padding:40px 0;
	}
div.form2{width:25%;
	height:260px;
	text-align:left;
	border:1px solid black;
	float:left;
	margin:25px 2px 2px 6px;
	padding:50px 10px 0 10px;
	line-height:130%;
	padding:20px 10px 10px 10px;
	}
div.form3{width:12%;
	height:345px;
	text-align:left;
	border:1px solid green;
	float:left;
	margin:15px 5px 2px 2px;
	padding:10px 5px 0 5px;
	line-height:130%;
	padding:20px 10px 10px 10px;
	}
div.form4{
	text-align:center;
	width:100%;
	font-size:140%;
	font-weight:bold
	padding:20px 0 0 0;
	margin:15px 5px 2px 2px;
	}
div.clear{
	clear:both;
	}
span.style1{
	color:red;
	font-size:12px;
}
</style>

<@CommonQueryMacro.CommonQuery id="financialIndexAnalsis" init="true" submitMode="current">
	<@CommonQueryMacro.Group id="group22" label="" colNm=6  
	fieldStr="jzyear,caliber,repno"/>
	<center>
	<@CommonQueryMacro.Button id="btnQuery" />
	</center>
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TCmFinanceIndexHyFw" init="true" submitMode="current">
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.GroupBox id="CapitalLiabilitiesBox" label="�������">
	<@CommonQueryMacro.CommonQuery id="CapitalLiabilities" init="true" submitMode="current">
		<div>ִ����Ҫ��ˮƽ�ο�ֵ: <@CommonQueryMacro.SingleField fId="reference_value"/></div>
		<@CommonQueryMacro.DataTable id="CapitalLiabilitiesTable" title="�ʲ���ծ��" nowrap='true' pageCache="false" maxRow="1000" 
		fieldStr="project_name,project_value,project_value_2,amt,rate,plvalue,excep_flag,range[200],excep_flag_2[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="Profit" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="ProfitTable" title="�����" nowrap='true' pageCache="false"  maxRow="1000" 
		fieldStr="project_name,project_value,project_value_2,amt,rate,plvalue,excep_flag,range[200],excep_flag_2[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.GroupBox>

<div style="clear:both;float:none;min-width:1200px;margin:0 0 0 10px">
	<div style="marign:20px 0 20px 0">&nbsp;</div>
	<table style="width:100%">
		<tr>
			<td style="width:70%" valign="bottom">
				<div class="form4">Ӧ��Ӧ���˿���ת�ڼ��仯�����</div>
			</td>
		</tr>
	</table>
	<div id="1" class="form1">1</div>
	<div id="2" class="form1">2</div>
	<div class="form2">
		<span class="style1">
			
				ָ��˵����</br>
				������ҵ�������ν���ʱ�ʽ�ʹ��״���Ƿ�����쳣,��ծȨ��ת�ں�ծ����ת����ɡ�ͨ��������ҵ�ڶ����ڽ����ʽ�ʹ�á��仯�����ͱ��ڽ����ʽ�ʹ�á�ˮƽֵ�������Է�����ҵ�ڽ��׻������ʽ��Ƿ���ڡ��쳣ֵ�����Լ����쳣ֵ������ҵ��ɷ��յĳ̶ȡ�ָ��ֵ����˵����ҵ�����տ��쳣�������οͻ������Ʋ��������ָ��ֵ��С˵����ҵ����֧���쳣�����޷�����ʽ�

		</span>
	</div>
	<div class="clear"></div>
	<div style="margin:20px 0 40px 0"></div>
	<table style="width:100%">
		<tr>
			<td style="width:35%;">
				<div class="form4">����ծ��״��ˮƽ�ͱ仯�����</div>
			</td>
			<td style="width:13%;">
				<div class="form4">&nbsp;</div>
			</td>
			<td style="width:35%;">
				<div class="form4">ʵ�����ʲ���ת�仯��</div>
			</td>
			<td style="width:15%;">
				<div class="form4">&nbsp;</div>
			</td>
		</tr>
	</table>
	<div id="4" class="form1"">4</div>
	<div class="form3"">
		<span class="style1">
			ָ��˵����</br>
			������ҵ���ڻ�����ڽ���ծ�񣨶��ڽ��ͳ��ڽ�ʹ��Ч���Ƿ��쳣��ָ��ֵ�����仯������ƫ����ҵˮƽֵ˵������ҵ�Ľ��ʹ��Ч�ʺܵͣ���������ҵ���ʹ��״�����ֽ����Ƿ���֧�����۵��ʽ���ת��
		</span>
	</div>
	<div id="6" class="form1"">6</div>
	<div class="form3"">
		<span class="style1">
			ָ��˵����</br>
			ͨ����ҵ���ںͶ�����ʵ�����ʲ�������͹̶��ʲ����仯�Աȣ��ж���ҵ�Ƿ����ʵ�����ʲ�ʹ��Ч���쳣��ָ��ֵ����˵����ͻ����׻���������������ָ��ֵ��С˵����ҵ�ʽ���ת�񻯡�
		</span>
	</div>
	<div class="clear"></div>
	<div style="margin:20px 0 40px 0"></div>
	<table style="width:100%;">
		<tr>
			<td style="width:35%;">
				<div class="form4" title="���ھ�������=��Ӫҵ�����룫Ӫҵ������+�������룭Ӧ��Ʊ�������Ӧ���ʿ������Ԥ���˿������� 
���ھ���֧��=��Ӫҵ��ɱ�����Ӫҵ˰�𼰸��ӣ�����������+�������+Ӫҵ��֧����-Ӧ��Ʊ��������-Ӧ���˿�������-Ӧ������������-Ӧ��������������-Ӧ������������-Ӧ��˰��������+���������+Ԥ���˿�������+���������ʲ�������-����������ծ������" >������֧�����Է���<img style='vertical-align:top' src='${contextPath}/templets/lib/functionTree/imgs/1.png' width='16' height='16' /></div>
			</td>
			<td style="width:13%;">
				<div class="form4">&nbsp;</div>
			</td>
			<td style="width:35%;">
				<div class="form4">��ҵ�ʲ������ۺ����Է������ʲ�ϵ����</div>
			</td>
			<td style="width:15%;">
				<div class="form4">&nbsp;</div>
			</td>
		</tr>
	</table>
	<div  id="8" class="form1"">8</div>
	<div class="form3"">
		<span class="style1">
			ָ��˵����</br>
			������ҵ���ںͽ����ھ����Ի���ֽ��������ֽ�������һ����ҵ���ھ�����֧��100%����Ϊ������95%Ϊ�쳣������90%���պܴ󣬵���80%���ڵ��շ��ա�����ƽ������95%Ϊ�ǳ�Σ�գ�����90%Ϊ����Σ����ҵ��
		</span>
	</div>
	<div  id="10" class="form1"">10</div>
	<div class="form3"">
		<span class="style1">
			ָ��˵����</br>
			������ҵ���ʲ��뵱����Ӫҵ������ı�ֵ����Ӧ��ҵ�ʲ��ṹ���ʲ�Ч�ʵ�ƥ��̶ȡ�ָ��ֵ���󣨳���3����˵�������ʲ���ĭ����ϵͳ���գ�ָ��ֵ��С������0.3��˵����ҵ�����������һ����ҵ��0.75-1����Ϊ������
		</span>
	</div>
</div>

<!-- javascript -->


<script language="JavaScript">
var domList=document.getElementsByTagName('td');
function getDom(){
	//debugger;
	for(var i=0;i<domList.length;i++){
		if(domList[i].title=='ͬ�ȱ���ҵ�쳣'){
			domList[i].title="���ڿ�Ŀ������ֵ��ִ����Ҫ��ˮƽ�Ƚϣ��������쳣��Y��";
			domList[i].innerHTML="ͬ�ȱ���ҵ�쳣<img style='vertical-align:top' src='${contextPath}/templets/lib/functionTree/imgs/12.png' width='12' height='12' />";
		}
		if(domList[i].title=='ͬ�ȱ����ҵ�쳣'){
			domList[i].title="���ڿ�Ŀֵ������ͬ��ҵ��ҵ��λ��ȡֵ��Χ�Ƚϣ��������쳣��Y��";
			domList[i].innerHTML="ͬ�ȱ����ҵ�쳣<img style='vertical-align:top' src='${contextPath}/templets/lib/functionTree/imgs/12.png' width='12' height='12' />";
		}
		if(domList[i].title=='ƫ��ֵ'){
			domList[i].title="���ڲ��ľ���ֵ��ִ����Ҫ��ˮƽ�ο�ֵ�Ĳ��";
			domList[i].innerHTML="ƫ��ֵ<img style='vertical-align:top' src='${contextPath}/templets/lib/functionTree/imgs/12.png' width='12' height='12' />";
		}
	}
};
var customerNum='${customerNum}';
var record;
var recordFields=new Array();
var length=null;
function btnQuery_onClick(){
	var jzyear =financialIndexAnalsis_dataset.getValue('jzyear');
	var caliber=financialIndexAnalsis_dataset.getValue('caliber');
	var repno  =financialIndexAnalsis_dataset.getValue('repno');
	if((jzyear==null)||(jzyear=='')){
		easyMsg.info('��Ȳ���Ϊ�գ�');
		return;
	}else if(caliber==''){
		easyMsg.info('�ھ�����Ϊ�գ�');
		return;
	}else if(repno==''){
		easyMsg.info('��������Ϊ�գ�');
		return;
	}
	CapitalLiabilities_dataset.setParameter("customerNum",customerNum);
	CapitalLiabilities_dataset.setParameter("jzyear",jzyear);
	CapitalLiabilities_dataset.setParameter("caliber",caliber);
	CapitalLiabilities_dataset.setParameter("repno",repno);
	CapitalLiabilities_dataset.setParameter("tableCd","01");
	CapitalLiabilities_dataset.flushData();
	
	Profit_dataset.setParameter("customerNum",customerNum);
	Profit_dataset.setParameter("jzyear",jzyear);
	Profit_dataset.setParameter("caliber",caliber);
	Profit_dataset.setParameter("repno",repno);
	Profit_dataset.setParameter("tableCd","03");
	Profit_dataset.flushData();
	
	TCmFinanceIndexHyFw_dataset.setParameter("odsDate",jzyear);
	TCmFinanceIndexHyFw_dataset.setParameter("financeStatementTypeCd",caliber);
	TCmFinanceIndexHyFw_dataset.setParameter("repno",repno);
	TCmFinanceIndexHyFw_dataset.flushData();
	
	var date=new Date();
	var monthflag=date.getMonth();
	var yearflag=date.getFullYear();
	if(caliber=='709'){
		if(jzyear==yearflag){
			if(repno==1){
				  month=3
			  }else if(repno==2){
				  month=6;
			  }else if(repno==3){
				  month=9;
			  }else if(repno==4){
				  month=12;
			  }
			 var monthflag=date.getMonth();
			 if(month>=monthflag){
				 alert("��������ȷ������");
				 return false;
			 }
		}
	}else{
		if(jzyear==yearflag){
			 alert("�޷���ѯ�����걨��");
			 return false;
		}
	}
	//�첽�ύ����
	$.ajax({								
		url :"${contextPath}/char/financialIndexAnalsisHigtCharServlet",
		type : "post",
		data:{
				caliber:caliber,
				jzyear:jzyear,
				customerNum:customerNum,
				repno:repno,
				type:'index'	
			},
			success:function(data){
				var dataJson=eval("("+data+")");
				$.messager.progress({title:'���Ժ�',msg:'��������...'});
				//�˴���������  
				drawPict('div#1',dataJson.listXdata,dataJson.data,'column','��');
				drawPict('div#2',dataJson.listXdata1,dataJson.data1,'line','%');
				drawPict('div#4',dataJson.listXdata2,dataJson.data2,'line','');
				drawPict('div#6',dataJson.listXdata3,dataJson.data3,'line','');
				drawPict('div#8',dataJson.listXdata4,dataJson.data4,'line','');
				drawPict('div#10',dataJson.listXdata5,dataJson.data5,'line','');
				$.messager.progress('close');
			}
		});
}
function TCmFinanceIndexHyFw_dataset_flushDataPost(dataset){
	length=TCmFinanceIndexHyFw_dataset.length;
	$('span#3900008').html('');
	$('span#3900009').html('');
	$('span#3900006').html('');
	$('span#3900007').html('');
	$('span#3900004').html('');
	$('span#3900005').html('');
	$('span#3900001').html('');
	$('span#3900002').html('');
	$('span#3900003').html('');
	for(var i=0;i<length;i++){
		var str=null;
		var num=TCmFinanceIndexHyFw_dataset.record.getValue("indexCd");
		if(num=="3900008"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900009"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900006"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900007"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900004"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900005"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900001"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900002"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}
		if(num=="3900003"){
			$('span#'+num).html('(<span style="color:black;font-size:12px">'+TCmFinanceIndexHyFw_dataset.record.getValue("downValue")+'<span style="color:red">&nbsp-&nbsp</span>'+TCmFinanceIndexHyFw_dataset.record.getValue("upValue")+'</span>)');
		}

		TCmFinanceIndexHyFw_dataset.moveNext();
	}
}

function drawPict(id,listXdata,data,linetype,unit){
	$(id).highcharts({  
		chart:{  
           	type: 'line',//ͼ������ʾ���ͣ�line,spline,scatter,splinearea bar,pie,area,column��  
			height:'350',
			width:'400'
		},  
       	title:{  
           	text: ''//������  
       	},  
   		xAxis: {   //������  
       		categories: listXdata//��̬����
       	
       	},  
   		yAxis: {
   			title:{text: 'ָ��ֵ'}	     
        },  
        series:data
      });	
}
function repno_DropDown_beforeOpen(dropDown){
	var caliber = financialIndexAnalsis_dataset.getValue('caliber');//���ݵ�һ��selectId��õ�һ��selectֵ
	if(!caliber) return "��ѡ��ھ�!";//�жϵ�һ��select��ֵ�Ƿ�Ϊ�գ����Ϊ��ֱ�ӷ���һ���ַ���
	repnoSelect_DropDownDataset.setParameter("dataTypeNo",caliber);
	repno_DropDown.cached=false;//��qGroupId�����뻺��
}
function caliber_DropDown_onSelect(dropDown,record,editor){
	var oldVal = financialIndexAnalsis_dataset.getValue("caliber");//��һ�ε�ֵ
    
    var newVal = record ? record.getValue('data') : '';//���ڵ�ֵ
	if(oldVal!=newVal){
	//�ж����ε�ֵ�Ƿ���ȣ��������Ȱ�ֵ����
		financialIndexAnalsis_dataset.setValue('repno','');
		financialIndexAnalsis_dataset.setValue('repnoName','');
	}
	return true;
}
function initCallGetter_post(){
	var dat=new Date();
	record=TCmFinanceIndexHyFw_dataset.record;
	$.messager.progress({title:'���Ժ�',msg:'��������...'});
	$.ajax({								
		url :"${contextPath}/char/financialIndexAnalsisHigtCharServlet",
		type : "post",
		data:{
				caliber:'707',
				jzyear:dat.getFullYear()-1,
				customerNum:customerNum,
				repno:'1',
				type:'index'	
			},
		success:function(data){
			var dataJson=eval("("+data+")");
			//�˴���������  
			drawPict('div#1',dataJson.listXdata,dataJson.data,'column','��');
			drawPict('div#2',dataJson.listXdata1,dataJson.data1,'line','%');
			drawPict('div#4',dataJson.listXdata2,dataJson.data2,'line','');
			drawPict('div#6',dataJson.listXdata3,dataJson.data3,'line','');
			drawPict('div#8',dataJson.listXdata4,dataJson.data4,'line','');
			drawPict('div#10',dataJson.listXdata5,dataJson.data5,'line','');
			$.messager.progress('close');
		}
	});
}
$(document).ready(function(){
	var str=null;
	getDom();
})
</script>
<script src="${contextPath}/templets/ui/js/chart1/jquery-1.8.3.min.js.js"></script>
<script src="${contextPath}/templets/ui/js/chart1/highcharts.js"></script>

</@CommonQueryMacro.page>