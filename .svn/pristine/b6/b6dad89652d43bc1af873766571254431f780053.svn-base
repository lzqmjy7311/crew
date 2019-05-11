<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign pageReadOnly=RequestParameters["pageReadOnly"]?default('0')>

<@CommonQueryMacro.page title="用途监控报告">
	<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box1" label="贷款基本信息">
						<@CommonQueryMacro.Group id="group1" label="" colNm=4
						fieldStr="lendCode,custCode,custName,custTrade,custPhone,custAddress,productCode,guarType,loanAmt,loanBalance,checkWay,checkAddress,assistSurvPer,mainSurvPer,surveyDate"/>
					</@CommonQueryMacro.GroupBox>
					
					<@CommonQueryMacro.GroupBox id="box2" label="用途监控结论">
						<@CommonQueryMacro.Group id="group2" label="" colNm=4
						fieldStr="operResult,buesResult,guarResult,earnResult,hasCert,loanResult"/>
						<center>
						<a id="fupload" href="javascript:void()">附件上传/下载</a>
						</center>
					</@CommonQueryMacro.GroupBox>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="Yt_PlWarnSignal" init="false" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box3" label="预警信息">
						<@CommonQueryMacro.DataTable id="warnSignalTable" readonly="true"  paginationbar="warnSignalUpd" 
						fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="预警情况"  position="center"
							resize="true" minimize="false"  maximize="true" closure="true" show="false" defaultZoom="normal">
								<table style="width: 100%"><tr><td>
								<@CommonQueryMacro.Group id="group2" label="" colNm=2
								fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc"/>
								</td></tr>
								</table>
					    </@CommonQueryMacro.FloatWindow>	
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="false" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box5" label="控制措施">
							<@CommonQueryMacro.Group id="group5" labelwidth="400" label="" colNm=2
							fieldStr="lmtCtrl,riskCtrl,otherCtrlDesc,appendCtrl,frequency,applyOpin"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box6"  label="审核意见">
							<@CommonQueryMacro.Group labelwidth="400"  id="group6" label="" colNm=2
							fieldStr="opinion"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box7" label="措施完成时间">
							<@CommonQueryMacro.Group id="group7" labelwidth="400" label="" colNm=2
							fieldStr="measCompleteDate"/>
					</@CommonQueryMacro.GroupBox>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="top" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="false" submitMode="current">
					<center>
						<@CommonQueryMacro.Button id= "btnSave"/>
						<@CommonQueryMacro.Button id= "btnSelect"/>
						<@CommonQueryMacro.Button id= "btnSubmit"/>
						<@CommonQueryMacro.Button id= "btnBack"/>
						<@CommonQueryMacro.Button id= "btnPrint"/>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
<script>
	var readOnly="0";//默认可文件 上传
	function openUploadWin(){
		openSubWin("uploadFile", "附件管理", 
			"/gbicc-pages/upload/commonupload.ftl?relaID=${businessId}&relaType=YT&readOnly="+readOnly,
		null,400);
	}
	$("#fupload").linkbutton({"iconCls":"icon-upload"}).click(openUploadWin);
	
	$("a[id=btnSubmit]").hide();
	
	//页面初始化-发送post请求之前
	var opinion=true;
	var kf=true;
	var fldlabel_measCompleteDate=false;
	function initCallGetter_post(){
		var businessId='${businessId}';
		var rptStatus='${rptStatus}';
		YtMonitorReportWin_dataset.setParameter("businessId",businessId);
		Yt_PlWarnSignal_dataset.setParameter("businessId",null);
		Yt_PlWarnSignal_dataset.setParameter("loanAccount",YtMonitorReportWin_dataset.getValue("loanNo"));
		Yt_PlWarnSignal_dataset.flushData(Yt_PlWarnSignal_dataset.pageIndex);
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		
		$("#fldlabel_opinion").html($("#fldlabel_opinion").text()+"<span style='color:red;'>*</span>");
		$("#fldlabel_measCompleteDate").html($("#fldlabel_measCompleteDate").text()+"<span style='color:red;'>*</span>");
		
		TaskVariable.taskIsCompile(businessId,function(y){if(y){readOnly="1";}});
		if(YtMonitorReportWin_dataset.getValue('checkWay')=="2"){
			YtMonitorReportWin_dataset.setFieldRequired("checkAddress",false);
		}else{
			YtMonitorReportWin_dataset.setFieldRequired("checkAddress",true);
		}
		//查找流程图每一节点变量，初始化页面
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
				//设置页面只读
        		setPageReadOnlyFun();
        		$("#warnSignalUpd").hide();
        		$("fieldset[name=box7]").hide();
			}else{
				//如果贷款担保类型为‘信用’则担保是否落实可编辑 。反之隐藏或禁用.
				var guarType=YtMonitorReportWin_dataset.getValue('guarType');
				if(guarType=="1"){
					YtMonitorReportWin_dataset.setFieldReadOnly("guarResult",true);
				}else{
					YtMonitorReportWin_dataset.setFieldReadOnly("guarResult",false);
				}
				//客户经理可编辑
				TaskVariable.getSystemCurrentDate(null,function(y){
					YtMonitorReportWin_dataset.setValue("surveyDate",y);
				});
			}
			
        	if(y.backBtn!=null && y.backBtn=="hide"){
        		//隐藏退回按钮
        		$("a[id=btnBack]").hide();
        		//隐藏审核意见
        		//$("fieldset[name=box6]").hide();
        	}else{
        		var editFields=["opinion"];
        		setPageCanWriteFun(editFields);
        	}
        	if(y.ctrlMeas!=null && y.ctrlMeas=="hide"){
        		//隐藏控制措施
        		$("fieldset[name=box5]").hide();
        	}
        	if(y.ctrlMeasReadOnly!=null && y.ctrlMeasReadOnly=="false"){
        		//部分字段可写
        		kf=false;
        		var editFields=["lmtCtrl","frequency","riskCtrl","otherCtrlDesc","appendCtrl","applyOpin","opinion"];
        		setPageCanWriteFun(editFields);
        		YtMonitorReportWin_dataset.setFieldHidden("frequency",true);//默认隐藏监控频率
        		YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",true);
        	}
        	if(y.measDate==null || y.measDate=="hide"){
        		//显示措施完成时间
        		$("fieldset[name=box7]").hide();
        	}else{
        		var editFields=["measCompleteDate"];
        		//YtMonitorReportWin_dataset.setFieldRequired("measCompleteDate",true);
        		setPageCanWriteFun(editFields);
        		opinion=false;
        		$("fieldset[name=box6]").hide();
        		$("fieldset[name=box7]").show();
        		fldlabel_measCompleteDate=true;
        	}
        	
        	if('${pageReadOnly}'=='1'){
				setPageReadOnlyFun();
        		readOnly="1";
        		$("#warnSignalUpd").hide();
        		$("a[id=btnSave]").hide();
        		$("a[id=btnSubmit]").hide();
        		$("a[id=btnSelect]").hide();
        		$("a[id=btnBack]").hide();
        		//$("a[id=btnPrint]").hide();
        		$("fieldset[name=box6]").hide();
        		$("fieldset[name=box7]").show();
			}
			
			var frequency=YtMonitorReportWin_dataset.getValue("frequency");
        	if(frequency){
        		YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
        	}
        	var riskCtrl=YtMonitorReportWin_dataset.getValue("riskCtrl");
        	if(riskCtrl && riskCtrl!="" && riskCtrl.indexOf("SS")>-1){
				YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",false);
			}
       	});
		
       	MonitorReportCtrl.dwrFindCtrl(businessId,function(y){
			if(y && y.length>0){
				var apdCtrl="";
				for(var i=0;i<y.length;i++){
					var obj=eval("("+y[i]+")");
					if(obj.ctrlType=="1"){
						YtMonitorReportWin_dataset.setValue("lmtCtrl",obj.conmeasCode);
					}else if(obj.ctrlType=="2"){
						YtMonitorReportWin_dataset.setValue("riskCtrl",obj.conmeasCode);
						YtMonitorReportWin_dataset.setValue("otherCtrlDesc",obj.otherCtrlDesc);
					}else if(obj.ctrlType=="3"){
						apdCtrl=apdCtrl+obj.conmeasCode+",";
					}
				}
				if(apdCtrl!=""){
					apdCtrl=apdCtrl.substring(0,apdCtrl.length-1);
				}
				YtMonitorReportWin_dataset.setValue("appendCtrl",apdCtrl);
			}
		});
		MonitorReportCtrl.dwrFindFrequency(businessId,function(y){					
			if(y){						
				YtMonitorReportWin_dataset.setValue("frequency",y[0]);
				YtMonitorReportWin_dataset.setValue("frequencyName",y[1]);
				YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
			}else{
				YtMonitorReportWin_dataset.setFieldHidden("frequency",true);
			}
		});				
	}
	
	function riskCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("SS")>-1){
			YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",false);
		}else{
			YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",true);
			YtMonitorReportWin_dataset.setValue("otherCtrlDesc",null);
		}
	}
	
	function YtMonitorReportWin_dataset_onSetValue(ds,curretField,val){
		if(curretField.name=='appendctrl'){
			appendCtrl_selectedFun(val);
		}else if(curretField.name=='riskctrl'){
			riskCtrl_selectedFun(val);
		}
		return val;
	}
	
	function appendCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("1")>-1){
			YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
			YtMonitorReportWin_dataset.setValue("frequency","0.5");
			YtMonitorReportWin_dataset.setValue("frequencyName","0.5月");
		}else{
			YtMonitorReportWin_dataset.setFieldHidden("frequency",true);
			YtMonitorReportWin_dataset.setValue("frequency",null);
			YtMonitorReportWin_dataset.setValue("frequencyName",null);
		}
	}
	
	function frequency_DropDown_beforeOpen(dropDown){
		var businessId='${businessId}';
		subAutoDataDic_DropDownDataset.setParameter("businessId",businessId);
		subAutoDataDic_DropDownDataset.setParameter("dicCode",703);
		frequency_DropDown.cached=false;//让qGroupId不存入缓存
	}
	function YtMonitorReportWin_dataset_afterChange(dataset,field){
		if(field.fieldName=='checkWay'){			
			if(YtMonitorReportWin_dataset.getValue('checkWay')=="2"){
				YtMonitorReportWin_dataset.setFieldRequired("checkAddress",false);
			}else{
				YtMonitorReportWin_dataset.setFieldRequired("checkAddress",true);
			}
		}
	}
	//保存按钮提交检查事件
	function btnSave_onClickCheck(button){
		YtMonitorReportWin_dataset.setParameter("op","save");
	}
	//提交按钮提交检查事件-选择流程提交人
	function btnSelect_onClickCheck(button){
		if(opinion && YtMonitorReportWin_dataset.getValue("opinion")==""){
			alert('审核意见不能为空!');
			return false;
		}
		if(fldlabel_measCompleteDate && 
			YtMonitorReportWin_dataset.getValue("measCompleteDate")==""){//需要填写控制措施完成时间 
			alert('控制措施完成时间不能为空!');
			return false;
		}
		var orgId=user_info.orgId;
		var roleId="";
		var businessId='${businessId}';
		/////没有选择控制措施就不需要选 人-直接提交///
		if(!kf && YtMonitorReportWin_dataset.getValue("lmtCtrl")=="" &&
			YtMonitorReportWin_dataset.getValue("riskCtrl")=="" &&
			YtMonitorReportWin_dataset.getValue("appendCtrl")==""){
			btnSubmit.click();
			return false;
		}
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y && y.nextRole){//获取到角色ID打开窗口。
				submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+y.nextRole,"600","400");
			}else{//获取不到，直接提交
				btnSubmit.click();
			}
		});
	}
	function cancelFun(){
		YtMonitorReportWin_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		YtMonitorReportWin_dataset.setParameter("taskAssignee",taskAssignee);
		btnSubmit.click();
	}
	
	//实际提交人
	function btnSubmit_onClickCheck(button){
		var op="submit";
		YtMonitorReportWin_dataset.setParameter("op",op);
	}
	
	//退回按钮提交检查事件
	function btnBack_onClickCheck(button){
		var op="back";
		YtMonitorReportWin_dataset.setParameter("op",op);
		if(YtMonitorReportWin_dataset.getValue("opinion")==""){
			alert('审核意见不能为空!');
			return false;
		}
	}
	
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		var fieldName="";
		for(var i=0;i<YtMonitorReportWin_dataset.fields.length;i++){
			fieldName=YtMonitorReportWin_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				YtMonitorReportWin_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	//设置页面字段可写
	function setPageCanWriteFun(editFields){
		for(var i=0;i<editFields.length;i++){
			YtMonitorReportWin_dataset.setFieldReadOnly(editFields[i],false);
		}
	}

	function warnSignalUpd_onClick(button){
		if(Yt_PlWarnSignal_dataset.record){
			subwindow_warnSignalFW.show();
		}else{
			alert('没有数据可以显示！');
		}
	}
	function warnSignalConfirm_onClick(button){
		subwindow_warnSignalFW.close();
	}
	
	//保存后关闭页面，刷新表格
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		//if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		//window.parent.ajMonitorReportWin_close();
	}
	//保存后关闭页面，刷新表格
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		window.parent.ajMonitorReportWin_close();
	}
	//退回后关闭页面，刷新表格
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		window.parent.ajMonitorReportWin_close();
	}
	//查看意见
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
	//打印
	function btnPrint_onClick(){
		var reportId=YtMonitorReportWin_dataset.getValue("id");
		var businessId='${businessId}';
		window.open("${contextPath}/common/donloadWord?reportType=YTR&reportId="+reportId+"&businessId="+businessId);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/MonitorReportCtrl.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>