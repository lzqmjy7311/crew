<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="微交换添加示例">
	<@CommonQueryMacro.CommonQuery id="SwitchQuery" init="false" navigate="false">
			<div style="padding:5px;color:#336699">
				此功能为微交换与FP查询功能测试，交易码1002，如果卡号为：1系统返回错误。
			</div>
			<table width="90%">
			<tr>
				<td valign="top">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
				</td>
			</tr>
			<tr>
				<td>
					<@CommonQueryMacro.DataTable id="datatable1" fieldStr="pan,purchAmount,currency,exponent,trsFeeAmount"  width="100%" hasFrame="true" readonly="true"/>
				</td>
			</tr>
			</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>