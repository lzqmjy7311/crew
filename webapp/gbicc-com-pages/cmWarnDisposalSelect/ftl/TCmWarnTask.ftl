<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="预警处置  &gt;  我的任务">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnTaskSelect" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" showButton="false" colNm="8" />
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:5px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" frozens="10"  height="555" paginationbar="btHandle" width="100%" hasFrame="true"  pageCache="false" remoteSort="true" sortable="true"
			fieldStr="taskCode[120],taskType[80],custcode[100],custname[250],warnCunt[70],status[100],startType[100],inspectorsNam[100],taskOverran[70],taskCreatDate[100],taskMatureDate[100]" />
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
var warnDisposalWin;
function warnDisposalWin_close(){
	warnDisposalWin.close();
	TCmWarnTaskSelect_dataset.flushData(TCmWarnTaskSelect_dataset.pageIndex);
}
function datatable1_onDbClick(){
	btHandle.click();
}
function btHandle_onClick(button) {
	var taskId=TCmWarnTaskSelect_dataset.getValue("id");
	if(taskId){
		var customerId=TCmWarnTaskSelect_dataset.getValue("customerId");
		var taskType=TCmWarnTaskSelect_dataset.getValue("taskType");
		var rptStatus=TCmWarnTaskSelect_dataset.getValue("status");
		var startType=TCmWarnTaskSelect_dataset.getValue("startType");
		var title="查看";
		var path="/gbicc-com-pages/cmWarnDisposalSelect/ftl/warnDisposalWin.ftl";
		if(startType=="1"){//如果发发起类型为手工
			path="/gbicc-com-pages/cmWarnDisposalSelect/ftl/personWarnDisposalWin.ftl";
		}
	    warnDisposalWin=openSubWin("warnDisposalWin",title,path+"?taskId="+taskId+"&customerId="+customerId+"&businessId="+taskId+"&selectType=selectAll","1000","700");
	}else{
		top.easyMsg.info("请选择一条数据！");
		return false;
	}
}
function btnReset_onClick(){
	TCmWarnTaskSelect_interface_dataset.clearData();
}
</script>
</@CommonQueryMacro.page>