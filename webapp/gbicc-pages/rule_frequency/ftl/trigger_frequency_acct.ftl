<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="调整监控频率账户">
<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcct" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 showButton="false"/>
					<div align="center" style="margin-bottom:10px">
						<@CommonQueryMacro.InterfaceButton desc="查询" />
						<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
					</div>
				<@CommonQueryMacro.DataTable id ="triggerFrequencyAcctTable" paginationbar="btn_Add,btn_Read"
				fieldStr="loanAcct,custName,warnLevel,warnDate,loanVariety,loanAmt,loanBalance,loanTerm,frequency,status" readonly="true" width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="triggerFrequencyAcctFW" modal="true" label="调整监控频率" position="top" 
			resize="true" minimize="false"  maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcct" init="true" submitMode="selected" navigate="false">
				<table>
				 <tr>
		    		<td class="labeltd" align="center" width="width:20%">
		    		   贷款账号:
					</td>
					<td align="left" nowrap style="width:80%">
						<@CommonQueryMacro.SingleField fId="loanAcct"/>
						<@CommonQueryMacro.SimpleButton id="btnSelect" desc="选择" onclick="selectMainObj();" icon="" plain="false" />
					</td>
		    	</tr>
				</table>
					<@CommonQueryMacro.Group id="triggerFrequencyAcctGroup" label="" colNm=4
					fieldStr="warnLevel,custName,loanAmt,loanVariety,loanBalance,sysFrequency,frequency,loanTerm,launchPer,launchBank"/>
					<center>
					<@CommonQueryMacro.Button id= "btn_Submit"/>
					<@CommonQueryMacro.Button id= "btn_SubmitTrue"/>
					<span id="msgLabel">该贷款账号已发送调整监控频率流程至总行审批，暂时无法变更，请等待审核结束！</span>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
	
	
</table>
<@CommonQueryMacro.FloatWindow id="AccW" modal="true" label="贷款账户选择" 
	resize="true" minimize="false" width="1000" height="500" maximize="true" closure="true" show="false" defaultZoom="normal">
 <table>	
	<@CommonQueryMacro.CommonQuery id="TPlTrigFrequencyAcctV" init="true" submitMode="current">
	<tr>
	   <td>	
	       <@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6 />
	   </td>
	<tr>
	   <td>
		<@CommonQueryMacro.DataTable id="taskTable"   fieldStr="loanAccount,custname,productCode[150],loanAmount,loanBalance,loanPeriod,operator,operBank[150],trigRate,rankFinal" paginationbar="chanceAcc" width="100%" hasFrame="true"/>
	  </td>
	
	</@CommonQueryMacro.CommonQuery>
 </table>	
</@CommonQueryMacro.FloatWindow>
<script language="JavaScript">
    var submitWindow=null;  
  //重置查询条件
	function btnReset_onClick(button){
		TPlTriggerFrequencyAcct_interface_dataset.clearData();
	}
    function initCallGetter_post(){
		$("a[id=btnBack]").hide();
		$("a[id=btn_SubmitTrue]").hide();//提交 隐含
		$("span[id=msgLabel]").hide();
				
	}
	function chanceAcc_onClick(){
		//warnLevel,custName,loanAmt,loanVariety,loanBalance,sysFrequency,frequency,loanTerm,status,launchPer,launchBank 目標
		//loanAccount,custname,productCode,loanAmount,loanBalance,loanPeriod,operator,operBank,trigRate,rankFinal 源
		var loanAccount=TPlTrigFrequencyAcctV_dataset.getValue("loanAccount");//获取账户号
		var custName=TPlTrigFrequencyAcctV_dataset.getValue("custname");//客户名称
		var loanAmt=TPlTrigFrequencyAcctV_dataset.getValue("loanAmount");//贷款金额
		var loanVariety=TPlTrigFrequencyAcctV_dataset.getValue("productCode");//产品名称
		var loanBalance=TPlTrigFrequencyAcctV_dataset.getValue("loanBalance");//贷款余额
		var sysFrequency=TPlTrigFrequencyAcctV_dataset.getValue("trigRate");//系统频率
		var loanTerm=TPlTrigFrequencyAcctV_dataset.getValue("loanPeriod");//贷款期限
		var launchPer=TPlTrigFrequencyAcctV_dataset.getValue("operator");//经办人
		var launchBank=TPlTrigFrequencyAcctV_dataset.getValue("operBank");//经办行
		var warnLevel=TPlTrigFrequencyAcctV_dataset.getValue("rankFinal");//最终风险等级
		if(loanAccount==null || loanAccount==""){
			top.easyMsg.info("请先选择账户！");
			return;
		}
		TPlTriggerFrequencyAcct_dataset.setValue("loanAcct",loanAccount);
		TPlTriggerFrequencyAcct_dataset.setValue("custName",custName);
		TPlTriggerFrequencyAcct_dataset.setValue("loanAmt",loanAmt);
		TPlTriggerFrequencyAcct_dataset.setValue("loanVariety",loanVariety);
		TPlTriggerFrequencyAcct_dataset.setValue("loanBalance",loanBalance);
		TPlTriggerFrequencyAcct_dataset.setValue("sysFrequency",sysFrequency);
		TPlTriggerFrequencyAcct_dataset.setValue("loanTerm",loanTerm);
		TPlTriggerFrequencyAcct_dataset.setValue("launchPer",launchPer);
		TPlTriggerFrequencyAcct_dataset.setValue("launchBank",launchBank);
		TPlTriggerFrequencyAcct_dataset.setValue("warnLevel",warnLevel);
		
		
	     TaskVariable.findRuningTaskByBusinessKey(loanAccount,function(y){
		   
		   if(null!=y && y=="true"){ 
			       TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
		            $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").show();
		   }else{
			        
			        TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",false);
		            $("a[id=btn_Submit]").show();
					$("span[id=msgLabel]").hide();
		   } 
		});
		
		subwindow_AccW.close();
	}

	function selectMainObj(){

		
		subwindow_AccW.show();
		
	}
	
	//退回按钮提交检查事件
	function btnBack_onClickCheck(button){
		var op="back";	
		var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
		TPlTriggerFrequencyAcct_dataset.setParameter("businessId",businessId);
		TPlTriggerFrequencyAcct_dataset.setParameter("op",op);
	}

	function btn_Submit_onClick(button){
		 var frequency=TPlTriggerFrequencyAcct_dataset.getValue('frequency');
		 var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
		    if(frequency==""){
		    	top.easyMsg.info("请选择监控频率！");
		    	return false;
		    }
		    var orgId=user_info.orgId;
		  
			submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+557,"600","400");
				
		
	}
	//取消
	function cancelFun(){
		TPlTriggerFrequencyAcct_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		TPlTriggerFrequencyAcct_dataset.setParameter("taskAssignee",taskAssignee);
		btn_SubmitTrue.click();
	}
	//提交按钮提交检查事件
	function btn_SubmitTrue_onClickCheck(button){
		var op="one_submit";	
	
		TPlTriggerFrequencyAcct_dataset.setParameter("op",op);
	}
	//提交后关闭页面，刷新表格
	function btn_SubmitTrue_postSubmit(button) {
		button.url="#";
		if(submitWindow){
			submitWindow.close();
		}
		top.easyMsg.info("保存成功！");
		subwindow_triggerFrequencyAcctFW.close();
		
		TPlTriggerFrequencyAcct_dataset.flushData(TPlTriggerFrequencyAcct_dataset.pageIndex);
	}
	
 	function btn_Add_onClick(button){
 		            TPlTriggerFrequencyAcct_dataset.insertRecord("end");		   			
		            $("a[id=btn_Submit]").hide();
		            $("a[id=btnSelect]").show();
					//$("span[id=msgLabel]").show();
					TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
		  
					$("span[id=msgLabel]").hide();
 	                subwindow_triggerFrequencyAcctFW.show();
	}
 	
 	function triggerFrequencyAcctFW_floatWindow_beforeClose(subwindow) {
 		TPlTriggerFrequencyAcct_dataset.cancelRecord();
 		return true;
 	}
 	
	function btn_Read_onClick(button){
	     
	     TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
	     $("a[id=btnSelect]").hide();
	     var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
 	     TaskVariable.findRuningTaskByBusinessKey(businessId,function(y){
		   
		   if(null!=y && y=="true"){ 
		            $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").show();
		   }else{
		          $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").hide();
		   } 
		});
	    subwindow_triggerFrequencyAcctFW.show();
	
	}
	
 	function btnAdd_onClick(button){
 	    var businessId=TPlTriggerFrequencyAcctTask_dataset.getValue('loanAcct');
		
		TPlTriggerFrequencyAcct_dataset.setParameter("businessId",businessId);
 	     TaskVariable.findTaskVariable(businessId,function(y){
		   if(y.back!=null&&y.back=='show'){ 
		     $("a[id=btnBack]").show();
		   } 
		});
 	    TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
 	     subwindow_triggerFrequencyAcctTaskFW.show();
	}
		

	

	
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>

</@CommonQueryMacro.page>