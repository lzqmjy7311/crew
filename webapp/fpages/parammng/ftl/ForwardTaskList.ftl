<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="启动工作流测试交易">
<table align="left">
<tr>
	<td valign="top"  valign="top" width="1000">
<#-- modify by lizh 2010/09/13 处理TLS-410 begin: -->
				<@CommonQueryMacro.CommonQuery id="ForwardTask" init="false" navigate="true" mode="0" >
					<table align="left">
					<tr>
       					<td valign="top"  width="900">
       				<@CommonQueryMacro.PagePilot id="PagePilot"/>
					<@CommonQueryMacro.DataTable id="table1"  fieldStr="select,taskId,contractno,taskName,taskState,userName,procName,taskStartTime" readonly = "true"/>

						</td>
      				</tr>
  			 		</table>
  			 	</@CommonQueryMacro.CommonQuery>
	</td>
	<td valign="top"  valign="top" width="1000">
	</td>
</tr>

<tr>
	<td valign="top"  valign="top" width="300">
			<@CommonQueryMacro.CommonQuery id="ForwardTaskSubmit" init="false" navigate="false" mode="0">
					<table align="left">
					<tr>
       					<td valign="center"  width="300">
					<@CommonQueryMacro.Group id="group1"  label="任务移交" fieldStr="forwardTlrno"/>
						<CENTER><@CommonQueryMacro.Button id= "btForwardTask"/></CENTER>
						</td>
      				</tr>
  			 		</table>
  			</@CommonQueryMacro.CommonQuery>
	</td>
	<td valign="top"  valign="top" width="100">
	</td>
</tr>
<#-- modify by lizh 2010/09/13 处理TLS-410 end -->
</@CommonQueryMacro.page>
