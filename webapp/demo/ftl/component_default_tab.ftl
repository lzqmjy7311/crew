<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="组件页面">
<#--
引用组件：COMP_DEMO
组件FTL：comp_demo.ftl

引用组件: COMP_TAB
组件FTL: comp_tab.ftl
-->
<table width="100%"><tr><td>
<@CommonQueryMacro.Component id="COMP_DEMO" showLine="true" label="表格组件">
</@CommonQueryMacro.Component>
</td></tr>
<tr><td>
<@CommonQueryMacro.Component id="COMP_TAB" showLine="true" label="标签组件">
</@CommonQueryMacro.Component>
</td></tr>
</table>
</@CommonQueryMacro.page>