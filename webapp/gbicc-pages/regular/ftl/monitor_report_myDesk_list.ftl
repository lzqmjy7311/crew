<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="��ҳ">
	<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
	<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
	<@CommonQueryMacro.CommonQuery id="MonitorReportList" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable  id="monitorReportTable" readonly="true" paginationbar="btHandle,moreHandle" 
		fieldStr="warnLevel[80],loanAcct[165],custName[120],loanVariety[150],loanAmt[120],loanBalance[120],loanTerm[80],rptStatus[90],taskType[90],taskCreatDate[90],taskMatureDate[90],handler[70],ifTimeout[15]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	
	<br/>
	<@CommonQueryMacro.CommonQuery id="TCollectionInfo" init="true" submitMode="current">
			<@CommonQueryMacro.DataTable id="datatable1"  title="<h2>��������</h2>" nowrap="true" readonly="true" paginationbar="registInfoBtn"
			fieldStr="loanAccount[120],custCode[100],custName[60],productName[140],riskStatus[70],loanBalance[70],arrearAmt[70],arrearInterests[70],arrearCount[80],matureDate[90],collectionType[140],status[60]"  width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	
<script type="text/javascript">
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('ajMonitorReportWin',"�ҵĴ�������",'/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?flag=desk&type=todoTask');
	}
	var ajMonitorReportWin;
	function ajMonitorReportWin_close(){
		ajMonitorReportWin.close();
		MonitorReportList_dataset.flushData(MonitorReportList_dataset.pageIndex);
	}
	
	function monitorReportTable_onDbClick(){
		btHandle_onClick();
	}
	
	function btHandle_onClick(button) {
		var businessId=MonitorReportList_dataset.getValue("id");
		var rptStatus=MonitorReportList_dataset.getValue("rptStatus");
		var custName=MonitorReportList_dataset.getValue("custName");
		var loanAcct=MonitorReportList_dataset.getValue("loanAcct");
		var reportUrl=MonitorReportList_dataset.getValue("reportUrl");
		var taskType=MonitorReportList_dataset.getValue("taskType");

		var title="������";
		
		if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="��д���ڼ�ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.DQ&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="��˶��ڼ�ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.back){
			title="���ڼ�ر��汻�˻�("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.wait_examine){
			title="��鶨�ڼ�ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.approve_pass){
			title="���ڼ�ر������ͨ��������д��ʩ���ʱ��("+custName+"��"+loanAcct+"��)";
		}
		else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="��дԤ�����ñ���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YJ&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="���Ԥ�����ñ���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.back){
			title="Ԥ�����ñ��汻�˻�("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.wait_examine){
			title="���Ԥ�����ñ���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.approve_pass){
			title="Ԥ�����ñ������ͨ��������д��ʩ���ʱ��("+custName+"��"+loanAcct+"��)";
		}
		else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="��д��С�ڸ�����("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.RF&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="�����С�ڸ�����("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.back){
			title="��С�ڸ����汻�˻�("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.wait_examine){
			title="�����С�ڸ�����("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.approve_pass){
			title="��С�ڸ��������ͨ��������д��ʩ���ʱ��("+custName+"��"+loanAcct+"��)";
		}
		
		else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="��д��;��ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YT&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="�����;��ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.back){
			title="��;��ر��汻�˻�("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.wait_examine){
			title="�������;��ر���("+custName+"��"+loanAcct+"��)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.approve_pass){
			title="��;��ر������ͨ��������д��ʩ���ʱ��("+custName+"��"+loanAcct+"��)";
		}
		parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus);
	}
	
	
	//��λһ�м�¼
	function locate(id) {
		var record = TCollectionInfo_dataset.find(["id"],[id]);
		if(record) {
			TCollectionInfo_dataset.setRecord(record);
		}
	}
	
	 function btCancel_onClickCheck(button){
	     jobschedulermanage_dataset.cancelRecord();
	     subwindow_detailFW.close();
	  }  
	var tCollectionInfoWin;
	var tCollectionInfoCheckWin;
	function registInfoBtn_onClick(button) {
		var businessId=TCollectionInfo_dataset.getValue("id");
		if(businessId){
			TaskVariable.findTaskVariable(businessId,function(y){
				var title="���";
					var custName=TCollectionInfo_dataset.getValue("custName");
					var loanAccount=TCollectionInfo_dataset.getValue("loanAccount");
				if(y.nowRoleName=="ejzhhz"){
					title="���";
					//tCollectionInfoCheckWin=openSubWin("TCollectionInfoCheckWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoCheckWin.ftl?id="+businessId,"1000","700");
//					tCollectionInfoWin=openSubWin("TCollectionInfoWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?id="+businessId+"&businessId="+businessId,"1000","700");
					parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?id="+businessId+"&businessId="+businessId);
				}else{
					title="���յǼ�";
//					tCollectionInfoWin=openSubWin("TCollectionInfoWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?queryType=registBtn&id="+businessId+"&businessId="+businessId,"1000","700");
					parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?queryType=registBtn&id="+businessId+"&businessId="+businessId);
				}
				
			});
		}else{
			top.easyMsg.info("��ѡ��һ�У�");
		}
	}
	function datatable1_onDbClick(){
		registInfoBtn.click();
	}

	function checkBtn_onClick(button) {
		
		var businessId=TCollectionInfo_dataset.getValue("id");
		var custName=TCollectionInfo_dataset.getValue("custName");
		var title="���";
		//tCollectionInfoCheckWin=openSubWin("TCollectionInfoWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoCheckWin.ftl?id="+businessId,"1000","700");
		parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?id="+businessId+"&businessId="+businessId);
	}
	
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TCollectionInfo_dataset.flushData(TCollectionInfo_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>