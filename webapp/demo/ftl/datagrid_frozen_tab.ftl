<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="冻结列表格">
	
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
	<table width="800">
			<tr>
				<td >
		<@CommonQueryMacro.DataTable id="demodatatabale" fitColumns="false" frozens="2" paginationbar="" height="" width="100%"  hasFrame="true" />
		</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	
</@CommonQueryMacro.page>