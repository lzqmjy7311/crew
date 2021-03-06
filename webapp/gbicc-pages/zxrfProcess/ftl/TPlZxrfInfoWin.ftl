<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign pageReadOnly=RequestParameters["pageReadOnly"]?default('0')>
<@CommonQueryMacro.page title="中小融辅  &gt;  我的任务">
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/ZxrfInfoAjax.js'> </script>
	<table style="width: 100%">
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TPlZxrfInfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box1" label="账号信息">
						<@CommonQueryMacro.Group id="group1" label=""  printabled="true" colNm=4 fieldStr="loanAccount,custcode,custname,industry,productName,loanAmount,loanBalance,grantDate,overDate,visitway,visitadd,leadInvestigator,assInvestigator,surveydate"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box2" label="基本问题">
						<@CommonQueryMacro.Group id="group2" label="" colNm=4 fieldStr="surveyType,surveyTypeinfo,surveyAdd,surveyAddinfo,havePer,havePerSname,contactDiff,loanperMeet,loanperCooperate,loanperEnforce,loanperEnforceinfo"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box3" label="贷款个人信息">
						<@CommonQueryMacro.Group id="group3" label="" colNm=4 fieldStr="perWorkstatus,perWorkinfo,perPostchange,perPostinfo,perNewjob,perNewjobcount,perNewjobSname,perHavework,perNoworklength,perOverwages,perOverlength,perComover,perOthfamloan,perFamloancou,perFamamount,perFamhasamount,perChangeadd,perChangeaddinfo,perHaveguarantor,perGuarantorcount,perGuarantoramt,perHralthstatus,perHralthinfo,perFamily,perLiveinfo,perSpouseinvite,perSpouseinfo,perIllegal,perIllegalamt"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box11" label="贷款个人信息">
						<@CommonQueryMacro.Group id="group11" label="" colNm=4 fieldStr="perWorkstatus,perWorkinfo,perOthfamloan,perFamhasbank,perFamamount,perChangeadd,perChangeaddcount,perChangeaddinfo,perHaveguarantor,perGuarantorcount,perGuarantoramt,perHralthstatus,perHralthinfo"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box12" label="经营状况信息">
						<@CommonQueryMacro.Group id="group12" label="" colNm=4 fieldStr="opsChangeper,opsChangecount,opsAddboss,opsAddstockcount,opsAddstockinfo,opsLatelyifo,opsAddstaff,opsAddstaffcount,opsStaffcount,opsStafflesscount,opsGuacontactinfo,opsMarkinfo,opsAddsupp,opsAddsuppcount,opsAdddeal,opsAdddealcount,opsOpsamount,opsComstop"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box13" label="财务状况信息">
						<@CommonQueryMacro.Group id="group13" label="" colNm=4 fieldStr="perSpouseinvite,perSpouseinfo,finNeedmoney,finNeedmoneyinfo,finNeedmoneycount,finChangebank,finChangebankinfo,perIllegal,perIllegalinfo,finOthloan,finOthloancount,finOthbankloan,finOthbankloaninfo,finStock,finStockamt,finMobthreport,finChargeamt,finChargeacomname,finChargeapername,finChargeapertel"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box4" label="其他说明">
						<@CommonQueryMacro.Group id="group4" label="" colNm=4 fieldStr="othinfo,dddd,dddd"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box5" label="保证人信息">
						<@CommonQueryMacro.Group id="group6" label="" colNm=4 fieldStr="guaRepdate,guaContactch,dddd,dddd"/>
						<@CommonQueryMacro.Group id="group7" label="保证人最新联系方式(一)" colNm=4 fieldStr="gua1Comname,gua1Tel,gua1Address,dddd,dddd"/>
						<@CommonQueryMacro.Group id="group8" label="保证人最新联系方式(二)" colNm=4 fieldStr="gua2Comname,gua2Tel,gua2Address,dddd,dddd"/>
						<@CommonQueryMacro.Group id="group9" label="保证人最新人民银行征信资料" colNm=4 fieldStr="guaName,guaIdcard,guaTel,guaAddress,guaBadaccount,guaOvercount,guaAddfinace,guaAddloanbank,dddd,dddd"/>
					</@CommonQueryMacro.GroupBox>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TWarnSignal" init="false" submitMode="all">	
					<@CommonQueryMacro.GroupBox id="box22" label="预警信息">
						<@CommonQueryMacro.DataTable id="warnSignalTable" paginationbar="warnSignalUpd" pagination="true" 
			             fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="预警情况"  position="center" resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%">
								<tr><td>
									<@CommonQueryMacro.Group id="group2" label="" colNm=4 fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc,dddd,dddd"/>
								</td></tr>
								<tr><td>
							<center>
							<@CommonQueryMacro.Button id="warnSignalConfirm" />
							</center>
								</td></tr>
							</table>
					    </@CommonQueryMacro.FloatWindow>	
									
		           </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TPlZxrfInfo" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box4" label="流程退回/提交">
					<@CommonQueryMacro.Group id="group4" label="" colNm=4 fieldStr="opinion,dddd,dddd"/>
					</@CommonQueryMacro.GroupBox>
					<center>
					<@CommonQueryMacro.Button id= "btnSubmit" />
					<@CommonQueryMacro.Button id= "btnSubmitTrue" />
					<@CommonQueryMacro.Button id= "btnSave" />
					<@CommonQueryMacro.Button id= "calculteInfo" />
					<@CommonQueryMacro.Button id= "btnBack" />
					<@CommonQueryMacro.Button id= "contractBtn" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>

	
	<div style="" hidden="true">
		<form id="uploadForm" action="${contextPath}/this/DonloadWordServlet" method="post" enctype="multipart/form-data" target="aa">
		</form>
	</div>

	
<script language="JavaScript">

//[判断的字段，需要显示的字段值，显示或隐藏]
var fields=[["havePer","0","havePerSname"],
            ["loanperEnforce","1","loanperEnforceinfo"],
            ["perPostchange","1","perPostinfo"],
            ["perNewjob","1","perNewjobcount"],
            ["perNewjob","1","perNewjobSname"],
            ["perHavework","1","perNoworklength"],
            ["perOverwages","1","perOverlength"],
            ["perOthfamloan","1","perFamloancou"],
            ["perOthfamloan","1","perFamamount"],
            ["perOthfamloan","1","perFamhasamount"],
            ["perOthfamloan","1","perFamhasbank"],
            ["perChangeadd","1","perChangeaddcount"],
            ["perChangeadd","1","perChangeaddinfo"],
            ["perHaveguarantor","1","perGuarantorcount"],
            ["perHaveguarantor","1","perGuarantoramt"],
            ["perIllegal","1","perIllegalamt"],
            ["perIllegal","1","perIllegalinfo"],
            ["opsChangeper","1","opsChangecount"],
            ["opsAddboss","1","opsAddstockcount"],
            ["opsAddboss","1","opsAddstockinfo"],
            ["finNeedmoney","1","finNeedmoneyinfo"],
            ["finNeedmoney","1","finNeedmoneycount"],
            ["finChangebank","1","finChangebankinfo"],
            ["finOthloan","1","finOthloancount"],
            ["finOthbankloan","1","finOthbankloaninfo"],
            ["finStock","1","finStockamt"]];

function initCallGetter_post(dataset) {
	var businessId='${businessId}';
	var rptStatus='${rptStatus}';
	calculteInfo.disable(true); 
	//主动加载规则表数据
	TWarnSignal_dataset.setParameter("businessId",businessId);
	TWarnSignal_dataset.setParameter("id","");
	TWarnSignal_dataset.flushData(TWarnSignal_dataset.pageIndex);
	if(rptStatus=="6" || rptStatus=="1"){
		var TWarnSignalDate = TWarnSignal_dataset.getValue("id");
		if(TWarnSignalDate){
			btnSubmit.disable(false); 
		}else{
			btnSubmit.disable(true); 
		}
	}else{
		btnSubmit.disable(false); 
	}
	
	//根据产品类型，显示不同的Box
	var productType=TPlZxrfInfo_dataset.getValue("productType");
	if(productType=='10'){//个人消费类
		$("fieldset[name=box11]").hide();
		$("fieldset[name=box12]").hide();
		$("fieldset[name=box13]").hide();
	}else{
		$("fieldset[name=box3]").hide();
	}
	
	//根据角色，显示或者隐藏按钮
	TaskVariable.findTaskVariable(businessId,function(y){
		 if(y.canEdit=="true"){//客户经理
			 $("a[id=btnBack]").hide();
			
		 }else{
			 $("a[id=btnSave]").hide();
			 $("a[id=calculteInfo]").hide();
			 setPageReadOnlyFun();
		 }
		   
		
	});
	TPlZxrfInfo_dataset.setFieldReadOnly("loanAccount",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("custcode",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("custname",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("industry",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("productCode",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("loanAmount",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("loanBalance",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("grantDate",true);
	TPlZxrfInfo_dataset.setFieldReadOnly("overDate",true);
	
	for(var i=0;i<fields.length;i++){
		var value=TPlZxrfInfo_dataset.getValue(fields[i][0]);
		////console.log(fields[i][0]+"------"+value+"------"+fields[i][1]+"------"+fields[i][2]);
		_TPlZxrfInfo_selectedFun(value,fields[i][1],fields[i][2],"AJTPlZxrfInfoWin");
	}
	if('${pageReadOnly}'=='1'){
		btnSubmit.disable(true); 
		btnSave.disable(true); 
		calculteInfo.disable(true); 
		btnBack.disable(true); 
		contractBtn.disable(true); 
		$("a[id=btnSubmit]").hide();
		$("a[id=btnSave]").hide();
		$("a[id=calculteInfo]").hide();
		$("a[id=btnBack]").hide();
		$("a[id=contractBtn]").hide();
	}
	$("a[id=btnSubmitTrue]").hide();
	
}

function TPlZxrfInfo_dataset_onSetValue(ds,curretField,val){
	for(var i=0;i<fields.length;i++){
		if(curretField.name==fields[i][0].toLowerCase()){
			//console.log(curretField.name);
			_TPlZxrfInfo_selectedFun(val,fields[i][1],fields[i][2],"AJTPlZxrfInfoWin");
		}
	}
	return val;
}
function _TPlZxrfInfo_selectedFun(val,show,fieldName,comQueryName){
	if(null!=val && val!="" && val==show){
		if(comQueryName=="AJTPlZxrfInfoWin"){
			//console.log("显示----"+fieldName);
			TPlZxrfInfo_dataset.setFieldHidden(fieldName,false);
		}
	}else {
		if(comQueryName=="AJTPlZxrfInfoWin"){
			//console.log("隐藏----"+fieldName);
			TPlZxrfInfo_dataset.setFieldHidden(fieldName,true);
			TPlZxrfInfo_dataset.setValue(fieldName,null);
		}
	}
}
//设置页面所有字段只读
function setPageReadOnlyFun(){
	warnSignalUpd.disable(true);
	var fieldName="";
	for(var i=0;i<TPlZxrfInfo_dataset.fields.length;i++){
		fieldName=TPlZxrfInfo_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TPlZxrfInfo_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	TPlZxrfInfo_dataset.setFieldReadOnly("opinion",false);
}
//保存
function btnSave_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("保存成功！");
	calculteInfo.disable(false);
}
function calculteInfo_postSubmit(button) {
	var retObj=button.returnParam;
	if(retObj.success=="false"){
		top.easyMsg.info(retObj.msg);
	}else{
		button.url="#";
		top.easyMsg.info("计算成功！");
		var businessId='${businessId}';
		TWarnSignal_dataset.setParameter("businessId",businessId);
		TWarnSignal_dataset.setParameter("id","");
		TWarnSignal_dataset.flushData(TWarnSignal_dataset.pageIndex);
		btnSubmit.disable(false); 
	}
}

//查看意见
function btnOpinion_onClick(button){
	subwindow_taskApprovalHistoryFW.show();
}
//退回按钮提交检查事件
function btnBack_onClickCheck(button){
	var op="back";	
	var opinion=TPlZxrfInfo_dataset.getValue("opinion");
	TPlZxrfInfo_dataset.setParameter("opinion",opinion);
	TPlZxrfInfo_dataset.setParameter("op",op);
}
/*
function calculteInfo_onClickCheck(button){
	var businessId='${businessId}';
	ZxrfInfoAjax.findReport(businessId,function(y){
			 if(y.success=="true"){//
				 top.easyMsg.info("计算成功！");
				 button.url="#";
				 return true;
			 }else{
				 top.easyMsg.info(y.message);
				 button.url="#";
				 return false;
			 }
			   
			
		});
}

*/
//打印
function contractBtn_onClickCheck(button){
	
	var reportId=TPlZxrfInfo_dataset.getValue("id");
	window.open("${contextPath}/common/donloadWord?reportType=RF&reportId="+reportId);
	/*
	
	$('#uploadForm').ajaxSubmit({
		type:"post", 
		success:function(data){
		}
	});
	*/
}
//提交事件
function btnSubmitTrue_onClickCheck(button){
	var op="submit";
	var opinion=TPlZxrfInfo_dataset.getValue("opinion");
	TPlZxrfInfo_dataset.setParameter("opinion",opinion);
	TPlZxrfInfo_dataset.setParameter("op",op);
}
//保存事件
function btnSave_onClickCheck(button){
	var opinion=TPlZxrfInfo_dataset.getValue("opinion");
	TPlZxrfInfo_dataset.setParameter("opinion",opinion);
}

//提交后关闭页面，刷新表格
function btnSubmitTrue_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("提交成功！");
	
	if(window.parent.ajMonitorReportWin){
		window.parent.TPlZxrfInfo_dataset.flushData(window.parent.TPlZxrfInfo_dataset.pageIndex);
		window.parent.ajMonitorReportWin_close();
	}
	if(parent.parent.GTab){parent.parent.GTab.closeTab();}
	
	
	
}

//提交按钮单击事件
function btnSubmit_onClick(button){
	var orgId=user_info.orgId;
	var roleId="";
	var businessId='${businessId}';
	var params=[businessId,orgId];
	ZxrfInfoAjax.isOpenNextUserWin(params,function(sy){
		if(sy.success=="true"){
			TaskVariable.findTaskVariable(businessId,function(y){
				if(y && y.nextRole){//获取到角色ID打开窗口。
					submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+sy.orgId+"&roleId="+y.nextRole,"600","400");
				}else{//获取不到，直接提交
					btnSubmitTrue.click();
				}
			});
		}else{
			top.easyMsg.info("系统出错，请联系管理员！");
			return false;
		}
	});
}
function submitFun(taskAssignee){
	TPlZxrfInfo_dataset.setParameter("taskAssignee",taskAssignee);
	btnSubmitTrue.click();
}

//提交后关闭页面，刷新表格
function btnBack_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("提交成功！");
	if(window.parent.ajMonitorReportWin){
		window.parent.TPlZxrfInfo_dataset.flushData(window.parent.TPlZxrfInfo_dataset.pageIndex);
		window.parent.ajMonitorReportWin_close();
	}
	if(parent.parent.GTab){parent.parent.GTab.closeTab();}
}

function btCancel_onClickCheck(button){
	window.parent.ajMonitorReportWin_close();
 }  
 
 
function warnSignalUpd_onClick(button){
	var id = TWarnSignal_dataset.getValue("id");
	if(id){
		subwindow_warnSignalFW.show();
	}else{
		top.easyMsg.info("请选择一条记录！");
		return;
	}
}
function warnSignalConfirm_onClick(button){
	subwindow_warnSignalFW.close();
}
 
 
</script>
</@CommonQueryMacro.page>