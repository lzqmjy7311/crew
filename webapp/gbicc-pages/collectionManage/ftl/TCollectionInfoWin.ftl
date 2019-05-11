<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign id=RequestParameters["id"]?default("")>
<@CommonQueryMacro.page title="���չ���  &gt;  �ҵ�����">

<@CommonQueryMacro.CommonQuery id="TCollectionInfo" init="true" submitMode="current">
		
		<@CommonQueryMacro.GroupBox id="box1" label="�˻��������">
			<@CommonQueryMacro.Group id="group1" label="" colNm=4
			fieldStr="loanAccount,custCode,custName,productName,guarWay,loanBalance,acctStatus,riskStatus,provideDate,matureDate,operatorNam,operBankNam"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box2" label="�������">
			<@CommonQueryMacro.Group id="group2" label="" colNm=4
			fieldStr="earliestOverDate,arrearCount,arrearAmt,arrearInterests"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box4" label="���δ������">
			<@CommonQueryMacro.Group id="group4" label="" colNm=4
			fieldStr="taskCount,credited,tel,collectionType,arrearReason,situationExplain,receiptInfo,resultInfo,controlMeasure,controlMeasureOth,remark,exprctReturnDate,collePersonName,colleDate,registDate"/>
		</@CommonQueryMacro.GroupBox>
		<@CommonQueryMacro.GroupBox id="box5" label="������ע">
			<@CommonQueryMacro.Group id="group5" label="" colNm=4
			fieldStr="opinion"/>
		</@CommonQueryMacro.GroupBox>
		
		
		
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="TCollectionInfoHis" init="false" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="������ʷ">
						<@CommonQueryMacro.DataTable id="TCollectionInfoHisTable" paginationbar="btnOpinion"
						fieldStr="taskCount,credited,postLoanPer,collePersonName,collectionType,exprctReturnDate,colleDate,registDate" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="TCollectionInfoHisFW" modal="true" label="" position="center" width="800"
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="TCollectionInfoHisGroup" label="��������" colNm=4 fieldStr="taskCount,credited,postLoanPer,collePersonName,collectionType,exprctReturnDate,colleDate,registDate,arrearReason,situationExplain,receiptInfo,resultInfo"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
		</@CommonQueryMacro.CommonQuery>
		
		<@CommonQueryMacro.CommonQuery id="TCollectionInfo" init="true" submitMode="current">
			<center>
			<@CommonQueryMacro.Button id= "btnSubmit" />
			<@CommonQueryMacro.Button id= "btnSave" />
			<@CommonQueryMacro.Button id= "btnSubmitTrue" />
			<span name="btnHid">
			<@CommonQueryMacro.Button id= "btnBack" />
			</span>
			</center>
		</@CommonQueryMacro.CommonQuery>
		
		<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="������ʷ">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="�鿴���" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
		</@CommonQueryMacro.CommonQuery>
		

<script language="JavaScript">
var roleName="";
function initCallGetter_post(dataset) {
	$("a[id=btnSubmitTrue]").hide();
	var businessId='${id}';
	TaskVariable.findTaskVariable(businessId,function(y){
		roleName=y.nowRoleName;
		if(y.nowRoleName=="ejzhhz"){
			setPageReadOnlyFun()
		}else{
			btnBack.disable(true);
			$("span[name=btnHid]").hide();
			$("fieldset[name=box5]").hide();
		}
		
	});
	
	TCollectionInfoHis_dataset.setValue("loanAccount",TCollectionInfo_dataset.getValue("loanAccount"));
	TCollectionInfoHis_dataset.flushData(TCollectionInfoHis_dataset.pageIndex);
	var controlMeasure=TCollectionInfo_dataset.getValue("controlMeasure");
	if(controlMeasure){
		if(controlMeasure.indexOf("SS")>-1){
			TCollectionInfo_dataset.setFieldHidden("controlMeasureOth",false);
		}else{
			TCollectionInfo_dataset.setFieldHidden("controlMeasureOth",true);
		}
	}else{
		TCollectionInfo_dataset.setFieldHidden("controlMeasureOth",true);
	}
	
}

//����ҳ�������ֶ�ֻ��
function setPageReadOnlyFun(){
	var fieldName="";
	for(var i=0;i<TCollectionInfo_dataset.fields.length;i++){
		fieldName=TCollectionInfo_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCollectionInfo_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	TCollectionInfo_dataset.setFieldReadOnly("opinion",false);
}
function TCollectionInfo_dataset_onSetValue(ds,curretField,val){
	if((curretField.name=="controlmeasure"||curretField.name=="controlmeasurename")){
		if(val.indexOf("SS")>-1){
			TCollectionInfo_dataset.setFieldHidden("controlMeasureOth",false);
		}else{
			TCollectionInfo_dataset.setFieldHidden("controlMeasureOth",true);
		}
	}
	return val;
}
function btnBack_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("�����ɹ���");
	window.parent.TCollectionInfo_dataset.flushData(window.parent.TCollectionInfo_dataset.pageIndex);
	window.parent.tCollectionInfoWin.close();
}
function btnBack_onClickCheck(button){
	TCollectionInfo_dataset.setParameter("op","back");
}
function btnSave_onClickCheck(button){
	/*
	var exprctReturnDate=TCollectionInfo_dataset.getValue("exprctReturnDate");
	var nowDate=new Date();
	alert(nowDate);
	alert(exprctReturnDate);
	if(exprctReturnDate>=nowDate){
		alert("yes");
	}else{
		alert("no");
	}
	*/
	return true;
}
//�����ر�ҳ�棬ˢ�±���
function btnSave_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("����ɹ���");
	if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	if(window && window.parent){
		window.parent.tCollectionInfoWin.close();
	}
	//window.parent.tCollectionInfoWin.close();
	//window.parent.TCollectionInfo_dataset.flushData(window.parent.TCollectionInfo_dataset.pageIndex);
	//window.parent.tCollectionInfoWin.close();
	
}

//�ύ��ť�����¼�
function btnSubmit_onClick(button){
	if(roleName=="ejzhhz"){
		var opinion=TCollectionInfo_dataset.getValue("opinion");
		if(opinion){
			
		}else if(opinion=="" || opinion==null){
			top.easyMsg.info("����������");
			return false;
		}else{
			top.easyMsg.info("����������");
			return false;
		}
	}
	var orgId=user_info.orgId;
	var roleId="";
	var businessId='${id}';
	TaskVariable.findTaskVariable(businessId,function(y){
		if(y && y.nextRole){//��ȡ����ɫID�򿪴��ڡ�
			submitWindow=openSubWin("submitWindow","��������","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+y.nextRole,"600","400");
		}else{//��ȡ������ֱ���ύ
			btnSubmitTrue.click();
		}
	});
}
function submitFun(taskAssignee){
	TCollectionInfo_dataset.setParameter("taskAssignee",taskAssignee);
	btnSubmitTrue.click();
}
function btnSubmitTrue_onClickCheck(button){
	TCollectionInfo_dataset.setParameter("op","submit");
}
function btnSubmitTrue_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("�ύ�ɹ���");
	if(parent.parent.GTab){
			parent.parent.GTab.closeTab();
		}
	if(window && window.parent){
		window.parent.tCollectionInfoWin.close();
	}
	//if(window.parent.tCollectionInfoWin){
	//	window.parent.TCollectionInfo_dataset.flushData(window.parent.TCollectionInfo_dataset.pageIndex);
	//	window.parent.tCollectionInfoWin.close();
	//}
	//if(parent.parent.GTab){parent.parent.GTab.closeTab('TCollectionInfoWin');}
	
}
//�鿴����
function btnOpinion_onClick(button){
	var id = TCollectionInfoHis_dataset.getValue("id");
	if(id){
		subwindow_TCollectionInfoHisFW.show();
	}else{
		top.easyMsg.info("��ѡ��һ����¼��");
		return;
	}
}
//�鿴���
function btnOpinion_onClick(button){
	subwindow_taskApprovalHistoryFW.show();
}

function btCancel_onClickCheck(button){
	window.parent.tCollectionInfoWin.close();
 }  
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>