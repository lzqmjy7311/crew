<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="催收管理  &gt;  审核">

<@CommonQueryMacro.CommonQuery id="TCollectionInfo" init="true" submitMode="current">
		<@CommonQueryMacro.GroupBox id="box1" label="账户基本情况">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanAccount,custCode,custName,productName,guarWay,loanBalance,acctStatus,riskStatus,provideDate,matureDate,operator,operBank"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box2" label="逾期情况">
			<@CommonQueryMacro.Group id="group2" label="" colNm=4
			fieldStr="earliestOverDate,arrearCount,arrearAmt,arrearInterests"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box4" label="本次催收情况">
			<@CommonQueryMacro.Group id="group4" label="" colNm=4
			fieldStr="taskCount,credited,tel,collectionType,arrearReason,situationExplain,receiptInfo,resultInfo,controlMeasure,controlMeasureOth,remark,exprctReturnDate,collePersonName,colleDate,registDate"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box5" label="审批备注">
			<@CommonQueryMacro.Group id="group5" label="" colNm=4
			fieldStr="opinion"/>
		</@CommonQueryMacro.GroupBox>
		<center>
		<@CommonQueryMacro.Button id= "btnSubmit" />
		<@CommonQueryMacro.Button id= "btnBack" />
		</center>
		<@CommonQueryMacro.CommonQuery id="TCollectionInfoHis" init="false" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar=""
						fieldStr="loanAccount,custCode,custName,productName,acctStatus,riskStatus,loanBalance,arrearAmt,arrearInterests,arrearCount,postLoanPer,matureDate,collectionType" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="loanAccount,custCode,custName,productName,acctStatus,riskStatus,loanBalance,arrearAmt,arrearInterests,arrearCount,postLoanPer,matureDate,collectionType"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
		</@CommonQueryMacro.CommonQuery>
	</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function initCallGetter_post(dataset) {
	/*
	TCollectionInfo_dataset.setFieldReadOnly("collectionType",true);
	TCollectionInfo_dataset.setFieldReadOnly("situationExplain",true);
	TCollectionInfo_dataset.setFieldReadOnly("receiptInfo",true);
	TCollectionInfo_dataset.setFieldReadOnly("resultInfo",true);
	TCollectionInfo_dataset.setFieldReadOnly("colleDate",true);
	TCollectionInfo_dataset.setFieldReadOnly("registDate",true);
	TCollectionInfo_dataset.setFieldReadOnly("controlMeasure",true);
	TCollectionInfo_dataset.setFieldReadOnly("remark",true);
	*/
}




//保存后关闭页面，刷新表格
function btnSubmit_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("操作成功！");
	window.parent.TCollectionInfo_dataset.flushData(window.parent.TCollectionInfo_dataset.pageIndex);
	window.parent.tCollectionInfoCheckWin.close();
}
function btnBack_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("操作成功！");
	window.parent.TCollectionInfo_dataset.flushData(window.parent.TCollectionInfo_dataset.pageIndex);
	window.parent.tCollectionInfoCheckWin.close();
}
function btnBack_onClickCheck(button){
	TCollectionInfo_dataset.setParameter("op","back");
}
function btnSubmit_onClickCheck(button){
	TCollectionInfo_dataset.setParameter("op","next");
}

</script>
</@CommonQueryMacro.page>