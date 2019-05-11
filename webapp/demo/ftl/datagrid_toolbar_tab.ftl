<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="普通表格-工具栏">
  <br/>
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demodatatabale" title="带搜索功能的表格" width="600" 
		         fieldStr="col1[50],col2[150],col3[100],col10[100]"  paginationbar="btn1,-,btn2" toolbar="mytoolbar"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.ToolBar id="mytoolbar">
	<div style="text-align:right">
	<@CommonQueryMacro.InterfaceElement elId="qCol1" /><@CommonQueryMacro.InterfaceButton desc="btQuery" />
	</div>
	</@CommonQueryMacro.ToolBar>
</@CommonQueryMacro.page>