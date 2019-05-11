<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="触发规则账户">
<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TriggerRuleAcct" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4/>
				<@CommonQueryMacro.DataTable id ="triggerRuleAcctTable" paginationbar="btnAdd,btnRead"
				fieldStr="loanacno[150],custname[150],prodid[100],prodname[150],acflag[80],acflag2[100],riskflag[80],overbal[100],operidName[100],bankidName[100]" readonly="true" width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="triggerRuleAcctFW" modal="true" label="规则排除/恢复" position="top" 
			resize="true" minimize="false" width="800" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.CommonQuery id="TriggerRuleAcct" init="true" submitMode="current" navigate="false">
					<@CommonQueryMacro.Group id="triggerRuleAcctGroup" label="" colNm=4
					fieldStr="loanacno,custname,prodid,prodname,riskflag,bankidName"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="TriggerWarningRule" init="false" submitMode="selected" navigate="false">
					<@CommonQueryMacro.DataTable height="300" id ="triggerWarningRuleTable" paginationbar="" pagination="false"
					fieldStr="select,ruleCode,ruleName" readonly="true" width="100%"/>
					<span><font color="red">&nbsp;PS:勾选的记录为排除的记录</font></span>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="RuleEliminate" init="true" submitMode="current" navigate="false">
					<@CommonQueryMacro.Group id="ruleEliminateGroup" label="" colNm=4 labelwidth="250"
					fieldStr="eliminateRuleDesc"/>
					<center>
					<@CommonQueryMacro.Button id= "btn_save"/>
					<@CommonQueryMacro.Button id= "btn_submit"/>
					<@CommonQueryMacro.Button id= "btn_submit_true"/>
					<span id="msgLabel">该贷款账号已保存规则排除或恢复尚未提交或者已经发送任务至总行审批，暂时无法变更，请等待审核结束！</span>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
</table>
<script language="JavaScript">
	var submitWindow=null;
	function initCallGetter_post(){
		$("a[id=btn_submit_true]").hide();
	}
	function btn_save_onClickCheck(button){
		if(TriggerWarningRule_dataset.length==0){
			top.easyMsg.info("帐户未触发任何规则,无法执行该操作！");
			return false;
		}
		var vd=RuleEliminate_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		var eliminateRuleDesc=RuleEliminate_dataset.getValue("eliminateRuleDesc");
		if(eliminateRuleDesc==null || eliminateRuleDesc==""){
			top.easyMsg.info("排除/恢复规则说明不能为空！");
			return false;
		}
		var op="one_save";
		RuleEliminate_dataset.setParameter("flag","add");
		TriggerRuleAcct_dataset.setParameter("op",op);
	}
	function btn_submit_onClick(button){
		if(TriggerWarningRule_dataset.length==0){
			top.easyMsg.info("帐户未触发任何规则,无法执行该操作！");
			return false;
		}
		var vd=RuleEliminate_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		var eliminateRuleDesc=RuleEliminate_dataset.getValue("eliminateRuleDesc");
		if(eliminateRuleDesc==null || eliminateRuleDesc==""){
			top.easyMsg.info("排除/恢复规则说明不能为空！");
			return false;
		}
		var orgId=user_info.orgId;
		var roleId="557";
		submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+roleId,"600","400");
	}
	//取消
	function cancelFun(){
		TriggerRuleAcct_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		TriggerRuleAcct_dataset.setParameter("taskAssignee",taskAssignee);
		btn_submit_true.click();
	}
	function btn_submit_true_onClickCheck(){
		var op="one_submit";
		RuleEliminate_dataset.setParameter("flag","add");
		TriggerRuleAcct_dataset.setParameter("op",op);
	}
	function btnAdd_onClick(button){
		var triggerRuleAcctId=TriggerRuleAcct_dataset.getValue("loanacno");
		TriggerWarningRule_dataset.setParameter("accId",triggerRuleAcctId);
		TriggerWarningRule_dataset.flushData(TriggerWarningRule_dataset.pageIndex);
		
		subwindow_triggerRuleAcctFW.show();
		TriggerWarningRule_dataset.setFieldReadOnly("select",false);
		$("div[name=ruleEliminateGroup]").show();
		RuleEliminate_dataset.setParameter("triggerRuleAcctId",triggerRuleAcctId);
		RuleEliminate_dataset.flushData(RuleEliminate_dataset.pageIndex);
		var ruleEliminateId=RuleEliminate_dataset.getValue("id");
		if(ruleEliminateId!=null){
			TaskVariable.findRuningTaskByBusinessKey(ruleEliminateId,function(y){
				if(null!=y && y=="true"){
					$("a[id=btn_save]").hide();
					$("a[id=btn_submit]").hide();
					$("span[id=msgLabel]").show();
					RuleEliminate_dataset.setFieldReadOnly("eliminateRuleDesc",true);
					TriggerWarningRule_dataset.setFieldReadOnly("select",true);
					var flag="2";
					selectGridFun(triggerRuleAcctId,flag);
				}else{
					$("a[id=btn_save]").show();
					$("a[id=btn_submit]").show();
					$("span[id=msgLabel]").hide();
					RuleEliminate_dataset.setFieldReadOnly("eliminateRuleDesc",false);
					TriggerWarningRule_dataset.setFieldReadOnly("select",false);
					var flag="1";
					selectGridFun(triggerRuleAcctId,flag);
				}
			});
		}else{
			$("a[id=btn_save]").show();
			$("a[id=btn_submit]").show();
			$("span[id=msgLabel]").hide();
			RuleEliminate_dataset.setFieldReadOnly("eliminateRuleDesc",false);
			TriggerWarningRule_dataset.setFieldReadOnly("select",false);
			var flag="1";
			selectGridFun(triggerRuleAcctId,flag);
		}
		
		$("#fldlabel_eliminateRuleDesc").html($("#fldlabel_eliminateRuleDesc").text()+"<span style='color:red;'>*</span>");
	}
	function btnRead_onClick(button){
		subwindow_triggerRuleAcctFW.show();
		var triggerRuleAcctId=TriggerRuleAcct_dataset.getValue("loanacno");
		$("div[name=ruleEliminateGroup]").hide();
		$("span[id=msgLabel]").hide();
		var flag="1";
		selectGridFun(triggerRuleAcctId,flag);
		$("a[id=btn_save]").hide();
		$("a[id=btn_submit]").hide();
		TriggerWarningRule_dataset.setFieldReadOnly("select",true);
	}
	//加载页面勾选表格
	function selectGridFun(triggerRuleAcctId,flag){
		TriggerWarningRule_dataset.flushData(TriggerWarningRule_dataset.pageIndex);
		RuleEliminate.dwrFindEliminateList(triggerRuleAcctId,flag,function(y){
			var record=TriggerWarningRule_dataset.getFirstRecord();
			if(null!=y && y.length>0){
				while(record){
					for(var i=0;i<y.length;i++){
						if(y[i]==record.getValue("ruleCode")){
							record.setValue("select",true);
						}
					}
					record=record.getNextRecord();
				}
			}else{
				while(record){
					record.setValue("select",false);
					record=record.getNextRecord();
				}
			}
		});
	}
	//保存后关闭页面，刷新表格
	function btn_save_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		subwindow_triggerRuleAcctFW.close();
		TriggerRuleAcct_dataset.flushData(TriggerRuleAcct_dataset.pageIndex);
	}
	//提交后关闭页面，刷新表格
	function btn_submit_true_postSubmit(button) {
		if(submitWindow){
			submitWindow.close();
		}
		button.url="#";
		top.easyMsg.info("提交成功！");
		subwindow_triggerRuleAcctFW.close();
		TriggerRuleAcct_dataset.flushData(TriggerRuleAcct_dataset.pageIndex);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/RuleEliminate.js'> </script>
</@CommonQueryMacro.page>