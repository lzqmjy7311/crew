<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="�ϲ��б��">
	
	<@CommonQueryMacro.CommonQuery id="GridMergeFields" init="true" submitMode="current" navigate="false">
	<table width="100%">
			<tr>
				<td >
		<@CommonQueryMacro.DataTable id="demodatatabale" fitColumns="false" mergeCols="col2" paginationbar="" height="" width="100%"  hasFrame="true" />
		</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	
</@CommonQueryMacro.page>