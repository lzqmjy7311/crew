<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="���ӱ��">
<table border=1 cellpadding=0>
	<tr><td valign="top">
	�����:
	<@CommonQueryMacro.CommonQuery id="MasterTable" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="masterdatatabale" fieldStr="col1,col2,col3,col4,col5" height="" width="600" />
	</@CommonQueryMacro.CommonQuery>
	</td>
	<td valign="top">
	�ӱ��:
	<@CommonQueryMacro.CommonQuery id="ReferenceTable" init="false" masterDataset="MasterTable_dataset" references="col1=col1" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="referencetable1" fieldStr="col1,col2,col3,col4" pagination="true" height="" width="500"/>
	</@CommonQueryMacro.CommonQuery>
	</td></tr> 
</table>
</@CommonQueryMacro.page>