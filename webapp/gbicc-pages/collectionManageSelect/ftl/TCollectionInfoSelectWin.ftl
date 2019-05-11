<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign id=RequestParameters["id"]?default("")>
<@CommonQueryMacro.page title="催收管理  &gt;  我的任务">

<@CommonQueryMacro.CommonQuery id="TCollectionInfoSelect" init="true" submitMode="current">
		
		<@CommonQueryMacro.GroupBox id="box1" label="账户基本情况">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanAccount,custCode,custName,productName,guarWay,loanBalance,acctStatus,riskStatus,provideDate,matureDate,operatorNam,operBankNam"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box2" label="逾期情况">
			<@CommonQueryMacro.Group id="group2" label="" colNm=4
			fieldStr="earliestOverDate,arrearCount,arrearAmt,arrearInterests"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box4" label="本次催收情况">
			<@CommonQueryMacro.Group id="group4" label="" colNm=4
			fieldStr="taskCount,credited,tel,collectionType,arrearReason,situationExplain,receiptInfo,resultInfo,controlMeasure,controlMeasureOth,remark,exprctReturnDate,collePersonName,colleDate,registDate"/>
		</@CommonQueryMacro.GroupBox>
		
		
		
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="TCollectionInfoHis" init="false" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="催收历史">
						<@CommonQueryMacro.DataTable id="TCollectionInfoHisTable" paginationbar="btnOpinion"
						fieldStr="taskCount,credited,postLoanPer,collePersonName,collectionType,exprctReturnDate,colleDate,registDate" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="TCollectionInfoHisFW" modal="true" label="" position="center" width="800"
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="TCollectionInfoHisGroup" label="任务详情" colNm=4 fieldStr="taskCount,credited,postLoanPer,collePersonName,collectionType,exprctReturnDate,colleDate,registDate,arrearReason,situationExplain,receiptInfo,resultInfo"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
		</@CommonQueryMacro.CommonQuery>
		
		<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
		</@CommonQueryMacro.CommonQuery>
		
<script language="JavaScript">

function initCallGetter_post(dataset) {
	var businessId='${id}';
	TaskVariable.findTaskVariable(businessId,function(y){
		if(y.nowRoleName=="ejzhhz"){
			setPageReadOnlyFun()
		}
		
	});
	TCollectionInfoHis_dataset.setValue("loanAccount",TCollectionInfoSelect_dataset.getValue("loanAccount"));
	TCollectionInfoHis_dataset.flushData(TCollectionInfoHis_dataset.pageIndex);
	var controlMeasure=TCollectionInfoSelect_dataset.getValue("controlMeasure");
	if(controlMeasure){
		if(controlMeasure.indexOf("SS")>-1){
			TCollectionInfoSelect_dataset.setFieldHidden("controlMeasureOth",false);
		}else{
			TCollectionInfoSelect_dataset.setFieldHidden("controlMeasureOth",true);
		}
	}else{
		TCollectionInfoSelect_dataset.setFieldHidden("controlMeasureOth",true);
	}
	
}

//设置页面所有字段只读
function setPageReadOnlyFun(){
	var fieldName="";
	for(var i=0;i<TCollectionInfoSelect_dataset.fields.length;i++){
		fieldName=TCollectionInfoSelect_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCollectionInfoSelect_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	TCollectionInfoSelect_dataset.setFieldReadOnly("opinion",false);
}
function TCollectionInfoSelect_dataset_onSetValue(ds,curretField,val){
	if((curretField.name=="controlmeasure"||curretField.name=="controlmeasurename")){
		if(val.indexOf("SS")>-1){
			TCollectionInfoSelect_dataset.setFieldHidden("controlMeasureOth",false);
		}else{
			TCollectionInfoSelect_dataset.setFieldHidden("controlMeasureOth",true);
		}
	}
	return val;
}

//查看详情
function btnOpinion_onClick(button){
	var id = TCollectionInfoHis_dataset.getValue("id");
	if(id){
		subwindow_TCollectionInfoHisFW.show();
	}else{
		top.easyMsg.info("请选择一条记录！");
		return;
	}
}
//查看意见
function btnOpinion_onClick(button){
	subwindow_taskApprovalHistoryFW.show();
}

function btCancel_onClickCheck(button){
	window.parent.TCollectionInfoSelectWin.close();
 }  
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>