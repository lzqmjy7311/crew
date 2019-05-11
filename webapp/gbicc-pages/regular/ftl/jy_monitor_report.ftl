<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign pageReadOnly=RequestParameters["pageReadOnly"]?default('0')>

<@CommonQueryMacro.page title="个人经营类定期监控报告">
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
<table>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box1" label="贷款基本信息">
					<@CommonQueryMacro.Group id="group1" label="" colNm=4 labelwidth="150" 
					fieldStr="custName,custCode,loanAcct,prodName,loanAmt,loanBalance,arrearAmt,arrearInte,issueDate,completeDate,guarWay,rateFloPct,acctStatus,riskType,mobilecall,contaddr,surveyDate,mainSurvPer,assistSurvPer,checkWay"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box2" label="借款人经营资质">
					<@CommonQueryMacro.Group id="group2" label="" colNm=4 labelwidth="150" 
					fieldStr="estaDate,regiAddr,operAddr,operStartDate,operEndDate,enteProp,induClass,staffQuan,regiCapi,rcvCapi,operScope,enteScale,enteGrade,juirPerDelegate,juirPerIdentCode,realCtrlPer,realCtrlPerIdentCode"/>
					<@CommonQueryMacro.Group id="group21" label="合法经营手续" colNm=4 labelwidth="150" 
						fieldStr="busiLice,zhongZhengMa,orgCode,taxRegiCode,enviFlag,specOperCode"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box3" label="注册资本变化情况">
					<@CommonQueryMacro.Group id="group3" label="" colNm=4 labelwidth="400" 
					fieldStr="regiCapiChange,ifHaveCapiRpt,regiCapiChangeDesc"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="box4" label="股权结构变化情况">
				<@CommonQueryMacro.CommonQuery id="JYStockStruInfo" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="stockStruTable" paginationbar="" pagination="true"
					fieldStr="holdcustname,paperid,inveamt,stockperc" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group5" label="" colNm=4 labelwidth="250" 
					fieldStr="sharStruIfChange,realCtrlPerIfChange,stockStruChangeDesc"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box6" label="借款人基本信息变动情况">
					<@CommonQueryMacro.Group id="group6" label="" colNm=4 labelwidth="250" 
					fieldStr="enteNameIfChange,orgCodeIfChange,busiLiceIfChange,taxRegiCodeIfChange,loanCardIfChange,specOperCodeIfChange,induClassIfChange,enteIdentIfLose,enteInfoChangeDesc"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box7" label="财务分析结论">
					<@CommonQueryMacro.Group id="group7" label="" colNm=4 labelwidth="250" 
					fieldStr="finaRptIfCredible,loanPerFinaCond,enteAmtIfChange,predRepmtSrc,finaAnalEval"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="box8" label="自然人保证人债项及担保信息（如果有自然人保证人，下列信息项必填）">
				<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group8" label="" colNm=4 labelwidth="150" 
						fieldStr="guarantorName,ourbankGuarTotAmt,othbankGuarTotAmt,ourbankLoanBal,othbankLoanBal"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="JYOurbankCreditBusiInfo" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="ourbankCreditBusiTable" pagination="true"
					fieldStr="contno,assukind,tcapi,bal,issueDate,matureDate,riskflag" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="JYOurbankGuarInfo" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="ourbankGuarTable" pagination="true"
					fieldStr="custname,contno,assukind,tcapi,bal,begindate,enddate,riskflag" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box9" label="自然人保证人信息变动情况（如果有自然人保证人，下列信息项必填）">
					<@CommonQueryMacro.Group id="group9" label="" colNm=4 labelwidth="350" 
					fieldStr="relaPer,othRelaPer,guarantorWorkChange,newCompName,guarantorPhoneChange,guarantorNewPhone,guarantorAddrChange,guarantorNewAddr,guarantorIncomeChange,guarantorPosiChange,guarantorNewPosi,guarantorOperChange,guarantorInfoChangeDesc"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box10" label="自然人保证人担保能力分析（如果有抵押物，下列信息项必填）">
					<@CommonQueryMacro.Group id="group10" label="" colNm=4 labelwidth="170" 
					fieldStr="guarantorWishChange,guarantorGuarStre,guarantorWishChangeDesc,guarantorGuarStreDesc"/>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="box11" label="借款人抵押物（如果有抵押物，下列信息项必填）">
				<@CommonQueryMacro.CommonQuery id="JYLoanPerMortgageInfo" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="loanPerMortgageTable" pagination="true"
					fieldStr="assuname,impatype,oldowner,orgivalue,evalvalue,confvalue,validdate,impanum,assurate2,addr" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group11" label="" colNm=4 labelwidth="250" 
					fieldStr="mortCond,mortIfDevalue,mortAsseInsuIfExpire,mortIssueAndDesc"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="box12" label="借款人质押物">
				<@CommonQueryMacro.CommonQuery id="JYLoanPerCollatInfo" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="loanPerCollatTable" pagination="true"
					fieldStr="assuname,impatype,oldowner,orgivalue,evalvalue,confvalue,validdate,impanum,assurate2" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group12" label="" colNm=4 labelwidth="350" 
					fieldStr="collatCond,collatCondDesc,collatIfDevalue,collatImelIfExpire,collatIfLoseLawPote,collatIssueAndDesc"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
				<@CommonQueryMacro.CommonQuery id="MonitorReportWarnInfo" init="false" submitMode="current">
					<@CommonQueryMacro.FloatWindow id="MonitorReportWarnInfoFW" modal="true" label="查看预警信息" position="center" 
						closure="true" show="false" defaultZoom="normal" width="800" height="300">
						<@CommonQueryMacro.DataTable id="MonitorReportWarnInfoFWTable" pagination="true" pageCache="false" pagination="false"
						fieldStr="ruleCode[100],ruleName[250],ruleDesc[250],ruleRank[100],trigDate[100]" width="100%" hasFrame="true"/>
					</@CommonQueryMacro.FloatWindow>
				</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<!-- 
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="box14" label="重大事件说明">
				<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" init="false" submitMode="current">
					<@CommonQueryMacro.Group id="group14" label="" colNm=2
					fieldStr="loanPerIfInvoLawsuit,loanPerIfInvoLawsuitDesc"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	 -->
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<@CommonQueryMacro.GroupBox id="box15" label="控制措施">
						<@CommonQueryMacro.Group id="group15" label="" colNm=2
						fieldStr="lmtCtrl,riskCtrl,otherCtrlDesc,appendCtrl,frequency,applyOpin"/>
				</@CommonQueryMacro.GroupBox>
				<@CommonQueryMacro.GroupBox id="box16" label="意见">
						<@CommonQueryMacro.Group id="group6" labelwidth="250" label="" colNm=2
						fieldStr="opinion"/>
				</@CommonQueryMacro.GroupBox>
				<@CommonQueryMacro.GroupBox id="box17" label="措施完成时间">
						<@CommonQueryMacro.Group id="group7" label="" colNm=2
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
					<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
						closure="true" show="false" defaultZoom="normal">
						<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
					</@CommonQueryMacro.FloatWindow>
				</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="JYMonitorReportWin" mode="1" init="true" submitMode="current">
				<center>
					<@CommonQueryMacro.Button id= "btnSave"/>
					<@CommonQueryMacro.Button id= "btnSubmit"/>
					<@CommonQueryMacro.Button id= "btnSubmitTrue"/>
					<@CommonQueryMacro.Button id= "btnBack"/>
					<@CommonQueryMacro.Button id= "btnPrint"/>
				</center>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script>
	var submitWindow=null;
	var measCompleteDateHide=false;
	function btnPrint_onClick(){
		var reportId='${businessId}';
		window.open("${contextPath}/common/donloadWord?reportType=JY&reportId="+reportId+"&businessId="+reportId);
	}
	//预警等级
	var redWarnLevel="3";
	var orangeWarnLevel="2";
	var yellowWarnLevel="1";
	
	var fields=[["relaPer","5","othRelaPer"],["guarantorWorkChange","2","newCompName"],
	            ["guarantorPhoneChange","2","guarantorNewPhone"],["guarantorAddrChange","2","guarantorNewAddr"],
	            ["guarantorPosiChange","2","guarantorNewPosi"],["guarantorWishChange","2","guarantorWishChangeDesc"],
				["guarantorGuarStre","2","guarantorGuarStreDesc"],["collatCond","2","collatCondDesc"]];
	//页面初始化
	function initCallGetter_post(){
		$("a[id=btnSubmitTrue]").hide();
		var riskCtrl=JYMonitorReportWin_dataset.getValue("riskCtrl");
		riskCtrl_selectedFun(riskCtrl);
		//隐藏或显示字段
		for(var i=0;i<fields.length;i++){
			var value=JYMonitorReportWin_dataset.getValue(fields[i][0]);
			_jyMonitorReport_selectedFun(value,fields[i][1],fields[i][2]);
		}
		
		var businessId='${businessId}';
		var rptStatus='${rptStatus}';
		JYMonitorReportWin_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		JYStockStruInfo_dataset.setParameter("businessId",businessId);
		JYStockStruInfo_dataset.flushData(JYStockStruInfo_dataset.pageIndex);
		JYOurbankCreditBusiInfo_dataset.setParameter("businessId",businessId);
		JYOurbankCreditBusiInfo_dataset.flushData(JYOurbankCreditBusiInfo_dataset.pageIndex);
		JYOurbankGuarInfo_dataset.setParameter("businessId",businessId);
		JYOurbankGuarInfo_dataset.flushData(JYOurbankGuarInfo_dataset.pageIndex);
		JYLoanPerMortgageInfo_dataset.setParameter("businessId",businessId);
		JYLoanPerMortgageInfo_dataset.setParameter("assusort","D");
		JYLoanPerMortgageInfo_dataset.flushData(JYLoanPerMortgageInfo_dataset.pageIndex);
		JYLoanPerCollatInfo_dataset.setParameter("businessId",businessId);
		JYLoanPerCollatInfo_dataset.setParameter("assusort","Z");
		JYLoanPerCollatInfo_dataset.flushData(JYLoanPerCollatInfo_dataset.pageIndex);
		//查找流程图每一节点变量，初始化页面
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
				//设置页面只读
        		setPageReadOnlyFun();
			}
        	if(y.backBtn!=null && y.backBtn=="hide"){
        		//隐藏退回按钮
        		$("a[id=btnBack]").hide();
        		//隐藏审核意见
        		//$("fieldset[name=box16]").hide();
        	}else{
        		//var editFields=["opinion"];
        		//setPageCanWriteFun(editFields);
        	}
        	if(y.ctrlMeas!=null && y.ctrlMeas=="hide"){
        		//隐藏控制措施
        		$("fieldset[name=box15]").hide();
        	}
        	if(y.ctrlMeasReadOnly!=null && y.ctrlMeasReadOnly=="false"){
        		//部分字段可写
        		var editFields=["riskCtrl","otherCtrlDesc","appendCtrl","applyOpin","lmtCtrl","frequency"];
        		setPageCanWriteFun(editFields);
        	}
        	if(y.measDate==null || y.measDate=="hide"){
        		//显示措施完成时间
        		$("fieldset[name=box17]").hide();
        		measCompleteDateHide=true;
        	}else{
        		var editFields=["measCompleteDate"];
        		setPageCanWriteFun(editFields);
        		measCompleteDateHide=false;
        	}
        	var editFields=["opinion"];
    		setPageCanWriteFun(editFields);
       	});
		MonitorReportCtrl.dwrFindCtrl(businessId,function(y){
			if(y && y.length>0){
				var apdCtrl="";
				var lmtCtrl="";
				var othCtrl="";
				for(var i=0;i<y.length;i++){
					var obj=eval("("+y[i]+")");
					if(obj.ctrlType=="1"){
						lmtCtrl=lmtCtrl+obj.conmeasCode+",";
					}else if(obj.ctrlType=="2"){
						othCtrl=othCtrl+obj.conmeasCode+",";
						JYMonitorReportWin_dataset.setValue("otherCtrlDesc",obj.otherCtrlDesc);
					}else if(obj.ctrlType=="3"){
						apdCtrl=apdCtrl+obj.conmeasCode+",";
					}
				}
				if(apdCtrl!=""){
					apdCtrl=apdCtrl.substring(0,apdCtrl.length-1);
				}
				if(lmtCtrl!=""){
					lmtCtrl=lmtCtrl.substring(0,lmtCtrl.length-1);
				}
				if(othCtrl!=""){
					othCtrl=othCtrl.substring(0,othCtrl.length-1);
				}
				JYMonitorReportWin_dataset.setValue("appendCtrl",apdCtrl);
				JYMonitorReportWin_dataset.setValue("lmtCtrl",lmtCtrl);
				JYMonitorReportWin_dataset.setValue("riskCtrl",othCtrl);
			}
		});
		var surveyDate=JYMonitorReportWin_dataset.getValue("surveyDate");
		var mainSurvPer=JYMonitorReportWin_dataset.getValue("mainSurvPer");
		if(surveyDate==null || surveyDate==""){
			TaskVariable.getSystemCurrentDate(null,function(y){
				JYMonitorReportWin_dataset.setValue("surveyDate",y);
			});
		}
		if(mainSurvPer==null || mainSurvPer==""){
			JYMonitorReportWin_dataset.setValue("mainSurvPer",user_info.userId);
		}
		
		var accountId=JYMonitorReportWin_dataset.getValue("loanAcct");
		MonitorReportCtrl.dwrGetReportWarnInfo(accountId,function(y){
			if(y && y.length>0){
				for(var i=0;i<y.length;i++){
					if(y[i].WARN_LEVEL==redWarnLevel){
						$("#redWarnCount").text(y[i].COUNT_);
					}else if(y[i].WARN_LEVEL==orangeWarnLevel){
						$("#orangeWarnCount").text(y[i].COUNT_);
					}else if(y[i].WARN_LEVEL==yellowWarnLevel){
						$("#yellowWarnCount").text(y[i].COUNT_);
					}
				}
			}
		});
		MonitorReportCtrl.dwrFindFrequency(businessId,function(y){
			if(y && y[0]!=""){
				JYMonitorReportWin_dataset.setValue("frequency",y[0]);
				JYMonitorReportWin_dataset.setValue("frequencyName",y[1]);
				JYMonitorReportWin_dataset.setFieldHidden("frequency",false);
			}else{
				JYMonitorReportWin_dataset.setFieldHidden("frequency",true);
			}
		});
		$("#fldlabel_opinion").html($("#fldlabel_opinion").text()+"<span style='color:red;'>*</span>");
		$("#fldlabel_measCompleteDate").html($("#fldlabel_measCompleteDate").text()+"<span style='color:red;'>*</span>");
		var pageReadOnly='${pageReadOnly}';
		if(pageReadOnly=="1"){
			JYMonitorReportWin_dataset.setReadOnly(true);
			$("a[id=btnSave]").hide();
			$("a[id=btnSubmit]").hide();
			$("a[id=btnBack]").hide();
		}
	}
	//值改变后根据需求显示或隐藏字段
	function JYMonitorReportWin_dataset_onSetValue(ds,curretField,val){
		for(var i=0;i<fields.length;i++){
			if(curretField.name=='appendctrl'){
				appendCtrl_selectedFun(val);
			}else if(curretField.name==fields[i][0].toLowerCase()){
				_jyMonitorReport_selectedFun(val,fields[i][1],fields[i][2]);
			}else if(curretField.name=='riskctrl'){
				riskCtrl_selectedFun(val);
			}
		}
		return val;
	}
	function frequency_DropDown_beforeOpen(dropDown){
		var businessId='${businessId}';
		subAutoDataDic_DropDownDataset.setParameter("businessId",businessId);
		subAutoDataDic_DropDownDataset.setParameter("dicCode",703);
		frequency_DropDown.cached=false;//让qGroupId不存入缓存
	}
	//单选按钮与下拉框点击事件------start
	function riskCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("SS")>-1){
			JYMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",false);
		}else{
			JYMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",true);
			JYMonitorReportWin_dataset.setValue("otherCtrlDesc",null);
		}
	}
	function appendCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("1")>-1){
			JYMonitorReportWin_dataset.setFieldHidden("frequency",false);
		}else{
			JYMonitorReportWin_dataset.setFieldHidden("frequency",true);
			JYMonitorReportWin_dataset.setValue("frequency",null);
			JYMonitorReportWin_dataset.setValue("frequencyName",null);
		}
	}
	function _jyMonitorReport_selectedFun(val,show,fieldName){
		if(null!=val && val!="" && val==show){
			JYMonitorReportWin_dataset.setFieldHidden(fieldName,false);
		}else {
			JYMonitorReportWin_dataset.setFieldHidden(fieldName,true);
			JYMonitorReportWin_dataset.setValue(fieldName,null);
		}
	}
	//单选按钮与下拉框点击事件------end
	
	//取消
	function cancelFun(){
		JYMonitorReportWin_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		JYMonitorReportWin_dataset.setParameter("taskAssignee",taskAssignee);
		btnSubmitTrue.click();
	}
	function btnSubmitTrue_onClickCheck(button){
		var op="submit";
		JYMonitorReportWin_dataset.setParameter("op",op);
	}
	function btnSubmitTrue_postSubmit(button) {
		if(submitWindow){
			submitWindow.close();
		}
		top.easyMsg.info("保存成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
		if(window && window.parent){
			window.parent.ajMonitorReportWin_close();
		}
	}
	//提交按钮单击事件
	function btnSubmit_onClick(button){
		var appendCtrl=JYMonitorReportWin_dataset.getValue("appendCtrl");
		var lmtCtrl=JYMonitorReportWin_dataset.getValue("lmtCtrl");
		var riskCtrl=JYMonitorReportWin_dataset.getValue("riskCtrl");
		var frequency=JYMonitorReportWin_dataset.getValue("frequency");
		var opinion=JYMonitorReportWin_dataset.getValue("opinion");
		var rptStatus='${rptStatus}';
		if(appendCtrl.indexOf('1')>-1 && (frequency==null || frequency=="")){
			top.easyMsg.info("【附加处理措施】选择加强监控频率必须选择加强后的监控频率！");
			return false;
		}
		if(opinion==null || opinion==""){
			top.easyMsg.info("意见不能为空！");
			return false;
		}
		var vd=JYMonitorReportWin_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		var measCompleteDate=JYMonitorReportWin_dataset.getValue("measCompleteDate");
		if(measCompleteDateHide==false && (measCompleteDate==null || measCompleteDate=="")){
			top.easyMsg.info("措施完成时间不能为空！");
			return false;
		}
		//选择了控制措施，需要选择审核人
		if(rptStatus!="2" || ((appendCtrl!=null && appendCtrl!="") || (lmtCtrl!=null && lmtCtrl!="") || (riskCtrl!=null && riskCtrl!=""))){
			var orgId=user_info.orgId;
			var roleId="";
			var businessId='${businessId}';
			TaskVariable.findTaskVariable(businessId,function(y){
				if(y && y.nextRole){//获取到角色ID打开窗口。
					submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+y.nextRole,"600","400");
				}else{//获取不到，直接提交
					btnSubmitTrue.click();
				}
			});
		}else{
			btnSubmitTrue.click();
		}
	}
	//退回按钮提交检查事件
	function btnBack_onClickCheck(button){
		var op="back";
		JYMonitorReportWin_dataset.setParameter("op",op);
		var appendCtrl=JYMonitorReportWin_dataset.getValue("appendCtrl");
		var frequency=JYMonitorReportWin_dataset.getValue("frequency");
		var opinion=JYMonitorReportWin_dataset.getValue("opinion");
		if(appendCtrl.indexOf('1')>-1 && (frequency==null || frequency=="")){
			top.easyMsg.info("【附加处理措施】选择加强监控频率必须选择加强后的监控频率！");
			return false;
		}
		if(opinion==null || opinion==""){
			top.easyMsg.info("意见不能为空！");
			return false;
		}
	}
	
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		//warnUpd.disable(true);
		//设置所有字段只读,部分字段可写
		var fieldName="";
		for(var i=0;i<JYMonitorReportWin_dataset.fields.length;i++){
			fieldName=JYMonitorReportWin_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				JYMonitorReportWin_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	//设置页面字段可写
	function setPageCanWriteFun(editFields){
		for(var i=0;i<editFields.length;i++){
			JYMonitorReportWin_dataset.setFieldReadOnly(editFields[i],false);
		}
	}
	
	//查看预警信息
	function readWarnInfoFun(color){
		subwindow_MonitorReportWarnInfoFW.show();
		var accountId=JYMonitorReportWin_dataset.getValue("loanAcct");
		MonitorReportWarnInfo_dataset.setParameter("accountId",accountId);
		MonitorReportWarnInfo_dataset.setParameter("color",color);
		MonitorReportWarnInfo_dataset.flushData(MonitorReportWarnInfo_dataset.pageIndex);
	}
	
	function btnSave_onClickCheck(button){
		JYMonitorReportWin_dataset.setParameter("op",null);
		var appendCtrl=JYMonitorReportWin_dataset.getValue("appendCtrl");
		var frequency=JYMonitorReportWin_dataset.getValue("frequency");
		if(appendCtrl.indexOf('1')>-1 && (frequency==null || frequency=="")){
			top.easyMsg.info("【附加处理措施】选择加强监控频率必须选择加强后的监控频率！");
			return false;
		}
		var measCompleteDate=JYMonitorReportWin_dataset.getValue("measCompleteDate");
		if(measCompleteDateHide==false && (measCompleteDate==null || measCompleteDate=="")){
			top.easyMsg.info("措施完成时间不能为空！");
			return false;
		}
	}
	//保存后
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
	}
	//退回后关闭页面，刷新表格
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
		window.parent.ajMonitorReportWin_close();
	}

	function stockAdd_onClick(button) {
		JYStockStruInfo_dataset.insertRecord("end");
		subwindow_stockStruFW.show();
	}
	function stockUpd_onClick(button){
		subwindow_stockStruFW.show();
	}
	function stockConfirm_onClick(button){
		subwindow_stockStruFW.close();
	}
	
	function btnOpinion_onClick(){
		subwindow_taskApprovalHistoryFW.show();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/MonitorReportCtrl.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'></script>
</@CommonQueryMacro.page>