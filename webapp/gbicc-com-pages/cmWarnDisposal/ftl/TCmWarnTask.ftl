<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="预警处置  &gt;  我的任务">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" showButton="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<#assign roleId = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getWorkflowRoleId()>
		<td colspan="2">
	 	<#if (roleId == "601")>
			<@CommonQueryMacro.DataTable  frozens="20" id="datatable1" paginationbar="btHandle,perStartDC,perStartRC" fieldStr="taskCode[100],taskType[70],custcode[100],custname[200],warnCunt[70],status[70],taskCreatDate[100],taskMatureDate[100],startType[80],taskOverran[70]"  width="100%" hasFrame="true"/>
		<#else>
			<@CommonQueryMacro.DataTable  frozens="20" id="datatable1" paginationbar="btHandle" fieldStr="taskCode[100],taskType[70],custcode[100],custname[200],warnCunt[70],status[70],taskCreatDate[100],taskMatureDate[100],startType[80],taskOverran[70]"  width="100%" hasFrame="true"/>
		</#if>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
  		</td>
  	</tr>
  		
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
//重置查询条件
function btnReset_onClick(button){
	TCmWarnTask_interface_dataset.clearData();
}
var warnDisposalWin;
function warnDisposalWin_close(){
	warnDisposalWin.close();
	TCmWarnTask_dataset.flushData(TCmWarnTask_dataset.pageIndex);
}


function datatable1_onDbClick(){
	btHandle.click();
}

function btHandle_onClick(button) {
	var taskId=TCmWarnTask_dataset.getValue("id");
	if(taskId){
		var customerId=TCmWarnTask_dataset.getValue("customerId");
		var taskType=TCmWarnTask_dataset.getValue("taskType");
		var rptStatus=TCmWarnTask_dataset.getValue("status");
		var startType=TCmWarnTask_dataset.getValue("startType");
		var title="任务处理";
		if(taskType=="RC"){
			title=title+"【处置反馈】";
		}else{
			title="【预警处置】";
		}
		if(rptStatus=="1"||rptStatus=="2"){//审核
			title=title+">【审核】";
		}else if(rptStatus=="3"){
			title=title+">【审核确认】";
		}
		var path="/gbicc-com-pages/cmWarnDisposal/ftl/warnDisposalWin.ftl";
		if(startType=="1"){//如果发发起类型为手工
			path="/gbicc-com-pages/cmWarnDisposal/ftl/personWarnDisposalWin.ftl";
		}
	    warnDisposalWin=openSubWin("warnDisposalWin",title,path+"?taskId="+taskId+"&customerId="+customerId+"&businessId="+taskId,"1000","700");
	}else{
		top.easyMsg.info("请选择一条数据！");
		return false;
	}
}

var selectCustomerWin;
function perStartDC_onClick(button) {
	selectCustomerWin=openSubWin("selectCustomerWin","人工发起预警》预警客户","/gbicc-com-pages/cmWarnDisposal/ftl/TCmCustomer.ftl","1000","500");
}
function selectCustomerWin_close(){
	selectCustomerWin.close();
}

var selectWarnTaskWin;
function perStartRC_onClick(button) {
	selectWarnTaskWin=openSubWin("selectWarnTaskWin","人工发起处置反馈》可发起任务","/gbicc-com-pages/cmWarnDisposal/ftl/TCmWarnTaskReport.ftl?selectType=TCmWarnTaskReport","1000","500");
}
function selectWarnTaskWin_close(){
	selectWarnTaskWin.close();
}
	
</script>
</@CommonQueryMacro.page>