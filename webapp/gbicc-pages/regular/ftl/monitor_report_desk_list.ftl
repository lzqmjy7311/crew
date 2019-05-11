<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign type=RequestParameters["type"]?default("")>

<@CommonQueryMacro.page title="���̹���  &gt;  �������">
	<@CommonQueryMacro.CommonQuery id="MonitorReportDestList" init="true" submitMode="current">
		<table>
		<tr><td>
		<@CommonQueryMacro.Interface id="qalityquery" label="��ѯ" colNm=6  showButton="false"/>
		</td></tr>
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
				</div>
			</td>
		</tr>
		
		<tr>
		<td><@CommonQueryMacro.DataTable  id="monitorReportTable" paginationbar="btHandle" readonly="true" 
		fieldStr="warnLevel[80],loanAcct[180],custName,loanVariety[150],loanAmt,loanBalance,loanTerm,rptStatus,taskType,taskMatureDate,handler,ifTimeout" width="100%" hasFrame="true"/>
		</td></tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
<script type="text/javascript">
	var ajMonitorReportWin;
	//ҳ���ʼ��
	function btnReset_onClick(button){
		MonitorReportDestList_interface_dataset.clearData();
	}
	
	function initCallGetter_post(){
		var type='${type}';
		MonitorReportDestList_dataset.setParameter("type",type);
	}
	function ajMonitorReportWin_close(){
		ajMonitorReportWin.close();
		MonitorReportDestList_dataset.flushData(MonitorReportDestList_dataset.pageIndex);
	}
	
	function monitorReportTable_onDbClick(){
		btHandle_onClick();
	}
	
	function btHandle_onClick(button) {
		var businessId=MonitorReportDestList_dataset.getValue("id");
		var rptStatus=MonitorReportDestList_dataset.getValue("rptStatus");
		var custName=MonitorReportDestList_dataset.getValue("custName");
		var loanAcct=MonitorReportDestList_dataset.getValue("loanAcct");
		var reportUrl=MonitorReportDestList_dataset.getValue("reportUrl");
		var taskType=MonitorReportDestList_dataset.getValue("taskType");
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
		var path=reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus;
		var pageReadOnly=MonitorReportDestList_dataset.getValue("pageReadOnly");
		if(rptStatus==REPORT_STATUS.complete||pageReadOnly=='0'){
			path=path+"&pageReadOnly=1";
		}
		
		//parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus);
		 ajMonitorReportWin=openSubWin('ajMonitorReportWin',title,path,"1000","700");
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
</@CommonQueryMacro.page>