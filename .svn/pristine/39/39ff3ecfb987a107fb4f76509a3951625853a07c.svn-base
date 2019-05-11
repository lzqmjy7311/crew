<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="财务诊断分析">  
<style>
div.form1{
    width:30px;height:10px;
	text-align:left;
	color:blue;
	background-color:gray;
	font-size:100%;
	}

span.style1{
	color:blue;
	background-color:gray;
	font-size:150%;
}
</style>
   
	<@CommonQueryMacro.CommonQuery id="TFinanceIndexQ" init="false" submitMode="selected" navigate="false">
			<#assign jzyear=''>
			<#assign caliber=''>
			<#assign repno=''>
			<#assign customerNum=RequestParameters["customerNum"]?default("")>
			<#assign chineseName="${RequestParameters['chineseName']?default('')}" />
			
			<table align="left" width="100%">
			    <tr>
					<td>
						<@CommonQueryMacro.Group id="group22" label="" colNm=6  
						fieldStr="jzyear,caliber,repno"/>
						<center>
						<@CommonQueryMacro.Button id="btModOrAdd" />
						<@CommonQueryMacro.Button id="btExpExcel" />
						</center>
					</td>
				</tr>  
			</table>
	</@CommonQueryMacro.CommonQuery>
	<span id='title1'  class="style1"> </span>
	<@CommonQueryMacro.CommonQuery id="TbCsmFinanceIndexData" init="false" submitMode="selected" navigate="false">
				
			<table align="left" width="98.5%">
			
				<tr>
		   <td>
					<@CommonQueryMacro.DataTable id ="datatablefincour"  treeGrid="true"  treeField="name"  fieldStr="name,indexDisp[350],stringType,sStringType,ssStringType,avgStringType,updown[50]" readonly="true"  height="280"  width="100%"/></br>
				</td>
			</tr>
			
			    
			</table>
	</@CommonQueryMacro.CommonQuery>
	






<script language="JavaScript">


	//系统刷新单元格
	function datatablefincour_updown_onRefresh(cell,value,record) {
		if(record) {
			var id = record.getValue("indexDataId");
            var  contextPath='${contextPath}';
			var upDown= record.getValue("updown");
			
			  if(upDown=='S'){
				cell.innerHTML="<center><img src='${contextPath}/templets/ui/themes/icons/up1.png' width='12' height='12'></center>";
			  }else  if(upDown=='J'){
				cell.innerHTML="<center><img src='${contextPath}/templets/ui/themes/icons/down1.png' width='12' height='12'></center>";
			  }else{
			  cell.innerHTML="&nbsp;";
			  }
	  }
	}

function btModOrAdd_onClickCheck(button){
 
 
	 var jzyear =TFinanceIndexQ_dataset.getValue('jzyear');
	 var caliber =TFinanceIndexQ_dataset.getValue('caliber');
	 var caliberName =TFinanceIndexQ_dataset.getValue('caliberName');
	
	 var repno  =TFinanceIndexQ_dataset.getValue('repno');
	 var repnoName  =TFinanceIndexQ_dataset.getValue('repnoName');
	 var customerNum='${customerNum}';
	 

	 
		 //验证判断
		 if(!!!jzyear){
		   easyMsg.info('年度不能为空！');
		   return false;
		 }else if(!!!caliber){
		   easyMsg.info('口径不能为空！');
		   return false;
		 }else if(!!!repno){
		   easyMsg.info('期数不能为空！');
		   return false;
		 }
		 
	 TbCsmFinanceIndexData_dataset.setParameter("jzyear",jzyear);
	 TbCsmFinanceIndexData_dataset.setParameter("caliber",caliber);
	 TbCsmFinanceIndexData_dataset.setParameter("repno",repno);
	 TbCsmFinanceIndexData_dataset.setParameter("customerNum",customerNum);	
	 TbCsmFinanceIndexData_dataset.getParameter("repno",repno);
	 
	 TbCsmFinanceIndexData_dataset.flushData(TbCsmFinanceIndexData_dataset.pageIndex);
//	 var chineseName=TbCsmFinanceIndexData_dataset.getValue("chineseName",chineseName);
//	 var title='>>财务诊断分析-展示结果（'+chineseName+'  '+jzyear+'年 '+repnoName+' ' + caliberName+' ）';
//	 document.getElementById("title1").innerText=title;  //插入到span 
}



function repno_DropDown_beforeOpen(dropDown){

			var caliber = TFinanceIndexQ_dataset.getValue('caliber');//根据第一个selectId获得第一个select值
			if(!caliber) return "请选择口径!";//判断第一个select的值是否为空，如果为空直接返回一个字符串
			repnoSelect_DropDownDataset.setParameter("dataTypeNo",caliber); 
			repno_DropDown.cached=false;//让qGroupId不存入缓存
}
function caliber_DropDown_onSelect(dropDown,record,editor){
			var oldVal = TFinanceIndexQ_dataset.getValue("caliber");//上一次的值
		    
            var newVal = record ? record.getValue('data') : '';//现在的值
			if(oldVal!=newVal){		
			//判断两次的值是否相等，如果不想等把值赋空
				TFinanceIndexQ_dataset.setValue('repno','');
				TFinanceIndexQ_dataset.setValue('repnoName','');
			}
			return true;
}

function btExpExcel_onClick(button){
	var jzyear =TFinanceIndexQ_dataset.getValue('jzyear');
	var caliber =TFinanceIndexQ_dataset.getValue('caliber');
	var caliberName =TFinanceIndexQ_dataset.getValue('caliberName');
	var repno  =TFinanceIndexQ_dataset.getValue('repno');
	var repnoName  =TFinanceIndexQ_dataset.getValue('repnoName');
	var customerNum='${customerNum}';
	//验证判断
	if (jzyear == '') {
		easyMsg.info('年度不能为空！');
		return false;
	} else if (caliber == '') {
		easyMsg.info('口径不能为空！');
		return false;
	} else if (repno == '') {
		easyMsg.info('期数不能为空！');
		return false;
	}
	var proPath="${contextPath}"
	var reqPath=proPath+"/common/downloadFinIndexExcel";
	//绘制前进度条提示
	//$.messager.progress({title:'请稍候',msg:'正在导出...'});
	//
	var params={
			jzyear : jzyear,
			caliber : caliber,
			caliberName : caliberName,
			repno:repno,
			repnoName:repnoName,
			customerNum:customerNum	
	};
//	$.ajax({
//		url : reqPath,
//		data : params,
//		type:'get',
//		success : function(data) {
//			//关闭进度条
//            $.messager.progress('close');
//			console.log(data);
//			debugger;
//		}
//	});
	//
	var form=$("<form>");//定义一个form表单
	form.attr("style","display:none");
	form.attr("method","post");
	form.attr("action",reqPath);
	//
	var input1=$("<input>");
	input1.attr("type","hidden");
	input1.attr("name","jzyear");
	input1.attr("value",jzyear);
	form.append(input1);
	var input2=$("<input>");
	input2.attr("type","hidden");
	input2.attr("name","caliber");
	input2.attr("value",caliber);
	form.append(input2);
	var input3=$("<input>");
	input3.attr("type","hidden");
	input3.attr("name","caliberName");
	input3.attr("value",caliberName);
	form.append(input3);
	var input4=$("<input>");
	input4.attr("type","hidden");
	input4.attr("name","repno");
	input4.attr("value",repno);
	form.append(input4);
	var input5=$("<input>");
	input5.attr("type","hidden");
	input5.attr("name","repnoName");
	input5.attr("value",repnoName);
	form.append(input5);
	var input6=$("<input>");
	input6.attr("type","hidden");
	input6.attr("name","customerNum");
	input6.attr("value",customerNum);
	form.append(input6);
	//
	$("body").append(form);
	if(window.confirm('确定要导出Excel表格吗？')){
		//绘制前进度条提示
		//$.messager.progress({title:'请稍候',msg:'正在导出...'});
		form.submit();
	}else{
		return;
	}
	
	//setTimeout(function(){
		//关闭进度条
		//$.messager.progress('close');
	//},5000);
	form.remove();
}
</script>
</@CommonQueryMacro.page>
