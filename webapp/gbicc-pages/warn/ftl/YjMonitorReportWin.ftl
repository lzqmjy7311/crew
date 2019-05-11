<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>


<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign pageReadOnly=RequestParameters["pageReadOnly"]?default('0')>
<@CommonQueryMacro.page title="个人预警处置监控报告">
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>


	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YjMonitorReportWin" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box1" label="贷款基本信息">
						<@CommonQueryMacro.Group id="group1" label="" colNm=4
						fieldStr="fdLoanAccount,fdCustCode,fdCustName,fdIndustry,custPhone,custAddress,fdProductName,fdLoanAmt,fdLoanBalance,fdGuarWay,fdSlidingScales,fdAcctStatus,fdRiskClass,fdVisitWay,fdVisitAdd,fdLeadInvestigator,fdAssInvestigator,fdSurveyDate"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="plWarnSignal" init="true" submitMode="all">	

					<@CommonQueryMacro.GroupBox id="box2" label="预警信号与处置措施">
			
						<@CommonQueryMacro.DataTable id="warnSignalTable" paginationbar="warnSignalUpd" pagination="true" 
			             fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc" width="100%" hasFrame="true"/>
							<@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="预警情况"  position="top"
							resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
								<@CommonQueryMacro.Group id="group2" label="" colNm=2
								fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc"/>
								<center>
								<@CommonQueryMacro.Button id="warnSignalConfirm" />
								</center>
					       </@CommonQueryMacro.FloatWindow>	
									
		           </@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>

		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="YjMonitorReportWin" init="true" submitMode="current">		
				<@CommonQueryMacro.GroupBox id="box3" label="控制措施">
				
				<@CommonQueryMacro.Group id="group3_1" label="风险控制措施" colNm=2 labelwidth="350"
						fieldStr="fdCreLimconMeasures,fdOtherConMeasures,fdOtherConMeasuresDesc,tempEmpty,tempEmpty"/>
				<@CommonQueryMacro.Group id="group3_2" label="" colNm=4 labelwidth="350"
						fieldStr="fdAddConMeasures,frequency,tempEmpty,tempEmpty"/>						
				</@CommonQueryMacro.GroupBox>
				
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="YjMonitorReportWin"  init="true" submitMode="current">		
				<@CommonQueryMacro.GroupBox id="box3_1" label="意见">
				
				<@CommonQueryMacro.Group id="group3_1_1" labelwidth="350" label="" colNm=4
						fieldStr="fdApplyOpin,tempEmpty,tempEmpty,tempEmpty"/>						
				</@CommonQueryMacro.GroupBox>
				
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td><@CommonQueryMacro.CommonQuery id="YjMonitorReportWin" init="true" submitMode="current">	
					
					<@CommonQueryMacro.GroupBox id="box5" label="控制措施完成时间">
							<@CommonQueryMacro.Group id="group5" label="" colNm=2
							fieldStr="fdCompleteDate"/>
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
		<td><@CommonQueryMacro.CommonQuery id="YjMonitorReportWin" init="true" submitMode="current">	
				
			<center>
			<@CommonQueryMacro.Button id="yjReportUpd" />	
			<@CommonQueryMacro.Button id="yjReportSubmit" />	
			<@CommonQueryMacro.Button id="yjReportSubmitTrue" />	
			<@CommonQueryMacro.Button id="yjReportBack" />	
			<@CommonQueryMacro.Button id= "contractBtn" />
			</center>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	</table>
<script>
    var submitWindow=null;  
    var ctrlMeasReadOnly='true';
   
    //页面初始化
	function initCallGetter_post(){
	
		var businessId='${businessId}';
		var rptStatus='${rptStatus}';
		var pageReadOnly='${pageReadOnly}';
		
		YjMonitorReportWin_dataset.setParameter("businessId",businessId);
		plWarnSignal_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		
		//判断是否来源任务调查 所有只读pageReadOnly=1
		if(pageReadOnly=='1'){
			//设置页面只读
			setPageReadOnlyFun();
			$("a[id=yjReportBack]").hide();	//隐藏退回按钮
			$("a[id=yjReportUpd]").hide();	//隐藏保存按钮
			$("a[id=yjReportSubmit]").hide();	//隐藏提交按钮
			//$("a[id=contractBtn]").hide();	//隐藏打印按钮
			$("a[id=warnSignalUpd]").hide();	//隐藏查证按钮
			//设置页面只读
			 $("fieldset[name=box3_1]").hide(); //隐藏审核意见
			
		}
		if(YjMonitorReportWin_dataset.getValue('fdVisitWay')=="0"){
			YjMonitorReportWin_dataset.setFieldRequired("fdVisitAdd",false);
		}else{
			YjMonitorReportWin_dataset.setFieldRequired("fdVisitAdd",true);
		}
		//隐藏真实提交按钮
		$("a[id=yjReportSubmitTrue]").hide();
		
		
		TaskVariable.findTaskVariable(businessId,function(y){
		  if(y.pageReadOnly!=null&&y.pageReadOnly=="true"){
			//设置页面只读
			setPageReadOnlyFun();			
		  }
		   if(y.backBtn!=null&&y.backBtn=="hide"){
		    $("a[id=yjReportBack]").hide();	//隐藏退回按钮	  		      
		  }
		  if(y.ctrlMeas!=null&&y.ctrlMeas=="hide"){
		  $("fieldset[name=box3]").hide();//隐藏控制措施GroupBox
		  }
		  if(y.ctrlMeasReadOnly!=null&&(y.ctrlMeasReadOnly=="false")&&pageReadOnly!='1'){//控制措施可写
			ctrlMeasReadOnly='false';
		    var editFields=["fdCreLimconMeasures","fdOtherConMeasures","fdOtherConMeasuresDesc","fdAddConMeasures","frequency"];
		    setPageCanWriteFun(editFields);		
		   // YjMonitorReportWin_dataset.setFieldHidden("frequency",true);//默认隐藏监控频率
		    YjMonitorReportWin_dataset.setFieldHidden("fdOtherConMeasuresDesc",true);
		  }
//		   if(y.ctrlOpinion!=null&&y.ctrlOpinion=="hide"){
//		    $("fieldset[name=box3_1]").hide(); //隐藏审核意见		      		   
//		  }
//		   if(y.ctrlOpinReadOnly!=null&&y.ctrlOpinReadOnly=="false"){
		    var editFields=["fdApplyOpin"];
		    setPageCanWriteFun(editFields);	
//		  }
		     
		  if((y.measDate==null||y.measDate=="hide")&&pageReadOnly!='1'){			 
		      $("fieldset[name=box5]").hide();//隐藏 措施完成措施
		  }else  if((y.length==undefined)&&(pageReadOnly=='1')){
			
			  $("fieldset[name=box5]").show();//隐藏 措施完成措施
		  }else {
		     var editFields=["fdCompleteDate"];
		     YjMonitorReportWin_dataset.setFieldRequired("fdCompleteDate",true);
		    setPageCanWriteFun(editFields);	
		  }
		  //为必填写添加红色星号警示
		  $("#fldlabel_fdApplyOpin").html($("#fldlabel_fdApplyOpin").text()+"<span style='color:red;'>*</span>");
		  var warnCode=plWarnSignal_dataset.getValue("warnCode");//预警信号 
		  warnCode=$.trim(warnCode);
		  
		  if(warnCode.length>0){
			  $("#fldlabel_checkStatus").html($("#fldlabel_checkStatus").text()+"<span style='color:red;'>*</span>"); 
		  }
		 

		  
		
		});
		
		//查询 控制措施
				MonitorReportCtrl.dwrFindCtrl(businessId,function(y){					       
									if(y && y.length>0){
										var apdCtrl="";
										for(var i=0;i<y.length;i++){
											var obj=eval("("+y[i]+")");
											if(obj.ctrlType=="1"){
												YjMonitorReportWin_dataset.setValue("fdCreLimconMeasures",obj.conmeasCode);
											}else if(obj.ctrlType=="2"){
												YjMonitorReportWin_dataset.setValue("fdOtherConMeasures",obj.conmeasCode);
												YjMonitorReportWin_dataset.setValue("fdOtherConMeasuresDesc",obj.otherCtrlDesc);
											}else if(obj.ctrlType=="3"){
												apdCtrl=apdCtrl+obj.conmeasCode+",";
											}
										}
										if(apdCtrl!=""){
											apdCtrl=apdCtrl.substring(0,apdCtrl.length-1);
										}
										YjMonitorReportWin_dataset.setValue("fdAddConMeasures",apdCtrl);
									}
								});
				//判断监控频率是否为空 不为空则显示
				var frequency=$.trim(YjMonitorReportWin_dataset.getValue("frequency"));
				
//	        	if(frequency.length>0){
//	        		YjMonitorReportWin_dataset.setFieldHidden("frequency",false);
//	        	}else{
//	        		YjMonitorReportWin_dataset.setFieldHidden("frequency",true);
//	        	}
	        	
				var  fdOtherConMeasures= YjMonitorReportWin_dataset.getValue("fdOtherConMeasures");
				
	        	if( fdOtherConMeasures &&  fdOtherConMeasures!="" &&  fdOtherConMeasures.indexOf("SS")>-1){
					  YjMonitorReportWin_dataset.setFieldHidden("fdOtherConMeasuresDesc",false);
			    	}
	
	        	
				MonitorReportCtrl.dwrFindFrequency(businessId,function(y){	
					if(y){		
						
						YjMonitorReportWin_dataset.setValue("frequency",y[0]);
						YjMonitorReportWin_dataset.setValue("frequencyName",y[1]);
						if(frequency.length>0){
							YjMonitorReportWin_dataset.setFieldHidden("frequency",false);
						}else{
							YjMonitorReportWin_dataset.setFieldHidden("frequency",true);
						}
						
						
					}
				});
		
		
	
		
	}
	
	function YjMonitorReportWin_dataset_onSetValue(ds,curretField,val){
//		console.log("curretField.name----》"+curretField.name);
		 if(curretField.name=='fdaddconmeasures'){
			appendCtrl_selectedFun(val);
		}else if(curretField.name=='fdotherconmeasures'){
//			console.log("2222");
			fdOtherConMeasures_selectedFun(val);
		}
		return val;
	}
	function appendCtrl_selectedFun(val){
		
		var frequency=YjMonitorReportWin_dataset.getValue("frequency");
		
		frequency=$.trim(frequency);
//		console.log("frequency---"+frequency);
		if(val && val!="" && val.indexOf("1")==0){
			YjMonitorReportWin_dataset.setFieldHidden("frequency",false);
			if(frequency==""){
				YjMonitorReportWin_dataset.setValue("frequency","0.5");
				YjMonitorReportWin_dataset.setValue("frequencyName","0.5月");
			}			
		}else{
			YjMonitorReportWin_dataset.setFieldHidden("frequency",true);
			YjMonitorReportWin_dataset.setValue("frequency",null);
			YjMonitorReportWin_dataset.setValue("frequencyName",null);
		}
	}
	function  fdOtherConMeasures_selectedFun(val){
//		console.log("fdOtherConMeasures_selectedFun___>"+val);
		if(val && val!="" && val.indexOf("SS")>-1){
			 YjMonitorReportWin_dataset.setFieldHidden("fdOtherConMeasuresDesc",false);
		}else{
			 YjMonitorReportWin_dataset.setFieldHidden("fdOtherConMeasuresDesc",true);
			 YjMonitorReportWin_dataset.setValue("fdOtherConMeasuresDesc",null);
		}
	}
	function frequency_DropDown_beforeOpen(dropDown){
		var businessId='${businessId}';
		subAutoDataDic_DropDownDataset.setParameter("businessId",businessId);
		subAutoDataDic_DropDownDataset.setParameter("dicCode",703);
		frequency_DropDown.cached=false;//让qGroupId不存入缓存
	}
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		 warnSignalUpd.disable(true);
		 //warnSignalDel.disable(true);
		var fieldName="";
		for(var i=0;i<YjMonitorReportWin_dataset.fields.length;i++){
			fieldName=YjMonitorReportWin_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){				
				YjMonitorReportWin_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	//设置页面字段可写
	function setPageCanWriteFun(editFields){
		for(var i=0;i<editFields.length;i++){
			YjMonitorReportWin_dataset.setFieldReadOnly(editFields[i],false);
		}
	}
	function YjMonitorReportWin_dataset_afterChange(dataset,field){
		if(field.fieldName=='fdVisitWay'){
			if(YjMonitorReportWin_dataset.getValue('fdVisitWay')=="0"){
				YjMonitorReportWin_dataset.setFieldRequired("fdVisitAdd",false);
			}else{
				YjMonitorReportWin_dataset.setFieldRequired("fdVisitAdd",true);
			}
			
		}
	}	
	
		//提交按钮提交检查事件
	function yjReportSubmit_onClick(button){
//		var rptStatus='${rptStatus}';
//		var op="submit";
//		var fdOtherConMeasures;
//		var fdOtherConMeasuresDesc;
//		//关联验证
//		//submitCheck();
//		
//		
//		
//		YjMonitorReportWin_dataset.setParameter("op",op);
		var orgId=user_info.orgId;
		var roleId="";
		var businessId='${businessId}';
		var fdApplyOpin=YjMonitorReportWin_dataset.getValue("fdApplyOpin");//意见
		var checkStatus=plWarnSignal_dataset.getValue("checkStatus");//查证情况
		var warnCode=plWarnSignal_dataset.getValue("warnCode");//预警信号 
		warnCode=$.trim(warnCode);
		//console.log("warnCode--->"+warnCode.length);
		var fdCreLimconMeasures=YjMonitorReportWin_dataset.getValue("fdCreLimconMeasures");//授信额度
		var fdOtherConMeasures=YjMonitorReportWin_dataset.getValue("fdOtherConMeasures");//其他控制措施
		var fdAddConMeasures=YjMonitorReportWin_dataset.getValue("fdAddConMeasures");//附加控制措施
		if(fdApplyOpin==""){
			top.easyMsg.info("请先填写意见！");
			return false;
		}else if(checkStatus==""&&warnCode.length>0){
			top.easyMsg.info("请先选择【预警信号】中查证情况！");
			return false;
		}
		
		TaskVariable.findTaskVariable(businessId,function(y){			
			if(y && y.nextRole&&(ctrlMeasReadOnly=='true'||ctrlMeasReadOnly=='false'&&(fdCreLimconMeasures!=""||fdOtherConMeasures!=""||fdAddConMeasures!=""))){//获取到角色ID且（不显示控制措施或显示但是必须一项控制措施不为空） 打开窗口。
				submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+y.nextRole,"600","400");
			}else{//获取不到，直接提交
				yjReportSubmitTrue.click();
			}
		});
	}
	//------控制选择 下一接收人start
	//取消
	function cancelFun(){
		YjMonitorReportWin_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		YjMonitorReportWin_dataset.setParameter("taskAssignee",taskAssignee);
		yjReportSubmitTrue.click();
	}
	function yjReportSubmitTrue_onClickCheck(button){
		var op="submit";
		YjMonitorReportWin_dataset.setParameter("op",op);
	}
	function yjReportSubmitTrue_postSubmit(button) {
		if(submitWindow){
			submitWindow.close();
		}
		top.easyMsg.info("提交成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
		if(window && window.parent){
			window.parent.ajMonitorReportWin_close();
		}
	}

	
	//--------控制选择 下一接收人end
	
	//退回按钮提交检查事件
	function yjReportBack_onClickCheck(button){
		var rptStatus='${rptStatus}';
		var op="back";	
		var fdApplyOpin=YjMonitorReportWin_dataset.getValue("fdApplyOpin");
		if(fdApplyOpin==""){
			top.easyMsg.info("请先填写意见！");
			return false;
		}
		YjMonitorReportWin_dataset.setParameter("op",op);
	}
	

	
	//function warnSignalAdd_onClick(button) {
	//	plWarnSignal_dataset.insertRecord("end");
	//	subwindow_warnSignalFW.show();
	//}
	function warnSignalUpd_onClick(button){
		subwindow_warnSignalFW.show();
	}
	function warnSignalConfirm_onClick(button){
		subwindow_warnSignalFW.close();
	}
	
	
	//保存后关闭页面，刷新表格
	function yjReportUpd_postSubmit(button) {
		button.url="#";
//		var fdApplyOpin=YjMonitorReportWin_dataset.getValue("fdApplyOpin");
//		if(fdApplyOpin==""){
//			top.easyMsg.info("请先填写意见！");
//		return false;
//		}
		top.easyMsg.info("保存成功！");
//操作完成后关闭当前页面	
//		if(parent.parent.GTab)
//		 {parent.parent.GTab.closeTab();}
//		window.parent.ajMonitorReportWin_close();
	}
	//提交后关闭页面，刷新表格
//	function yjReportSubmit_postSubmit(button) {
//		button.url="#";
//		top.easyMsg.info("操作成功！");
//		
//		if(parent.parent.GTab)
//		 {parent.parent.GTab.closeTab();}
//		window.parent.ajMonitorReportWin_close();
//	}
	//退回后关闭页面，刷新表格
	function yjReportBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		
		if(parent.parent.GTab)
		 {parent.parent.GTab.closeTab();}
		window.parent.ajMonitorReportWin_close();
	}
	
	//提交验证
	function submitCheck(){
	      var fdIsZdzqzwjfflss; 
	      var  fdIsZdzqzwjfflssDesc;  
	     
      
      
      
         fdIsZdzqzwjfflss=YjMonitorReportWin_dataset.getValue("fdIsZdzqzwjfflss"); //借款人是否涉及或者即将涉及重大债权债务纠纷、法律诉讼:（诉讼）
		    
		    fdIsZdzqzwjfflssDesc=YjMonitorReportWin_dataset.getValue("fdIsZdzqzwjfflssDesc");
		  
	        if(fdIsZdzqzwjfflss!=""&&fdIsZdzqzwjfflssDesc==""){
	         $('#fdIsZdzqzwjfflssDesc').focus();
			       top.easyMsg.warn("选择其他控制措施，必须填写借款人是否涉及或者即将涉及重大债权债务纠纷、法律诉讼说明！");
			       return false;
			    }
		    if(fdIsZdzqzwjfflss==""&&fdIsZdzqzwjfflssDesc!=""){
		    $('#fdIsZdzqzwjfflss').focus();
		       top.easyMsg.warn("填写借款人是否涉及或者即将涉及重大债权债务纠纷、法律诉讼说明，必须选择该选项！");
		       return false;
		    }
        
	}
	//打印
	function contractBtn_onClickCheck(button){
		var businessId='${businessId}';
		var reportId=YjMonitorReportWin_dataset.getValue("fdId");
		window.open("${contextPath}/common/donloadWord?reportType=YJ&reportId="+reportId+'&businessId='+businessId);
		/*
		
		$('#uploadForm').ajaxSubmit({
			type:"post", 
			success:function(data){
			}
		});
		*/
	}
	
	//查看意见
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/MonitorReportCtrl.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>