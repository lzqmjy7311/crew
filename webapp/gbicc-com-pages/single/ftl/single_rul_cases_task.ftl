<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="单规则预警处置-案例管理列表">
<table>
	<@CommonQueryMacro.CommonQuery id="SingleRulCases" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="SingleRulCasesTable" readonly="true" paginationbar="btHandle,btnCasesDel" 
		fieldStr="casesCode,casesName,casesStatus,createDt,warnCount,inveCount,alreInveCount" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.FloatWindow id="SingleRulCasesFW" modal="true" label="单规则案例管理" 
	resize="true" minimize="false" width="1200" height="650" maximize="true" closure="true" show="false" defaultZoom="normal">
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="SingleRulCases" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="SingleRulCasesGroup" label="" colNm=4 labelwidth="150"
					fieldStr="casesCode,casesName,casesNature,followupFlag,createDt,createOrg,casesDesc,casesConclusion,opinion"/>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.GroupBox id="SingleRulWarningSelectBox" label="已有预警信号列表" expand="true">
					<@CommonQueryMacro.CommonQuery id="SingleRulWarningSelect" init="false" submitMode="selected">
						<@CommonQueryMacro.DataTable id="SingleRulWarningSelectTable" nowrap="true" readonly="false" paginationbar="btRemove,btLaunchInve,btnShow" 
						fieldStr="select,rulCode,rulType,rulName,fcettypecode[120],fcetname[150],warnStatus,warnDt,mainOrg,warningRelieve" width="100%" hasFrame="true"/>
					</@CommonQueryMacro.CommonQuery>
				</@CommonQueryMacro.GroupBox>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.GroupBox id="SingleRulInvestigationBox" label="协查任务列表" expand="true">
					<@CommonQueryMacro.CommonQuery id="SingleRulInvestigation" init="false" submitMode="current">
						<@CommonQueryMacro.DataTable id="SingleRulInvestigationTable" nowrap="true" readonly="true" paginationbar="btnAgainInve,btnRead" 
						fieldStr="inveCode[120],inveName[150],inveOrgName[150],inveUser[150],inveCont[150],createDt[100],status[100],matureDt[100],inveNumb[80],inveFeedDt[100],opr[100]" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.Button id="btnDel" />
					</@CommonQueryMacro.CommonQuery>
				</@CommonQueryMacro.GroupBox>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" nowrap="true" paginationbar="btnOpinion"
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
				<@CommonQueryMacro.CommonQuery id="SingleRulCases" mode="1" init="true" submitMode="current">
					<br/><center>
						<@CommonQueryMacro.Button id="btSave" />
						<@CommonQueryMacro.Button id="btFiling" />
						<@CommonQueryMacro.Button id="btAgree" />
						<@CommonQueryMacro.Button id="btBack" />
						<@CommonQueryMacro.Button id="btClose" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</@CommonQueryMacro.FloatWindow>
</table>
<script>
	var invetask_wait_submit_status="1";//协查任务待提交状态
	var invetask_already_complete="3";//协查任务已协查状态
	//页面初始化
	function initCallGetter_post(){
		var casesId=SingleRulCases_dataset.getValue("id");
		TaskApprovalHistory_dataset.setParameter("businessId",casesId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
		$("a[id=btnDel]").hide();
		var roleId=user_info.roleId;
		if(roleId=="559"||roleId=="561"){
			$("a[id=btn_Add]").hide();
			$("a[id=btnCasesDel]").hide();
		}
	}
	//删除
	function btnCasesDel_onClickCheck(){
		var casesStatus=SingleRulCases_dataset.getValue("casesStatus");
		var casesId=SingleRulCases_dataset.getValue("id");
		if(casesId==null || casesId==""){
			top.easyMsg.info("请选择要删除的案例！");
			return false;
		}
		if(casesStatus!="1"){
			top.easyMsg.info("只能删除草稿状态的案例！");
			return false;
		}
		SingleRulWarningSelect_dataset.setParameter("casesId",casesId);
		SingleRulWarningSelect_dataset.flushData(SingleRulWarningSelect_dataset.pageIndex);
		if(SingleRulWarningSelect_dataset.length>0){
			top.easyMsg.info("该案例中存在预警信号，无法删除！");
			return false;
		}
		SingleRulCases_dataset.setFieldRequired("casesNature",false);
		return confirm("确认删除该案例？");
	}
	function btnCasesDel_postSubmit(){
		top.easyMsg.info("操作成功！");
		SingleRulCases_dataset.flushData(SingleRulCases_dataset.pageIndex);
	}
	function SingleRulCasesTable_onDbClick(){
		btHandle_onClick();
	}
	//处理
	function btHandle_onClick(button){
		subwindow_SingleRulCasesFW.show();
		var casesId=SingleRulCases_dataset.getValue("id");
		SingleRulWarningSelect_dataset.setParameter("casesId",casesId);
		SingleRulWarningSelect_dataset.flushData(SingleRulWarningSelect_dataset.pageIndex);
		
		TaskApprovalHistory_dataset.setParameter("businessId",casesId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
		
		SingleRulInvestigation_dataset.setParameter("casesId",casesId);
		SingleRulInvestigation_dataset.flushData(SingleRulInvestigation_dataset.pageIndex);
		
		//查找流程图每一节点变量，初始化页面
		var fields=["casesNature","casesConclusion"];
		TaskVariable.findTaskVariable(casesId,function(y){
			if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
				setPageReadOnlyFieldsFun(fields,true);
				$("a[id=btAgree]").show();
				$("a[id=btBack]").show();
				$("a[id=btFiling]").hide();
				$("a[id=btSave]").hide();
				SingleRulCases_dataset.setFieldHidden("opinion",false);
				SingleRulCases_dataset.setFieldHidden("followupFlag",false);
				SingleRulCases_dataset.setFieldRequired("followupFlag",true);
				$("a[id=btRemove]").hide();
				$("a[id=btLaunchInve]").hide();
				$("a[id=btnAgainInve]").hide();
				SingleRulWarningSelect_dataset.setFieldReadOnly("warningRelieve",true);
			}else{
				setPageReadOnlyFieldsFun(fields,false);
				$("a[id=btAgree]").hide();
				$("a[id=btBack]").hide();
				$("a[id=btFiling]").show();
				$("a[id=btSave]").show();
				SingleRulCases_dataset.setFieldHidden("opinion",true);
				SingleRulCases_dataset.setFieldHidden("followupFlag",true);
				SingleRulCases_dataset.setFieldRequired("followupFlag",false);
				$("a[id=btRemove]").show();
				$("a[id=btLaunchInve]").show();
				$("a[id=btnAgainInve]").show();
				SingleRulWarningSelect_dataset.setFieldReadOnly("warningRelieve",false);
			}
		});
		setPageRequiredFieldsFun(fields,true);
		//SingleRulWarningSelect_dataset.setFieldRequired("warningRelieve",true);
	}
	var investigationWin=null;
	function investigationWin_close(){
		investigationWin.close();
	}
	function singleRulInvestigation_flush_data(){
		SingleRulInvestigation_dataset.flushData(SingleRulInvestigation_dataset.pageIndex);
	}
	function investigationWin_and_parWin_close(){
		investigationWin.close();
		subwindow_SingleRulCasesFW.close();
		flushCurrentPage();
	}
	//移除
	function btRemove_onClickCheck(){
		var fields=["casesNature"];
		var fields2=["checkEmph","inveWay","inveConc","partUser"];
		setPageReadOnlyFieldsFun(fields,true);
		setPageReadOnlyFieldsFun2(fields2,true);
		
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("select")==true){
				records.push(record);
			}
			record=record.getNextRecord();
		}
		if(!(records.length>0)){
			top.easyMsg.info("请选择要移除的预警信号！");
			return false;;
		}
		
		var fields=["casesNature","casesConclusion"];
		setPageRequiredFieldsFun(fields,false);
		SingleRulWarningSelect_dataset.setFieldRequired("warningRelieve",false);
		
		var warningIds="";
		for(var i=0;i<records.length;i++){
			warningIds=warningIds+records[i].getValue("id")+",";
		}
		DWREngine.setAsync(false);
		warningIds=warningIds.substring(0,warningIds.length-1);
		var bool=true;
		InveRelWarning.dwrFindWarningCount(warningIds,function(y){
			if(y>0){
				bool=false;
			}
		});
		DWREngine.setAsync(true);
		if(!bool){
			top.easyMsg.info("您选择的预警信号已发起协查任务，无法移除！");
			return false;
		}else{
			return confirm("确认移除该信号？");
		}
	}
	function btRemove_postSubmit(button){
		top.easyMsg.info("操作成功！");
		SingleRulWarningSelect_dataset.flushData(SingleRulWarningSelect_dataset.pageIndex);
		
		var fields=["casesNature"];
		var fields2=["checkEmph","inveWay","inveConc","partUser"];
		setPageReadOnlyFieldsFun(fields,false);
		setPageReadOnlyFieldsFun2(fields2,false);
	}
	//发起协查
	function btLaunchInve_onClick(button){
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("select")==true){
				records.push(record);
			}
			record=record.getNextRecord();
		}
		var warningIds="";
		for(var i=0;i<records.length;i++){
			warningIds=warningIds+records[i].getValue("id")+",";
		}
		if(warningIds.length>0){
			warningIds=warningIds.substring(0,warningIds.length-1);
		}else{
			warningIds="0";
		}
		var casesId=SingleRulCases_dataset.getValue("id");
		openInvestigationWin(casesId,warningIds,"");
	}
	
	//查看 单规则 详细 
	function btnShow_onClick(){
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("select")==true){
				records.push(record);
			}
			record=record.getNextRecord();
		}
		var warningIds="";
		for(var i=0;i<records.length;i++){
			warningIds=warningIds+records[i].getValue("id")+",";
		}
		if(warningIds.length>0){
			warningIds=warningIds.substring(0,warningIds.length-1);
			openSubWin("singleRuleWin","单规则预警信号详细信息","/gbicc-com-pages/single/query_ftl/single_rul_warning_read_win.ftl?businessId="+warningIds,"1200","700");
		}else{
			warningIds="0";
			top.easyMsg.info("未选择预警信号");
		}	
	} 
	//打开发起协查窗口
	function openInvestigationWin(casesId,warningIds,inveId){
		investigationWin=openSubWin("investigationWin","发起协查","/gbicc-com-pages/single/ftl/single_rul_investigation_add.ftl?casesId="+casesId+"&warningIds="+warningIds+"&inveId="+inveId,"950","500");
	}
	//协查任务列表刷新触发
	function SingleRulInvestigationTable_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			if(record.getValue("status")=="1"){
				cell.innerHTML="<a href='JavaScript:inveUpdate(\""+value+"\")'>修改</a>&nbsp;<a href='JavaScript:inveDel(\""+value+"\")'>删除</a>";
			}else{
				cell.innerHTML="";
			}
		} 
	}
	//协查任务列表-修改事件
	function inveUpdate(inveId){
		var casesId=SingleRulCases_dataset.getValue("id");
		var warningIds="";
		InveRelWarning.dwrFindWarningIds(inveId,function(y){
			if(y.length>0){
				for(var i=0;i<y.length;i++){
					warningIds=warningIds+y[i]+",";
				}
			}else{
				warningIds="0";
			}
			openInvestigationWin(casesId,warningIds,inveId);
		});
	}
	//协查任务列表-删除事件
	function inveDel(inveId){
		SingleRulInvestigation_dataset.setParameter("op","deleteInve");
		SingleRulInvestigation_dataset.setParameter("inveId",inveId);
		
		var fields=["casesNature"];
		var fields2=["checkEmph","inveWay","inveConc","partUser"];
		setPageReadOnlyFieldsFun(fields,true);
		setPageReadOnlyFieldsFun2(fields2,true);
		$("a[id=btnDel]").click();
	}
	function btnDel_postSubmit(){
		SingleRulInvestigation_dataset.flushData(SingleRulInvestigation_dataset.pageIndex);
		var fields=["casesNature"];
		var fields2=["checkEmph","inveWay","inveConc","partUser"];
		setPageReadOnlyFieldsFun(fields,false);
		setPageReadOnlyFieldsFun2(fields2,false);
	}
	//查看协查任务
	function btnRead_onClick(){
		//添加弹窗提醒
		var id = SingleRulInvestigation_dataset.getValue("id");
		if (id.length > 0)
			openInvestigationWinAllFun("read");
		else
			top.easyMsg.info("未选择协查任务");
	}
	//重调查
	function btnAgainInve_onClick(){
		var status=SingleRulInvestigation_dataset.getValue("status");
		if(status!=invetask_already_complete){
			top.easyMsg.info("只有【已协查】状态的任务能执行重调查操作！");
			return;
		}
		openInvestigationWinAllFun("againInve");
	}
	function openInvestigationWinAllFun(oper){
		var casesId=SingleRulInvestigation_dataset.getValue("casesId");
		var inveId=SingleRulInvestigation_dataset.getValue("id");
		var warningIds="";
		InveRelWarning.dwrFindWarningIds(inveId,function(y){
			if(y.length>0){
				for(var i=0;i<y.length;i++){
					warningIds=warningIds+y[i]+",";
				}
			}else{
				warningIds="0";
			}
			openInvestigationWinAll(casesId,warningIds,inveId,oper);
		});
	}
	//打开任务协查窗口
	function openInvestigationWinAll(casesId,warningIds,inveId,oper){
		investigationWin=openSubWin("investigationWin","协查任务","/gbicc-com-pages/single/ftl/single_rul_investigation.ftl?casesId="+casesId+"&warningIds="+warningIds+"&inveId="+inveId+"&oper="+oper,"950","700");
	}
	//同意
	function btAgree_onClickCheck(button){
		SingleRulCases_dataset.setParameter("op","agree");
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("warningRelieve")==null || record.getValue("warningRelieve")==""){
				/* top.easyMsg.info("预警解除情况全部录入后才可申请归档！请双击【已有预警信号列表】完成录入！");
				return false; */
				record.setValue("warningRelieve","Y");
			}
			var temp="{'warnId':'"+record.getValue("id")+"','warningRelieve':'"+record.getValue("warningRelieve")+"'}";
			records.push(temp);
			record=record.getNextRecord();
		}
		SingleRulCases_dataset.setParameter("warnRecords","["+records+"]");
		
	}
	function btAgree_postSubmit(button){
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_SingleRulCasesFW.close();
		flushCurrentPage();
	}
	//设置页面字段必填
	function setPageRequiredFieldsFun(fields,bool){
		for(var i=0;i<fields.length;i++){
			SingleRulCases_dataset.setFieldRequired(fields[i],bool);
		}
	}
	//设置页面字段只读
	function setPageReadOnlyFieldsFun(fields,bool){
		for(var i=0;i<fields.length;i++){
			SingleRulCases_dataset.setFieldReadOnly(fields[i],bool);
		}
	}
	//设置页面字段只读2
	function setPageReadOnlyFieldsFun2(fields,bool){
		for(var i=0;i<fields.length;i++){
			SingleRulInvestigation_dataset.setFieldReadOnly(fields[i],bool);
		}
	}
	//保存
	function btSave_onClickCheck(button){
		var casesNature=SingleRulCases_dataset.getValue("casesNature");
		var casesConclusion=SingleRulCases_dataset.getValue("casesConclusion");
		if(casesNature==null || casesNature=="" || casesConclusion==null || casesConclusion==""){
			top.easyMsg.info("填写【案例性质】与【案例处置结论】后才可申请归档！");
			return false;
		}
		SingleRulWarningSelect_dataset.setFieldRequired("warningRelieve",true);
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("warningRelieve")==null || record.getValue("warningRelieve")==""){
				record.setValue("warningRelieve","Y");
			}
			var temp="{'warnId':'"+record.getValue("id")+"','warningRelieve':'"+record.getValue("warningRelieve")+"'}";
			records.push(temp);
			record=record.getNextRecord();
		}
		SingleRulCases_dataset.setParameter("op","save");
		SingleRulCases_dataset.setParameter("warnRecords","["+records+"]");
	}
	//申请归档
	function btFiling_onClickCheck(button){
		//检查是否能归档
		var record=SingleRulInvestigation_dataset.getFirstRecord();
		var bool=true;
		while(record){
			if(record.getValue("status")!=invetask_already_complete){
				bool=false;
			}
			record=record.getNextRecord();
		}
		if(!bool){
			top.easyMsg.info("发起的协查任务状态必须全部为【已协查】才可申请归档！");
			return false;
		}
		
		var casesNature=SingleRulCases_dataset.getValue("casesNature");
		var casesConclusion=SingleRulCases_dataset.getValue("casesConclusion");
		if(casesNature==null || casesNature=="" || casesConclusion==null || casesConclusion==""){
			top.easyMsg.info("填写【案例性质】与【案例处置结论】后才可申请归档！");
			return false;
		}
		
		SingleRulWarningSelect_dataset.setFieldRequired("warningRelieve",true);
		
		var record=SingleRulWarningSelect_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("warningRelieve")==null || record.getValue("warningRelieve")==""){
				/* top.easyMsg.info("预警解除情况全部录入后才可申请归档！请双击【已有预警信号列表】完成录入！");
				return false; */
				record.setValue("warningRelieve","Y");
			}
			var temp="{'warnId':'"+record.getValue("id")+"','warningRelieve':'"+record.getValue("warningRelieve")+"'}";
			records.push(temp);
			record=record.getNextRecord();
		}
		SingleRulCases_dataset.setParameter("op","filing");
		SingleRulCases_dataset.setParameter("warnRecords","["+records+"]");
		SingleRulCases_dataset.setValue("opinion",SingleRulCases_dataset.getValue("casesConclusion"));
	}
	//申请归档提交后刷新页面
	function btFiling_postSubmit(button){
		button.url="#";
		top.easyMsg.info("保存成功！");
		subwindow_SingleRulCasesFW.close();
		flushCurrentPage();
	}
	//退回检查事件
	function btBack_onClickCheck(button){
		SingleRulCases_dataset.setFieldRequired("followupFlag",false);
		var opinion=SingleRulCases_dataset.getValue("opinion");
		if(opinion==null || opinion==""){
			top.easyMsg.info("退回请埴写审核意见！");
			return false;
		}
		SingleRulCases_dataset.setParameter("op","back");
	}
	//退回后刷新页面
	function btBack_postSubmit(button){
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_SingleRulCasesFW.close();
		flushCurrentPage();
	}
	//关闭
	function btClose_onClick(button){
		subwindow_SingleRulCasesFW.close();
	}
	//刷新当前页
	function flushCurrentPage(){
		SingleRulCases_dataset.flushData(SingleRulCases_dataset.pageIndex);
	}
	function taskApprovalHistoryTable_onDbClick(){
		btnOpinion_onClick();
	}
	//查看意见
	function btnOpinion_onClick(button){
		var id = TaskApprovalHistory_dataset.getValue("taskName");
		if (id.length > 0)
			subwindow_taskApprovalHistoryFW.show();
		else
			top.easyMsg.info("未选择历史意见");
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/InveRelWarning.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>