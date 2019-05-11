<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign businessId=RequestParameters["businessId"]?default("")>

<@CommonQueryMacro.page title="单规则预警处理">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="SingleRulWarning" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="SingleRulWarningGroup" label="" colNm=4 labelwidth="150"
				fieldStr="fcettypecode,fcetname,rulCode,rulType,warnStatus,rulName,warnDt,mainOrg,warnDesc,eliminateDesc,opinion"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DynamicTabSet id="BusinInfoTab" hasMenu="false" fit="false" height="350" selected="A01">
		    </@CommonQueryMacro.DynamicTabSet>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
				<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史" expand="false">
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
			<@CommonQueryMacro.CommonQuery id="SingleRulWarning" init="true" mode="1" submitMode="current">
				<center>
					<span style="margin-right:-250px">
					<@CommonQueryMacro.Button id="btAddCases" />
					<@CommonQueryMacro.Button id="btJoinCases" />
					<@CommonQueryMacro.Button id="btRiskElim" />
					<@CommonQueryMacro.Button id="btnAgree" />
					<@CommonQueryMacro.Button id="btnBack" /></span>
					<span style="float:right;padding:7px 0 0  0;">
					<a id="readFinaAnal" onclick="readFinaAnal_onClick()" href="javascript:void(0)">查看财务分析</a>
					<a id="readFinaInte" onclick="readFinaInte_onClick()" href="javascript:void(0)">查看财务诚信</a>
					<a id="readFundMoni" onclick="readFundMoni_onClick()" href="javascript:void(0)">查看资金流向监控</a>
					</span>
				</center>
				<@CommonQueryMacro.FloatWindow id="RiskEliminateFW" modal="true" label="风险排除" 
				resize="true" minimize="false" width="700" height="320" maximize="true" closure="true" show="false" defaultZoom="normal">
					<@CommonQueryMacro.Group id="RiskEliminateGroup" label="" colNm=2 labelwidth="250"
					fieldStr="rulCode,rulType,rulDesc,rulName,eliminateDesc"/>
					<center>
					<@CommonQueryMacro.Button id="btnSubmit" />
					<@CommonQueryMacro.Button id="warnTaskSubmit" />
					<@CommonQueryMacro.Button id="btCancel" />
				</center>
				</@CommonQueryMacro.FloatWindow>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script>
	var submitWindow=null;
	function readFinaAnal_onClick(){
		var customerNum =SingleRulWarning_dataset.getValue("fcettypecode");
		var chineseName =SingleRulWarning_dataset.getValue("fcetname");
		var paramMap=new Map();
		paramMap.put("customerNum",customerNum);
		paramMap.put("chineseName",chineseName);
		windows = openSubWin("warninfoWin", "财务分析\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName, "/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum+"&chineseName="+chineseName,"1150","600",false,true,windows_close,true);
		//btHandle.disable(true);
	}
	function readFinaInte_onClick(){
		var customerNum =SingleRulWarning_dataset.getValue("fcettypecode");
		var chineseName =SingleRulWarning_dataset.getValue("fcetname");
		var industryCd =SingleRulWarning_dataset.getValue("pbcIndustryCd");
		windows = openSubWin("warninfoWin", "财务诚信度\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName,"/gbicc-com-pages/financialIndexAnalsis/ftl/financialIndexAnalsis.ftl?customerNum="+customerNum+"&industryCd="+industryCd,"1150","600",false,true,windows_close,true);
	}
	function readFundMoni_onClick(){
		var customerNum =SingleRulWarning_dataset.getValue("fcettypecode");
		windows = openSubWin('1',"账户帐页","/gbicc-com-pages/accountpage/ftl/TAccountPage.ftl"+"?customerNum="+customerNum,"1200","700");
	}
	function windows_close(){
		//btHandle.disable(false);
	}
	//页面初始化
	function initCallGetter_post(){
		$("a[id=warnTaskSubmit]").hide();
		var businessId='${businessId}';
		SingleRulWarning_dataset.setParameter("id",businessId);
		SingleRulWarning_dataset.flushData(SingleRulWarning_dataset.pageIndex);
		
		var handleOrgFlag=SingleRulWarning_dataset.getValue("handleOrgFlag");
		if(handleOrgFlag=="head"){
			$("a[id=readFundMoni]").show();
		}else{
			$("a[id=readFundMoni]").hide();
		}
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
		//添加输出TAB页
		var OUTPUT={
			A01:{id:"A01",title:"帐务交易流水",url:"/gbicc-com-pages/single/output_ftl/a01.ftl?warningId="+businessId},
			A30:{id:"A30",title:"查冻扣登记簿",url:"/gbicc-com-pages/single/output_ftl/a30.ftl?warningId="+businessId},
			A38:{id:"A38",title:"承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/a38.ftl?warningId="+businessId},
			B01:{id:"B01",title:"自然人借据信息",url:"/gbicc-com-pages/single/output_ftl/b01.ftl?warningId="+businessId},
			C01:{id:"C01",title:"对公贷款借据明细",url:"/gbicc-com-pages/single/output_ftl/c01.ftl?warningId="+businessId},
			C02:{id:"C02",title:"对公贷款还款明细",url:"/gbicc-com-pages/single/output_ftl/c02.ftl?warningId="+businessId},
			C03:{id:"C03",title:"信贷合同",url:"/gbicc-com-pages/single/output_ftl/c03.ftl?warningId="+businessId},
			C05:{id:"C05",title:"对公贴现登记簿",url:"/gbicc-com-pages/single/output_ftl/c05.ftl?warningId="+businessId},
			C06:{id:"C06",title:"信贷支用申请明细",url:"/gbicc-com-pages/single/output_ftl/c06.ftl?warningId="+businessId},
			C08:{id:"C08",title:"对公抵质押物出入库操作流水",url:"/gbicc-com-pages/single/output_ftl/c08.ftl?warningId="+businessId},
			C09:{id:"C09",title:"票据信息",url:"/gbicc-com-pages/single/output_ftl/c09.ftl?warningId="+businessId},
			C11:{id:"C11",title:"跟单背书信息",url:"/gbicc-com-pages/single/output_ftl/c11.ftl?warningId="+businessId},
			C12:{id:"C12",title:"电子票据流转信息",url:"/gbicc-com-pages/single/output_ftl/c12.ftl?warningId="+businessId},
			C13:{id:"C13",title:"关联人信息",url:"/gbicc-com-pages/single/output_ftl/c13.ftl?warningId="+businessId},
			C14:{id:"C14",title:"担保圈信息",url:"/gbicc-com-pages/single/output_ftl/c14.ftl?warningId="+businessId},
			C15:{id:"C15",title:"客户指标信息",url:"/gbicc-com-pages/single/output_ftl/c15.ftl?warningId="+businessId},
			C16:{id:"C16",title:"自然人账户信息",url:"/gbicc-com-pages/single/output_ftl/c16.ftl?warningId="+businessId},
			J02:{id:"J02",title:"对公客户信息",url:"/gbicc-com-pages/single/output_ftl/j02.ftl?warningId="+businessId},
			J04:{id:"J04",title:"对私客户信息",url:"/gbicc-com-pages/single/output_ftl/j04.ftl?warningId="+businessId},
			J09:{id:"J09",title:"员工信息",url:"/gbicc-com-pages/single/output_ftl/j09.ftl?warningId="+businessId},
			J16:{id:"J16",title:"理财账户信息",url:"/gbicc-com-pages/single/output_ftl/j16.ftl?warningId="+businessId},
			J17:{id:"J17",title:"从合同信息",url:"/gbicc-com-pages/single/output_ftl/j17.ftl?warningId="+businessId},
			J18:{id:"J18",title:"信贷公司客户信息",url:"/gbicc-com-pages/single/output_ftl/j18.ftl?warningId="+businessId},
			L01:{id:"L01",title:"外部工商信息",url:"/gbicc-com-pages/single/output_ftl/l01.ftl?warningId="+businessId},
			L02:{id:"L02",title:"工商变更明细",url:"/gbicc-com-pages/single/output_ftl/l02.ftl?warningId="+businessId},
			L03:{id:"L03",title:"工商处罚明细",url:"/gbicc-com-pages/single/output_ftl/l03.ftl?warningId="+businessId},
			L04:{id:"L04",title:"开庭公告信息",url:"/gbicc-com-pages/single/output_ftl/l04.ftl?warningId="+businessId},
			L05:{id:"L05",title:"判决文书信息",url:"/gbicc-com-pages/single/output_ftl/l05.ftl?warningId="+businessId},
			L11:{id:"L11",title:"企业征信信息",url:"/gbicc-com-pages/single/output_ftl/l11.ftl?warningId="+businessId},
			L12:{id:"L12",title:"个人征信信息",url:"/gbicc-com-pages/single/output_ftl/l12.ftl?warningId="+businessId},
			L13:{id:"L13",title:"征信文件信息",url:"/gbicc-com-pages/single/output_ftl/l13.ftl?warningId="+businessId},
			L14:{id:"L14",title:"黑名单信息",url:"/gbicc-com-pages/single/output_ftl/l14.ftl?warningId="+businessId},
			L15:{id:"L15",title:"高能耗信息",url:"/gbicc-com-pages/single/output_ftl/l15.ftl?warningId="+businessId},
			L16:{id:"L16",title:"企业征信未结清贷款信息",url:"/gbicc-com-pages/single/output_ftl/l16.ftl?warningId="+businessId},
			L17:{id:"L17",title:"企业征信未结清承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/l17.ftl?warningId="+businessId}
		}
		var halfresult=SingleRulWarning_dataset.getValue("halfresult");
		if(halfresult!=null && halfresult!=""){
			var ids=halfresult.split("|");
			for(var i=0;i<ids.length;i++){
				if(ids[i] && OUTPUT[ids[i]]!=null){
					BusinInfoTab_tabset.add(OUTPUT[ids[i]]);
				}
			}
		}
		
		//查找流程图每一节点变量，初始化页面
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
				$("a[id=btAddCases]").hide();
				$("a[id=btJoinCases]").hide();
				$("a[id=btRiskElim]").hide();
				$("#SingleRulWarningFW").css("height","650px");
				$("#editor_eliminateDesc").css("width","722px");
				$("a[id=btnAgree]").show();
				$("a[id=btnBack]").show();
				SingleRulWarning_dataset.setFieldHidden("eliminateDesc",false);
				SingleRulWarning_dataset.setFieldHidden("opinion",false);
				SingleRulWarning_dataset.setFieldReadOnly("eliminateDesc",true);
			}else{
				$("a[id=btAddCases]").show();
				$("a[id=btJoinCases]").show();
				$("a[id=btRiskElim]").show();
				$("a[id=btnAgree]").hide();
				$("a[id=btnBack]").hide();
				SingleRulWarning_dataset.setFieldHidden("eliminateDesc",true);
				SingleRulWarning_dataset.setFieldHidden("opinion",true);
			}
		})
	}
	var casesWin=null;
	function casesWin_close(){
		casesWin.close();
	}
	function caseWin_and_parWin_close(){
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	}
	//新增案例
	function btAddCases_onClick(){
		var warningId=SingleRulWarning_dataset.getValue("id");
		casesWin=openSubWin("casesWin","新增案例","/gbicc-com-pages/single/ftl/single_rul_cases_add.ftl?warningId="+warningId,"950","300");
	}
	//归入案例
	function btJoinCases_onClick(){
		var warningId=SingleRulWarning_dataset.getValue("id");
		casesWin=openSubWin("casesWin","归入案例","/gbicc-com-pages/single/ftl/single_rul_cases_join.ftl?warningId="+warningId,"950","350");
	}
	//风险排除
	function btRiskElim_onClick(){
		subwindow_RiskEliminateFW.show();
	}
	//提交检查事件
	function btnSubmit_onClickCheck(button){
		var op="riskEliminate";
		var eliminateDesc=SingleRulWarning_dataset.getValue("eliminateDesc");
		if(!eliminateDesc){
			top.easyMsg.info("请填写排除说明！");
			return false;
		}
		//subwindow_RiskEliminateCheckerFW.show();
		//submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-com-pages/single/ftl/single_rul_warning_eliminate_checker.ftl","600","400");
		SingleRulWarning_dataset.setParameter("op",op);
		var orgId=user_info.orgId;
		var roleId="";
		var businessId='${businessId}';
		
		if("00001"==orgId){
			roleId="559";
		}else{
			roleId="561";
		}
		submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+roleId,"600","400");
	}
	//退回检查事件
	function btnBack_onClickCheck(button){
		var op="back";
		SingleRulWarning_dataset.setParameter("op",op);
	}
	//同意检查事件
	function btnAgree_onClickCheck(button){
		var op="agree";
		SingleRulWarning_dataset.setParameter("op",op);
	}
	//取消
	function btCancel_onClick(){
		subwindow_RiskEliminateFW.close();
	}
//	function readFinaAnal_onClick(){
//		top.easyMsg.info("暂无此功能！");
//	}
//	function readFinaInte_onClick(){
//		top.easyMsg.info("暂无此功能！");
//	}
//	function readFundMoni_onClick(){
//		top.easyMsg.info("暂无此功能！");
//	}
	//提交后关闭页面，刷新表格
	function btnSubmit_postSubmit(button) {
		button.url="#";
		//top.easyMsg.info("操作成功！");
		subwindow_RiskEliminateFW.close();
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	}
	//退回后关闭页面，刷新表格
	function btnBack_postSubmit(button){
		button.url="#";
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	}
	//同意后关闭页面，刷新表格
	function btnAgree_postSubmit(button){
		button.url="#";
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	}
	//刷新当前页
	function flushCurrentPage() {
		SingleRulWarning_dataset.flushData(SingleRulWarning_dataset.pageIndex);
	}
	function taskApprovalHistoryTable_onDbClick(){
		btnOpinion_onClick();
	}
	//查看意见
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
	function cancelFun(){
		submitWindow.close();
	}
	function submitFun(userId){
		SingleRulWarning_dataset.setParameter("userId",userId);
		warnTaskSubmit.click();
	}
	function warnTaskSubmit_postSubmit(){
		submitWindow.close();
		subwindow_RiskEliminateFW.show();
		top.easyMsg.info("操作成功！");
		if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>