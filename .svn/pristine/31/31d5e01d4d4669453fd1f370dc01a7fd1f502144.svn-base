<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="定时任务日志查询">
<table align="left" width="90%">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TblCronTaskJobLog" init="false" submitMode="current">
			<table width="100%">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" fieldStr="执行时间{qstartDate|' ~ '|qendDate},qQuartzResult" colNm="4"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1" fieldStr="jobno,subProceFunction,excuteTime,excuteResult,excuteOwn,failFlag,sucFlag,exceptionMsg,endExcuteFlag"  width="100%"/>
					</td>
				</tr>
				
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
	
</script>
</@CommonQueryMacro.page>