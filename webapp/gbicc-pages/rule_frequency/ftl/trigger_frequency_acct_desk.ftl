<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="调整监控频率账户">
<table align="left" width="100%">
   
	
	 <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcctTask" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.DataTable id ="triggerFrequencyAcctTaskTable" paginationbar="btnAdd,moreHandle"
				fieldStr="loanAcct,custName,warnLevel,warnDate,loanVariety,loanAmt,loanBalance,loanTerm,frequency,sysFrequency,status" readonly="true"    width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="triggerFrequencyAcctTaskFW" modal="true" label="所属调整监控频率任务" position="top" 
			resize="true" minimize="false" width="800" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcctTask" mode="1" init="true" submitMode="current" navigate="false">
					<@CommonQueryMacro.Group id="triggerFrequencyAcctGroup" label="" colNm=4
					fieldStr="warnLevel,custName,loanAcct,loanAmt,loanVariety,loanBalance,sysFrequency,frequency,loanTerm,warnDate,status,launchPer,launchBank"/>
					<center>
					<@CommonQueryMacro.Button id= "btnSubmit"/>
					<@CommonQueryMacro.Button id= "btnSubmitTrue"/>
					<@CommonQueryMacro.Button id= "btnBack"/>
					</center>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="false" submitMode="all">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion" nowrap="false"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
</table>
<script language="JavaScript">
    var submitWindow=null; 
    function initCallGetter_post(){
		$("a[id=btnBack]").hide();
		$("a[id=btnSubmitTrue]").hide();//提交 隐含
				
	}

	//查看意见
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
	
	//退回按钮提交检查事件
	function btnBack_onClickCheck(button){
		var op="back";	
		var businessId=TPlTriggerFrequencyAcctTask_dataset.getValue('loanAcct');
		TPlTriggerFrequencyAcctTask_dataset.setParameter("businessId",businessId);
		TPlTriggerFrequencyAcctTask_dataset.setParameter("op",op);
		subwindow_triggerFrequencyAcctTaskFW.close();
		TPlTriggerFrequencyAcctTask_dataset.flushData(TPlTriggerFrequencyAcctTask_dataset.pageIndex);
	}
	
	function btnSubmit_onClick(button){
		 var frequency=TPlTriggerFrequencyAcctTask_dataset.getValue('frequency');
		 var businessId=TPlTriggerFrequencyAcctTask_dataset.getValue('loanAcct');
		    if(frequency==""){
		    	top.easyMsg.info("请选择监控频率！");
		    	return false;
		    }
		    var orgId=user_info.orgId;
		    btnSubmitTrue.click();
//			TaskVariable.findTaskVariable(businessId,function(y){			
//				if(y && y.nextRole){//获取到角色ID且 打开窗口。
//					submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+557,"600","400");
//				}else{//获取不到，直接提交
//					btnSubmitTrue.click();
//				}
//			});
		    
				
		
	}
	//取消
	function cancelFun(){
		TPlTriggerFrequencyAcctTask_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		TPlTriggerFrequencyAcctTask_dataset.setParameter("taskAssignee",taskAssignee);
		btnSubmitTrue.click();
	}
	//提交按钮提交检查事件
	function btnSubmitTrue_onClickCheck(button){
		var op="submit";	

		TPlTriggerFrequencyAcctTask_dataset.setParameter("op",op);
	}
	
	//(任务)提交后关闭页面，刷新表格
	function btnSubmitTrue_postSubmit(button) {
		button.url="#";
		if(submitWindow){
			submitWindow.close();
		}
		top.easyMsg.info("提交成功！");
		subwindow_triggerFrequencyAcctTaskFW.close();
		TPlTriggerFrequencyAcctTask_dataset.flushData(TPlTriggerFrequencyAcctTask_dataset.pageIndex);
	}
	
	
	
 	function btnAdd_onClick(button){
 	    var businessId=TPlTriggerFrequencyAcctTask_dataset.getValue('loanAcct');
 	   if(businessId==""){
	    	top.easyMsg.info("未选任何记录！");
	    	return false;
	    }
		TPlTriggerFrequencyAcctTask_dataset.setParameter("businessId",businessId);
 	     TaskVariable.findTaskVariable(businessId,function(y){
 	     
		   if(y.back!=null&&y.back=='show'){ 
		     $("a[id=btnBack]").show();
		   } 
		});
 	    TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
 	     subwindow_triggerFrequencyAcctTaskFW.show();
	}
		
	
	

	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('TPlTriggerFrequencyAcctTask',"调整监控频率",'/gbicc-pages/rule_frequency/ftl/trigger_frequency_acct_more.ftl');
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>

</@CommonQueryMacro.page>
