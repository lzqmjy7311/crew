<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="Ԥ������  &gt;  �ҵ�����">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmWarnTaskRel" init="false" submitMode="current">
<table width="100%">
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" frozens="20" paginationbar="btHandle" fieldStr="taskCode,taskType,warnCunt,status,taskCreatDate,taskMatureDate,taskOverran"  width="100%" hasFrame="true"/>
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
	MonitorReportList_dataset.flushData(MonitorReportList_dataset.pageIndex);
}
function datatable1_onDbClick(){
	btHandle.click();
}
function btHandle_onClick(button) {
	var taskId="id";
	var rptStatus="1";
	var title="Ԥ������";
    warnDisposalWin=openSubWin("warnDisposalWin",title,"/gbicc-com-pages/cmWarnDisposal/ftl/warnDisposalWin.ftl?taskId="+taskId+"&rptStatus="+rptStatus,"1000","700");
}
	
</script>
</@CommonQueryMacro.page>