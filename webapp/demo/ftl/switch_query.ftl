<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="΢�������ʾ��">
	<@CommonQueryMacro.CommonQuery id="SwitchQuery" init="false" navigate="false">
			<div style="padding:5px;color:#336699">
				�˹���Ϊ΢������FP��ѯ���ܲ��ԣ�������1002���������Ϊ��1ϵͳ���ش���
			</div>
			<table width="90%">
			<tr>
				<td valign="top">
					<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" />
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