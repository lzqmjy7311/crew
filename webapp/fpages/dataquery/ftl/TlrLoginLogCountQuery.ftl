<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="�û���¼��־����ʱ��β�ѯ">
<@CommonQueryMacro.CommonQueryTab id="tlrLoginLogQueryTabs" navigate="false" currentTab="TlrLoginLogCountQuery">
<@CommonQueryMacro.CommonQuery id="TlrLoginLogCountQuery" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=4 />
		</td>
	</tr>

	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrno,brno,startDate,endDate,count" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">


</script>
</@CommonQueryMacro.page>